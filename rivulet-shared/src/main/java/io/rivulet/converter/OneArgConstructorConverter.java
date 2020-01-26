package io.rivulet.converter;

/* Converts instances to the source type using a 1-argument constructor for the target type that takes an
 * instance of the source type. */
public class OneArgConstructorConverter extends ForcedTypeConverter {

    private static final long serialVersionUID = 5931450905977635623L;

    private OneArgConstructorConverter() {
        super(ConverterPriority.LOW);
    }

    @Override
    public boolean canConvert(Class<?> targetType, Class<?> sourceType) {
        try {
            return targetType.getConstructor(sourceType) != null;
        } catch(Exception e) {
            return false;
        }
    }

    @Override
    public boolean isInPlace() {
        return false;
    }

    @Override
    public Object convert(Object target, Object source) {
        try {
            return target.getClass().getConstructor(source.getClass()).newInstance(source);
        } catch(Exception e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "<OneArgConstructorConverter>";
    }

    /* Provides access to the single instance of OneArgConstructorConverter. */
    public static OneArgConstructorConverter getInstance() {
        return OneArgConstructorConverter.OneArgConstructorConverterSingleton.INSTANCE.getValue();
    }

    public enum OneArgConstructorConverterSingleton {
        INSTANCE;

        private final OneArgConstructorConverter value;

        OneArgConstructorConverterSingleton() {
            value = new OneArgConstructorConverter();
        }

        public OneArgConstructorConverter getValue() {
            return value;
        }
    }
}
