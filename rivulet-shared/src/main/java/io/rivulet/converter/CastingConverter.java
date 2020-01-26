package io.rivulet.converter;

/* Converter that can be applied when the source type is a subtype of the target type, converts the subtype to the
 * supertype by casting. */
public class CastingConverter extends TargetIndependentConverter {

    private static final long serialVersionUID = -8724150719448527704L;

    private CastingConverter() {
        super(ConverterPriority.CRITICAL, Object.class, Object.class);
    }

    @Override
    public boolean isInPlace() {
        return false;
    }

    @Override
    public boolean canConvert(Class<?> targetType, Class<?> sourceType) {
        return targetType.isAssignableFrom(sourceType);
    }

    @Override
    public Object convert(Object source) {
        return source;
    }

    @Override
    public String toString() {
        return "<CastingConverter>";
    }

    /* Provides access to the single instance of CastingConverter. */
    public static CastingConverter getInstance() {
        return CastingConverter.CastingConverterSingleton.INSTANCE.getValue();
    }

    public enum CastingConverterSingleton {
        INSTANCE;

        private final CastingConverter value;

        CastingConverterSingleton() {
            value = new CastingConverter();
        }

        public CastingConverter getValue() {
            return value;
        }
    }
}
