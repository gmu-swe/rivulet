package io.rivulet.converter;

import java.util.HashMap;

/* Represents some way of generating an instance of a target type from a source object by using one converter to convert the
 * source instance to an intermediate type and another converter to convert from the intermediate instance to the target type. */
public class ChainedTypeConverter extends ForcedTypeConverter {

    private static final long serialVersionUID = -2326508464345520323L;

    // The first converter to apply
    private final TargetIndependentConverter firstConverter;
    // The second converter to apply
    private final ForcedTypeConverter secondConverter;
    // The target type of the first conversion and the source type of second conversion
    private final Class<?> intermediateType;

    /* Constructs a new converter with the specified first and second converters . */
    private ChainedTypeConverter(TargetIndependentConverter firstConverter, ForcedTypeConverter secondConverter) {
        super(ConverterPriority.VERY_LOW);
        this.firstConverter = firstConverter;
        this.secondConverter = secondConverter;
        this.intermediateType = firstConverter.getTargetType();
    }

    @Override
    public boolean isInPlace() {
        return secondConverter.isInPlace();
    }

    @Override
    public boolean canConvert(Class<?> targetType, Class<?> sourceType) {
        return firstConverter.canConvert(intermediateType, sourceType) && secondConverter.canConvert(targetType, intermediateType);
    }

    @Override
    public Object convert(Object target, Object source) {
        try {
            return secondConverter.convert(target, firstConverter.convert(source));
        } catch(Exception e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return String.format("{%s -> %s}", firstConverter, secondConverter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ChainedTypeConverter converter = (ChainedTypeConverter) o;

        if (!firstConverter.equals(converter.firstConverter)) return false;
        return secondConverter.equals(converter.secondConverter);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + firstConverter.hashCode();
        result = 31 * result + secondConverter.hashCode();
        return result;
    }

    private static HashMap<TargetIndependentConverter, HashMap<ForcedTypeConverter, ChainedTypeConverter>> converterMap = new HashMap<>();

    /* Returns an instance of ChainedTypeConverter that uses the two specified converters. If an instance for the specified
     * pair of converters already exists returns that instance, otherwise creates and returns a new instance. */
    public static ChainedTypeConverter getInstance(TargetIndependentConverter firstConverter, ForcedTypeConverter secondConverter) {
        converterMap.putIfAbsent(firstConverter, new HashMap<>());
        HashMap<ForcedTypeConverter, ChainedTypeConverter> secondaryMap = converterMap.get(firstConverter);
        secondaryMap.putIfAbsent(secondConverter, new ChainedTypeConverter(firstConverter, secondConverter));
        return secondaryMap.get(secondConverter);
    }
}
