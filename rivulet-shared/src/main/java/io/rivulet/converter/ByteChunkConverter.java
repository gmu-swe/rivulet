package io.rivulet.converter;

/* Converts Strings into ByteChunks by setting the bytes of the ByteChunk to be the bytes of the String. */
public class ByteChunkConverter extends ForcedTypeConverter {

    private static final long serialVersionUID = -7085187992736485619L;
    private static final String BC_CLASS_NAME = "org.apache.tomcat.util.buf.ByteChunk";

    private ByteChunkConverter() {
        super(ConverterPriority.HIGH);
    }

    @Override
    public boolean isInPlace() {
        return true;
    }

    @Override
    public boolean canConvert(Class<?> targetType, Class<?> sourceType) {
        return targetType.getName().equals(BC_CLASS_NAME) && sourceType.equals(String.class);
    }

    @Override
    public Object convert(Object target, Object source) {
        try {
            if(target.getClass().getName().equals(BC_CLASS_NAME) && source instanceof String) {
                String str = (String)source;
                target.getClass().getMethod("setBytes", byte[].class, int.class, int.class).invoke(target, str.getBytes(), 0, str.length());
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
        return "<ByteChunkConverter>";
    }

    /* Provides access to the single instance of ByteChunkConverter. */
    public static ByteChunkConverter getInstance() {
        return ByteChunkConverterSingleton.INSTANCE.getValue();
    }

    public enum ByteChunkConverterSingleton {
        INSTANCE;

        private final ByteChunkConverter value;

        ByteChunkConverterSingleton() {
            value = new ByteChunkConverter();
        }

        public ByteChunkConverter getValue() {
            return value;
        }
    }
}
