package io.rivulet.internal;

import edu.columbia.cs.psl.phosphor.PreMain;
import edu.columbia.cs.psl.phosphor.TaintUtils;
import edu.columbia.cs.psl.phosphor.runtime.Taint;
import edu.columbia.cs.psl.phosphor.struct.*;
import io.rivulet.FieldNameComparator;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import static sun.misc.Unsafe.INVALID_FIELD_OFFSET;

/* Stores information about a class' phosphor-added mark field and other fields. */
public class ClassOffsetInfo {
    private static final Class<?> TAINT_CLASS = Taint.class;

    // The offset for the phosphor-added mark field of this class or INVALID_FIELD_OFFSET if no such field exists for the
    // class
    private long markFieldOffset = INVALID_FIELD_OFFSET;
    // The stored field for this class
    private final SinglyLinkedList<FieldInfo> fields = new SinglyLinkedList<>();

    /* Stores information about the field offsets for the specified class. */
    public ClassOffsetInfo(Class startClazz) {
        // Iterate over superclasses to record their declared fields as well
        for(Class<?> clazz = startClazz; clazz != null; clazz = clazz.getSuperclass()) {
            Field[] declaredFields = clazz.getDeclaredFields();
            // Sort the fields by their name
            Arrays.sort(declaredFields, new FieldNameComparator());
            for(Field field : declaredFields) {
                try {
                    if(isMarkField(field)) {
                        markFieldOffset = unsafe.objectFieldOffset(field);
                    } else if(storeField(field) && field.getType().isPrimitive()) {
                        // Get the associated taint field
                        Field taintField = clazz.getField(field.getName() + TaintUtils.TAINT_FIELD);
                        if(taintField.getType().equals(TAINT_CLASS)) {
                            // Primitive has an associated taint field of type Taint
                            FieldInfo taintInfo = new FieldInfo(taintField.getType(), unsafe.objectFieldOffset(taintField));
                            fields.addLast(new PrimitiveFieldInfo(field.getType(), unsafe.objectFieldOffset(field), taintInfo));
                        }
                    } else if(storeField(field)) {
                        fields.addLast(new FieldInfo(field.getType(), unsafe.objectFieldOffset(field)));
                    }
                } catch (Exception e) {
                    //
                }
            }
        }
    }

    /* Returns whether the class represented by this instance has a phosphor-added mark field. */
    public boolean hasMarkField() {
        return markFieldOffset != INVALID_FIELD_OFFSET;
    }

    /* Sets the value of the phosphor-added mark field for the specified object to the specified value if the field exists.
     * Returns true is the class represented by this instance has a phosphor-added mark field and the value of the mark
     * field of the specified object did not already equal the specified value. */
    public boolean setMarkFieldForObject(int value, Object obj) {
        if(!hasMarkField()) {
            return false;
        } else if(unsafe.getInt(obj, markFieldOffset) == value) {
            return false;
        } else {
            unsafe.putInt(obj, markFieldOffset, value);
            return true;
        }
    }


    /* Returns a list of record objects which store information about the types and offsets of the fields for the class
     * represented by this instance. */
    public SinglyLinkedList<FieldInfo> getFields() {
        return fields;
    }

    /* Returns whether the specified field should be stored. */
    private static boolean storeField(Field field) {
        // Skip static fields
        // Skip taint fields, they get added with their associated primitive, or are the taint field for the class
        // Skip primitive array fields, they are represented by their associated LazyArray field
        return !Modifier.isStatic(field.getModifiers()) && !field.getType().equals(TAINT_CLASS) &&
                !(field.getType().isArray() && field.getType().getComponentType().isPrimitive());
    }

    /* Returns whether the specified field is a phosphor-added mark field. */
    private static boolean isMarkField(Field field) {
        return field.getType().equals(Integer.TYPE) && field.getName().equals(TaintUtils.MARK_FIELD);
    }

    /* Record type that stores the type and offset of a field */
    public static class FieldInfo {
        // The Class of the field
        final Class<?> type;
        // The offset for the field within a heap object
        final long offset;

        FieldInfo(Class<?> type, long offset) {
            this.type = type;
            this.offset = offset;
        }

        /* Returns the value for the field represented by this FieldInfo instance for the specified Object. */
        Object getObject(Object obj) {
            return unsafe.getObject(obj, offset);
        }
    }

    /* Record type that stores the type, offset and associated taint tag field for a primitive field. */
    public static class PrimitiveFieldInfo extends FieldInfo {
        // The associated taint tag field for this primitive.
        final FieldInfo taintField;

        PrimitiveFieldInfo(Class<?> type, long offset, FieldInfo taintField) {
            super(type, offset);
            this.taintField = taintField;
        }

        @Override
        /* Grabs the primitive value for the field represented by this instance and wraps with its Taint into a
         * TaintedPrimitiveWithObjTag. Returns the wrapped value. */
        Object getObject(Object obj) {
            Taint taint = (Taint) unsafe.getObject(obj, taintField.offset);
            if(type.equals(Boolean.TYPE)) {
                return new TaintedBooleanWithObjTag(taint, unsafe.getBoolean(obj, offset));
            } else if(type.equals(Byte.TYPE)) {
                return new TaintedByteWithObjTag(taint, unsafe.getByte(obj, offset));
            } else if(type.equals(Character.TYPE)) {
                return new TaintedCharWithObjTag(taint, unsafe.getChar(obj, offset));
            } else if(type.equals(Double.TYPE)) {
                return new TaintedDoubleWithObjTag(taint, unsafe.getDouble(obj, offset));
            } else if(type.equals(Float.TYPE)) {
                return new TaintedFloatWithObjTag(taint, unsafe.getFloat(obj, offset));
            } else if(type.equals(Integer.TYPE)) {
                return new TaintedIntWithObjTag(taint, unsafe.getInt(obj, offset));
            } else if(type.equals(Long.TYPE)) {
                return new TaintedLongWithObjTag(taint, unsafe.getLong(obj, offset));
            } else if(type.equals(Short.TYPE)) {
                return new TaintedShortWithObjTag(taint, unsafe.getShort(obj, offset));
            }
            return new RuntimeException(String.format("PrimitiveFieldInfo must represent a primitive type, not %s.", type));
        }
    }

    private static Unsafe unsafe;
    static {
        if(PreMain.RUNTIME_INST) {
            unsafe = Unsafe.getUnsafe();
        }
    }
}
