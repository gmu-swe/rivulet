package io.rivulet.internal;

import edu.columbia.cs.psl.phosphor.runtime.Taint;
import edu.columbia.cs.psl.phosphor.runtime.TaintSourceWrapper;
import edu.columbia.cs.psl.phosphor.struct.*;

import java.lang.reflect.Array;
import java.util.Arrays;

/* Build a String up from Strings, Objects, TaintedPrimitiveWithObjTags and LazyArrayObjTags instances. */
public class TaintedStringBuilder {
    // The maximum length of the value and taint arrays
    private static final int MAX_CAPACITY = Integer.MAX_VALUE - 8;
    // The initial length of the value and taint arrays
    private static final int INITIAL_CAPACITY = 100;
    // Stores the characters of the String being built
    private char[] values;
    // Stores the taints of the characters of the String being built
    private Taint[] taints;
    // The current number of characters in the String being built
    private int size;

    /* Constructs a new empty TaintedStringBuilder. */
    public TaintedStringBuilder() {
        this.values = new char[INITIAL_CAPACITY];
        this.taints = new Taint[INITIAL_CAPACITY];
        this.size = 0;
    }

    /* Increases the size of the value and taint arrays so that they can each hold at least the specified minimum number
     * of elements. */
    private void ensureCapacity(int minCapacity) {
        if(values.length < minCapacity) {
            int newCapacity = values.length + (values.length >> 1); // Increase capacity by 50%
            newCapacity = (newCapacity - minCapacity < 0) ? minCapacity : newCapacity;
            newCapacity = (newCapacity - MAX_CAPACITY > 0) ? MAX_CAPACITY : newCapacity;
            // Resize values
            char[] valuesTemp = values;
            values = new char[newCapacity];
            System.arraycopy(valuesTemp, 0, values, 0, size);
            // Resize taints
            Taint[] taintsTemp = taints;
            taints = new Taint[newCapacity];
            System.arraycopy(taintsTemp, 0, taints, 0, size);
        }
    }

    public TaintedStringBuilder append(TaintedCharWithObjTag taintedChar) {
        ensureCapacity(size+1);
        values[size] = taintedChar.val;
        taints[size] = taintedChar.taint;
        size++;
        return this;
    }

    public TaintedStringBuilder append(Object obj) {
        return append(String.valueOf(obj));
    }

    public TaintedStringBuilder append(String str) {
        LazyCharArrayObjTags tags = TaintSourceWrapper.getStringValueTag(str);
        if(tags == null) {
            tags = new LazyCharArrayObjTags(str.toCharArray(), null);
        }
        return append(tags);
    }

    public TaintedStringBuilder append(LazyCharArrayObjTags tags) {
        return append(tags, 0, tags.getLength());
    }

    public TaintedStringBuilder append(LazyCharArrayObjTags tags, int offset, int len) {
        ensureCapacity(size + len);
        for(int i = offset; i < len; i++) {
            values[size] = tags.val[i];
            if(tags.taints != null && tags.taints.length > i) {
                taints[size] = tags.taints[i];
            }
            size++;
        }
        return this;
    }

    public TaintedStringBuilder append(TaintedBooleanWithObjTag b) {
        return append(taintChars(String.valueOf(b.val), b.taint));
    }

    public TaintedStringBuilder append(TaintedIntWithObjTag i) {
        return append(taintChars(String.valueOf(i.val), i.taint));
    }

    public TaintedStringBuilder append(TaintedLongWithObjTag l) {
        return append(taintChars(String.valueOf(l.val), l.taint));
    }

    public TaintedStringBuilder append(TaintedFloatWithObjTag f) {
        return append(taintChars(String.valueOf(f.val), f.taint));
    }

    public TaintedStringBuilder append(TaintedDoubleWithObjTag d) {
        return append(taintChars(String.valueOf(d.val), d.taint));
    }

    /* Sets the taints for every character in the specified String to be the specified Taint. Returns the specified
     * String.*/
    public static String taintChars(String str, Taint taint) {
        if(str == null || str.length() < 1) {
            return str;
        }
        Taint[] taintArr = new Taint[str.length()];
        for(int i = 0; i < taintArr.length; i++) {
            taintArr[i] = taint == null ? null : taint.copy();
        }
        TaintSourceWrapper.setStringValueTag(str, new LazyCharArrayObjTags(str.toCharArray(), taintArr));
        return str;
    }

    public String toString() {
        char[] chars = new char[size];
        Taint[] taintArr = new Taint[size];
        System.arraycopy(values, 0, chars, 0, size);
        System.arraycopy(taints, 0, taintArr, 0, size);
        String result = new String(chars);
        TaintSourceWrapper.setStringValueTag(result, new LazyCharArrayObjTags(chars, taintArr));
        return result;
    }

    /* Returns a nicely formatted String representation of the specified value after removing any taint wrapping. */
    public static String formatTaintedValue(Object sinkValue) {
        if(sinkValue == null) {
            return "";
        } else if(sinkValue instanceof LazyArrayObjTags) {
            sinkValue = ((LazyArrayObjTags)sinkValue).getVal();
            if(sinkValue == null) {
                return "";
            }
        }
        String sinkValueString;
        if(sinkValue instanceof Object[]) {
            sinkValueString = Arrays.deepToString((Object[])sinkValue);
        } else if(sinkValue instanceof char[]) {
            sinkValueString =  new String((char[])sinkValue);
        } else if(sinkValue instanceof byte[]) {
            sinkValueString = new String((byte[])sinkValue);
        } else if(sinkValue.getClass().isArray()) {
            StringBuilder builder = new StringBuilder();
            builder.append('[');
            for(int i = 0; i < Array.getLength(sinkValue); i++) {
                Object el = (Array.get(sinkValue, i));
                builder.append(formatTaintedValue(el));
                if(i < Array.getLength(sinkValue) - 1) {
                    // The element appended was not the last value in the array
                    builder.append(", ");
                }
            }
            sinkValueString = builder.append(']').toString();
        } else {
            sinkValueString = sinkValue.toString();
        }
        if(sinkValueString == null) {
            return "";
        } else {
            return new String(sinkValueString.replace("\0", "").getBytes());
        }
    }
}