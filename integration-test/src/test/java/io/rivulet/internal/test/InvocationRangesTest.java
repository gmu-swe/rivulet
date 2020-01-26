package io.rivulet.internal.test;

import io.rivulet.internal.InvocationRanges;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/* Tests the behavior of InvocationRanges. */
public class InvocationRangesTest {

    /* Tests that an InvocationRanges instances constructed from an array has a strictly increasing ranges list. */
    @Test
    public void testInvocationRangesFromArray() {
        InvocationRanges ranges = new InvocationRanges(5, new int[]{9, 9, 7, 3, 4, 5, 6, 6, 9, -1});
        assertArrayEquals(new int[]{-1, 3, 4, 5, 6, 7, 9}, ranges.getRangesCopy());
    }

    /* Tests InvocationRanges.addRange when the start of the range being added is less than the lowest range start in the
     * InvocationRanges instance it is being added to. */
    @Test
    public void testAddRangeStartMin() {
        InvocationRanges ranges = new InvocationRanges(5, new int[]{1, 3, 5, 6, 7, 10});
        ranges.addRange(0, 4);
        assertArrayEquals(new int[]{0, 4, 5, 6, 7, 10}, ranges.getRangesCopy());
    }

    /* Tests InvocationRanges.addRange when the start of the range being added is greater than the largest range end in the
     * InvocationRanges instance it is being added to. */
    @Test
    public void testAddRangeStartMax() {
        InvocationRanges ranges = new InvocationRanges(5, new int[]{1, 3, 5, 6, 7, 10});
        ranges.addRange(11, 13);
        assertArrayEquals(new int[]{1, 3, 5, 6, 7, 10, 11, 13}, ranges.getRangesCopy());
    }

    /* Tests InvocationRanges.addRange when the range being added joins two existing ranges in the
     * InvocationRanges instance it is being added to. */
    @Test
    public void testAddRangeJoinTwoExistingRanges() {
        InvocationRanges ranges = new InvocationRanges(5, new int[]{1, 3, 5, 6, 7, 10});
        ranges.addRange(6, 7);
        assertArrayEquals(new int[]{1, 3, 5, 10}, ranges.getRangesCopy());
    }

    /* Tests InvocationRanges.addRange when the range being added is already in the ranges in the InvocationRanges
     * instance it is being added to. */
    @Test
    public void testAddExistingRange() {
        InvocationRanges ranges = new InvocationRanges(5, new int[]{1, 3, 5, 6, 7, 10});
        ranges.addRange(5, 6);
        assertArrayEquals(new int[]{1, 3, 5, 6, 7, 10}, ranges.getRangesCopy());
    }

    /* Tests InvocationRanges.addRange when the range being added contains all of the ranges in the InvocationRanges
     * instance it is being added to. */
    @Test
    public void testAddRangeContainsAllExistingRanges() {
        InvocationRanges ranges = new InvocationRanges(5, new int[]{-2, 0, 1, 3, 5, 6, 7, 10});
        ranges.addRange(-3, 12);
        assertArrayEquals(new int[]{-3, 12}, ranges.getRangesCopy());
    }

    /* Tests InvocationRanges.addRange when the range being added is disjoint from the the ranges in the InvocationRanges
     * instance it is being added to. */
    @Test
    public void testAddDisjointRange() {
        InvocationRanges ranges = new InvocationRanges(5, new int[]{-2, 0, 4, 6});
        ranges.addRange(1, 3);
        assertArrayEquals(new int[]{-2, 0, 1, 3, 4, 6}, ranges.getRangesCopy());
    }

    /* Tests InvocationRanges.merge when the instances have overlapping and non-overlapping ranges in their ranges. */
    @Test
    public void testMerge() {
        InvocationRanges ranges1 = new InvocationRanges(5, new int[]{-1, 3, 4, 6, 7, 9, 12, 13});
        InvocationRanges ranges2 = new InvocationRanges(5, new int[]{1, 2, 4, 7, 9, 11});
        ranges1.merge(ranges2);
        assertArrayEquals(new int[]{-1, 3, 4, 11, 12, 13}, ranges1.getRangesCopy());
    }
}
