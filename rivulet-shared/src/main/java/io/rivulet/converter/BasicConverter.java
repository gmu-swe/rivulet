package io.rivulet.converter;

/* Represents a way of converting an instance of a source type into an instance of a target type. */
public abstract class BasicConverter extends ForcedTypeConverter {

    private static final long serialVersionUID = 1572576785850390255L;

    // The type of the target type that the source instance is converter to
    private final Class<?> targetType;
    // The type of the source instance to be converted
    private final Class<?> sourceType;

    /* Constructs a new converter that creates instances of the specified target type from instances of the specified
     * source type. */
    public BasicConverter(ConverterPriority priority, Class<?> targetType, Class<?> sourceType) {
        super(priority);
        this.targetType = targetType;
        this.sourceType = sourceType;
    }

    @Override
    public boolean canConvert(Class<?> targetType, Class<?> sourceType) {
        return targetType.isAssignableFrom(this.targetType) && this.sourceType.isAssignableFrom(sourceType);
    }

    /* Getter for targetType. */
    public Class<?> getTargetType() {
        return targetType;
    }

    /* Getter for sourceType. */
    public Class<?> getSourceType() {
        return sourceType;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        BasicConverter that = (BasicConverter) o;
        if(targetType != null ? !targetType.equals(that.targetType) : that.targetType != null) return false;
        return sourceType != null ? sourceType.equals(that.sourceType) : that.sourceType == null;
    }

    @Override
    public int hashCode() {
        int result = targetType != null ? targetType.hashCode() : 0;
        result = 31 * result + (sourceType != null ? sourceType.hashCode() : 0);
        return result;
    }
}
