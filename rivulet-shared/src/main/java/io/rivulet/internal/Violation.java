package io.rivulet.internal;

import io.rivulet.ViolationReportingUtils;
import io.rivulet.internal.rerun.Replacement;
import io.rivulet.internal.rerun.TestRerunConfiguration;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;

/* Stores information about a flow from at least one source method to a sink method. */
public class Violation implements Serializable {

    private static final long serialVersionUID = 7285031412986364823L;
    // The maximum number of tainted values that should be printed
    private static final int MAX_TAINTED_VALUES = 5;
    // Name of sink method from which the actual sink method invoked inherited its status as a sink
    private final String baseSink;
    // Name of the class of the actual sink method to which a tainted value flowed
    private final String actualSinkClass;
    // Set of tainted values that reached the sink
    private final LinkedHashSet<TaintedSinkValue> taintedValues;
    // Uniquely identifies this violation
    private String uniqueID;
    // Name of the class of the test method during which this violation occurred
    private String testClass;
    // Name of the test method during which this violation occurred
    private String testMethod;

    /* Constructs a new violation with an empty set of tainted values. */
    public Violation(String baseSink, String actualSink) {
        this.baseSink = baseSink;
        this.actualSinkClass = actualSink.substring(0, actualSink.indexOf("."));
        this.taintedValues = new LinkedHashSet<>();
    }

    /* Constructs a new violation with a tainted value set containing the values in the specified collection. */
    private Violation(String baseSink, String actualSinkClass, Collection<? extends TaintedSinkValue> taintedValues) {
        this.baseSink = baseSink;
        this.actualSinkClass = actualSinkClass;
        this.taintedValues = new LinkedHashSet<>(taintedValues);
    }

    /* Adds the specified TaintedSinkValue to taintedValues. */
    public void addTaintedValue(TaintedSinkValue value) {
        taintedValues.add(value);
    }

    /* Adds information about the test being run to this violation. */
    public void setTestInfo(String uniqueID, String testClass, String testMethod) {
        this.uniqueID = uniqueID;
        this.testClass = testClass;
        this.testMethod = testMethod;
    }

    /* Getter for baseSink. */
    public String getBaseSink() {
        return baseSink;
    }

    /* Getter for actualSinkClass. */
    public String getActualSinkClass() {
        return actualSinkClass;
    }

    /* Getter for taintedValues. */
    public LinkedHashSet<TaintedSinkValue> getTaintedValues() {
        return taintedValues;
    }

    /* Getter for uniqueID. */
    public String getUniqueID() {
        return uniqueID;
    }

    /* Getter for testClass. */
    public String getTestClass() {
        return testClass;
    }

    /* Getter for testMethod. */
    public String getTestMethod() {
        return testMethod;
    }

    /* Returns a text representation of this violation. */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("\tbaseSink: ").append(baseSink);
        builder.append("\n\tactualSinkClass: ").append(actualSinkClass);
        builder.append("\n\ttaintedValues: [\n");
        int i = 0;
        for(TaintedSinkValue val : taintedValues) {
            builder.append(val.toString(2)).append("\n");
            if(i++ >= MAX_TAINTED_VALUES) {
                break;
            }
        }
        int remaining = taintedValues.size() - MAX_TAINTED_VALUES;
        if(remaining > 0) {
            builder.append("\t\t+").append(remaining).append(" more\n");
        }
        return builder.append("\t]").toString();
    }

    /* Returns a nicely formatted string containing information about this violation. If critical is true the violation
     * is labeled as being critical. */
    public String toString(boolean critical, TestRerunConfiguration curConfig) {
        String violationStatus = ViolationReportingUtils.colorText(critical ? "CRITICAL VIOLATION" : "VIOLATION", ViolationReportingUtils.RivuletColor.VIOLATION);
        violationStatus = ViolationReportingUtils.boldText(violationStatus);
        String testName = ViolationReportingUtils.formatTestName(testClass, testMethod);
        if(critical && curConfig != null) {
            // Added replacement information
            StringBuilder builder = new StringBuilder(String.format("[%s] %s {\n%s\n", violationStatus, testName, toString()));
            builder.append("\treplacements: [\n");
            for(Replacement replacement : curConfig.getReplacementsCopy()) {
                builder.append(replacement.toString(2)).append("\n");
            }
            return builder.append("\t]\n}").toString();
        } else {
            return String.format("[%s] %s {\n%s\n}", violationStatus, testName, toString());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Violation violation = (Violation) o;
        if (!baseSink.equals(violation.baseSink)) return false;
        if (!actualSinkClass.equals(violation.actualSinkClass)) return false;
        return taintedValues.equals(violation.taintedValues);
    }

    @Override
    public int hashCode() {
        int result = baseSink.hashCode();
        result = 31 * result + actualSinkClass.hashCode();
        result = 31 * result + taintedValues.hashCode();
        return result;
    }

    /* Returns a semi-shallow copy of this Violation. */
    public Violation copy() {
        return copyWithTaintedValues(new LinkedHashSet<>(taintedValues));
    }

    /* Returns a copy of this Violation but with the specified set of taintedValues. */
    public Violation copyWithTaintedValues(Collection<? extends TaintedSinkValue> newTaintedValues) {
        Violation copy = new Violation(baseSink, actualSinkClass, newTaintedValues);
        copy.setTestInfo(uniqueID, testClass, testMethod);
        return copy;
    }

    /* Returns all of the labels on some tainted value in this instance's taint value set. */
    public LinkedHashSet<SourceInfoTaintLabel> getAllLabels() {
        LinkedHashSet<SourceInfoTaintLabel> labels = new LinkedHashSet<>();
        for(TaintedSinkValue taintedValue : taintedValues) {
            labels.addAll(taintedValue.getTaintSources());
        }
        return labels;
    }
}
