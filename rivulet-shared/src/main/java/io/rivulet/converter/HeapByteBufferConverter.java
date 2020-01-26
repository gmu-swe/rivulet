package io.rivulet.converter;

import java.nio.ByteBuffer;

/* Converts byte arrays into HeapByteBuffers by calling ByteBuffer.wrap. */
public class HeapByteBufferConverter extends TargetIndependentConverter {

    private static final long serialVersionUID = -6065014238006778317L;

    private HeapByteBufferConverter() {
        super(ConverterPriority.HIGH, ByteBuffer.wrap(new byte[0]).getClass(), byte[].class);
    }

    @Override
    public Object convert(Object source) {
        if(source instanceof byte[]) {
            return ByteBuffer.wrap((byte[])source);
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "<HeapByteBufferConverter>";
    }

    /* Provides access to the single instance of HeapByteBufferConverter. */
    public static HeapByteBufferConverter getInstance() {
        return HeapByteBufferConverter.HeapByteBufferConverterSingleton.INSTANCE.getValue();
    }

    public enum HeapByteBufferConverterSingleton {
        INSTANCE;

        private final HeapByteBufferConverter value;

        HeapByteBufferConverterSingleton() {
            value = new HeapByteBufferConverter();
        }

        public HeapByteBufferConverter getValue() {
            return value;
        }
    }
}
