package com.sabeshkin.Heap;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest {
    public static void printArray(int[] array){
        System.out.println( Arrays.toString(array));
    }
    @Test
    public void MakeHeap(){
        Heap heap = new Heap();
        int[] in = new int[]{1,2,3};
        int depth = in.length;
        heap.MakeHeap(in, depth);
        int Root = heap.HeapArray[0];
        int RootLeftChild = heap.HeapArray[1];
        int RootRightChild = heap.HeapArray[2];
        printArray(heap.HeapArray);
        assertTrue(RootLeftChild<Root);
        assertTrue(RootRightChild<Root);
        assertTrue(heap.HeapArray[depth-1]!=-1);
    }

    @Test
    public void MakeHeap_Empty_Arr(){
        Heap heap = new Heap();
        int[] in = new int[]{};
        int depth = in.length;
        heap.MakeHeap(in, depth);


    }
    @Test
    public void MakeHeap_Null(){
        Heap heap = new Heap();
        int[] in = null;
        int depth = 0;
        heap.MakeHeap(in, depth);


    }

    public void MakeHeap_Several_Node_Test(int indexOfNode){
        Heap heap = new Heap();
        int[] in = new int[]{6, 5, 4, 3, 2, 1};
        int depth = in.length;
        heap.MakeHeap(in, depth);
        int parent = heap.HeapArray[indexOfNode];
        int indexOfLeftChild = heap.getLeftChildIndex(indexOfNode);
        int leftChild = heap.HeapArray[indexOfLeftChild];
        int indexOfRightChild = heap.getRightChildIndex(indexOfNode);
        int rightChild = heap.HeapArray[indexOfRightChild];
        printArray(heap.HeapArray);
        assertTrue(leftChild<parent);
        assertTrue(rightChild<parent);
    }

    @Test
    public void MakeHeap_Several_Node(){
        MakeHeap_Several_Node_Test(1);
    }

    @Test
    public void GetMaxKey_Test(){
        Heap heap = new Heap();
        int[] in = new int[]{4, 3, 2, 1};
        int depth = in.length;
        heap.MakeHeap(in, depth);
        printArray(heap.HeapArray);
        assertEquals(4, heap.GetMax());
        assertEquals(3, heap.GetMax());
        printArray(heap.HeapArray);
        assertEquals(2, heap.GetMax());
        printArray(heap.HeapArray);
        assertEquals(1, heap.GetMax());
        printArray(heap.HeapArray);
        assertEquals(-1, heap.GetMax());
        printArray(heap.HeapArray);

        assertEquals(heap.HeapArray[0], heap.GetMax());
        printArray(heap.HeapArray);

        assertEquals(heap.DEFAULT_NODE_VALUE, heap.GetMax());
        printArray(heap.HeapArray);

    }

    @Test
    public void GetMaxKey_Without_Repeat_Keys_Test(){
        Heap heap = new Heap();
        int[] in = new int[]{4, 3, 2, 1};
        int depth = in.length;
        heap.MakeHeap(in, depth);
        // printArray(heap.HeapArray);

        int excludedMax = heap.GetMax();
        assertTrue(Arrays.stream(heap.HeapArray).noneMatch(value->value==excludedMax));
        // printArray(heap.HeapArray);
        int excludedMax_2 = heap.GetMax();
        assertTrue(Arrays.stream(heap.HeapArray).noneMatch(value->value==excludedMax_2));
        // printArray(heap.HeapArray);
        int excludedMax_3 = heap.GetMax();
        assertTrue(Arrays.stream(heap.HeapArray).noneMatch(value->value==excludedMax_3));
        //printArray(heap.HeapArray);
        int excludedMax_4 = heap.GetMax();
        assertTrue(Arrays.stream(heap.HeapArray).noneMatch(value->value==excludedMax_4));
        assertEquals(-1, heap.GetMax());
        printArray(heap.HeapArray);
    }

    @Test
    public void Add_Test(){
        Heap heap = new Heap();
        int[] in = new int[]{3, 2, 1};
        int depth = in.length;
        heap.MakeHeap(in, depth);
        assertFalse(heap.Add(4));
    }

    @Test
    public void GetMaxKey_And_Add_Test(){
        Heap heap = new Heap();
        int[] in = new int[]{4, 3, 2, 1};
        int depth = in.length;
        heap.MakeHeap(in, depth);

        int excludedMax = heap.GetMax();
        assertTrue(Arrays.stream(heap.HeapArray).noneMatch(value->value==excludedMax));
        printArray(heap.HeapArray);
        assertTrue(heap.Add(excludedMax));
        printArray(heap.HeapArray);
        int excludedMax_2 = heap.GetMax();
        assertEquals(excludedMax_2, excludedMax);
        printArray(heap.HeapArray);
    }

}