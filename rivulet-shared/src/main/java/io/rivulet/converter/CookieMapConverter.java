package io.rivulet.converter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* Converter which replaces a request's cookie header value string either entirely or by appending values from a source
 * map. */
public class CookieMapConverter extends ForcedTypeConverter {

    private static final long serialVersionUID = -4113324628916395735L;
    // Whether the source's values should be appended to the target map
    private final boolean append;

    private CookieMapConverter(boolean append) {
        super(ConverterPriority.VERY_LOW);
        this.append = append;
    }

    @Override
    public boolean isInPlace() {
        return true;
    }

    @Override
    public boolean canConvert(Class<?> targetType, Class<?> sourceType) {
        return targetType.equals(String.class) && Map.class.isAssignableFrom(sourceType);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object convert(Object target, Object source) {
        try {
            if((target != null && !(target instanceof String)) || !(source instanceof Map)) {
                return null;
            } else {
                Map<String, String> sourceMap = (Map<String, String>) source;
                HashMap<String, String> originalMap = parseOriginalCookie((String)target);
                if(!append) {
                    originalMap.clear();
                }
                for(String key : sourceMap.keySet()) {
                    originalMap.put(key, sourceMap.get(key));
                }
                return makeCookieString(originalMap);
            }
        } catch(Exception e) {
            return null;
        }
    }

    /* Returns a map of key-value pairs from the specified cookie string. */
    public static HashMap<String, String> parseOriginalCookie(String cookieString) {
        LinkedHashMap<String, String> pairs = new LinkedHashMap<>();
        if(cookieString != null) {
            for(String cookie : cookieString.split(";")) {
                if(cookie.contains("=")) {
                    String[] split = cookie.split("=", 2);
                    pairs.put(split[0].trim(), split[1].trim());
                } else {
                    pairs.put(cookie.trim(), "");
                }
            }
        }
        return pairs;
    }

    /* Returns a cookie string containing the key value pairs of the specified map. */
    private String makeCookieString(Map map) {
        StringBuilder builder = new StringBuilder();
        boolean first = true;
        for(Object key : map.keySet()) {
            if(first) {
                first = false;
            } else {
                builder.append("; ");
            }
            builder.append(key).append('=').append(map.get(key));
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return append ? "<CookieMapConverter: append>" : "<CookieMapConverter>";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CookieMapConverter that = (CookieMapConverter) o;
        return append == that.append;
    }

    @Override
    public int hashCode() {
        return (append ? 1 : 0);
    }

    /* Provides access to the instances of CookieMapConverter. */
    public static CookieMapConverter getInstance(boolean append) {
        return append ? CookieMapConverterSingletons.APPENDING_INSTANCE.getValue() : CookieMapConverterSingletons.REPLACING_INSTANCE.getValue();
    }

    public enum CookieMapConverterSingletons {
        APPENDING_INSTANCE(true),
        REPLACING_INSTANCE(false);

        private final CookieMapConverter value;

        CookieMapConverterSingletons(boolean append) {
            value = new CookieMapConverter(append);
        }

        public CookieMapConverter getValue() {
            return value;
        }
    }
}
