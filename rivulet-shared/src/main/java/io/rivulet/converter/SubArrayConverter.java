package io.rivulet.converter;

import java.lang.reflect.Array;

/* Converts by replacing the elements of a target array between some range with the elements of a source array. */
public class SubArrayConverter extends ForcedTypeConverter {

    private static final long serialVersionUID = -2653448456225496946L;
    // The inclusive start index of the range to be replaced
    private final int start;
    // The exclusive end index of the range to be replaced
    private final int end;

    /* Constructs a new SubArrayConverter that replaces the elements a target array from the specified start index
     * (inclusive) to the specified end index (exclusive) with the elements of a source array. */
    public SubArrayConverter(int start, int end) {
        super(ConverterPriority.VERY_LOW);
        if(start < 0 || end <= start) {
            throw new RuntimeException(String.format("Invalid sub-array range: [%d, %d))", start, end));
        }
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean isInPlace() {
        return false;
    }

    @Override
    public boolean canConvert(Class<?> targetType, Class<?> sourceType) {
        return targetType.isArray() && sourceType.isArray() && targetType.getComponentType().isAssignableFrom(sourceType.getComponentType());
    }

    @Override
    public Object convert(Object target, Object source) {
        try {
            if(source.getClass().isArray() && target == null) {
                return source;
            } else if(canConvert(target.getClass(), source.getClass())) {
                int targetLength = Array.getLength(target);
                int srcLength = Array.getLength(source);
                int length = (targetLength > end) ? (targetLength-end) + srcLength + start : srcLength + start;
                Object array = Array.newInstance(target.getClass().getComponentType(), length);
                int index = 0;
                for(int targetIndex = 0; targetIndex < start; targetIndex++, index++) {
                    Array.set(array, index, Array.get(target, targetIndex));
                }
                for(int srcIndex = 0; srcIndex < srcLength; srcIndex++, index++) {
                    Array.set(array, index, Array.get(source, srcIndex));
                }
                for(int targetIndex = end; targetIndex < targetLength; targetIndex++, index++) {
                    Array.set(array, index, Array.get(target, targetIndex));
                }
                return array;
            } else {
                return null;
            }
        } catch(Exception e) {
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubArrayConverter that = (SubArrayConverter) o;
        if (start != that.start) return false;
        return end == that.end;
    }

    @Override
    public int hashCode() {
        int result = start;
        result = 31 * result + end;
        return result;
    }

    @Override
    public String toString() {
        return String.format("<SubArrayConverter: [%d, %d)>", start, end);
    }
}
