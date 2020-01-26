package io.rivulet.internal;

import java.util.*;

/* Stores information about a set of tainted values that were passed as arguments to a sink method at a particular
 * argument index. Used to help with merging violations that are the same except for their sinkValues. */
public class TaintedSinkValueSet extends TaintedSinkValue {

    private static final long serialVersionUID = 4570655916959523458L;
    // Text representations of the tainted values that reached the sink
    private final TreeSet<String> sinkValues;

    /* Constructs a new TaintedSinkValueSet with the information from the specified TaintedSinkValue Converts all of the
     * taintSource labels of the specified TaintedSinkValue into ProcessedSourceInfoTaintLabels. */
    private TaintedSinkValueSet(TaintedSinkValue value) {
        super(value.getSinkValueClass(), value.getSinkArgIndex());
        for(SourceInfoTaintLabel label : value.getTaintSources()) {
            getTaintSources().add(new ProcessedSourceInfoTaintLabel(label));
        }
        this.sinkValues = new TreeSet<>();
    }

    /* Getter for sinkValues. */
    public List<String> getSinkValues() {
        return new LinkedList<>(sinkValues);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TaintedSinkValueSet that = (TaintedSinkValueSet) o;
        return sinkValues.equals(that.sinkValues);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + sinkValues.hashCode();
        return result;
    }

    /* Adds indexInfo information from the labels of the specified actualValue to the labels of the specified baseValue. */
    private static void mergeIndexInfo(TaintedSinkValueSet baseValue, TaintedSinkValueImpl actualValue) {
        LinkedHashSet<SourceInfoTaintLabel> baseSources = baseValue.getTaintSources();
        LinkedHashSet<SourceInfoTaintLabel> actualSources = actualValue.getTaintSources();
        for(SourceInfoTaintLabel actualLabel : actualSources) {
            if(actualLabel instanceof IndexedSourceInfoTaintLabel) {
                InvocationRanges indexInfo = ((IndexedSourceInfoTaintLabel) actualLabel).getIndexInfoCopy();
                for(SourceInfoTaintLabel baseLabel : baseSources) {
                    if(baseLabel instanceof ProcessedSourceInfoTaintLabel && ((ProcessedSourceInfoTaintLabel) baseLabel).baseInfoMatches(actualLabel)) {
                        ((ProcessedSourceInfoTaintLabel) baseLabel).addIndexInfo(indexInfo);
                    }
                }
            }
        }
    }

    /* Merges the specified list of actualSets which match the specified baseSet into a single set. */
    private static LinkedHashSet<TaintedSinkValueSet> mergeTaintedValues(LinkedHashSet<TaintedSinkValueImpl> baseSet, LinkedList<LinkedHashSet<TaintedSinkValueImpl>> actualSets) {
        // Map each base TaintedSinkValueImpl to a TaintedSinkValueSet created from it
        LinkedHashMap<TaintedSinkValueImpl, TaintedSinkValueSet> map = new LinkedHashMap<>();
        for(TaintedSinkValueImpl baseImpl : baseSet) {
            map.put(baseImpl, new TaintedSinkValueSet(baseImpl));
        }
        // Extract information from the actual sets
        for(LinkedHashSet<TaintedSinkValueImpl> actualSet : actualSets) {
            for(TaintedSinkValueImpl actualImpl : actualSet) {
                TaintedSinkValueSet match = map.get(actualImpl.copyWithoutSinkValueOrIndexInfo());
                // Add sinkValue information
                match.sinkValues.add(actualImpl.getSinkValue());
                // Add indexInfo information to the labels
                mergeIndexInfo(match, actualImpl);
            }
        }
        return new LinkedHashSet<>(map.values());
    }

    /* Merges violations that are the same except for their sinkValues and indexInfo together. Returns a mapping from
     * these merged violation to lists of the original violations that were merged to form them. */
    public static LinkedHashMap<Violation, LinkedList<Violation>> mergeViolations(Iterable<Violation> violations) {
        // Maps base violations (violations with their taintedValues removed) to a mapping between sets of base TaintedSinkValueImpls
        // (TaintedSinkValueImpl with their sinkValue and indexInfo removed) to a list of sets TaintedSinkValueImpls that match
        // the base TaintedSinkValueImpl set
        LinkedHashMap<Violation, LinkedHashMap<LinkedHashSet<TaintedSinkValueImpl>, LinkedList<LinkedHashSet<TaintedSinkValueImpl>>>> map = new LinkedHashMap<>();
        LinkedHashMap<Violation, LinkedHashMap<LinkedHashSet<TaintedSinkValueImpl>, LinkedList<Violation>>> originalViolationMap = new LinkedHashMap<>();
        for(Violation v : violations) {
            Violation baseViolation = v.copyWithTaintedValues(new LinkedHashSet<>());
            map.putIfAbsent(baseViolation, new LinkedHashMap<>());
            originalViolationMap.putIfAbsent(baseViolation, new LinkedHashMap<>());
            LinkedHashMap<LinkedHashSet<TaintedSinkValueImpl>, LinkedList<LinkedHashSet<TaintedSinkValueImpl>>> baseToActualSetMap = map.get(baseViolation);
            LinkedHashMap<LinkedHashSet<TaintedSinkValueImpl>, LinkedList<Violation>> baseSetToOriginalViolationMap = originalViolationMap.get(baseViolation);
            LinkedHashSet<TaintedSinkValueImpl> baseSet = new LinkedHashSet<>();
            LinkedHashSet<TaintedSinkValueImpl> actualSet = new LinkedHashSet<>();
            for(TaintedSinkValue value : v.getTaintedValues()) {
                if(value instanceof TaintedSinkValueImpl) {
                    baseSet.add(((TaintedSinkValueImpl)value).copyWithoutSinkValueOrIndexInfo());
                    actualSet.add((TaintedSinkValueImpl)value);
                }
            }
            baseToActualSetMap.putIfAbsent(baseSet, new LinkedList<>());
            baseToActualSetMap.get(baseSet).add(actualSet);
            baseSetToOriginalViolationMap.putIfAbsent(baseSet, new LinkedList<>());
            baseSetToOriginalViolationMap.get(baseSet).add(v);
        }
        LinkedHashMap<Violation, LinkedList<Violation>>  result = new LinkedHashMap<>();
        for(Violation baseViolation : map.keySet()) {
            for(LinkedHashSet<TaintedSinkValueImpl> baseSet : map.get(baseViolation).keySet()) {
                Violation mergedViolation = baseViolation.copyWithTaintedValues(mergeTaintedValues(baseSet, map.get(baseViolation).get(baseSet)));
                result.put(mergedViolation, originalViolationMap.get(baseViolation).get(baseSet));
            }
        }
        return result;
    }

    /* Returns a copy of the specified violation but with it's taintedValues merged. */
    public static Violation processViolation(Violation violation) {
        // Map each base TaintedSinkValueImpl to a TaintedSinkValueSet created from it
        LinkedHashMap<TaintedSinkValueImpl, TaintedSinkValueSet> map = new LinkedHashMap<>();
        for(TaintedSinkValue value : violation.getTaintedValues()) {
            if(value instanceof TaintedSinkValueImpl) {
                TaintedSinkValueImpl valueImpl = (TaintedSinkValueImpl) value;
                TaintedSinkValueImpl base = valueImpl.copyWithoutSinkValueOrIndexInfo();
                if(!map.containsKey(base)) {
                    map.put(base, new TaintedSinkValueSet(valueImpl));
                }
                map.get(base).sinkValues.add(valueImpl.getSinkValue());
                mergeIndexInfo(map.get(base), valueImpl);
            }
        }
        return violation.copyWithTaintedValues(map.values());
    }
}
