package com.sabeshkin.algorithmsDataStructures2;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class AlgorithmsDataStructures2Test {

    @Test
    public void generateBBSTArray_Empty_In() {
        int[] in = new int[]{};
        int[] expected = new int[]{};
        int[] result = AlgorithmsDataStructures2.GenerateBBSTArray(in);
        assertArrayEquals(expected, result);
    }

    @Test
    public void generateBBSTArray_One_Node() {
        int[] in = new int[]{1};
        int[] expected = new int[]{1};
        int[] result = AlgorithmsDataStructures2.GenerateBBSTArray(in);
        assertArrayEquals(expected, result);
    }

    @Test
    public void generateBBSTArray_Three_Nodes(){
        int[] in = new int[]{1,2,3};
        int[] expected = new int[]{2,1,3};
        int[] result = AlgorithmsDataStructures2.GenerateBBSTArray(in);
        System.out.println(Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void generateBBSTArray_Next_Three_Nodes(){
        int[] in = new int[]{5,6,7};
        int[] expected = new int[]{6,5,7};
        int[] result = AlgorithmsDataStructures2.GenerateBBSTArray(in);
        assertArrayEquals(expected, result);
    }

    @Test
    public void generateBBSTArray_Not_Sorted(){
        int[] in = new int[]{7,5,6};
        int[] expected = new int[]{6,5,7};
        int[] result = AlgorithmsDataStructures2.GenerateBBSTArray(in);
        assertArrayEquals(expected, result);
    }

    @Test
    public void generateBBSTArray() {
        int[] in = new int[]{1,2,3,4,5,6,7};
        int[] expected = new int[]{4,2,6,1,3,5,7};
        int[] result = AlgorithmsDataStructures2.GenerateBBSTArray(in);
        assertArrayEquals(expected, result);
    }
}