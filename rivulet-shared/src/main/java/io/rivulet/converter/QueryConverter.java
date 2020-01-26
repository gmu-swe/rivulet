package io.rivulet.converter;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* Converter which creates a request query string either by replacing a target query string or by appending values to a target
 * query string. */
public class QueryConverter extends ForcedTypeConverter {

    private static final long serialVersionUID = -4113324628916395735L;
    // Used to convert between a map made from the target value and the source value
    private final MapConverter intermediateConverter;
    // Whether the original query string and its replacement should be encoded.
    private final boolean encoded;

    private QueryConverter(boolean append, boolean encoded) {
        super(ConverterPriority.VERY_LOW);
        this.intermediateConverter = MapConverter.getInstance(append);
        this.encoded = encoded;
    }

    @Override
    public boolean isInPlace() {
        return false;
    }

    @Override
    public boolean canConvert(Class<?> targetType, Class<?> sourceType) {
        return targetType.equals(String.class) && intermediateConverter.canConvert(Map.class, sourceType);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object convert(Object target, Object source) {
        try {
            if(target != null && !(target instanceof String)) {
                return null;
            }
            HashMap<String, String> originalMap = parseOriginalQuery((String)target);
            HashMap<String, String> resultMap = (HashMap<String, String>)intermediateConverter.convert(originalMap, source);
            return makeQueryString(resultMap);
        } catch(Exception e) {
            return null;
        }
    }

    /* Returns a map of key-value parameter pairs from the specified query string. */
    public HashMap<String, String> parseOriginalQuery(String queryString) {
        HashMap<String, String> params = new HashMap<>();
        if(queryString != null) {
            List<NameValuePair> pairs = URLEncodedUtils.parse(queryString, Consts.UTF_8);
            for (NameValuePair pair : pairs) {
                params.put(pair.getName(), pair.getValue());
            }
        }
        return params;
    }

    /* Returns a query string containing the key value pairs of the specified map. */
    private String makeQueryString(Map<String, String> map) {
        if(encoded) {
            List<NameValuePair> pairs = new LinkedList<>();
            for(String key : map.keySet()) {
                pairs.add(new BasicNameValuePair(key, map.get(key)));
            }
            return URLEncodedUtils.format(pairs, Consts.UTF_8);
        } else {
            StringBuilder builder = new StringBuilder();
            boolean first = true;
            for(String key : map.keySet()) {
                if(first) {
                    first = false;
                } else {
                    builder.append('&');
                }
                builder.append(key).append('=').append(map.get(key));
            }
            return builder.toString();
        }
    }

    @Override
    public String toString() {
        return String.format("<QueryConverter: %s + %s>", encoded ? "encoded" : "decoded", intermediateConverter);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        QueryConverter that = (QueryConverter) o;

        if (encoded != that.encoded) return false;
        return intermediateConverter.equals(that.intermediateConverter);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + intermediateConverter.hashCode();
        result = 31 * result + (encoded ? 1 : 0);
        return result;
    }

    /* Provides access to the instances of QueryConverter. */
    public static QueryConverter getInstance(boolean append, boolean encoded) {
        if(append) {
            if(encoded) {
                return QueryConverterSingletons.ENCODED_APPENDING_INSTANCE;
            } else {
                return QueryConverterSingletons.DECODED_APPENDING_INSTANCE;
            }
        } else {
            if(encoded) {
                return QueryConverterSingletons.ENCODED_REPLACING_INSTANCE;
            } else {
                return QueryConverterSingletons.DECODED_REPLACING_INSTANCE;
            }
        }
    }

    /* Inner class used to provide access to the four instances of QueryConverter and ensure that only four instances of
     * QueryConverter are ever created. */
    private static class QueryConverterSingletons {
        private static final QueryConverter ENCODED_APPENDING_INSTANCE = new QueryConverter(true, true);
        private static final QueryConverter DECODED_APPENDING_INSTANCE = new QueryConverter(true, false);
        private static final QueryConverter ENCODED_REPLACING_INSTANCE = new QueryConverter(false, true);
        private static final QueryConverter DECODED_REPLACING_INSTANCE = new QueryConverter(false, false);
    }
}
