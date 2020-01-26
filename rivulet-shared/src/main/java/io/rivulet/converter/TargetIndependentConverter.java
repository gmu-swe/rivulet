package io.rivulet.converter;

/* Represents a way of converting an instance of a source type into an instance of a target type without using an instance
 * of the target type. */
public abstract class TargetIndependentConverter extends BasicConverter {

    private static final long serialVersionUID = 8257147883241788128L;

    public TargetIndependentConverter(ConverterPriority priority, Class<?> targetType, Class<?> sourceType) {
        super(priority, targetType, sourceType);
    }

    @Override
    public boolean isInPlace() {
        return false;
    }

    @Override
    public Object convert(Object target, Object source) {
        return convert(source);
    }

    public abstract Object convert(Object source);
}
