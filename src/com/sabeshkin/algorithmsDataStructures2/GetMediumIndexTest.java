package com.sabeshkin.algorithmsDataStructures2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetMediumIndexTest {

    @Test
    public void getMediumIndex_One_Node() {
        int[] in = new int[]{1};
        int expectedIndex = 0;
        int minIndex = 0;
        int maxIndex = in.length-1;
        int result = AlgorithmsDataStructures2.getMediumIndex(minIndex, maxIndex);
        assertEquals(expectedIndex, result);
    }

    @Test
    public void getMediumIndex_Three_Nodes(){
        int[] in = new int[]{1,2,3};
        int expectedElement = 2;
        int minIndex = 0;
        int maxIndex = in.length-1;
        int result = AlgorithmsDataStructures2.getMediumIndex(minIndex, maxIndex);
        assertEquals(expectedElement, in[result]);
    }


    @Test
    public void getMediumIndex_getElement() {
        int[] in = new int[]{1,2,3,4,5,6,7};
        int expectedElement = 4;
        int minIndex = 0;
        int maxIndex = in.length-1;
        assert maxIndex==6;
        assert 6/2==3;
        assert in[3]==4;
        int result = AlgorithmsDataStructures2.getMediumIndex(minIndex, maxIndex);
        assertEquals(expectedElement, in[result]);
    }
}