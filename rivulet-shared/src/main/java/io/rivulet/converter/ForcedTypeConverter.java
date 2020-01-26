package io.rivulet.converter;

import java.io.Serializable;
import java.util.Comparator;

/* Represents some way of generating an instance of a particular type from a source object. */
public abstract class ForcedTypeConverter implements Serializable {

    private static final long serialVersionUID = 8971125134678371744L;

    // The precedence of this converter relative to other converters
    private final ConverterPriority priority;

    /* Constructs a new converter with the specified priority. */
    public ForcedTypeConverter(ConverterPriority priority) {
        this.priority = priority;
    }

    /* Returns whether "conversion" occurs by replacing fields of the target instance, rather than by creating a new instance. */
    public abstract boolean isInPlace();

    /* Returns whether an instance of the specified target type can be forcibly converted from an instance of specified source
     * type using this converter. */
    public abstract boolean canConvert(Class<?> targetType, Class<?> sourceType);

    /* Returns an instance of same type as the specified target object by forcibly converting the specified source object
     * or null if forced conversion is not possible. */
    public abstract Object convert(Object target, Object source);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForcedTypeConverter converter = (ForcedTypeConverter) o;
        return priority == converter.priority;
    }

    @Override
    public int hashCode() {
        return priority.hashCode();
    }

    /* Compares ForcedTypeConverters based on their priority.*/
    public static final class ConverterComparator implements Comparator<ForcedTypeConverter> {

        private ConverterComparator() {
            super();
        }

        private static final ConverterComparator INSTANCE = new ConverterComparator();

        public static ConverterComparator getInstance() {
            return  INSTANCE;
        }

        @Override
        public int compare(ForcedTypeConverter o1, ForcedTypeConverter o2) {
            return o1.priority.compareTo(o2.priority);
        }
    }
}
