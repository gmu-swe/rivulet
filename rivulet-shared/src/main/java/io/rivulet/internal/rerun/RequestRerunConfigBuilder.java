package io.rivulet.internal.rerun;

import io.rivulet.PhosphorHttpRequestSource;

import java.util.Map;

/* Allows replacement values to be easily specified for PhosphorHttpRequest sources. */
public class RequestRerunConfigBuilder extends RerunConfigBuilder {

    /* Adds the specified string value as the replacement value for the body entity of the request. */
    public RequestRerunConfigBuilder bodyEntityReplacement(String value, boolean required, boolean payload) {
        ReplacementBuilder builder = new ReplacementImplBuilder()
                        .required(required)
                        .value(value)
                        .actualSourceClass("io/rivulet/PhosphorHttpRequest")
                        .sourceArgIndex(-1)
                        .isPayload(payload)
                        .baseSource(PhosphorHttpRequestSource.ENTITY_BODY.getSignature());
        addReplacementBuilder(builder);
        return this;
    }

    /* Adds the specified string value as the replacement value for the content type of the request. */
    public RequestRerunConfigBuilder contentTypeReplacement(String value, boolean required, boolean payload) {
        ReplacementBuilder builder = new ReplacementImplBuilder()
                        .required(required)
                        .value(value)
                        .actualSourceClass("io/rivulet/PhosphorHttpRequest")
                        .sourceArgIndex(-1)
                        .isPayload(payload)
                        .baseSource(PhosphorHttpRequestSource.CONTENT_TYPE_HEADER.getSignature());
        addReplacementBuilder(builder);
        return this;
    }

    /* Adds the specified map's key-value pairs as replacement values for the query of the request. */
    public RequestRerunConfigBuilder queryReplacement(Map<String, String> value, boolean required, boolean payload) {
        ReplacementBuilder builder = new ReplacementImplBuilder()
                        .required(required)
                        .value(value)
                        .actualSourceClass("io/rivulet/PhosphorHttpRequest")
                        .sourceArgIndex(-1)
                        .isPayload(payload)
                        .baseSource(PhosphorHttpRequestSource.ENCODED_QUERY.getSignature());
        addReplacementBuilder(builder);
        return this;
    }

    /* Adds the specified string as a replacement value for all of the values of the query parameters of the request. */
    public RequestRerunConfigBuilder queryReplacement(String value, boolean required, boolean payload) {
        ReplacementBuilder builder = new ReplacementImplBuilder()
                        .required(required)
                        .value(value)
                        .actualSourceClass("io/rivulet/PhosphorHttpRequest")
                        .sourceArgIndex(-1)
                        .isPayload(payload)
                        .baseSource(PhosphorHttpRequestSource.ENCODED_QUERY.getSignature());
        addReplacementBuilder(builder);
        return this;
    }
}
