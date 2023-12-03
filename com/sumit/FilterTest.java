package com.sumit;

import org.junit.Assert;
import org.junit.Test;

public class FilterTest {

    @Test
    public void testFilter_predicateMod3() {
        Hierarchy unfiltered = new ArrayBasedHierarchy(
                new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
                new int[] {0, 1, 2, 3, 1, 0, 1, 0, 1, 1, 2}
        );
        Hierarchy filteredActual = Filter.filter(unfiltered, nodeId -> nodeId % 3 != 0);
        Hierarchy filteredExpected = new ArrayBasedHierarchy(
                new int[] {1, 2, 5, 8, 10, 11},
                new int[] {0, 1, 1, 0, 1, 2}
        );

        Assert.assertEquals(filteredExpected.formatString(), filteredActual.formatString());
    }

    @Test
    public void testFilter_predicateMod2_1() {
        Hierarchy unfiltered = new ArrayBasedHierarchy(
                new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
                new int[] {0, 1, 2, 3, 1, 0, 1, 0, 1, 1, 2}
        );
        Hierarchy filteredActual = Filter.filter(unfiltered, nodeId -> nodeId % 2 != 0);
        Hierarchy filteredExpected = new ArrayBasedHierarchy(
                new int[] {1, 5},
                new int[] {0, 1}
        );

        Assert.assertEquals(filteredExpected.formatString(), filteredActual.formatString());
    }

    @Test
    public void testFilter_predicateMod2_2() {
        Hierarchy unfiltered = new ArrayBasedHierarchy(
                new int[] {1, 2, 3, 4, 5, 6, 7, 13, 9, 10, 11},
                new int[] {0, 1, 2, 3, 1, 0, 1, 0, 1, 1, 2}
        );
        Hierarchy filteredActual = Filter.filter(unfiltered, nodeId -> nodeId % 2 != 0);
        Hierarchy filteredExpected = new ArrayBasedHierarchy(
                new int[] {1, 5, 13, 9},
                new int[] {0, 1, 0, 1}
        );

        Assert.assertEquals(filteredExpected.formatString(), filteredActual.formatString());
    }

    @Test
    public void testFilter_predicateMod4() {
        Hierarchy unfiltered = new ArrayBasedHierarchy(
                new int[] {1, 2, 3, 4, 5, 8, 9, 11, 13, 15, 18, 19, 22, 23, 24 ,25 ,26, 27},
                new int[] {0, 1, 2, 3, 3, 4, 5, 2, 1, 2, 3, 4, 0, 1, 0, 1 , 2 , 1}
        );
        Hierarchy filteredActual = Filter.filter(unfiltered, nodeId -> nodeId % 4 != 0);
        Hierarchy filteredExpected = new ArrayBasedHierarchy(
                new int[] {1, 2, 3, 5, 11, 13, 15, 18, 19, 22, 23},
                new int[] {0, 1, 2, 3, 2, 1, 2, 3, 4, 0, 1}
        );
        Assert.assertEquals(filteredExpected.formatString(), filteredActual.formatString());
    }


}
