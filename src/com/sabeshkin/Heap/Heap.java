package com.sabeshkin.Heap;

import java.util.*;

class Heap
{
    public int [] HeapArray; 
    private int lastFreeIndex;

    public Heap() {
        HeapArray = null;
    }

    public static int AMOUNT_OF_CHILDREN = 2;
    public static int OFFSET_LEFT_CHILD = 1;
    public static int OFFSET_RIGHT_CHILD = 2;

    public static final int DEFAULT_NODE_VALUE = -1;
    public static final int HAVE_NOT_CHILD_INDEX = -1;

    /**
     * Check that index valid for Heap array
     * @param indexForCheck
     * @return
     */
    public boolean isValidIndex(int indexForCheck){
        return indexForCheck<HeapArray.length && indexForCheck>=0;
    }

    /**
     * get index for left child
     * @param indexOfParentInBST index of node(parent)
     * @return index of right child
     */
    public int getLeftChildIndex(int indexOfParentInBST){
        int childIndex = AMOUNT_OF_CHILDREN*indexOfParentInBST+OFFSET_LEFT_CHILD;
        if(isValidIndex(childIndex)){
            return childIndex;
        }
        return HAVE_NOT_CHILD_INDEX;
    }

    /**
     * get index for right child
     * @param indexOfParentInBST  index of node(parent)
     * @return index of right child
     */
    public  int getRightChildIndex(int indexOfParentInBST){
        int childIndex =  AMOUNT_OF_CHILDREN*indexOfParentInBST+OFFSET_RIGHT_CHILD;
        if(isValidIndex(childIndex)){
            return childIndex;
        }
        return HAVE_NOT_CHILD_INDEX;
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
     * Check object is null
     * @param object
     * @return
     */
    public boolean isNull(Object object){
        return object==null;
    }

    /**
     * Make heap from arr
     *
     *Алгоритм построения кучи
     *
     * если переменная в которой храню индекс крайнего свободного элемента, равно (-1),
     * 	    то возвращаю false;
     * Создаю новый массив размера depth, начальные значения -1
     * Все узлы в массиве - равны (-1) - так смогу определять, какие еще не проставлены
     * При создании объекта, указываю, что последний свободный индекс равен 0
     * Беру узел и ставлю его в последнюю свободную ячейку
     * после этого проверяю, является ли он корнем дерева
     * 	    то выхожу из метода и возвращаю true, т.к. элемент первый и единственный в куче
     * родитель есть, то беру его значение
     * до тех пора пока значение родителя меньше значения потомка,
         * 	меняю узлы местами,
         * 	то есть поднимаю потомка на место родителя
         * 	(достаточно поменять их позиции в массиве, какие-то внутренние ссылки, к счастью, менять не надо)
         * 	и меняем рассматриваемого родителя
     * возвращаю true;
     */
    public void MakeHeap(int[] a, int depth)
    {

        if(isNull(a)){
            return;
        }

        int heapArraySise = calculateArrSizeForBinaryTree(depth);
        HeapArray = new int[heapArraySise];
        Arrays.fill(HeapArray, DEFAULT_NODE_VALUE);
        lastFreeIndex = 0;
        Arrays.stream(a).forEach(number -> Add(number));
    }

    /**
     * Сalculate Arr Size For Binary Tree
     *
     */
    public int calculateArrSizeForBinaryTree(int depth)
    {
        return (int) (Math.pow(AMOUNT_OF_CHILDREN,depth+1)-1);
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
     * Алгоритм замены родителя и потомка
     *
     * На вход индекс родителя и индекс потомка
     * зная индекс потомка, вычисляю индекс родителя
     * в третью переменную кладу значение родителя
     * под индекс родителя кладу значение потомка
     * Под индекс потомка, кладу значение из третьей переменной кармана
     */
    public void replaceParentWithChild(int indexOfChild, int child)
    {
        int parentIndex = getParentIndex(indexOfChild);
        int replacedValue = HeapArray[parentIndex];
        HeapArray[parentIndex] = child;
        HeapArray[indexOfChild] = replacedValue;
    }

    /**
     * Get and remove from heap her max key
     *
     */
    public int GetMax()
    {
        int indexNodeForReplace = 0;
        int maxKey = HeapArray[indexNodeForReplace];
        int nodeForMove = getMinKeyWithoutRemove();
        HeapArray[indexNodeForReplace] = nodeForMove;
        int indexMinKey = getMinKeyIndex();
        removeNodeByIndex(indexMinKey);
        if(maxKey == nodeForMove){
            if(lastFreeIndex==0){
                assert HeapArray[0]==-1:"Heap array must be contain only '-1'";
            }
            return maxKey;
        }
        int maxNearestChildIndex = getMaxNearestChildIndex(indexNodeForReplace);
        int maxChild = HeapArray[maxNearestChildIndex];
        while(nodeForMove<maxChild){
            replaceNodesByIndex(indexNodeForReplace, maxNearestChildIndex);
            indexNodeForReplace = maxNearestChildIndex;
            maxNearestChildIndex = getMaxNearestChildIndex(indexNodeForReplace);
            maxChild = HeapArray[maxNearestChildIndex];
        }
        return maxKey;
    }
    /**
     * Get index of max nearest child index
     *
     */
    public int getMaxNearestChildIndex(int parentIndex)
    {
        int leftChildIndex = getLeftChildIndex(parentIndex);
        int rightChildIndex = getRightChildIndex(parentIndex);

        boolean isNotExistLeftChild = leftChildIndex==-1 && rightChildIndex!=-1;
        if(isNotExistLeftChild){
            return rightChildIndex;
        }
        boolean isNotExistRightChild = leftChildIndex!=-1 && rightChildIndex==-1;
        if(isNotExistRightChild){
            return leftChildIndex;
        }

        boolean isNotExistAllChildren = leftChildIndex==-1 && rightChildIndex==-1;
        if(isNotExistAllChildren){
            return parentIndex;
        }


        boolean isLeftBigger = HeapArray[leftChildIndex] >  HeapArray[rightChildIndex];
        if(isLeftBigger){
            return leftChildIndex;
        }
        return rightChildIndex;
    }


    /**
     * Replace nodes
     *
     */
    public void replaceNodesByIndex(int firstNodeIndex, int secondNodeIndex)
    {
        int firstValue = HeapArray[firstNodeIndex];
        HeapArray[firstNodeIndex] = HeapArray[secondNodeIndex];
        HeapArray[secondNodeIndex] = firstValue;
    }

    /**
     * Remove from heap
     *
     */
    public void removeNodeByIndex(int index)
    {
        HeapArray[index] = -1;
        boolean haveNodeInHeap = lastFreeIndex>0;
        if(haveNodeInHeap){
            lastFreeIndex--;
        }
        assert lastFreeIndex >= 0:"You should validate lastFreeIndex";
    }



    /**
     * Get min key
     *
     */
    public int getMinKeyWithoutRemove()
    {
        int indexMinKey = lastFreeIndex-1;
        if(isValidIndex(indexMinKey)){
            return HeapArray[indexMinKey];
        }
        return DEFAULT_NODE_VALUE;
    }

    /**
     * Get min key
     *
     */
    public int getMinKeyIndex()
    {
        int indexMinKey = lastFreeIndex-1;
        if(isValidIndex(indexMinKey)){
            return indexMinKey;
        }
        return 0;
    }


}