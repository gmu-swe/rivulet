package io.rivulet;

import java.lang.reflect.Field;
import java.util.Comparator;

/* Compares two field instances based on their names. */
public class FieldNameComparator implements Comparator<Field> {

    @Override
    public int compare(Field f1, Field f2) {
        return f1.getName().compareTo(f2.getName());
    }
}
