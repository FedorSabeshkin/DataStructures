package com.sabeshkin.algorithmsDataStructures2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SetElementInArrForBSTTest {

    @Test
    public void setElementInArrForBST_Three_Nodes(){
        int[] in = new int[]{1,2,3};
        int[] arrForBST = new int[3];
        int minIndex = 0;
        int maxIndex = in.length-1;
        int mediumIndex = AlgorithmsDataStructures2.getMediumIndex(minIndex, maxIndex);
        int expectedElement = 2;
        int result = AlgorithmsDataStructures2.setElementInArrForBST(false,
                    arrForBST, in,
                minIndex, maxIndex,
                -1,
                mediumIndex
                );
        int[] out = new int[]{2,1,3};
        assertEquals(expectedElement, arrForBST[result]);
    }

//    @Test
//    public void setElementInArrForBST_LeftPart(){
//        int[] in = new int[]{1,2,3};
//        int expectedElement = 1;
//        int minIndex = 0;
//        int maxIndex = 1-1;
//        int result = AlgorithmsDataStructures2.setElementInArrForBST(true, in, minIndex, maxIndex,  0);
//        int[] out = new int[]{2,1,3};
//        assertEquals(expectedElement, out[result]);
//    }
//
//    @Test
//    public void setElementInArrForBST_RightPart(){
//        int[] in = new int[]{1,2,3};
//        int expectedElement = 3;
//        int minIndex = 1;
//        int maxIndex = in.length-1;
//        int result = AlgorithmsDataStructures2.setElementInArrForBST(false, in, minIndex, maxIndex,  0);
//        int[] out = new int[]{2,1,3};
//        assertEquals(expectedElement, out[result]);
//    }



}