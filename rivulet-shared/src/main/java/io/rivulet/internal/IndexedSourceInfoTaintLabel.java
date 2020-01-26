package io.rivulet.internal;

/* Label that stores additional information about the index in an originalArray of the value tainted at the source. */
public class IndexedSourceInfoTaintLabel extends SourceInfoTaintLabel {

    private static final long serialVersionUID = 5263586916022774864L;
    // Stores information about the index of the value tainted with this label in the originalArray or string and a unique identifier
    // shared by all other labels produced by by the same invocation of autoTaint as this one.
    private final InvocationRanges indexInfo;
    // If the value tainted with this label was part of a primitive array stores a copy of the primitive array it was a
    // a part of. Otherwise, null
    private final Object originalArray;

    /* Constructs a new label with the specified information. */
    public IndexedSourceInfoTaintLabel(String baseSource, String actualSource, int sourceArgIndex, Class<?> sourceValueClass,
                                       boolean fullyReplaceable, InvocationRanges indexInfo) {
        super(baseSource, actualSource, sourceArgIndex, sourceValueClass, fullyReplaceable);
        this.indexInfo = indexInfo;
        this.originalArray = null;
    }

    /* Constructs a new label with the specified information. */
    public IndexedSourceInfoTaintLabel(String baseSource, String actualSource, int sourceArgIndex, Class<?> sourceValueClass,
                                       boolean fullyReplaceable, InvocationRanges indexInfo, Object originalArray) {
        super(baseSource, actualSource, sourceArgIndex, sourceValueClass, fullyReplaceable);
        this.indexInfo = indexInfo;
        this.originalArray = originalArray;
    }

    /* Constructs a new label with the same information as the specified other label, but with the specified sourceValueClass
     * and fullyReplaceable values. */
    public IndexedSourceInfoTaintLabel(IndexedSourceInfoTaintLabel other, Class<?> sourceValueClass, boolean fullyReplaceable) {
        super(other, sourceValueClass, fullyReplaceable);
        this.indexInfo = other.getIndexInfoCopy();
        this.originalArray = other.getOriginalArrayCopy();
    }

    /* Constructs a new label with the same information as the specified other label, but with only the specified index
     * indicated as present in its index information. */
    public IndexedSourceInfoTaintLabel(IndexedSourceInfoTaintLabel other, int index) {
        super(other);
        this.indexInfo = new InvocationRanges(other.indexInfo.getInvocationID(), index);
        this.originalArray = other.getOriginalArrayCopy();
    }

    /* Constructs a new label with the same information as the specified other label, but with only the original array. */
    public IndexedSourceInfoTaintLabel(IndexedSourceInfoTaintLabel other, Object originalArray) {
        super(other);
        this.indexInfo = other.getIndexInfoCopy();
        this.originalArray = originalArray;
    }

    /* Returns a deep copy of indexInfo. */
    public InvocationRanges getIndexInfoCopy() {
        return indexInfo.copy();
    }

    /* Returns a copy of originalArray. */
    public Object getOriginalArrayCopy() {
        return copyPrimitiveArray(originalArray);
    }

    /* Returns a text representation of this label. */
    @Override
    public String toString() {
        return String.format("IndexedSourceInfoTaintLabel{baseSource=%s, actualSourceClass=%s, sourceArgIndex=%d, sourceValueClass=%s, indexInfo=%s}",
                getBaseSource(), getActualSourceClass(), getSourceArgIndex(), getSourceValueClass(), indexInfo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        IndexedSourceInfoTaintLabel that = (IndexedSourceInfoTaintLabel) o;
        return indexInfo.equals(that.indexInfo);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + indexInfo.hashCode();
        return result;
    }

    /* Returns a copy of the specified object if it is a primitive array otherwise returns the specified object. */
    public static Object copyPrimitiveArray(Object obj) {
        if(obj instanceof boolean[]) {
            return ((boolean[])obj).clone();
        } else if(obj instanceof byte[]) {
            return ((byte[]) obj).clone();
        } else if(obj instanceof char[]) {
            return ((char[]) obj).clone();
        } else if(obj instanceof double[]) {
            return ((double[]) obj).clone();
        } else if(obj instanceof float[]) {
            return ((float[]) obj).clone();
        } else if(obj instanceof int[]) {
            return ((int[]) obj).clone();
        }  else if(obj instanceof long[]) {
            return ((long[]) obj).clone();
        }  else if(obj instanceof short[]) {
            return ((short[]) obj).clone();
        } else {
            return null;
        }
    }
}
