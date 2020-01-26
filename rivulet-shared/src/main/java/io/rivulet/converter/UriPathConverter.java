package io.rivulet.converter;

import org.apache.http.Consts;
import org.apache.http.client.utils.URLEncodedUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

/* Converter which replaces an HTTP URI's path entirely or by appending */
public class UriPathConverter extends BasicConverter {

    private static final long serialVersionUID = 5050148404894290169L;

    // Whether the replacement should be appended to the original
    private final boolean append;
    // Whether the original path and its replacement should be encoded.
    private final boolean encoded;

    private UriPathConverter(boolean append, boolean encoded) {
        super(ConverterPriority.VERY_LOW, String.class, String.class);
        this.append = append;
        this.encoded = encoded;
    }

    @Override
    public boolean isInPlace() {
        return false;
    }

    @Override
    public Object convert(Object target, Object source) {
        if(!(source instanceof String && target instanceof String)) {
            return null;
        } else {
            String sourceStr = (String) source;
            try {
                sourceStr = encodeIfNecessary(sourceStr);
            } catch(Exception e) {
                return null;
            }
            String targetStr = (String) target;
            if(!append || !targetStr.contains("/")) {
                return new String(sourceStr);
            } else if(targetStr.endsWith(sourceStr)) {
                return new String(targetStr);
            } else {
                return targetStr + "/" + sourceStr;
            }
        }
    }

    private String encodeIfNecessary(String path) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        if(encoded) {
            Method encodeMethod = URLEncodedUtils.class.getDeclaredMethod("encPath", String.class, Charset.class);
            encodeMethod.setAccessible(true);
            return (String) encodeMethod.invoke(null, path, Consts.UTF_8);
        } else {
            return path;
        }
    }

    @Override
    public String toString() {
        return String.format("<UriPathConverter: %s + %s>", encoded ? "encoded" : "decoded", append ? "appending" : "replacing");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        UriPathConverter that = (UriPathConverter) o;

        if (append != that.append) return false;
        return encoded == that.encoded;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (append ? 1 : 0);
        result = 31 * result + (encoded ? 1 : 0);
        return result;
    }

    /* Provides access to the instances of UriPathConverter. */
    public static UriPathConverter getInstance(boolean afterSlash, boolean encoded) {
        if(afterSlash) {
            if(encoded) {
                return UriPathConverterSingletons.ENCODED_APPENDING_INSTANCE;
            } else {
                return UriPathConverterSingletons.DECODED_APPENDING_INSTANCE;
            }
        } else {
            if(encoded) {
                return UriPathConverterSingletons.ENCODED_REPLACING_INSTANCE;
            } else {
                return UriPathConverterSingletons.DECODED_REPLACING_INSTANCE;
            }
        }
    }

    /* Inner class used to provide access to the four instances of UriPathConverter and ensure that only four instances of
     * UriPathConverter are ever created. */
    private static class UriPathConverterSingletons {
        private static final UriPathConverter ENCODED_APPENDING_INSTANCE = new UriPathConverter(true, true);
        private static final UriPathConverter DECODED_APPENDING_INSTANCE = new UriPathConverter(true, false);
        private static final UriPathConverter ENCODED_REPLACING_INSTANCE = new UriPathConverter(false, true);
        private static final UriPathConverter DECODED_REPLACING_INSTANCE = new UriPathConverter(false, false);
    }
}
