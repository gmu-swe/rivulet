package io.rivulet.converter;

/* Converts Strings into byte and char arrays. */
public class StringArrayConverter extends TargetIndependentConverter {

    private static final long serialVersionUID = -3809648286184163140L;

    public StringArrayConverter(Class<?> targetArrayClass) {
        super(ConverterPriority.HIGH, targetArrayClass, String.class);
    }

    @Override
    public Object convert(Object source) {
        if(source instanceof String && getTargetType().equals(byte[].class)) {
            return ((String)source).getBytes();
        } else if(source instanceof String) {
            return ((String)source).toCharArray();
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return String.format("<StringArrayConverter: %s>", getTargetType());
    }

    /* Provides access to the single instance of StringArrayConverter for converting to char arrays. */
    public static StringArrayConverter getCharInstance() {
        return StringArrayConverterSingletons.CHAR_INSTANCE;
    }

    /* Provides access to the single instance of StringArrayConverter for converting to byte arrays. */
    public static StringArrayConverter getByteInstance() {
        return StringArrayConverterSingletons.BYTE_INSTANCE;
    }

    /* Inner class used to provide access to the two instances of StringArrayConverter and ensure that only two instances of
     * StringArrayConverter are ever created. */
    private static class StringArrayConverterSingletons {
        private static final StringArrayConverter CHAR_INSTANCE = new StringArrayConverter(char[].class);
        private static final StringArrayConverter BYTE_INSTANCE = new StringArrayConverter(byte[].class);
    }
}