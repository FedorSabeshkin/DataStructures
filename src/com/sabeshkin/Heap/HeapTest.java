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
}