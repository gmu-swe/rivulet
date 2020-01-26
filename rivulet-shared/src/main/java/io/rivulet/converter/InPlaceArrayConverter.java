package io.rivulet.converter;

import java.lang.reflect.Array;

/* Converter that can be applied to convert an array source by putting its values into an array target type. */
public class InPlaceArrayConverter extends ForcedTypeConverter {

    private static final long serialVersionUID = -8724150719448527704L;

    private InPlaceArrayConverter() {
        super(ConverterPriority.LOW);
    }

    @Override
    public boolean isInPlace() {
        return true;
    }

    @Override
    public boolean canConvert(Class<?> targetType, Class<?> sourceType) {
        return targetType.isAssignableFrom(sourceType) && targetType.isArray() && sourceType.isArray();
    }

    @Override
    public Object convert(Object target, Object source) {
        try {
            if(canConvert(target.getClass(), source.getClass())) {
                for (int i = 0; i < Array.getLength(target); i++) {
                    if (i >= Array.getLength(source)) {
                        return target;
                    } else {
                        Array.set(target, i, Array.get(source, i));
                    }
                }
                return target;
            } else {
                return null;
            }
        } catch(Exception e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "<InPlaceArrayConverter>";
    }

    /* Provides access to the single instance of InPlaceArrayConverter. */
    public static InPlaceArrayConverter getInstance() {
        return InPlaceArrayConverter.InPlaceArrayConverterSingleton.INSTANCE.getValue();
    }

    public enum InPlaceArrayConverterSingleton {
        INSTANCE;

        private final InPlaceArrayConverter value;

        InPlaceArrayConverterSingleton() {
            value = new InPlaceArrayConverter();
        }

        public InPlaceArrayConverter getValue() {
            return value;
        }
    }
}
