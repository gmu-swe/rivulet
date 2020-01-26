package io.rivulet.converter;

import java.util.Enumeration;
import java.util.Map;

/* Converts Strings into Parameters instances. */
public class ParametersConverter extends ForcedTypeConverter {

    private static final long serialVersionUID = 6370707323431883934L;
    // The String name of the Parameters class
    private static final String PARAMS_CLASS_NAME = "org.apache.tomcat.util.http.Parameters";

    // Whether the source value should be appended as a new parameters or should replace the old parameters
    private final boolean append;

    private ParametersConverter(boolean append) {
        super(ConverterPriority.HIGH);
        this.append = append;
    }

    @Override
    public boolean isInPlace() {
        return append;
    }

    @Override
    public boolean canConvert(Class<?> targetType, Class<?> sourceType) {
        return targetType.getName().equals(PARAMS_CLASS_NAME) && ((sourceType.equals(String.class) && !append) || Map.class.isAssignableFrom(sourceType));
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object convert(Object target, Object source) {
        try {
            if(target.getClass() != null && target.getClass().getName().equals(PARAMS_CLASS_NAME)) {
                if(!append) {
                    Object result = target.getClass().newInstance();
                    result.getClass().getMethod("handleQueryParameters").invoke(result);
                    if(source instanceof String) {
                        Enumeration<String> paramNames = (Enumeration<String>)target.getClass().getMethod("getParameterNames").invoke(target);
                        while(paramNames.hasMoreElements()) {
                            result.getClass().getMethod("addParameter", String.class, String.class).invoke(result, paramNames.nextElement(), source.toString());
                        }
                        return result;
                    } else if(source instanceof Map) {
                        Map map = (Map)source;
                        for(Object key : map.keySet()) {
                            result.getClass().getMethod("addParameter", String.class, String.class).invoke(result, key.toString(), map.get(key).toString());
                        }
                        return result;
                    }
                } else if(source instanceof Map) {
                    Map map = (Map)source;
                    for(Object key : map.keySet()) {
                        Object current = target.getClass().getMethod("getParameter", String.class).invoke(target, key.toString());
                        if(current == null || !current.equals(map.get(key))) {
                            target.getClass().getMethod("addParameter", String.class, String.class).invoke(target, key.toString(), map.get(key).toString());
                        }
                    }
                    return target;
                }
                return null;
            } else {
                return null;
            }
        } catch(Exception e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return append ? "<ParametersConverter : append>" : "<ParametersConverter>";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParametersConverter that = (ParametersConverter) o;

        return append == that.append;
    }

    @Override
    public int hashCode() {
        return (append ? 1 : 0);
    }

    /* Provides access to the instances of ParametersConverter. */
    public static ParametersConverter getInstance(boolean append) {
        return append ? ParametersConverterSingletons.APPENDING_INSTANCE.getValue() : ParametersConverterSingletons.REPLACING_INSTANCE.getValue();
    }

    public enum ParametersConverterSingletons {
        APPENDING_INSTANCE(true),
        REPLACING_INSTANCE(false);

        private final ParametersConverter value;

        ParametersConverterSingletons(boolean append) {
            value = new ParametersConverter(append);
        }

        public ParametersConverter getValue() {
            return value;
        }
    }
}
