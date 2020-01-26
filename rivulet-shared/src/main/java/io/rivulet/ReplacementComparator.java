package io.rivulet;

import io.rivulet.converter.ForcedTypeConverter;
import io.rivulet.internal.rerun.Replacement;
import io.rivulet.internal.rerun.ReplacementImpl;
import io.rivulet.internal.rerun.ReplacementSet;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* Comparator for partially ordering Replacements. Compares Replacement instances in a way that considers how "specific"
 * the Replacement instances are. */
public class ReplacementComparator implements Comparator<Replacement>, Serializable {

    private static final long serialVersionUID = 2444262061410133111L;

    /* Constructs a new ReplacementComparator instance. */
    private ReplacementComparator() {

    }

    /* Compares the two specified Replacement instances. Assume that the only concrete implementations of Replacement are
     * ReplacementSet and ReplacementImpl. */
    @Override
    public int compare(Replacement r1, Replacement r2) {
        // Required replacements should come before non-required ones
        if(r1.isRequired() != r2.isRequired()) {
            return r1.isRequired() ? -1 : 1;
        }
        // ReplacementImpls should come before ReplacementSets
        if(r1.getClass() != r2.getClass()) {
            return (r1 instanceof ReplacementImpl) ? -1 : 1;
        }
        if(r1 instanceof ReplacementImpl && r2 instanceof ReplacementImpl) {
            return compare((ReplacementImpl) r1, (ReplacementImpl)r2);
        } else if(r1 instanceof ReplacementSet && r2 instanceof  ReplacementSet) {
            return compare((ReplacementSet) r1, (ReplacementSet) r2);
        } else {
            return 0;
        }
    }

    /* Compares the two specified ReplacementImpl instances. If a field is checked where one of the specified ReplacementImpl
     * instances has a null value and the other has a non-null value, the ReplacementImpl with the non-null value should be
     * considered to be "less than" the other ReplacementImpl as it is more specific about the conditions under which it
     * will replace a value. */
    public int compare(ReplacementImpl r1, ReplacementImpl r2) {
        // Compare their targetSourceArgIndices
        int argIndex1 = r1.getTargetedSourceArgIndex();
        int argIndex2 = r2.getTargetedSourceArgIndex();
        if(argIndex1 != argIndex2) {
            if(argIndex1 == Replacement.ANY_INT) {
                // r1 is less specific than r2
                return 1;
            } else if(argIndex2 == Replacement.ANY_INT) {
                // r1 is more specific than r2
                return -1;
            } else {
                // Lower targeted source arg index should come first
                return argIndex1 - argIndex2;
            }
        }
        // Compare their targetedBaseSources
        int compare = compareWithNulls(r1.getTargetedBaseSource(), r2.getTargetedBaseSource());
        if(compare != 0) {
            return compare;
        }
        // Compare their targetedActualSourceClasses
        compare = compareWithNulls(r1.getTargetedActualSourceClass(), r2.getTargetedActualSourceClass());
        if(compare != 0) {
            return compare;
        }
        // Check their converters
        ForcedTypeConverter converter1 = r1.getConverter();
        ForcedTypeConverter converter2 = r2.getConverter();
        if(!Objects.equals(converter1, converter2)) {
            if(converter1 == null) {
                // r1 doesn't require a specialized converter
                return 1;
            } else if(converter2 == null) {
                // r2 doesn't require a specialized converter
                return -1;
            } else if(!converter1.toString().equals(converter2.toString())) {
                return converter1.toString().compareTo(converter2.toString());
            }
        }
        // Compare their targetedSourceValueClasses' names
        Class<?> valueClazz1 = r1.getTargetedSourceValueClass();
        Class<?> valueClazz2 = r2.getTargetedSourceValueClass();
        if(valueClazz1 != valueClazz2) {
            if(valueClazz1 == null) {
                // r1 is less specific than r2
                return 1;
            } else if(valueClazz2 == null) {
                // r1 is more specific than r2
                return -1;
            } else {
                return compareWithNulls(valueClazz1.getName(), valueClazz2.getName());
            }
        }
        // Compare their targetedInvocationIDs
        int[] targetedInvocationIDs1 = r1.getTargetedInvocationIDs();
        int[] targetedInvocationIDs2 = r2.getTargetedInvocationIDs();
        if(targetedInvocationIDs1 != targetedInvocationIDs2) {
            if(targetedInvocationIDs1 == null) {
                // r1 is less specific than r2
                return 1;
            } else if(targetedInvocationIDs2 == null) {
                // r1 is more specific than r2
                return -1;
            } else if(targetedInvocationIDs1.length != targetedInvocationIDs2.length) {
                // Lower number of targeted ids should come first
                return targetedInvocationIDs1.length - targetedInvocationIDs2.length;
            } else {
                for(int i = 0; i < targetedInvocationIDs1.length; i++) {
                    if(targetedInvocationIDs1[i] != targetedInvocationIDs2[i]) {
                        return targetedInvocationIDs1[i] - targetedInvocationIDs2[i];
                    }
                }
            }
        }
        // Compare their replacement Values if possible
        Object value1 = r1.getReplacementValue(null, null);
        Object value2 = r2.getReplacementValue(null, null);
        if(value1 instanceof String && value2 instanceof String) {
            return ((String) value1).compareTo((String) value2);
        }
        return 0;
    }

    /* Compares the two specified ReplacementSet instances. */
    public int compare(ReplacementSet s1, ReplacementSet s2) {
        List<Replacement> list1 = s1.getSortedReplacementsCopy();
        List<Replacement> list2 = s2.getSortedReplacementsCopy();
        // Compare the size of their replacements
        if(list1.size() != list2.size()) {
            // The one with the smaller set should come first
            return list2.size() - list1.size();
        }
        // Compare their replacements
        Iterator<Replacement> it1 = list1.iterator();
        Iterator<Replacement> it2 = list2.iterator();
        while(it1.hasNext() && it2.hasNext()) {
            int compare = ReplacementComparator.getInstance().compare(it1.next(), it2.next());
            if(compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    /* Returns 0 if the specified objects are equal. Returns a negative number if the first object is less than the second
     * or the second instance is null. Returns a positive number if the first object is greater than the second of the
     * first instance if null; */
    private static <T extends Comparable<T>> int compareWithNulls(T obj1, T obj2) {
        if(obj1 == obj2) {
            return 0;
        } else if(obj1 == null) {
            return 1;
        } else if(obj2 == null) {
            return -1;
        } else {
            return obj1.compareTo(obj2);
        }
    }

    /* Provides access to the single instance of ReplacementComparator. */
    public static ReplacementComparator getInstance() {
        return ReplacementComparatorSingleton.INSTANCE;
    }

    /* Inner class used to provide access to the single instance of ReplacementComparator and ensure that only one instance
     * of ReplacementComparator is ever created. */
    private static class ReplacementComparatorSingleton {
        private static final ReplacementComparator INSTANCE = new ReplacementComparator();
    }
}
