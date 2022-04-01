package com.sabeshkin.algorithmsDataStructures2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class calculateIndexInArrForBSTTest {

    @Test
    public void calculateIndexInArrForBST_Three_Nodes(){
        int[] in = new int[]{1,2,3};
        int expectedElement = 2;
        int minIndex = 0;
        int maxIndex = in.length-1;
        int result = AlgorithmsDataStructures2.calculateIndexInArrForBST(false, minIndex, maxIndex, in, -1);
        int[] out = new int[]{2,1,3};
        assertEquals(expectedElement, out[result]);
    }

    @Test
    public void calculateIndexInArrForBST_LeftPart(){
        int[] in = new int[]{1,2,3};
        int expectedElement = 1;
        int minIndex = 0;
        int maxIndex = 1-1;
        int result = AlgorithmsDataStructures2.calculateIndexInArrForBST(true, minIndex, maxIndex, in, 0);
        int[] out = new int[]{2,1,3};
        assertEquals(expectedElement, out[result]);
    }

    @Test
    public void calculateIndexInArrForBST_RightPart(){
        int[] in = new int[]{1,2,3};
        int expectedElement = 3;
        int minIndex = 1;
        int maxIndex = in.length-1;
        int result = AlgorithmsDataStructures2.calculateIndexInArrForBST(false, minIndex, maxIndex, in, 0);
        int[] out = new int[]{2,1,3};
        assertEquals(expectedElement, out[result]);
    }



}