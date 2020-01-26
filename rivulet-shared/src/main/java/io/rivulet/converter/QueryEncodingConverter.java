package io.rivulet.converter;

import org.apache.http.Consts;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.util.Collections;

/* Encodes source query strings. */
public class QueryEncodingConverter extends TargetIndependentConverter {

    private static final long serialVersionUID = -1105137460093633724L;
    private final boolean parse;

    public QueryEncodingConverter(boolean parse) {
        super(ConverterPriority.VERY_LOW, String.class, String.class);
        this.parse = parse;
    }

    @Override
    public Object convert(Object source) {
        try {
            if(source instanceof String && parse) {
                return URLEncodedUtils.format(URLEncodedUtils.parse((String)source, Consts.UTF_8), Consts.UTF_8);
            } else if(source instanceof String) {
                return URLEncodedUtils.format(Collections.singletonList(new BasicNameValuePair((String) source, null)), Consts.UTF_8);
            } else {
                return null;
            }
        } catch(Exception e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return parse ? "<QueryEncodingConverter: parse>" : "<QueryEncodingConverter>";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QueryEncodingConverter that = (QueryEncodingConverter) o;

        return parse == that.parse;
    }

    @Override
    public int hashCode() {
        return (parse ? 1 : 0);
    }

    /* Provides access to the instances of QueryEncodingConverter. */
    public static QueryEncodingConverter getInstance(boolean parse) {
        if(parse) {
            return QueryEncodingConverterSingletons.PARSING_INSTANCE;
        } else {
            return QueryEncodingConverterSingletons.NON_PARSING_INSTANCE;

        }
    }

    /* Inner class used to provide access to the two instances of QueryEncodingConverter and ensure that only two instances of
     * QueryEncodingConverter are ever created. */
    private static class QueryEncodingConverterSingletons {
        private static final QueryEncodingConverter PARSING_INSTANCE = new QueryEncodingConverter(true);
        private static final QueryEncodingConverter NON_PARSING_INSTANCE =new QueryEncodingConverter(false);
    }
}
