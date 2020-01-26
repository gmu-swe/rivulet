package io.rivulet.internal;

import edu.columbia.cs.psl.phosphor.struct.IntSinglyLinkedList;

import java.io.Serializable;
import java.util.Arrays;

/* Stores ranges of ints with an invocation ID that uniques identifies some method call. */
public class InvocationRanges implements Serializable {

    private static final long serialVersionUID = 4350012043632363071L;
    // The unique identifies some method invocation
    private final int invocationID;
    // Specifies int ranges. The number of elements in the array is always even. When going through the array from start
    // end, every two elements specify a range. The first element is the inclusive starting number for that range and the
    // second is the exclusive end number for that range. The array elements are always in increasing order.
    private int[] ranges;

    /* Constructs a new InvocationRanges instance with an empty ranges array. */
    public InvocationRanges(int invocationID) {
        this.invocationID = invocationID;
        this.ranges = new int[0];
    }

    /* Constructs a new InvocationRanges instance with a ranges array containing the range containing only the specified
     * int. */
    public InvocationRanges(int invocationID, int i) {
        this.invocationID = invocationID;
        this.ranges = new int[]{i, i+1};
    }

    /* Constructs a new InvocationRanges instance with a ranges array formed by sorting and removing duplicates from the
     * specified array. If the number of unique elements in the specified array is odd the last one is excluded. */
    public InvocationRanges(int invocationID, int[] ranges) {
        this.invocationID = invocationID;
        IntSinglyLinkedList rangeList = new IntSinglyLinkedList();
        Arrays.sort(ranges);
        for(int i = 0; i < ranges.length; i+=2) {
            if(i == 0) {
                rangeList.enqueue(ranges[i]);
            } else if(ranges[i-1] != ranges[i]) {
                rangeList.enqueue(ranges[i]);
            }
            if(ranges[i] != ranges[i+1]) {
                rangeList.enqueue(ranges[i+1]);
            }
        }
        this.ranges = rangeList.toArray();
    }

    /* Getter for invocationID. */
    public int getInvocationID() {
        return invocationID;
    }

    /* Adds the range containing only the specified int to this instance's ranges. */
    public void addInt(int i) {
        addRange(i, i+1);
    }

    /* Adds the range starting at the specified start int (inclusive) and ending at the specified end int (exclusive) to
     * this instance's ranges. */
     public void addRange(int start, int end) {
         if(start >= end) {
             throw new RuntimeException(String.format("Invalid range: [%s, %s)", start, end));
         }
         addRanges(new int[]{start, end});
     }

     /* Adds the specified ranges to this instance's ranges. */
    private void addRanges(int[] otherRanges) {
        if(ranges.length == 0) {
            ranges = otherRanges.clone();
        } else if(otherRanges.length != 0) {
            IntSinglyLinkedList result = new IntSinglyLinkedList();
            int thisIndex = 0;
            int otherIndex = 0;
            int start0;
            int end0;
            if(ranges[thisIndex] < otherRanges[otherIndex]) {
                start0 = ranges[thisIndex++];
                end0 = ranges[thisIndex++];
            } else {
                start0 = otherRanges[otherIndex++];
                end0 = otherRanges[otherIndex++];
            }
            while(thisIndex < ranges.length || otherIndex < otherRanges.length) {
                int start1;
                int end1;
                if(thisIndex >= ranges.length || (otherIndex < otherRanges.length && otherRanges[otherIndex] <= ranges[thisIndex])) {
                    start1 = otherRanges[otherIndex++];
                    end1 = otherRanges[otherIndex++];
                } else {
                    start1 = ranges[thisIndex++];
                    end1 = ranges[thisIndex++];
                }
                int[] merge = mergeRanges(start0, end0, start1, end1);
                if(merge.length == 2) {
                    // Ranges overlapped
                    start0 = merge[0];
                    end0 = merge[1];
                } else {
                    // Ranges did not overlap add the smaller range to the list
                    result.enqueue(merge[0]);
                    result.enqueue(merge[1]);
                    start0 = merge[2];
                    end0 = merge[3];
                }
            }
            result.enqueue(start0);
            result.enqueue(end0);
            this.ranges = result.toArray();
        }
    }

     /* If the specified ranges overlap return an array with the start and end of the union of the two ranges. Otherwise,
      * returns an array with the start and end of the numerically smaller range first and then the start and end of numerically
      * larger range. */
     private int[] mergeRanges(int start1, int end1, int start2, int end2) {
         if(start1 <= start2 && start2 <= end1) {
             // Range 2 starts inside range 1
             int[] result = new int[2];
             result[0] = start1;
             result[1] = end1 > end2 ? end1 : end2;
             return result;
         } else if(start2 <= start1 && start1 <= end2) {
             // Range 1 starts inside range 2
             int[] result = new int[2];
             result[0] = start2;
             result[1] = end1 > end2 ? end1 : end2;
             return result;
         } else {
             // The ranges do not overlap
             int[] result = new int[4];
             if(start1 < start2) {
                 result[0] = start1;
                 result[1] = end1;
                 result[2] = start2;
                 result[3] = end2;
             } else {
                 result[0] = start2;
                 result[1] = end2;
                 result[2] = start1;
                 result[3] = end1;
             }
             return result;
         }
     }

    /* If the specified other InvocationRanges instance has that same invocation ID as this instance, merges the
     * array index ranges from the specified other instance into this instance's ranges. Returns whether the merge occurred
     * i.e. whether the this instance and the other instance have the same invocation ID. */
    public boolean merge(InvocationRanges other) {
        if(this.invocationID != other.invocationID) {
            return false;
        } else {
            addRanges(other.ranges);
            return true;
        }
    }

    /* Returns a copy ranges. */
    public int[] getRangesCopy() {
        return ranges.clone();
    }

    /* Returns a deep copy of this instance. */
    public InvocationRanges copy() {
        return new InvocationRanges(invocationID, ranges.clone());
    }

    /* Returns a text representation of this instance. */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("InvocationRanges {invocationID: ")
                .append(invocationID)
                .append(", ranges: ");
        for(int i = 0; i < ranges.length; i+=2) {
            builder.append('[').append(ranges[i]).append(", ").append(ranges[i+1]).append(')');
            if(i + 2 < ranges.length) {
                // This is not the last range
                builder.append(" U ");
            }
        }
        return builder.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        InvocationRanges that = (InvocationRanges) o;
        if(this.invocationID != that.invocationID || this.ranges.length != that.ranges.length) return false;
        for(int i = 0; i < this.ranges.length; i++) {
            if(this.ranges[i] != that.ranges[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = invocationID;
        for(int i : ranges) {
            result = 31 * result + i;
        }
        return result;
    }
}
