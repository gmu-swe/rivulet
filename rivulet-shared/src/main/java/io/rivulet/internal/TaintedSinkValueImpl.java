package io.rivulet.internal;

import edu.columbia.cs.psl.phosphor.runtime.Taint;

import java.util.Collections;
import java.util.List;

/* Stores information about a single tainted value that was passed as an argument to a sink method at a particular
 * argument index. */
public class TaintedSinkValueImpl extends TaintedSinkValue {

    private static final long serialVersionUID = 4570655916959523458L;
    // Text representation of the tainted value that reached the sink
    private final String sinkValue;

    /* Constructs a new TaintedSinkValueImpl whose taintSources set initially contains the labels of the specified taint.  */
    public TaintedSinkValueImpl(String sinkValue, Class<?> sinkValueClass, int sinkArgIndex, Taint<SourceInfoTaintLabel> taint) {
        super(sinkValueClass, sinkArgIndex, taint);
        this.sinkValue = (sinkValue == null) ? "" : sinkValue;
    }

    /* Constructs a new TaintedSinkValueImpl with an initially empty set of taintSources. */
    public TaintedSinkValueImpl(String sinkValue, Class<?> sinkValueClass, int sinkArgIndex) {
        super(sinkValueClass, sinkArgIndex);
        this.sinkValue = (sinkValue == null) ? "" : sinkValue;
    }

    /* Getter for sinkValue. */
    public String getSinkValue() {
        return sinkValue;
    }

    /* Returns a list containing the single sinkValue of this instance. */
    @Override
    protected List<String> getSinkValues() {
        return Collections.singletonList(sinkValue);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        if(!super.equals(o)) return false;
        TaintedSinkValueImpl that = (TaintedSinkValueImpl) o;
        return sinkValue.equals(that.sinkValue);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + sinkValue.hashCode();
        return result;
    }

    /* Returns a shallow copy of this TaintedSinkValueImpl. */
    public TaintedSinkValueImpl copy() {
        return copyWithSinkValue(sinkValue);
    }

    /* Returns a shallow copy of this TaintedSinkValueImpl but with its sinkValue as the specified value. */
    public TaintedSinkValueImpl copyWithSinkValue(String newSinkValue) {
        TaintedSinkValueImpl copy = new TaintedSinkValueImpl(newSinkValue, getSinkValueClass(), getSinkArgIndex());
        copy.getTaintSources().addAll(getTaintSources());
        return copy;
    }

    /* Returns a semi-shallow copy of this TaintedSinkValueImpl but with its sinkValue set to null and the indexInfo of all of
     * its taint sources set to null. */
    public TaintedSinkValueImpl copyWithoutSinkValueOrIndexInfo() {
        TaintedSinkValueImpl copy = new TaintedSinkValueImpl(null, getSinkValueClass(), getSinkArgIndex());
        for(SourceInfoTaintLabel label : getTaintSources()) {
            copy.getTaintSources().add(label.copyBaseLabel());
        }
        return copy;
    }
}
