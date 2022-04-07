package com.sabeshkin.Heap;

import java.util.*;

class Heap
{
    public int [] HeapArray; // хранит неотрицательные числа-ключи
    private int lastFreeIndex;

    public Heap() {
        HeapArray = null;
    }

    public static int AMOUNT_OF_CHILDREN = 2;
    public static int OFFSET_LEFT_CHILD = 1;
    public static int OFFSET_RIGHT_CHILD = 2;

    public static final int EMPTY_NODE = -1;

    /**
     * get index for left child
     * @param indexOfParentInBST index of node(parent)
     * @return index of right child
     */
    public static int getLeftChildIndex(int indexOfParentInBST){
        return AMOUNT_OF_CHILDREN*indexOfParentInBST+OFFSET_LEFT_CHILD;
    }

    /**
     * get index for right child
     * @param indexOfParentInBST  index of node(parent)
     * @return index of right child
     */
    public static int getRightChildIndex(int indexOfParentInBST){
        return AMOUNT_OF_CHILDREN*indexOfParentInBST+OFFSET_RIGHT_CHILD;
    }

    /**
     * get index for right child
     * @param indexOfNode  index of node(parent)
     * @return index of right child
     */
    public static int getParentIndex(int indexOfNode){
        return (indexOfNode-1)/AMOUNT_OF_CHILDREN;
    }

    /**
     * Make heap from arr
     *
     */
    public void MakeHeap(int[] a, int depth)
    {
        HeapArray = new int[depth];
        Arrays.fill(HeapArray, -1);
        lastFreeIndex = 0;
        Arrays.stream(a).forEach(number -> Add(number));
    }


    /**
     * Add new key to heap
     *
     */
    public boolean Add(int key)
    {
        boolean isFullArr = lastFreeIndex>HeapArray.length -1;
        if(isFullArr){
            return false;
        }

        HeapArray[lastFreeIndex] = key;
        boolean isRoot = lastFreeIndex == 0;
        if(isRoot){
            lastFreeIndex++;
            return true;
        }
        //как отработает кейс, когда Root меньше нового значения?
        /*
         *То есть мы уже заменим root на новое значение
         */
        int parentIndex = getParentIndex(lastFreeIndex);
        int parent = HeapArray[parentIndex];
        int childIndex = lastFreeIndex;
        int child = key;
        while(parent < child){
            replaceParentWithChild(childIndex, child);
            childIndex = parentIndex;
            parentIndex = getParentIndex(parentIndex);
            parent = HeapArray[parentIndex];
        }
        lastFreeIndex++;
        return true;
    }



    /**
     * Replace parent and child
     *
     */
    public void replaceParentWithChild(int indexOfChild, int child)
    {
        int parentIndex = getParentIndex(indexOfChild);
        int replacedValue = HeapArray[parentIndex];
        HeapArray[parentIndex] = child;
        HeapArray[indexOfChild] = replacedValue;
    }

    public int GetMax()
    {
        // вернуть значение корня и перестроить кучу
        return -1; // если куча пуста
    }



}