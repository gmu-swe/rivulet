package io.rivulet.fuzz;

import edu.columbia.cs.psl.phosphor.BasicSourceSinkManager;
import io.rivulet.ExpectsRivuletRerun;
import io.rivulet.internal.ViolationReport;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/* Performs tasks before and after tests run in order to provide Rivulet related testing behavior. Checks if the test class or
 * method using this rule has any Source, Sink, or TaintThrough annotations and replaces the default set of sources, sinks
 * or taintThrough methods used by Phosphor with the specified ones if such annotations are present and a test
 * rerun is not currently executing. Restores the original set of sources, sinks or taintThrough methods when evaluation
 * of the test class or method is completed. Passes information stored in a test method's ExpectsRivuletRerun annotation, if
 * present, to the ViolationReport. */
public class RivuletTestRule implements TestRule {

    // The default set of source methods or null if the default set is the set currently being used
    private static Iterable<String> defaultSources = null;
    // The default set of sink methods of null if the default set is the set currently being used
    private static Iterable<String> defaultSinks = null;
    // The default set of taintThrough methods of null if the default set is the set currently being used
    private static Iterable<String> defaultTaintThroughs = null;
    // Null if the set of source methods in use is the default set. Otherwise the Description instance from whose annotations
    // the set source methods in use was built.
    private static Description sourcesProvider = null;
    // Null if the set of sink methods in use is the default set. Otherwise the Description instance from whose annotations
    // the set sink methods in use was built.
    private static Description sinksProvider = null;
    // Null if the set of taintThrough methods in use is the default set. Otherwise the Description instance from whose annotations
    // the set taintThrough methods in use was built.
    private static Description taintThroughsProvider = null;
    // The description passed to the last class-level RivuletTestRule's apply method or null if a class-level
    // RivuletTestRule's apply  method has not yet been called.
    private static Description classLevelDescription = null;

    /* Looks at the Sink, Source, and TaintThrough annotations for the specified description and sets Phosphor's auto-taint
     * methods based on them. Passes a test method's ExpectedRivuletRerun annotation information to ViolationReport if the specified
     * description has a method name. */
    public synchronized Statement apply(Statement base, Description description) {
        if(description.isTest() && description.getMethodName() != null) {
            // Pass ExpectsRivuletRerun annotation to ViolationReport
            ViolationReport.reportAnnotation(description.getClassName(), description.getMethodName(), description.getAnnotation(ExpectsRivuletRerun.class));
        } else if(!description.isTest()) {
            // Apply is being called for a class-level rule
            classLevelDescription = description;
        }
        return new Statement() {
            @Override
            public synchronized void evaluate() throws Throwable {
                // The source methods before they were replaced or null if the source methods were not replaced
                Iterable<String> originalSources = null;
                // The sink methods before they were replaced or null if the sink methods were not replaced
                Iterable<String> originalSinks = null;
                // The taintThrough methods before they were replaced or null if the taintThrough methods were not replaced
                Iterable<String> originalTaintThroughs = null;
                // sourcesProvider before the sink methods were potentially replaced
                Description originalSourcesProvider = sourcesProvider;
                // sinksProvider before the source methods were potentially replaced
                Description originalSinksProvider = sinksProvider;
                // taintThroughProvider before the taintThrough methods were potentially replaced
                Description originalTaintThroughsProvider = taintThroughsProvider;
                try {
                    if(!isRivuletRerun()) {
                        // Leave the autoTaint methods unchanged if this is a rerun
                        originalSources = replaceSources(description);
                        originalSinks = replaceSinks(description);
                        originalTaintThroughs = replaceTaintThroughs(description);
                        if(defaultSources == null && originalSources != null) {
                            // The set of source methods that was just replaced was the default set
                            defaultSources = originalSources;
                        }
                        if(defaultSinks == null && originalSinks != null) {
                            // The set of sink methods that was just replaced was the default set
                            defaultSinks = originalSinks;
                        }
                        if(defaultTaintThroughs == null && originalTaintThroughs != null) {
                            // The set of taintThrough methods that was just replaced was the default set
                            defaultTaintThroughs= originalTaintThroughs;
                        }
                    }
                    base.evaluate();
                } finally {
                    if(!description.isTest()) {
                        // Class rule must restore default auto-taint methods
                        restoreDefaultAutoTaintMethods();
                        classLevelDescription = null;
                    } else if(classLevelDescription == null) {
                        // There is no class-level rule to restore changes made by this method-level rule
                        restoreAutoTaintMethods(originalSources, originalSinks, originalTaintThroughs, originalSourcesProvider,
                                originalSinksProvider, originalTaintThroughsProvider);
                    }
                }
            }
        };
    }

    /* Returns a collection of string methods from any Source annotations for the specified description or null if there
     * are no Source annotations on the specified description. */
    private Collection<String> getSourceMethods(Description description) {
        Sources sourcesAnnotation = description.getAnnotation(Sources.class);
        Source sourceAnnotation = description.getAnnotation(Source.class);
        if(sourcesAnnotation != null) {
            Source[] sources = sourcesAnnotation.value();
            LinkedList<String> sourceMethods = new LinkedList<>();
            for(Source source : sources) {
                sourceMethods.add(source.method());
            }
            return sourceMethods;
        } else if(sourceAnnotation != null) {
            return Collections.singletonList(sourceAnnotation.method());
        } else {
            return null;
        }
    }

    /* Returns a collection of string methods from any Sink annotations for the specified description or null if there
     * are no Sink annotations on the specified description. */
    private Collection<String> getSinkMethods(Description description) {
        Sinks sinksAnnotation = description.getAnnotation(Sinks.class);
        Sink sinkAnnotation = description.getAnnotation(Sink.class);
        if(sinksAnnotation != null) {
            Sink[] sinks = sinksAnnotation.value();
            LinkedList<String> sinkMethods = new LinkedList<>();
            for(Sink sink : sinks) {
                sinkMethods.add(sink.method());
            }
            return sinkMethods;
        } else if(sinkAnnotation != null) {
            return Collections.singletonList(sinkAnnotation.method());
        } else {
            return null;
        }
    }

    /* Returns a collection of string methods from any TaintThrough annotations for the specified description or null if there
     * are no TaintThrough annotations on the specified description. */
    private Collection<String> getTaintThroughMethods(Description description) {
        TaintThroughs taintThroughsAnnotation = description.getAnnotation(TaintThroughs.class);
        TaintThrough taintThroughAnnotation = description.getAnnotation(TaintThrough.class);
        if(taintThroughsAnnotation != null) {
            TaintThrough[] taintThroughs = taintThroughsAnnotation.value();
            LinkedList<String> taintThroughMethods = new LinkedList<>();
            for(TaintThrough taintThrough : taintThroughs) {
                taintThroughMethods.add(taintThrough.method());
            }
            return taintThroughMethods;
        } else if(taintThroughAnnotation != null) {
            return Collections.singletonList(taintThroughAnnotation.method());
        } else {
            return null;
        }
    }

    /* Checks the Source and Sources annotations for the specified description. If either is present replaces the set of source
     * methods and returns the set that was replaced. Returns null if the set of source methods was left unchanged or reverted
     * to the defaults. */
    private Iterable<String> replaceSources(Description description) {
        if(sourcesProvider != null && sourcesProvider.equals(description)) {
            // The set of source methods currently in use is the set built from this description's annotations
            return null;
        }
        Iterable<String> sourceMethods = getSourceMethods(description);
        if(sourceMethods != null) {
            // This description has at least one Source annotation
            sourcesProvider = description;
            return BasicSourceSinkManager.replaceAutoTaintMethods(sourceMethods, BasicSourceSinkManager.AutoTaint.SOURCE);
        } else if(classLevelDescription != null && description.isTest() && description.getMethodName() != null) {
            // This is a method-level description for a method with no Source annotations in a class that has a
            // class-level rule. Revert to the class-level sources.
            return replaceSources(classLevelDescription);
        } else if(classLevelDescription != null && defaultSources != null && sourcesProvider != null) {
            // Revert to the default sources
            sourcesProvider = null;
            BasicSourceSinkManager.replaceAutoTaintMethods(defaultSources, BasicSourceSinkManager.AutoTaint.SOURCE);
            return null;
        } else {
            return null;
        }
    }

    /* Checks the Sink and Sinks annotations for the specified description. If either is present replaces the set of sink
     * methods and returns the set that was replaced. Returns null if the set of sink methods was left unchanged or reverted
     * to the defaults. */
    private Iterable<String> replaceSinks(Description description) {
        if(sinksProvider != null && sinksProvider.equals(description)) {
            // The set of sink methods currently in use is the set built from this description's annotations
            return null;
        }
        Iterable<String> sinkMethods = getSinkMethods(description);
        if(sinkMethods != null) {
            // This description has at least one Sink annotation
            sinksProvider = description;
            return BasicSourceSinkManager.replaceAutoTaintMethods(sinkMethods, BasicSourceSinkManager.AutoTaint.SINK);
        } else if(classLevelDescription != null && description.isTest() && description.getMethodName() != null) {
            // This is a method-level description for a method with no Sink annotations in a class that has a
            // class-level rule. Revert to the class-level sinks.
            return replaceSinks(classLevelDescription);
        } else if(classLevelDescription != null && defaultSinks != null && sinksProvider != null) {
            // Revert to the default sinks
            sinksProvider = null;
            BasicSourceSinkManager.replaceAutoTaintMethods(defaultSinks, BasicSourceSinkManager.AutoTaint.SINK);
            return null;
        } else {
            return null;
        }
    }

    /* Checks the TaintThrough and TaintThroughs annotations for the specified description. If either is present replaces
     * the set of taintThrough methods and returns the set that was replaced. Returns null if the set of taintThrough methods
     * was left unchanged or reverted to the defaults. */
    private Iterable<String> replaceTaintThroughs(Description description) {
        if(taintThroughsProvider != null && taintThroughsProvider.equals(description)) {
            // The set of taintThrough methods currently in use is the set built from this description's annotations
            return null;
        }
        Iterable<String> taintThroughMethods = getTaintThroughMethods(description);
        if(taintThroughMethods != null) {
            // This description has at least one TaintThrough annotation
            taintThroughsProvider = description;
            return BasicSourceSinkManager.replaceAutoTaintMethods(taintThroughMethods, BasicSourceSinkManager.AutoTaint.TAINT_THROUGH);
        } else if(classLevelDescription != null && description.isTest() && description.getMethodName() != null) {
            // This is a method-level description for a method with no TaintThrough annotations in a class that has a
            // class-level rule. Revert to the class-level taintThroughs.
            return replaceTaintThroughs(classLevelDescription);
        } else if(classLevelDescription != null && defaultTaintThroughs != null && taintThroughsProvider != null) {
            // Revert to the default taintThroughs
            taintThroughsProvider = null;
            BasicSourceSinkManager.replaceAutoTaintMethods(defaultTaintThroughs, BasicSourceSinkManager.AutoTaint.TAINT_THROUGH);
            return null;
        } else {
            return null;
        }
    }

    /* Restores the source, sink and taintThrough methods to their defaults if necessary. */
    private void restoreDefaultAutoTaintMethods() {
        if(defaultSources != null && sourcesProvider != null) {
            sourcesProvider = null;
            BasicSourceSinkManager.replaceAutoTaintMethods(defaultSources, BasicSourceSinkManager.AutoTaint.SOURCE);
        }
        if(defaultSinks != null && sinksProvider != null) {
            sinksProvider = null;
            BasicSourceSinkManager.replaceAutoTaintMethods(defaultSinks, BasicSourceSinkManager.AutoTaint.SINK);
        }
        if(defaultTaintThroughs != null && taintThroughsProvider != null) {
            taintThroughsProvider = null;
            BasicSourceSinkManager.replaceAutoTaintMethods(defaultTaintThroughs, BasicSourceSinkManager.AutoTaint.TAINT_THROUGH);
        }
    }

    /* Restores the source, sink and taintThrough methods that were being used before they were replaced. */
    private void restoreAutoTaintMethods(Iterable<String> originalSources, Iterable<String> originalSinks, Iterable<String> originalTaintThroughs,
                                         Description originalSourcesProvider, Description originalSinksProvider, Description originalTaintThroughsProvider ) {
        if(originalSources != null && !equals(originalSourcesProvider, sourcesProvider)) {
            sourcesProvider = originalSourcesProvider;
            BasicSourceSinkManager.replaceAutoTaintMethods(originalSources, BasicSourceSinkManager.AutoTaint.SOURCE);
        }
        if(originalSinks != null && !equals(originalSinksProvider, sinksProvider)) {
            sinksProvider = originalSinksProvider;
            BasicSourceSinkManager.replaceAutoTaintMethods(originalSinks, BasicSourceSinkManager.AutoTaint.SINK);
        }
        if(originalTaintThroughs != null && !equals(originalTaintThroughsProvider, taintThroughsProvider)) {
            taintThroughsProvider = originalTaintThroughsProvider;
            BasicSourceSinkManager.replaceAutoTaintMethods(originalTaintThroughs, BasicSourceSinkManager.AutoTaint.TAINT_THROUGH);
        }
    }

    /* Returns whether the two objects are both null or equals. */
    private static boolean equals(Object o1, Object o2) {
        return (o1 == o2) || (o1 != null && o1.equals(o2));
    }

    /* Return whether the current test is an Rivulet generated rerun. */
    public boolean isRivuletRerun() {
        return RivuletJUnitCoreProvider.isReruns;
    }
}

