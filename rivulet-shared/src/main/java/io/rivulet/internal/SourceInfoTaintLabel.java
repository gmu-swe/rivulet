package io.rivulet.internal;

import edu.columbia.cs.psl.phosphor.runtime.AutoTaintLabel;

import java.io.Serializable;

/* Label that stores information about the source argument originally tainted. Used to taint elements. */
public class SourceInfoTaintLabel extends AutoTaintLabel implements Serializable {

    private static final long serialVersionUID = 8234534183405622086L;
    // Name of the class of the actual source method whose invocation caused this label to be generated
    private final String actualSourceClass;
    // -1 if the value tainted with this label was the return value of the source method, otherwise the index of the argument
    // of the source method that received this label starting from 0.
    private final int sourceArgIndex;
    // Class of the value that was tainted with this label when this label was generated
    private final Class<?> sourceValueClass;
    // Whether the entire value tainted with this label could be replaced at the source during a test rerun
    private final boolean fullyReplaceable;

    /* Constructs a new label with the specified information. */
    public SourceInfoTaintLabel(String baseSource, String actualSource, int sourceArgIndex, Class<?> sourceValueClass, boolean fullyReplaceable) {
        super(baseSource, null);
        this.actualSourceClass = actualSource.substring(0, actualSource.indexOf("."));
        this.sourceArgIndex = sourceArgIndex;
        this.sourceValueClass = sourceValueClass;
        this.fullyReplaceable = fullyReplaceable;
    }

    /* Constructs a new label with the same information as the specified other label. */
    protected SourceInfoTaintLabel(SourceInfoTaintLabel other) {
        super(other.getBaseSource(), null);
        this.actualSourceClass = other.actualSourceClass;
        this.sourceArgIndex = other.sourceArgIndex;
        this.sourceValueClass = other.sourceValueClass;
        this.fullyReplaceable = other.fullyReplaceable;
    }

    /* Constructs a new label with the same information as the specified other label, but with the specified sourceValueClass
     * and fullyReplaceable values. */
    protected SourceInfoTaintLabel(SourceInfoTaintLabel other, Class<?> sourceValueClass, boolean fullyReplaceable) {
        super(other.getBaseSource(), null);
        this.actualSourceClass = other.actualSourceClass;
        this.sourceArgIndex = other.sourceArgIndex;
        this.sourceValueClass = sourceValueClass;
        this.fullyReplaceable = fullyReplaceable;
    }

    /* Returns a SourceInfoTaintLabel copy of this label but without added subclass information. */
    public SourceInfoTaintLabel copyBaseLabel() {
        return new SourceInfoTaintLabel(this);
    }

    /* Returns the name of source method from which the actual source method inherited its status as a source. */
    public String getBaseSource() {
        return getSource();
    }

    /* Getter for actualSourceClass. */
    public String getActualSourceClass() {
        return actualSourceClass;
    }

    /* Getter for sourceArgIndex. */
    public int getSourceArgIndex() {
        return sourceArgIndex;
    }

    /* Getter for for sourceValueClass. */
    public Class<?> getSourceValueClass() {
        return sourceValueClass;
    }

    /* Getter for fullyReplaceable. */
    public boolean getFullyReplaceable() {
        return fullyReplaceable;
    }

    /* Returns a text representation of this label. */
    @Override
    public String toString() {
        return String.format("SourceInfoTaintLabel{baseSource=%s, actualSourceClass=%s, sourceArgIndex=%d, sourceValueClass=%s}", getBaseSource(), actualSourceClass, sourceArgIndex, sourceValueClass);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SourceInfoTaintLabel that = (SourceInfoTaintLabel) o;
        if (sourceArgIndex != that.sourceArgIndex) return false;
        if (fullyReplaceable != that.fullyReplaceable) return false;
        if (!actualSourceClass.equals(that.actualSourceClass)) return false;
        return sourceValueClass.equals(that.sourceValueClass);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + actualSourceClass.hashCode();
        result = 31 * result + sourceArgIndex;
        result = 31 * result + sourceValueClass.hashCode();
        result = 31 * result + (fullyReplaceable ? 1 : 0);
        return result;
    }
}