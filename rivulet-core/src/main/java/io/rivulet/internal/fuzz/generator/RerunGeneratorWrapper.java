package io.rivulet.internal.fuzz.generator;

import edu.columbia.cs.psl.phosphor.runtime.Taint;
import edu.columbia.cs.psl.phosphor.struct.LazyCharArrayObjTags;
import edu.columbia.cs.psl.phosphor.struct.TaintedBooleanWithObjTag;

import io.rivulet.internal.rerun.RerunConfigBuilder;
import io.rivulet.internal.rerun.SinglePayloadRerunConfigBuilder;
import io.rivulet.internal.rerun.TestRerunConfiguration;
import io.rivulet.internal.*;

import java.util.*;

public abstract class RerunGeneratorWrapper extends RivuletAutoTaintWrapper implements RerunGenerator {

	// Maximum number of characters from a tainted chunk's original value that can be added to a payload
	private static final int MAX_APPEND = 250;
	// Replacement String used to replace tainted chunks when generating reruns because the original tainted values may
	// have caused the String to be malformed
	private static final String STAND_IN = "text";

	/* Base implementation of isApplicable. Checks if the violation resulted from a tainted value flowing to one of the sinks
	 * that this generator targets for checking on reruns. */
	@Override
	public boolean isApplicable(Violation violation) {
		return getTargetedBaseSinks().contains(violation.getBaseSink());
	}

	public TaintedBooleanWithObjTag isApplicable$$PHOSPHORTAGGED(Violation violation, TaintedBooleanWithObjTag ret) {
		ret.taint = null;
		ret.val = isApplicable(violation);
		return ret;
	}

	/* Returns valid rerun configurations that can be used to verify the specified violation. */
	public Collection<TestRerunConfiguration> generateReruns(Violation violation, Object receiver, Object[] arguments) {
		return generateReruns(violation, generateRerunBuilders(violation, receiver, arguments));
	}

	protected LinkedHashSet<TestRerunConfiguration> generateReruns(Violation violation, Iterable<? extends RerunConfigBuilder> builders) {
		LinkedHashSet<TestRerunConfiguration> ret = new LinkedHashSet<>();
		for(RerunConfigBuilder builder : builders) {
			builder.autoTainterClass(getClass());
			ret.addAll(builder.build(violation));
		}
		return ret;
	}

	/* Returns rerun configuration builders that can be used to create reruns to verify the specified violation. */
	public Iterable<? extends RerunConfigBuilder> generateRerunBuilders(Violation violation, Object receiver, Object[] arguments) {
		return new LinkedList<>();
	}

	/* Returns a list of the sink methods that this generator is concerned with checking. Returns null if the generator is concerned
	 * with the same set of sinks as the original run. During a test rerun, only the methods returned by getTargetedBaseSinks
	 * for the generator that created the rerun will be considered sink methods regardless of any annotations on the test's method
	 * or class, any sink methods that reported violations on the original test run and the methods specified in phosphor.sinks file. */
	public abstract List<String> getTargetedBaseSinks();

	/* Returns whether the specified String contains at least one tainted character. */
	public static boolean containsTaintedChar(String s) {
		Taint<?>[] taints = getStringValueTaints(s);
		if(taints == null) {
			return false;
		}
		for(Taint<?> taint : taints) {
			if(taint != null && !taint.isEmpty()) {
				return true;
			}
		}
		return false;
	}

	/* Returns a shortened version of the specified String. */
	public String truncate(String str) {
		return (str.length() > MAX_APPEND) ? str.substring(0, MAX_APPEND) : str;
	}

	/* Returns a set containing the reruns configurations created using from tainted portions of the specified String the
	 * incorporate the values of the tainted portions into the specified payloads. Uses the specified regex to remove
	 * parts of the values of the tainted portions that might interfere with or break the payload. */
	protected Collection<TestRerunConfiguration> generateRerunsUsingTaintedChunks(Violation originalViolation, String str,
																				  Iterable<String> payloads, int argIndex, String removeRegex) {
		LinkedHashSet<TestRerunConfiguration> configs = new LinkedHashSet<>();
		// Build a tainted chunk to violation map
		LinkedHashMap<String, Violation> violationMap = createSourceValueViolationMap(originalViolation, str, argIndex);
		Violation violation = originalViolation.copyWithTaintedValues(new LinkedList<>());
		super.checkTaint(str, 0, violation);
		violation = TaintedSinkValueSet.processViolation(violation);
		if(!violation.getTaintedValues().isEmpty()) {
			for(String payload : payloads) {
				if(payload.contains("%s")) {
					// Fill in original values and generate on a per value basis
					for(String value: violationMap.keySet()) {
						String sanitizedValue = value.replaceAll(removeRegex, "");
						String filledPayload = fillInFormatSpecifiers(payload, truncate(sanitizedValue));
						configs.addAll(generateReruns(violationMap.get(value), Collections.singletonList(new SinglePayloadRerunConfigBuilder(filledPayload))));
					}
				} else {
					configs.addAll(generateReruns(violation, Collections.singletonList(new SinglePayloadRerunConfigBuilder(payload))));
				}
			}
		}
		return configs;
	}

	/* Returns a mapping between continuously tainted sink value chunks and violations containing only label information from
	 * the chunk. */
	private LinkedHashMap<String, Violation> createSourceValueViolationMap(Violation originalViolation, String taintedString,
																		   int argIndex) {
		LinkedHashMap<String, Violation> taintedChunkMap = new LinkedHashMap<>();
		for(TaintedSinkValueImpl taintedChunk : TaintedSinkValue.getContinuousTaintedChunks(getStringValueTag(taintedString), argIndex)) {
			Violation chunkViolation = originalViolation.copyWithTaintedValues(Collections.singletonList(taintedChunk));
			chunkViolation = TaintedSinkValueSet.processViolation(chunkViolation);
			taintedChunkMap.put(taintedChunk.getSinkValue(), chunkViolation);
		}
		return taintedChunkMap;
	}

	/* Formats the specified format string with copies of the specified String argument. */
	private String fillInFormatSpecifiers(String format, String arg) {
		int count = 0;
		for(int i = 0; i < format.length() - 1; i++) {
			if(format.charAt(i) == '%') {
				char next = format.charAt(++i);
				if(next == 's') {
					count++;
				}
			}
		}
		String[] arr = new String[count];
		for(int i  = 0; i < count; i++) {
			arr[i] = arg;
		}
		return String.format(format, (Object[]) arr);
	}

	/* Replaces each tainted section in the specified string with a stand-in value that contains only alphabetic letters.
	 * Each character of the replacement is tainted with a combined tag containing all of the tags in the original
	 * tainted section. */
	protected static String replaceTaintedChunksWithStandIns(String str) {
		if(str == null) {
			return null;
		}
		str = ParseUtils.removeDummyPositionTags(str);
		LazyCharArrayObjTags tags = getStringValueTag(str);
		InvocationRanges taintedRanges = new InvocationRanges(-1);
		if(tags != null && tags.taints != null) {
			for(int i = 0; i < tags.taints.length; i++) {
				Taint tag = tags.taints[i];
				if(tag != null && !tag.isEmpty()) {
					taintedRanges.addInt(i);
				}
			}
			int[] ranges = taintedRanges.getRangesCopy();
			if(ranges.length > 0) {
				TaintedStringBuilder builder = new TaintedStringBuilder();
				int previousEnd = 0;
				for(int i = 0; i < ranges.length; i+= 2) {
					int start = ranges[i];
					int end = ranges[i+1];
					// Append non-tainted portion between the start of this chunk and the end of the last chunk
					builder.append(str.substring(previousEnd, start));
					// Append the replace in place of the original tainted portion
					@SuppressWarnings("unchecked")
					Taint<SourceInfoTaintLabel>[] taints = (Taint<SourceInfoTaintLabel>[]) new Taint[end - start];
					System.arraycopy(tags.taints, start, taints, 0, taints.length);
					builder.append(TaintedStringBuilder.taintChars(new String(STAND_IN.toCharArray()), Taint.combineTaintArray(taints)));
					previousEnd = end;
				}
				return builder.append(str.substring(ranges[ranges.length-1])).toString();
			}
		}
		return new String(str);
	}

	/* Returns a processed violation for the specified String using information from the specified original violation. */
	protected Violation makeProcessedViolation(Violation originalViolation, String taintedString) {
		Violation violation = originalViolation.copyWithTaintedValues(new LinkedList<>());
		super.checkTaint(taintedString, 0, violation);
		return TaintedSinkValueSet.processViolation(violation);
	}

	/* Returns whether the first character of the specified String is tainted. */
	protected static boolean firstCharTainted(String s) {
		if(s == null) {
			return false;
		}
		@SuppressWarnings("unchecked")
		Taint<SourceInfoTaintLabel>[] taints = getStringValueTaints(s);
		if(taints == null || taints.length == 0) {
			return false;
		}
		return taints[0] != null && !taints[0].isEmpty();
	}

	/* Returns whether every character of the specified String is tainted. */
	protected static boolean allCharsTainted(String s) {
		if(s == null) {
			return false;
		}
		@SuppressWarnings("unchecked")
		Taint<SourceInfoTaintLabel>[] taints = getStringValueTaints(s);
		if(taints == null) {
			return false;
		}
		for(Taint<SourceInfoTaintLabel> taint : taints) {
			if(taint == null || taint.isEmpty()) {
				return false;
			}
		}
		return true;
	}
}
