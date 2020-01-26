package io.rivulet.internal.rerun;

import edu.columbia.cs.psl.phosphor.TaintUtils;
import edu.columbia.cs.psl.phosphor.struct.LazyArrayObjTags;
import io.rivulet.converter.ConversionUtils;
import io.rivulet.converter.ForcedTypeConverter;
import io.rivulet.internal.SourceInfoTaintLabel;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.Map;

/* Stores information about values that should be used to a replace values being tainted at source methods. */
public abstract class Replacement implements Serializable {

    private static final long serialVersionUID = 5794285013577824107L;
    // Value used to represent that any int value should match this value
    public static final int ANY_INT = -2;
    // Whether the success of this replacement impacts the overall success of a rerun
    private final boolean required;
    // Whether at least one value was successfully replaced by this replacement
    private boolean successful = false;

    /* Constructs a new Replacement. */
    protected Replacement(boolean required) {
        this.required = required;
    }

    /* Getter for required. */
    public boolean isRequired() {
        return required;
    }

    /* Getter for successful. */
    public boolean isSuccessful() {
        return successful;
    }

    /* Setter for successful. */
    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    /* Returns whether the replacement value for the specified type and label can be forcibly converted to the specified
     * type. */
    public boolean isApplicable(Class<?> targetType, SourceInfoTaintLabel label) {
        targetType = TaintUtils.getUnwrappedClass(targetType);
        Object replacementValue = getReplacementValue(targetType, label);
        if(replacementValue == null) {
            return false;
        }
        Class<?> sourceType= TaintUtils.getUnwrappedClass(replacementValue.getClass());
        ForcedTypeConverter converter = getConverter(targetType, label);
        if(label.getFullyReplaceable()) {
            if(converter == null) {
                return ConversionUtils.canBeForceConverted(targetType, sourceType);
            } else {
                return converter.canConvert(targetType, sourceType);
            }
        } else {
            if(converter == null) {
                return ConversionUtils.canBeInPlaceForceConverted(targetType, sourceType);
            } else {
                return converter.isInPlace() && converter.canConvert(targetType, sourceType);
            }
        }
    }

    /* Returns the converter specified for the specified type and label or null if no converter is stored for the specified
     * type and label. */
    public abstract ForcedTypeConverter getConverter(Class<?> targetType, SourceInfoTaintLabel label);

    /* Returns the replacement value for the specified type and label or null if no replacement value was is stored for
     * the specified type and label. */
    public abstract Object getReplacementValue(Class<?> targetType, SourceInfoTaintLabel label);

    /* Returns a replacement value of the same type as the specified original value or null if this instance's replacement value
     * could not be forcibly converted to the original values type. */
    @SuppressWarnings("unchecked")
    public <T> T getReplacement(T originalValue, SourceInfoTaintLabel label) {
        try {
            Class<?> clazz = originalValue.getClass();
            Object replacementValue = getReplacementValue(clazz, label);
            if(replacementValue == null) {
                return null;
            }
            ForcedTypeConverter converter = getConverter(clazz, label);
            T result;
            if(converter != null) {
                result = (T)converter.convert(originalValue, getCopy(replacementValue));
            } else if(label.getFullyReplaceable()) {
                result = ConversionUtils.forceConvert(originalValue, getCopy(replacementValue));
            } else {
                result = ConversionUtils.inPlaceForceConvert(originalValue, getCopy(replacementValue));
            }
            if(result != null) {
                successful = true;
            }
            return result;
        } catch(Exception e) {
            return null;
        }
    }

    /* Attempts to return a copy of the specified value, if a copy cannot be made returns the specified value. */
    @SuppressWarnings("unchecked")
    private static Object getCopy(Object value) {
        try {
            if(value instanceof LazyArrayObjTags) {
                Object wrappedArr = ((LazyArrayObjTags) value).getVal();
                Constructor constructor = value.getClass().getConstructor(int.class);
                LazyArrayObjTags copy = (LazyArrayObjTags) constructor.newInstance(Array.getLength(wrappedArr));
                for (int i = 0; i < Array.getLength(wrappedArr); i++) {
                    Array.set(copy.getVal(), i, Array.get(wrappedArr, i));
                }
                return copy;
            } else if(value.getClass().isArray()) {
                return shallowCopyArray(value);
            } else if(value instanceof String) {
                return new String((String)value);
            } else if(value instanceof Map) {
                Map map = (Map)value;
                Map copy = map.getClass().newInstance();
                for(Object o: map.entrySet()) {
                    Map.Entry e = (Map.Entry) o;
                    copy.put(e.getKey(), e.getValue());
                }
            }
        } catch (Exception e) {
            return value;
        }
        return value;
    }

    /* Returns a shallow copy of the specified array object. */
    private static Object shallowCopyArray(Object arr) {
        int length = Array.getLength(arr);
        Object copy = Array.newInstance(arr.getClass().getComponentType(), length);
        for(int i = 0; i < length; i++) {
            Array.set(copy, i, Array.get(arr, i));
        }
        return copy;
    }

    /* Returns a shallow copy of this replacement. */
    public abstract Replacement copy();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Replacement that = (Replacement) o;
        if (required != that.required) return false;
        return successful == that.successful;

    }

    @Override
    public int hashCode() {
        int result = (required ? 1 : 0);
        result = 31 * result + (successful ? 1 : 0);
        return result;
    }

    /* Returns a text representation of this replacement indented the specified amount. */
    public abstract String toString(int indent);
}
