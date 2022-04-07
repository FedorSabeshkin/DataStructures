package com.sabeshkin.Heap;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GetMinKeyWithoutRemoveTest {
    public static void printArray(int[] array){
        System.out.println( Arrays.toString(array));
    }
    @Test
    public void getMinKeyWithoutRemove_test(){
        Heap heap = new Heap();
        int[] in = new int[]{1,2,3};
        int depth = in.length;
        heap.MakeHeap(in, depth);
        int lastKey = heap.HeapArray[depth-1];
        printArray(heap.HeapArray);
        assertEquals(lastKey, heap.getMinKeyWithoutRemove());
    }


}