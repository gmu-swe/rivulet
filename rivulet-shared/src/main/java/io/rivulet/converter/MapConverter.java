package io.rivulet.converter;

import java.util.Map;

/* Converter which returns a Map instance formed either by replacing a target map with a source map, replacing the
 * values of the target map with a source object or by adding key-value pairs to a target map from the source map. */
public class MapConverter extends ForcedTypeConverter {

    private static final long serialVersionUID = -8331119379111792199L;

    // Whether the source's values should be appended to the target map
    private final boolean append;

    private MapConverter(boolean append) {
        super(ConverterPriority.VERY_LOW);
        this.append = append;
    }

    @Override
    public boolean isInPlace() {
        return true;
    }

    @Override
    public boolean canConvert(Class<?> targetType, Class<?> sourceType) {
        return Map.class.isAssignableFrom(targetType) && ((sourceType.equals(String.class) && !append) || Map.class.isAssignableFrom(sourceType));
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object convert(Object target, Object source) {
        try {
            if(!(target instanceof Map)) {
                return null;
            }
            Map targetMap =(Map)target;
            if(source instanceof Map) {
                Map sourceMap = (Map) source;
                if(!append) {
                    targetMap.clear();
                }
                for(Object key : sourceMap.keySet()) {
                    targetMap.put(key, sourceMap.get(key));
                }
                return targetMap;
            } else {
                for(Object key : targetMap.keySet()) {
                    targetMap.put(key, source);
                }
                return targetMap;
            }
        } catch(Exception e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return append ? "<MapConverter: append>" : "<MapConverter>";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapConverter that = (MapConverter) o;

        return append == that.append;
    }

    @Override
    public int hashCode() {
        return (append ? 1 : 0);
    }

    /* Provides access to the instances of MapConverter. */
    public static MapConverter getInstance(boolean append) {
        return append ? MapConverterSingletons.APPENDING_INSTANCE.getValue() : MapConverterSingletons.REPLACING_INSTANCE.getValue();
    }

    public enum MapConverterSingletons {
        APPENDING_INSTANCE(true),
        REPLACING_INSTANCE(false);

        private final MapConverter value;

        MapConverterSingletons(boolean append) {
            value = new MapConverter(append);
        }

        public MapConverter getValue() {
            return value;
        }
    }
}
