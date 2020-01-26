package io.rivulet.internal.rerun;

import edu.columbia.cs.psl.phosphor.runtime.TaintSourceWrapper;
import edu.columbia.cs.psl.phosphor.struct.SinglyLinkedList;
import io.rivulet.internal.Violation;

import java.util.*;

/* Builds valid TestRerunConfiguration instances for a violation based on certain criteria. */
public class RerunConfigBuilder {

    // The autoTaintClass of TestRerunConfigurations built from this builder.
    private Class<? extends TaintSourceWrapper> autoTainterClass;
    // List of ReplacementBuilders used to construct replacement sets for TestRerunConfigurations built from this builder.
    private SinglyLinkedList<ReplacementBuilder> replacementBuilders;

    /* Constructs a new RerunConfigBuilder with an empty replacement builder list. */
    public RerunConfigBuilder() {
        this.autoTainterClass = null;
        this.replacementBuilders = new SinglyLinkedList<>();
    }

    /* Adds the specified ReplacementBuilder to replacementBuilders. Returns this builder. */
    public RerunConfigBuilder addReplacementBuilder(ReplacementBuilder builder) {
        this.replacementBuilders.enqueue(builder);
        return this;
    }

    /* Sets autoTaintClass to the specified value. Returns this builder. */
    public RerunConfigBuilder autoTainterClass(Class<? extends TaintSourceWrapper> autoTainterClass) {
        this.autoTainterClass = autoTainterClass;
        return this;
    }

    /* Throws a runtime exception if this builder specifies invalid rerun configuration construction criteria. */
    public void validate() {
        if(replacementBuilders.isEmpty()) {
            throw new RuntimeException("At least one replacement builder must be specified in a RerunConfigBuilder.");
        } else if(autoTainterClass == null) {
            throw new RuntimeException("An auto-tainter class must be specified in a RerunConfigBuilder.");
        } else {
            for(ReplacementBuilder builder : replacementBuilders) {
                if(builder.isRequiredForGeneration()) {
                    return;
                }
            }
            throw new RuntimeException("At least one of a RerunConfigBuilder's replacement builders must be a required payload replacement builder.");
        }
    }

    /* Returns a list of valid TestRerunConfigurations that can be built based on this builds fields to verify the
     * specified violation */
    public List<TestRerunConfiguration> build(Violation violation) {
        validate();
        LinkedList<TestRerunConfiguration> configs = new LinkedList<>();
        for(LinkedHashSet<Replacement> combo : getAllCombinations(replacementBuilders, violation)) {
            LinkedHashSet<String> violationUIDs = new LinkedHashSet<>();
            if(violation.getUniqueID() != null) {
                violationUIDs.add(violation.getUniqueID());
            }
            LinkedHashSet<Replacement> replacements = new LinkedHashSet<>();
            for(Replacement r : combo) {
                replacements.add(r.copy());
            }
            if(!hasConflict(replacements)) {
                configs.add(new TestRerunConfiguration(violation.getTestClass(), violation.getTestMethod(), autoTainterClass, violationUIDs, replacements));
            }
        }
        return configs;
    }

    /* Returns all combinations of replacements for the given violation that use one replacement from each builder. */
    public static LinkedHashSet<LinkedHashSet<Replacement>> getAllCombinations(SinglyLinkedList<ReplacementBuilder> replacementBuilders, Violation violation) {
        LinkedList<LinkedHashSet<Replacement>> replacementGroups = new LinkedList<>();
        for(ReplacementBuilder builder : replacementBuilders) {
            LinkedHashSet<Replacement> replacements = builder.build(violation);
            if(!replacements.isEmpty()) {
                replacementGroups.add(replacements);
            } else if(builder.isRequiredForGeneration()) {
                // Some builder whose replacements are required for generation could not generate a valid replacement
                return new LinkedHashSet<>();
            }
        }
        LinkedHashSet<LinkedHashSet<Replacement>> combos = new LinkedHashSet<>();
        while(!replacementGroups.isEmpty()) {
            LinkedHashSet<Replacement> replacements = replacementGroups.pop();
            LinkedHashSet<LinkedHashSet<Replacement>> temp = new LinkedHashSet<>();
            for(Replacement replacement : replacements) {
                if(combos.isEmpty()) {
                    LinkedHashSet<Replacement> set = new LinkedHashSet<>();
                    set.add(replacement);
                    temp.add(set);
                } else {
                    for(LinkedHashSet<Replacement> combo : combos) {
                        LinkedHashSet<Replacement> copy = new LinkedHashSet<>(combo);
                        copy.add(replacement);
                        temp.add(copy);
                    }
                }
            }
            combos = temp;
        }
        return combos;
    }

    /* Returns whether there is a conflict between any two required replacements in the specified set. Remove any
     * non-required replacements in conflict with required ones. */
    private static boolean hasConflict(LinkedHashSet<Replacement> replacements) {
        if(replacements.size() == 1) {
            // The only replacement cannot be in conflict with itself.
            return false;
        } else {
            LinkedList<Replacement> copy = new LinkedList<>(replacements);
            while(!copy.isEmpty()) {
                Replacement r1 = copy.pop();
                Iterator<Replacement> it = copy.iterator();
                while(it.hasNext()) {
                    Replacement r2 = it.next();
                    if(hasConflict(r1, r2)) {
                        if(r1.isRequired() && r2.isRequired()) {
                            return true;
                        } else if(r1.isRequired()) {
                            it.remove();
                            replacements.remove(r2);
                        } else {
                            replacements.remove(r1);
                            break;
                        }
                    }
                }
            }
            return false;
        }
    }

    /* Returns whether the two specified replacements cannot both successfully occur in the same rerun. */
    private static boolean hasConflict(Replacement r1, Replacement r2) {
        if(r1 instanceof ReplacementImpl && r2 instanceof ReplacementImpl) {
            return ((ReplacementImpl) r1).hasConflict((ReplacementImpl) r2);
        } else if(r1 instanceof ReplacementSet) {
            for(Replacement r : ((ReplacementSet) r1).getSortedReplacementsCopy()) {
                if(hasConflict(r, r2)) {
                    return true;
                }
            }
        } else if(r2 instanceof ReplacementSet) {
            for(Replacement r : ((ReplacementSet) r2).getSortedReplacementsCopy()) {
                if(hasConflict(r1, r)) {
                    return true;
                }
            }
        }
        return false;
    }
}
