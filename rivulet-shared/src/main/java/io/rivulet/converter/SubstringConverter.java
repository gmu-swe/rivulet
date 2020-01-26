package io.rivulet.converter;

/* Converts by replacing the character of a target String between some range with a source String. */
public class SubstringConverter extends BasicConverter {

    private static final long serialVersionUID = 2363662551937017520L;
    // The inclusive start index of the range to be replaced
    private final int start;
    // The exclusive end index of the range to be replaced
    private final int end;

    /* Constructs a new SubstringConverter that replaces the characters a target String from the specified start index
     * (inclusive) to the specified end index (exclusive) with a source String. */
    public SubstringConverter(int start, int end) {
        super(ConverterPriority.VERY_LOW, String.class, String.class);
        if(start < 0 || end <= start) {
            throw new RuntimeException(String.format("Invalid substring range: [%d, %d))", start, end));
        }
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean isInPlace() {
        return false;
    }

    @Override
    public Object convert(Object target, Object source) {
        try {
            if(source instanceof String && (target == null || target.toString().length() == 0)) {
                return source;
            } else if(target instanceof String && source instanceof String) {
                String targetStr = (String)target;
                StringBuilder builder = new StringBuilder();
                if(start != 0) {
                    builder.append(targetStr, 0, start);
                }
                builder.append(source);
                if(end < targetStr.length()) {
                    builder.append(targetStr.substring(end));
                }
                return builder.toString();
            } else {
                return null;
            }
        } catch(Exception e) {
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubstringConverter that = (SubstringConverter) o;
        if (start != that.start) return false;
        return end == that.end;
    }

    @Override
    public int hashCode() {
        int result = start;
        result = 31 * result + end;
        return result;
    }

    @Override
    public String toString() {
        return String.format("<SubstringConverter: [%d, %d)>", start, end);
    }
}
