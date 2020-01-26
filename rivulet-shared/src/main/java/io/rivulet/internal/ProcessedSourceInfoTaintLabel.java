package io.rivulet.internal;

import java.util.LinkedHashMap;

/* A label not used to taint values, but instead used to aggregate index information from multiple other labels. */
public class ProcessedSourceInfoTaintLabel extends SourceInfoTaintLabel {

    private static final long serialVersionUID = -8650572663257515921L;
    // Maps invocation IDs to InvocationRanges
    private final LinkedHashMap<Integer, InvocationRanges> indexInfoMap;

    /* Constructs a new label with the same base information as the specified label and an empty indexInfoMap. */
    public ProcessedSourceInfoTaintLabel(SourceInfoTaintLabel label) {
        super(label);
        this.indexInfoMap = new LinkedHashMap<>();
    }

    /* Getter for indexInfoMap. */
    public LinkedHashMap<Integer, InvocationRanges> getIndexInfoMap() {
        return indexInfoMap;
    }

    /* Returns whether the base information for this label matches the base information for the specified other label. */
    public boolean baseInfoMatches(SourceInfoTaintLabel other) {
        if(this.getSourceArgIndex() != other.getSourceArgIndex()) {
            return false;
        } else if(this.getFullyReplaceable() != other.getFullyReplaceable()) {
            return false;
        } else if(!this.getActualSourceClass().equals(other.getActualSourceClass())) {
            return false;
        } else if(!this.getSourceValueClass().equals(other.getSourceValueClass())) {
            return false;
        } else {
            return this.getBaseSource().equals(other.getBaseSource());
        }
    }

    /* Adds the specified InvocationRanges instance to indexInfoMap. */
    public void addIndexInfo(InvocationRanges ranges) {
        if(indexInfoMap.containsKey(ranges.getInvocationID())) {
            indexInfoMap.get(ranges.getInvocationID()).merge(ranges);
        } else {
            indexInfoMap.put(ranges.getInvocationID(), ranges);
        }
    }

    /* Returns a text representation of this label. */
    @Override
    public String toString() {
        return String.format("ProcessedSourceInfoTaintLabel{baseSource=%s, actualSourceClass=%s, sourceArgIndex=%d, sourceValueClass=%s, indexInfo=%s}",
                getBaseSource(), getActualSourceClass(), getSourceArgIndex(), getSourceValueClass(), indexInfoMap.values());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProcessedSourceInfoTaintLabel that = (ProcessedSourceInfoTaintLabel) o;
        return indexInfoMap.equals(that.indexInfoMap);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + indexInfoMap.hashCode();
        return result;
    }
}
