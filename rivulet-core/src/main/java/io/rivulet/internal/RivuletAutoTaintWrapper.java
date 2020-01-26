package io.rivulet.internal;

import edu.columbia.cs.psl.phosphor.TaintUtils;
import edu.columbia.cs.psl.phosphor.runtime.MultiTainter;
import edu.columbia.cs.psl.phosphor.runtime.Taint;
import edu.columbia.cs.psl.phosphor.runtime.TaintSourceWrapper;
import edu.columbia.cs.psl.phosphor.struct.*;
import io.rivulet.BufferedHttpMessageParser;
import io.rivulet.RemoteTaintServerFacade;
import io.rivulet.internal.fuzz.generator.*;
import io.rivulet.internal.rerun.TestRerunConfiguration;
import sun.nio.ch.FileChannelImpl;

import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public class RivuletAutoTaintWrapper extends TaintSourceWrapper<SourceInfoTaintLabel> {

	// Whether JUnit tests are currently being run. If true, violations should not be directly printed by this class and
	// this class should generate rerun configurations
	private static boolean runningJUnitTests = true;
	// Whether at least one sink method was entered
	private static final AtomicBoolean reachedSink = new AtomicBoolean(false);
	// Maps violations that occurred due to some tainted value reaching a sink to reruns configurations generated for
	// the violation
	private static final LinkedHashMap<Violation, LinkedHashSet<TestRerunConfiguration>> violationConfigsMap = new LinkedHashMap<>();
	// Stores information used for a test rerun
	private static TestRerunConfiguration currentRerunConfig = null;
	// The maximum depth for recursive taint checking
	private static final int MAX_DEPTH = 10;
	// Value given to the mark field of any object enqueued in the queue of object to check for Taint instances to indicate
	// that that it was checked on a particular pass
	private static int currentMarkLevel = Integer.MIN_VALUE + 1;
	// Maps Classes to a list of record objects containing the fields and their offsets for the class
	private final IdentityHashMap<Class, ClassOffsetInfo> classInfoMap = new IdentityHashMap<>();
	// How deeply nested the sink currently being checked is, increases when entering a sink and decreases when
	// exiting one.
	private static final ThreadLocal<Integer> currentNestingLevel =
			ThreadLocal.withInitial(new Supplier<Integer>() {
				@Override
				public Integer get() {
					return 0;
				}
			});
	// One level deeper than the nesting level at which the last reported violation. A value of -1 indicates that there are no
	// reported violations on the stack.
	private static final ThreadLocal<Integer> lastViolationLevel =
			ThreadLocal.withInitial(new Supplier<Integer>() {
				@Override
				public Integer get() {
					return -1;
				}
			});
	// Maps actual sources, arg index pairs to the number of times a label with index information has been generated for that source. */
	private static final ConcurrentHashMap<NumberedObject, AtomicInteger> invocationIDMap = new ConcurrentHashMap<>();
	// List of generators that can be used to create rerun configurations for violations
	private static List<RerunGenerator> rerunGenerators = null;
	// Maps channels to the parser used to parse bytes read from it. Used to buffer http response bytes that need to be
	// until the full response is written
	private static final HashMap<Object, BufferedHttpMessageParser> parserMap = new HashMap<>();
	// Tracks nested calls to http response sinks
	private static final ThreadLocal<Integer> lastHttpResponseSinkLevel =
			ThreadLocal.withInitial(new Supplier<Integer>() {
				@Override
				public Integer get() {
					return 0;
				}
			});
	public static RemoteTaintServerFacade remoteTaintServerFacade = null;

	//Make sure that NIO doesn't try to directly transfer files, we won't see the content and it will break everything...
	static{
		try{
			Field f = FileChannelImpl.class.getDeclaredField("transferSupported");
			f.setAccessible(true);
			f.set(null, false);
		}catch(Throwable t){
			t.printStackTrace();
		}
	}

	public static int getNumberOfViolations() {
		if(remoteTaintServerFacade != null)
			return remoteTaintServerFacade.getNumberOfViolations();
		return getViolations().size();
	}

	/* Creates a label from the specified information and assigns it the specified invocation id if
	 * TaintTrackingRunListener is tracking violations. */
	private SourceInfoTaintLabel generateBaseLabel(String baseSource, String actualSource, int argIndex, Class<?> originalClass,
												   boolean fullyReplaceable, int invocationID) {
		originalClass = TaintUtils.getUnwrappedClass(originalClass);
		if(!runningJUnitTests) {
			// TaintTrackingRunListener is not tracking violation output, indexInfo shouldn't be added because reruns aren't
			// being generated
			return new SourceInfoTaintLabel(baseSource, actualSource, argIndex, originalClass, fullyReplaceable);
		} else {
			InvocationRanges indexInfo = new InvocationRanges(invocationID);
			return new IndexedSourceInfoTaintLabel(baseSource, actualSource, argIndex, originalClass, fullyReplaceable,
					indexInfo, null);
		}
	}

	/* Creates a new label from the specified base label but with the specified originalClass and fullyReplaceable values. */
	private SourceInfoTaintLabel generateLabelFromBase(SourceInfoTaintLabel baseLabel, Class<?> originalClass, boolean fullyReplaceable) {
		originalClass = TaintUtils.getUnwrappedClass(originalClass);
		if(baseLabel instanceof IndexedSourceInfoTaintLabel) {
			return new IndexedSourceInfoTaintLabel((IndexedSourceInfoTaintLabel)baseLabel, originalClass, fullyReplaceable);
		} else {
			return new SourceInfoTaintLabel(baseLabel, originalClass, fullyReplaceable);
		}
	}

	/* If the specified base label has index information returns a new label from the specified base label but with only
	 * the specified index indicated as present in its index information. Otherwise, returns a copy of the base label. */
	private SourceInfoTaintLabel generateLabelFromBase(SourceInfoTaintLabel baseLabel, int index) {
		if(baseLabel instanceof IndexedSourceInfoTaintLabel) {
			return new IndexedSourceInfoTaintLabel((IndexedSourceInfoTaintLabel)baseLabel, index);
		} else {
			return new SourceInfoTaintLabel(baseLabel);
		}
	}

	/* Returns a new String created to help with String interning if the specified String and its characters are not
	 * tainted. Otherwise, returns the original String. */
	private String unintern(String s) {
		Taint<SourceInfoTaintLabel> taint = getTaint(s);
		if((taint == null || taint.isEmpty()) && (getStringValueTag(s) == null || getStringValueTag(s).taints == null)) {
			return new String(s);
		} else {
			return s;
		}
	}

	/* Taints the specified object with a new taint with the specified label. */
	private Object autoTaint(Object ret, SourceInfoTaintLabel label) {
		if(ret == null) {
			return null;
		} else if(ret instanceof String && label.getFullyReplaceable()) {
			ret = unintern((String) ret);
		}
		ret = getReplacement(ret, label);
		if(ret instanceof String) {
			// Taint the String's value array
			String str = (String) ret;
			LazyCharArrayObjTags tags = getStringValueTag(str);
			combineTaintsOnArray(tags, new Taint<>(label));
			setStringValueTag(str, tags);
		}
		return super.autoTaint(ret, new Taint<>(label));
	}

	/* Called by sources for the arguments and return value. Taints the specified object with the specified tag. This
	 * object can only be fully replaced on a rerun if it is a return value (indicated by the argIndex being -1). */
	@Override
	public Object autoTaint(Object ret, String baseSource, String actualSource, int argIndex) {
		// Assign an invocation id for the call of the the actual source method
		NumberedObject key = new NumberedObject(actualSource, argIndex);
		invocationIDMap.putIfAbsent(key, new AtomicInteger(0));
		int invocationID = invocationIDMap.get(key).getAndIncrement();
		if(ret == null) {
			return null;
		}
		SourceInfoTaintLabel baseLabel = generateBaseLabel(baseSource, actualSource, argIndex, ret.getClass(), argIndex == -1, invocationID);
		if(ret instanceof LazyArrayObjTags) {
			// autoTainting a 1D primitive array - indices should be recorded
			return autoTaintWithIndexInfo((LazyArrayObjTags) ret, baseLabel);
		} else if(ret instanceof String) {
			// autoTainting a String - indices should be recorded
			return autoTaintWithIndexInfo((String) ret, baseLabel);
		} else if(ret instanceof Map) {
			return autoTaintMap((Map) ret, baseLabel);
		} else if(ret instanceof Collection) {
			return autoTaintCollection((Collection) ret, baseLabel);
		} else {
			if(ret.getClass().isArray()) {
				// Taint the array's elements
				for(int i = 0; i < Array.getLength(ret); i++) {
					Array.set(ret, i, autoTaint(Array.get(ret, i), generateLabelFromBase(baseLabel, ret.getClass().getComponentType(), true)));
				}
			}
			return autoTaint(ret, baseLabel);
		}
	}

	/* Taints the specified String's character with a label containing index info. */
	private Object autoTaintWithIndexInfo(String ret, SourceInfoTaintLabel baseLabel) {
		if(baseLabel.getFullyReplaceable()) {
			ret = unintern(ret);
		}
		// Try to replace the entire String
		ret = (String)getReplacement(ret, baseLabel);
		if(baseLabel instanceof IndexedSourceInfoTaintLabel) {
			baseLabel = new IndexedSourceInfoTaintLabel((IndexedSourceInfoTaintLabel)baseLabel, IndexedSourceInfoTaintLabel.copyPrimitiveArray(((String) ret).toCharArray()));
		}
		// Taint the String's value array
		char[] val = ret.toCharArray();
		Taint[] currentTaints = getStringValueTaints(ret);
		@SuppressWarnings("unchecked")
		Taint<SourceInfoTaintLabel>[] taints = (Taint<SourceInfoTaintLabel>[])(currentTaints == null ? new Taint[val.length] : currentTaints);
		for(int i = 0; i < taints.length; i++) {
			Taint<SourceInfoTaintLabel> tag = new Taint<>(generateLabelFromBase(baseLabel, i));
			if(taints[i] == null) {
				taints[i] = tag;
			} else {
				taints[i].addDependency(tag);
			}
		}
		setStringValueTag(ret, new LazyCharArrayObjTags(val, taints));
		return ret;
	}

	/* Taints the specified LazyArrayObjTags' elements with labels containing index info. */
	private Object autoTaintWithIndexInfo(LazyArrayObjTags ret, SourceInfoTaintLabel baseLabel) {
		ret = (LazyArrayObjTags)getReplacement(ret, baseLabel);
		if(baseLabel instanceof IndexedSourceInfoTaintLabel) {
			baseLabel = new IndexedSourceInfoTaintLabel((IndexedSourceInfoTaintLabel)baseLabel, IndexedSourceInfoTaintLabel.copyPrimitiveArray(ret.getVal()));
		}
		@SuppressWarnings("unchecked")
		Taint<SourceInfoTaintLabel>[] taints = (Taint<SourceInfoTaintLabel>[])(ret.taints == null ? new Taint[ret.getLength()] : ret.taints);
		for(int i = 0; i < taints.length; i++) {
			Taint<SourceInfoTaintLabel> tag = new Taint<>(generateLabelFromBase(baseLabel, i));
			if(taints[i] == null) {
				taints[i] = tag;
			} else {
				taints[i].addDependency(tag);
			}
		}
		ret.taints = taints;
		return ret;
	}

	/* Taints the specified Collection and its elements. */
	@SuppressWarnings("unchecked")
	private Object autoTaintCollection(Collection c, SourceInfoTaintLabel baseLabel) {
		boolean tryEntireCollectionReplacement = false;
		Object[] elements = c.toArray();
		try {
			c.clear();
			for(Object e : elements) {
				c.add(autoTaint(e, generateLabelFromBase(baseLabel, e.getClass(), true)));
			}
		} catch(UnsupportedOperationException ex) {
			// The object being tainted is probably some sort of unmodifiable or immutable collection.
			// If this isn't a rerun or we aren't tainting a return value just taint the value don't bother trying to replace it.
			tryEntireCollectionReplacement = true;
			for(Object e : c) {
				autoTaint(e, generateLabelFromBase(baseLabel, e.getClass(), baseLabel.getFullyReplaceable()));
			}
		}
		if(baseLabel.getFullyReplaceable() && tryEntireCollectionReplacement) {
			// c is the return value of the source method, we can try to swap out the entire object to replace its elements
			Object replacement = tryEntireMapOrCollectionReplacement(c, baseLabel);
			if(replacement != null) {
				return autoTaint(replacement, baseLabel);
			}
		}
		return autoTaint(c, baseLabel);
	}

	/* Taints the specified Map and its values. */
	@SuppressWarnings("unchecked")
	private Object autoTaintMap(Map map, SourceInfoTaintLabel baseLabel) {
		boolean tryEntireMapReplacement = false;
		for(Object _e: map.entrySet()) {
			Map.Entry e = (Map.Entry) _e;
			try {
				e.setValue(autoTaint(e.getValue(), generateLabelFromBase(baseLabel, e.getValue().getClass(), true)));
			} catch(UnsupportedOperationException ex) {
				// The object being tainted is probably some sort of unmodifiable or immutable map.
				// If this isn't a rerun or we aren't tainting a return value just taint the value don't bother trying to replace it.
				tryEntireMapReplacement = true;
				autoTaint(e.getValue(), generateLabelFromBase(baseLabel, e.getValue().getClass(), baseLabel.getFullyReplaceable()));
			}
		}
		if(baseLabel.getFullyReplaceable() && tryEntireMapReplacement) {
			// map is the return value of the source method, we can try to swap out the entire object to replace its values
			Object replacement = tryEntireMapOrCollectionReplacement(map, baseLabel);
			if(replacement != null) {
				return autoTaint(replacement, baseLabel);
			}
		}
		return autoTaint(map, baseLabel);
	}

	/* Tries to create a new instance of the specified object's type and fill it with replacement values. Returns null if
	 * this fails at any point for any reason. */
	@SuppressWarnings("unchecked")
	private Object tryEntireMapOrCollectionReplacement(Object obj, SourceInfoTaintLabel baseLabel) {
		try {
			if(obj instanceof Map) {
				Map map = (Map)obj;
				Map replacement = map.getClass().newInstance();
				for(Object o: map.entrySet()) {
					Map.Entry e = (Map.Entry) o;
					replacement.put(e.getKey(), autoTaint(e.getValue(), generateLabelFromBase(baseLabel, e.getValue().getClass(), true)));
				}
				return replacement;
			} else if(obj instanceof Collection) {
				Collection col = (Collection)obj;
				Collection replacement = col.getClass().newInstance();
				Object[] elements = col.toArray();
				for(Object e : elements) {
					replacement.add(autoTaint(e, generateLabelFromBase(baseLabel, e.getClass(), true)));
				}
				return replacement;
			} else {
				return null;
			}
		} catch(Exception e) {
			return null;
		}
	}

	/* Returns the appropriate valueToTry value for the specified source and count from the currentConfig, if there is not
	 * an appropriate value returns the specified original value. */
	private static Object getReplacement(Object originalValue, SourceInfoTaintLabel label) {
		if(currentRerunConfig != null && currentRerunConfig.hasReplacementValue(originalValue, label)) {
			return currentRerunConfig.getReplacementValue(originalValue, label);
		} else {
			return originalValue;
		}
	}

	/* Sets the mark field for the specified object to the currentMarkLevel if the object has a mark field. Returns true
	 * if the object has a mark field that was not already set to the currentMarkLevel that was successfully set to the
	 * currentMarkLevel. */
	private boolean setMark(Object obj, Set<Object> marked) {
		if(obj == null || obj.getClass() == null) {
			return false;
		}
		Class<?> clazz = obj.getClass();
		if(!classInfoMap.containsKey(clazz)) {
			classInfoMap.put(clazz, new ClassOffsetInfo(clazz));
		}
		ClassOffsetInfo info = classInfoMap.get(clazz);
		if(info.hasMarkField()) {
			return info.setMarkFieldForObject(currentMarkLevel, obj);
		} else if(!shouldDeepCheckTaint(clazz) || clazz.isArray()) {
			// The fields of these classes are not enqueued so they should not cause any infinite checking loops
			return true;
		} else {
			return marked.add(obj);
		}
	}

	/* Adds all of the non-null, non-visited values of the fields of the specified object to the stack. */
	private void enqueueFields(Object obj, int depth, SinglyLinkedList<NumberedObject> stack, Set<Object> marked) {
		Class<?> clazz = obj.getClass();
		if(!classInfoMap.containsKey(clazz)) {
			classInfoMap.put(clazz, new ClassOffsetInfo(clazz));
		}
		for(ClassOffsetInfo.FieldInfo info : classInfoMap.get(clazz).getFields()) {
			Object fieldValue = info.getObject(obj);
			if(fieldValue != null) {
				if(setMark(fieldValue, marked)) {
					stack.push(new NumberedObject(fieldValue, depth+1));
				}
			}
		}
	}

	/* Returns whether or not the fields of an instance of the specified class should be checked for taint tags. */
	private static boolean shouldDeepCheckTaint(Class<?> clazz) {
		if(clazz == null || clazz.getName() == null) {
			return false;
		}
		Package pack = clazz.getPackage();
		String name = clazz.getName();
		if(pack != null && (pack.equals(Package.getPackage("java.lang.reflect")) || pack.equals(Package.getPackage("sun.reflect")))) {
			// The specified class is associated with reflection
			return false;
		} else if(name.contains("/")) {
			// The specified class is a VM-anonymous class (not anonymous inner class)
			return false;
		} else {
			return !clazz.equals(Object.class) && !ReferenceQueue.class.isAssignableFrom(clazz) && !Number.class.isAssignableFrom(clazz) &&
					!clazz.equals(Character.class) && !clazz.equals(Boolean.class) && !clazz.isPrimitive() &&
					!TaintedPrimitiveWithObjTag.class.isAssignableFrom(clazz);
		}
	}

	/* Called after entering sink methods. */
	@Override
	public synchronized void checkTaint(Object self, Object[] arguments, String baseSink, String actualSink) {
		if(XssGenerator.isXssSink(baseSink)) {
			checkTaintHttpResponse(self, arguments, baseSink, actualSink);
		} else {
			// Check whether this sink is nested inside another sink which reported a violation
			if(arguments != null && (lastViolationLevel.get() == -1 || currentNestingLevel.get() < lastViolationLevel.get())) {
				Violation violation = new Violation(baseSink, actualSink);
				for(int i = 0; i < arguments.length; i++) {
					checkTaint(arguments[i], i, violation);
				}
				if(!violation.getTaintedValues().isEmpty()) {
					lastViolationLevel.set(currentNestingLevel.get() + 1);
					synchronized(violationConfigsMap) {
						if(!violationConfigsMap.containsKey(violation) && !runningJUnitTests) {
							System.out.println(violation.toString(false, null));
						} else if(!violationConfigsMap.containsKey(violation) && runningJUnitTests) {
							generateRerunConfigs(violation, self, arguments);
						}
					}
				}
			}
		}
	}

	/* Specified checkTaint for http responses that buffers bytes until a full response it written. */
	private synchronized void checkTaintHttpResponse(Object self, Object[] arguments, String baseSink, String actualSink) {
		if(arguments != null && lastHttpResponseSinkLevel.get() == 1) {
			// Make sure call to http response sink is not nested to prevent double writing bytes
			try {
				if(!parserMap.containsKey(self)) {
					parserMap.put(self, BufferedHttpMessageParser.getResponseParser());
				}
				BufferedHttpMessageParser parser = parserMap.get(self);
				if(arguments.length == 1) {
					if(arguments[0] instanceof ByteBuffer) {
						parser.appendBytes((ByteBuffer) arguments[0]);
					} else if(arguments[0] instanceof ByteBuffer[]) {
						for(ByteBuffer buffer : (ByteBuffer[]) arguments[0]) {
							parser.appendBytes(buffer);
						}
					}
				} else if(arguments.length == 3) {
					if(arguments[0] instanceof ByteBuffer[] && arguments[1] instanceof TaintedIntWithObjTag
							&& arguments[2] instanceof TaintedIntWithObjTag) {
						int offset = ((TaintedIntWithObjTag)arguments[1]).val;
						int len = ((TaintedIntWithObjTag)arguments[2]).val;
						ByteBuffer[] buffers = (ByteBuffer[]) arguments[0];
						for(int i = offset; i < offset+len; i++) {
							parser.appendBytes(buffers[i]);
						}
					}
				}
				while(parser.hasParsedMessage()) {
					BufferedHttpMessageParser.ParsedMessage parsed = parser.getParsedMessage();
					if(parsed.hasHtmlContent()) {
						Violation violation = new Violation(baseSink, actualSink);
						// Check the response body for taint tags
						String html = parsed.getEntityString();
						checkTaint(html, 0, violation);
						if(!violation.getTaintedValues().isEmpty()) {
							lastViolationLevel.set(currentNestingLevel.get() + 1);
							synchronized(violationConfigsMap) {
								if(!violationConfigsMap.containsKey(violation) && !runningJUnitTests) {
									System.out.println(violation.toString(false, null));
								} else if(!violationConfigsMap.containsKey(violation) && runningJUnitTests) {
									generateRerunConfigs(violation, self, new Object[]{html});
								}
							}
						}
					}
				}
			} catch(Exception e) {
				//
			}
		}
	}

	/* Reports violations if the specified object or its fields are tainted. Filters the sinkValue added to the violation
	 * to be only the tainted parts of arrays, if reporting a tainted array. */
	public void checkTaint(Object obj, int argIndex, Violation violation) {
		checkTaint(obj, argIndex, violation, true);
	}

	/* Reports violations if the specified object or its fields are tainted. */
	public void checkTaint(Object obj, int argIndex, Violation violation, boolean filterSinkValue) {
		if(obj != null) {
			SinglyLinkedList<NumberedObject> stack = new SinglyLinkedList<>();
			Set<Object> marked = Collections.newSetFromMap(new IdentityHashMap<>());
			setMark(obj, marked);
			stack.push(new NumberedObject(obj, 1));
			while(!stack.isEmpty()) {
				NumberedObject poppedObj = stack.pop();
				Object curObj = poppedObj.obj;
				int curDepth = poppedObj.num;
				if(curObj != null && !shallowCheckTaint(curObj, argIndex, violation, filterSinkValue) && curDepth < MAX_DEPTH && shouldDeepCheckTaint(curObj.getClass())) {
					if(curObj instanceof Object[]) {
						// curObj is a non-primitive array
						for(Object el : (Object[]) curObj) {
							if(setMark(el, marked)) {
								stack.push(new NumberedObject(el, curDepth + 1));
							}
						}
					} else {
						enqueueFields(curObj, curDepth, stack, marked);
					}
				}
			}
			currentMarkLevel++;
		}
	}

	/* Checks the specified object and reports a violation if it is tainted. Returns whether a violation was reported. */
	private boolean shallowCheckTaint(Object obj, int argIndex, Violation violation, boolean filterSinkValue) {
		Taint<SourceInfoTaintLabel> tag = getTaint(obj);
		if(obj != null && tag != null && !tag.isEmpty()) {
			if(obj instanceof TaintedPrimitiveWithObjTag) {
				TaintedPrimitiveWithObjTag o = (TaintedPrimitiveWithObjTag) obj;
				taintViolation(tag, o.getValue(), argIndex, violation, filterSinkValue);
				return true;
			} else {
				taintViolation(tag, obj, argIndex, violation, filterSinkValue);
				return true;
			}
		} else {
			return false;
		}
	}

	/* Returns the cast taint of the specified object. */
	@SuppressWarnings("unchecked")
	private Taint<SourceInfoTaintLabel> getTaint(Object obj) {
		if(obj instanceof LazyArrayObjTags) {
			Taint<SourceInfoTaintLabel>[] taints = (Taint<SourceInfoTaintLabel>[])((LazyArrayObjTags) obj).taints;
			return Taint.combineTaintArray(taints);
		} else if(obj instanceof TaintedPrimitiveWithObjTag) {
			TaintedPrimitiveWithObjTag taintedObj = (TaintedPrimitiveWithObjTag)obj;
			return (Taint<SourceInfoTaintLabel>) taintedObj.taint;
		} else {
			return (Taint<SourceInfoTaintLabel>) MultiTainter.getTaint(obj);
		}
	}

	private void taintViolation(Taint<SourceInfoTaintLabel> taint, Object taintedObj, int argIndex, Violation violation, boolean filterSinkValue) {
		if(taintedObj instanceof LazyArrayObjTags && filterSinkValue) {
			for(TaintedSinkValue taintedChunk : TaintedSinkValue.getContinuousTaintedChunks((LazyArrayObjTags)taintedObj, argIndex)) {
				if(!taintedChunk.getTaintSources().isEmpty()) {
					violation.addTaintedValue(taintedChunk);
				}
			}
		} else {
			TaintedSinkValueImpl taintedValue = new TaintedSinkValueImpl(TaintedStringBuilder.formatTaintedValue(taintedObj), TaintUtils.getUnwrappedClass(taintedObj.getClass()), argIndex, taint);
			violation.addTaintedValue(taintedValue);
		}
	}

	/* Initializes the list of rerun generators if necessary. */
	private static synchronized void setUpGenerators() {
		if(rerunGenerators == null || rerunGenerators.isEmpty()) {
			rerunGenerators = Arrays.asList(
					new RCEGenerator(),
					new SqlInjectionGenerator(),
					new XssGenerator(),
					new OgnlInjectionGenerator(),
					new XStreamGenerator(),
					new ELGenerator()
			);
		}
	}

	/* Creates rerun configurations that attempt to verify the specified violation. */
	private void generateRerunConfigs(Violation violation, Object receiver, Object[] arguments) {
		violationConfigsMap.put(violation, new LinkedHashSet<>());
		if(runningJUnitTests && currentRerunConfig == null) {
			// Generate configuration if in original test run
			setUpGenerators();
			LinkedHashSet<TestRerunConfiguration> configs = violationConfigsMap.get(violation);
			for(RerunGenerator gen : rerunGenerators) {
				if(gen.isApplicable(violation)) {
					configs.addAll(gen.generateReruns(TaintedSinkValueSet.processViolation(violation), receiver, arguments));
				}
			}
		}
	}

	/* Called after a sink method makes its calls to checkTaint but before the rest of the method body executes. */
	@Override
	public void enteringSink(String baseSink, String actualSink) {
		reachedSink.set(true);
		// Increase the nesting level
		currentNestingLevel.set(currentNestingLevel.get() + 1);
		if(XssGenerator.isXssSink(baseSink)) {
			// Increase the http response nesting level
			lastHttpResponseSinkLevel.set(lastHttpResponseSinkLevel.get() + 1);
		}
	}

	/* Called just before a sink method returns. */
	@Override
	public void exitingSink(String baseSink, String actualSink) {
		if(currentNestingLevel.get() < lastViolationLevel.get()) {
			lastViolationLevel.set(-1); // Clear the last violation
		}
		currentNestingLevel.set(currentNestingLevel.get() - 1); // Decrease the nesting level
		if(XssGenerator.isXssSink(baseSink)) {
			// Decrease the http response nesting level
			lastHttpResponseSinkLevel.set(lastHttpResponseSinkLevel.get() - 1);
		}
	}

	/* Returns whether at least one sink method was entered. Sets reachedSink to false. */
	public static boolean checkAndClearReachedSink() {
		if(remoteTaintServerFacade != null)
			return remoteTaintServerFacade.checkAndClearReachedSink();
		return reachedSink.getAndSet(false);
	}

	/* Prepares for the start of a new test. */
	public static void resetForNextTest() {
		lastViolationLevel.set(-1);
		currentNestingLevel.set(0);
		lastHttpResponseSinkLevel.set(0);
		reachedSink.getAndSet(false);
		invocationIDMap.clear();
	}

	/* Setter for runningJUnitTests. */
	public static void setRunningJUnitTests(boolean runningJUnitTests) {
		RivuletAutoTaintWrapper.runningJUnitTests = runningJUnitTests;
	}

	/* Getter for currentRerunConfig. */
	public static TestRerunConfiguration getCurrentRerunConfig() {
		if(remoteTaintServerFacade != null)
			return remoteTaintServerFacade.getCurrentRerunConfig();
		return currentRerunConfig;
	}

	/* Setter for currentRerunConfig. */
	public static void setCurrentRerunConfig(TestRerunConfiguration currentRerunConfig) {
		RivuletAutoTaintWrapper.currentRerunConfig = currentRerunConfig;
	}

	@Override
	@SuppressWarnings("unused")
	public boolean shouldInstrumentMethodForImplicitLightTracking(String className, String methodName, String methodDescriptor) {
		return false;
	}

	/* Returns a shallow copy of the set of reported violations. */
	public static Set<Violation> getViolations() {
		return new LinkedHashSet<>(violationConfigsMap.keySet());
	}

	/* Returns a shallow copy of the current value of violationConfigsMap and then clear the original map. */
	public static LinkedHashMap<Violation, LinkedHashSet<TestRerunConfiguration>> getAndClearViolationConfigsMap() {
		LinkedHashMap<Violation, LinkedHashSet<TestRerunConfiguration>> ret = new LinkedHashMap<>(violationConfigsMap);
		violationConfigsMap.clear();
		return ret;
	}

	/* Record type that stores an object and an int. */
	public static class NumberedObject {

		Object obj;
		int num;

		NumberedObject(Object obj, int num) {
			this.obj = obj;
			this.num = num;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			NumberedObject that = (NumberedObject) o;
			if (num != that.num) return false;
			return obj != null ? obj.equals(that.obj) : that.obj == null;
		}

		@Override
		public int hashCode() {
			int result = obj != null ? obj.hashCode() : 0;
			result = 31 * result + num;
			return result;
		}

		@Override
		public String toString() {
			return String.format("{%s = #%d}", obj, num);
		}
	}
}
