package io.rivulet.internal.rerun;

import io.rivulet.ReplacementComparator;
import io.rivulet.converter.ForcedTypeConverter;
import io.rivulet.internal.SourceInfoTaintLabel;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/* Represents a set of replacements that can be interchanged depending on what source methods are actually being used.
 * Only one of the replacements in the set must succeed during the rerun in order for the set as a whole to be considered
 * successful. */
public class ReplacementSet extends Replacement {

    private static final long serialVersionUID = -1038439981489020945L;

    // The set of replacements being grouped together
    private final LinkedHashSet<Replacement> replacements;
    // Cached sorted list of the element of replacements or null if the current value of replacements has not been sorted
    private List<Replacement> sortedReplacements;

    /* Constructs a new empty ReplacementSet. */
    public ReplacementSet(boolean required) {
        super(required);
        this.replacements = new LinkedHashSet<>();
        this.sortedReplacements = null;
    }

    /* If sortedReplacements is null, sets sortedReplacements to be a sorted list containing the elements of replacements.
     * Returns sortedReplacements. */
    private List<Replacement> getSortedReplacements() {
        if(sortedReplacements == null) {
            sortedReplacements = new ArrayList<>(replacements);
            sortedReplacements.sort(ReplacementComparator.getInstance());
        }
        return sortedReplacements;
    }

    /* If sortedReplacements is null, calculates sortedReplacements. Returns a copy of sortedReplacements. */
    public List<Replacement> getSortedReplacementsCopy() {
        return new ArrayList<>(getSortedReplacements());
    }

    /* Adds the specified replacement to the set. */
    public void addReplacement(Replacement replacement) {
        replacements.add(replacement);
        sortedReplacements = null; // Invalidates cached sorted list
    }

    @Override
    public ForcedTypeConverter getConverter(Class<?> targetType, SourceInfoTaintLabel label) {
        for(Replacement r : getSortedReplacements()) {
            if(r.isApplicable(targetType, label)) {
                return r.getConverter(targetType, label);
            }
        }
        return null;
    }

    @Override
    public Object getReplacementValue(Class<?> targetType, SourceInfoTaintLabel label) {
        for(Replacement r : getSortedReplacements()) {
            if(r.isApplicable(targetType, label)) {
                return r.getReplacementValue(targetType, label);
            }
        }
        return null;
    }

    @Override
    public Replacement copy() {
        ReplacementSet copy = new ReplacementSet(isRequired());
        for(Replacement r : replacements) {
            copy.addReplacement(r.copy());
        }
        copy.setSuccessful(isSuccessful());
        return copy;
    }

    /* Returns a text representation of this instance. */
    @Override
    public String toString() {
       return String.format("set: {%s}", getSortedReplacements().toString());
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        if(!super.equals(o)) return false;
        ReplacementSet that = (ReplacementSet) o;
        return getSortedReplacements().equals(that.getSortedReplacements());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getSortedReplacements().hashCode();
        return result;
    }

    @Override
    public String toString(int indent) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < indent; i++) {
            builder.append("\t");
        }
        return builder.append(String.format("ReplacementSet: (size=%d)",replacements.size())).toString();
    }
}
