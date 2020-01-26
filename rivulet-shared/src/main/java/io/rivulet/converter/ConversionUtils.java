package io.rivulet.converter;

import io.rivulet.PhosphorHttpRequestSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* Provides static utility methods for forcibly converting instances of one type to another type. */
public class ConversionUtils {

    // Stores a list of converters sorted by their priority and then by the order they were added in
    private static List<ForcedTypeConverter> forcedTypeConverters = new LinkedList<>(Arrays.asList(
            CastingConverter.getInstance(), StringArrayConverter.getByteInstance(),
            StringArrayConverter.getCharInstance(), HeapByteBufferConverter.getInstance(),
            ParametersConverter.getInstance(true), OneArgConstructorConverter.getInstance(),
            ByteChunkConverter.getInstance(), InPlaceArrayConverter.getInstance()
    ));

    static {
        // Add type converters that chain two other converters together
        List<ForcedTypeConverter> chainedConverters = new LinkedList<>();
        for(ForcedTypeConverter firstConverter : forcedTypeConverters) {
            if(firstConverter instanceof TargetIndependentConverter) {
                for(ForcedTypeConverter secondConverter : forcedTypeConverters) {
                    if(!firstConverter.equals(secondConverter)) {
                        chainedConverters.add(ChainedTypeConverter.getInstance((TargetIndependentConverter)firstConverter, secondConverter));
                    }
                }
            }
        }
        forcedTypeConverters.addAll(chainedConverters);
        forcedTypeConverters.sort(ForcedTypeConverter.ConverterComparator.getInstance());
    }

    /* Returns an instance of same type as the specified target object by forcibly converting the specified source object
     * or null if forced conversion is not possible. */
    @SuppressWarnings("unchecked")
    public static <T> T forceConvert(T target, Object source) {
        if(source == null || target == null || target.getClass() == null || source.getClass() == null) {
            return null;
        } else {
            try {
                ForcedTypeConverter converter = getForcedTypeConverter(target.getClass(), source.getClass());
                return (converter == null) ? null : (T)converter.convert(target, source);
            } catch(Exception e) {
                return null;
            }
        }
    }

    /* Returns the specified target object modified by setting its fields based on the specified source object
     * or null if in-place forced conversion is not possible. */
    @SuppressWarnings("unchecked")
    public static <T> T inPlaceForceConvert(T target, Object source) {
        if(source == null || target == null || target.getClass() == null || source.getClass() == null) {
            return null;
        } else {
            try {
                ForcedTypeConverter converter = getInPlaceForcedTypeConverter(target.getClass(), source.getClass());
                return (converter == null) ? null : (T)converter.convert(target, source);
            } catch(Exception e) {
                return null;
            }
        }
    }

    /* Returns the first converter found that can forcibly convert an instance of specified source type to the specified
     * target type or null if no such converter can be found. */
    public static ForcedTypeConverter getForcedTypeConverter(Class<?> targetType, Class<?> sourceType) {
        for(ForcedTypeConverter converter : forcedTypeConverters) {
            if(converter.canConvert(targetType, sourceType)) {
                return converter;
            }
        }
        return null;
    }

    /* Returns the first converter found that can forcibly convert an instance of specified source type to the specified
     * target type by replacing fields' values in the target instance or null if no such converter can be found. */
    public static ForcedTypeConverter getInPlaceForcedTypeConverter(Class<?> targetType, Class<?> sourceType) {
        for(ForcedTypeConverter converter : forcedTypeConverters) {
            if(converter.canConvert(targetType, sourceType) && converter.isInPlace()) {
                return converter;
            }
        }
        return null;
    }

    /* Returns whether an instance of the specified target type can be forcibly converted from an instance of specified source
     * type. */
    public static boolean canBeForceConverted(Class<?> targetType, Class<?> sourceType) {
        if(getForcedTypeConverter(targetType, sourceType) != null) {
            return true;
        } else {
            return targetType.isArray() && canBeForceConverted(targetType.getComponentType(), sourceType);
        }
    }

    /* Returns whether an instance of the specified target type can be forcibly converted from an instance of specified source
     * type by replacing fields' values in an instance of the target type. */
    public static boolean canBeInPlaceForceConverted(Class<?> targetType, Class<?> sourceType) {
        return getInPlaceForcedTypeConverter(targetType, sourceType) != null;
    }

    /* Returns a list of type converters that should be used when replacing a value at the specified base source. Null
     * values represent that any applicable converter can be used. */
    public static List<ForcedTypeConverter> getValidConverters(String baseSource) {
        if(PhosphorHttpRequestSource.ENCODED_QUERY.matchesSignature(baseSource)) {
            return Arrays.asList(
                    null,
                    QueryConverter.getInstance(true, true),
                    QueryConverter.getInstance(false, true),
                    QueryEncodingConverter.getInstance(true),
                    QueryEncodingConverter.getInstance(false)
            );
        } else if(PhosphorHttpRequestSource.COOKIE_HEADER.matchesSignature(baseSource)) {
            return Arrays.asList(
                    null,
                    CookieMapConverter.getInstance(true),
                    CookieMapConverter.getInstance(false),
                    QueryEncodingConverter.getInstance(false)
            );
        } else if(PhosphorHttpRequestSource.ENCODED_PATH.matchesSignature(baseSource)) {
            return Arrays.asList(
                    UriPathConverter.getInstance(true, true),
                    UriPathConverter.getInstance(false, true)
            );
        } else if(PhosphorHttpRequestSource.ENTITY_BODY.matchesSignature(baseSource)) {
            return Arrays.asList(
                    null,
                    QueryEncodingConverter.getInstance(false)
            );
        } else {
            return Collections.singletonList(null);
        }
    }
}
