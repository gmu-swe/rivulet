package io.rivulet.internal.rerun;

import edu.columbia.cs.psl.phosphor.runtime.TaintSourceWrapper;
import io.rivulet.ReplacementComparator;
import io.rivulet.internal.SourceInfoTaintLabel;

import java.io.Serializable;
import java.util.*;

/* Stores information needed to execute an Rivulet generated test rerun. */
public class TestRerunConfiguration implements Serializable {

    private static final long serialVersionUID = -4841743631847606347L;
    // Name of the class of the test method that should be rerun
    private String testClass;
    // Name of the test method that should be rerun
    private String testMethod;
    // Class of the auto-tainter instance that should be used to taint values at sources and check values for taint tags
    // at sinks during the rerun
    private final Class<? extends TaintSourceWrapper> autoTainterClass;
    // Set of unique identifiers for the original test run violations that this rerun is attempting to verify
    private final TreeSet<String> violationUIDs;
    // Sorted list of replacements that should be made to qualifying source values
    private final ArrayList<Replacement> replacements;

    /* Constructs a new TestRerunConfiguration with the specified information. */
    protected TestRerunConfiguration(String testClass, String testMethod, Class<? extends TaintSourceWrapper> autoTainterClass, Collection<String> violationUIDs, Set<? extends Replacement> replacements) {
        this.testClass = testClass;
        this.testMethod = testMethod;
        this.autoTainterClass = autoTainterClass;
        this.violationUIDs = new TreeSet<>(violationUIDs);
        this.replacements = new ArrayList<>(replacements);
        this.replacements.sort(ReplacementComparator.getInstance());
    }

    /* Getter for testClass. */
    public String getTestClass() {
        return testClass;
    }

    /* Getter for testMethod. */
    public String getTestMethod() {
        return testMethod;
    }

    /* Getter for autoTainterClass. */
    public Class<? extends TaintSourceWrapper> getAutoTainterClass() {
        return autoTainterClass;
    }

    /* Getter for violationUIDs. */
    public Set<String> getViolationUIDs() {
        return violationUIDs;
    }

    /* Returns a shallow copy of replacements. */
    public List<Replacement> getReplacementsCopy() {
        return new ArrayList<>(replacements);
    }

    /* Returns a list of texts representations of the replacement values for this configuration. */
    public String[] getReplacementRepresentations() {
        String[] ret = new String[replacements.size()];
        int i = 0;
        for(Replacement replacement : replacements) {
            ret[i++] = replacement.toString();
        }
        return ret;
    }

    /* Returns whether this configuration specifies a valid replacement value for a value being tainted with the specified
     * label. */
    public boolean hasReplacementValue(Object originalValue, SourceInfoTaintLabel label) {
        for(Replacement replacement : replacements) {
            if(replacement.isApplicable(originalValue.getClass(), label)) {
                return true;
            }
        }
        return false;
    }

    /* Returns a replacement value for the specified original value or the original value if a replacement could not be
     * generated for the specified original value. */
    public synchronized <T> T getReplacementValue(T originalValue, SourceInfoTaintLabel label) {
        for(Replacement replacement : replacements) {
            if(replacement.isApplicable(originalValue.getClass(), label)) {
                T ret = replacement.getReplacement(originalValue, label);
                if(ret != null) {
                    return ret;
                }
            }
        }
        return originalValue;
    }

    /* Returns whether every required replacement specified in this configuration was successful at least once. */
    public boolean requiredReplacementsSuccessful() {
        for(Replacement replacement : replacements) {
            if(replacement.isRequired() && !replacement.isSuccessful()) {
                return false;
            }
        }
        return true;
    }

    /* Returns whether the specified class and method name match this instance's test class and method name. */
    public boolean matchesTestInfo(String className, String methodName) {
        return testClass.equals(className) && (methodName == null || testMethod.equals(methodName));
    }

    /* Adds information about the test being run to this violation. */
    public void setTestInfo(String uniqueID, String testClass, String testMethod) {
        violationUIDs.clear();
        violationUIDs.add(uniqueID);
        this.testClass = testClass;
        this.testMethod = testMethod;
    }

    /* Adds all of the strings in the specified iterable to violationsUIDs. */
    public void addViolationUniqueIDs(Collection<String> ids) {
        violationUIDs.addAll(ids);
    }

    /* Reruns whether the specified other configuration would result in the same behavior as this configuration during a
     * rerun. */
    public boolean producesSameRerunBehavior(TestRerunConfiguration other) {
        if(testClass == null || testMethod == null || other.testClass == null || other.testMethod == null) {
            // At least one of the configuration is not completely specified
            return false;
        } else if(!testClass.equals(other.testClass) || !testMethod.equals(other.testMethod)) {
            // The configurations specified different tests to be rerun
            return false;
        } else if((autoTainterClass != null && !autoTainterClass.equals(other.autoTainterClass)) || (autoTainterClass == null && other.autoTainterClass != null)) {
            // The configurations specified different auto-tainter classes to check for critical violations or autoTaint source values
            return false;
        } else if(replacements.size() != other.replacements.size()) {
            return false;
        }else {
            // Return whether the configurations define the same replacements
            return replacements.equals(other.replacements);
        }
    }

    /* Returns the number of replacements for this configuration that are required to be successful in order for
     * value replacement to be considered successful for the configuration. */
    public int numberOfRequiredReplacements() {
        int count = 0;
        for(Replacement replacement : replacements) {
            if(replacement.isRequired()) {
                count++;
            }
        }
        return count;
    }

    /* Returns a test representation of this configuration. */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder()
                .append("RerunConfig {")
                .append("\n\tTest: ").append(testClass).append('#').append(testMethod)
                .append("\n\tAutoTainterClass: ").append(autoTainterClass)
                .append("\n\tViolationUIDS: ").append(violationUIDs)
                .append("\n\tReplacements: [");
        for(Replacement r : replacements) {
            builder.append("\n\t\t").append(r);
        }
        return builder.append("\n\t]\n}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestRerunConfiguration that = (TestRerunConfiguration) o;
        if (testClass != null ? !testClass.equals(that.testClass) : that.testClass != null) return false;
        if (testMethod != null ? !testMethod.equals(that.testMethod) : that.testMethod != null) return false;
        if (autoTainterClass != null ? !autoTainterClass.equals(that.autoTainterClass) : that.autoTainterClass != null)
            return false;
        if (violationUIDs != null ? !violationUIDs.equals(that.violationUIDs) : that.violationUIDs != null)
            return false;
        return replacements != null ? replacements.equals(that.replacements) : that.replacements == null;
    }

    @Override
    public int hashCode() {
        int result = testClass != null ? testClass.hashCode() : 0;
        result = 31 * result + (testMethod != null ? testMethod.hashCode() : 0);
        result = 31 * result + (autoTainterClass != null ? autoTainterClass.hashCode() : 0);
        result = 31 * result + (violationUIDs != null ? violationUIDs.hashCode() : 0);
        result = 31 * result + (replacements != null ? replacements.hashCode() : 0);
        return result;
    }

    /* Marks all replacements for this instance as unsuccessful. */
    public void resetReplacements() {
        for(Replacement r : replacements) {
            r.setSuccessful(false);
        }
    }
}
