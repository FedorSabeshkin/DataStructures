package com.sabeshkin.algorithmsDataStructures2;

import java.util.*;

public class AlgorithmsDataStructures2
{

    /**
     * Описание алгоритма работы на русском языке
     * //0.
     * получаю отсортированный массив
     *
     * вызываю метод в который передаю массив для BST, отсортированный массив, 0 и (длину in массива - 1), индекс родителя (-1)
     *
     * //1.
     * нахожу середину
     *
     * //2. складывание элемента в нужный индекс
     * если индекс начала равен 0, а индекс конца длине in массива - 1,
     * 	то кладу на 0 индекс
     *
     * если есть флаг что идем по левой ветке, то вычисляю индекс для сохранения левого потомка
     * 		надо вычислять индекс потомка отталкиваясь от значения индекса родителя, который тоже передам в методе
     * 		тогда и для левой и для правой ветки будет всегда актуальный индекс родителя, конкретно для левого
     * 		или правого кейса
     * // 2. end
     *
     * // 3. вызов метода 1 с разными аргументами
     * если индекс середины больше минимального индекса для этого поднабора
     * 	то вызываю метод в котором нахожусь, но с другими аргументом
     * 														старта равным индексу начала
     * 														и аргументом конца, равным найденному ранее индексу середины - 1
     * 														аргументом говорящем, что мы в левой ветке
     * 														аргументом индекса родителя
     *
     * если индекс середины меньше максимального индекса для этого набора
     * 	то вызываю метод в котором нахожусь, но с другими аргументом
     * 														старта равным найденному ранее индексу середины + 1
     * 														и аргументом конца, равным крайнему элементу
     * 														аргументом говорящем, что мы в правой ветке
     * 														аргументом индекса родителя
     * 	// 3. end
     * возвращаю сформированный массив
     */

    public static int AMOUNT_OF_CHILDREN = 2;
    public static int OFFSET_LEFT_CHILD = 1;
    public static int OFFSET_RIGHT_CHILD = 2;

    /**
     * Calculate index for left child
     * @param indexOfParentInBST index of node(parent)
     * @return index of right child
     */
    public static int calculateLeftChildIndex(int indexOfParentInBST){
        return AMOUNT_OF_CHILDREN*indexOfParentInBST+OFFSET_LEFT_CHILD;
    }

    /**
     * Calculate index for right child
     * @param indexOfParentInBST  index of node(parent)
     * @return index of right child
     */
    public static int calculateRightChildIndex(int indexOfParentInBST){
        return AMOUNT_OF_CHILDREN*indexOfParentInBST+OFFSET_RIGHT_CHILD;
    }

    public static int[] GenerateBBSTArray(int[] a)
    {
        if(a==null){
            return null;
        }

        boolean isEmptyArr = a.length==0;
        if(isEmptyArr){
            int[] emptyArr = a;
            return emptyArr;
        }

        int arrSize = calculateArraySize(a);
        int[] arrForBST = new int[arrSize];
        int[] sortedInArr = sortArray(a);
        // assert sortedInArr[0]<=sortedInArr[1];
        return generatePartOfBSTArr(false, arrForBST, sortedInArr, 0, arrSize-1, -1);
    }

    /**
     * Generate arr of BST for subset of sorted arr from start subset to end subset indexes
     * @param isLeftChild
     * @param arrForBST
     * @param sortedInArr
     * @param startSubset
     * @param endSubset
     * @param indexOfParentInBST
     * @return
     */
    public static int[] generatePartOfBSTArr(boolean isLeftChild,
                                             int[] arrForBST, int[] sortedInArr,
                                             int startSubset, int endSubset,
                                             int indexOfParentInBST){

        int mediumIndex = getMediumIndex(startSubset, endSubset);
        int indexOfElementForBST = setElementInArrForBST( isLeftChild,
                arrForBST, sortedInArr,
                startSubset, endSubset,
                indexOfParentInBST,
                mediumIndex);

        boolean haveLeftPart = mediumIndex>startSubset;
        if(haveLeftPart){
            int endLeftPartIndex = mediumIndex-1;
            generatePartOfBSTArr(true,
                    arrForBST,sortedInArr,
                    startSubset, endLeftPartIndex, indexOfElementForBST);
        }

        boolean haveRightPart = mediumIndex<endSubset;
        if(haveRightPart){
            int startRightPartIndex = mediumIndex+1;
            generatePartOfBSTArr(false,
                    arrForBST,sortedInArr,
                    startRightPartIndex, endSubset, indexOfElementForBST);
        }

        return arrForBST;
    }

    /**
     *
     * Set element in array for BST
     *
     * return index of element in arr for BST
     */
    public static int setElementInArrForBST( boolean isLeftChild,
                                             int[] arrForBST, int[] sortedArr,
                                             int startSubset, int endSubset,
                                             int indexOfParentInBST, int mediumIndex){

        int indexOfElementForBST = calculateIndexInArrForBST(isLeftChild, startSubset, endSubset, sortedArr, indexOfParentInBST);
        int elementOfSortedArr = sortedArr[mediumIndex];
        //assert elementOfSortedArr>0:"Don't exist this elem in unit tests";
        arrForBST[indexOfElementForBST] = elementOfSortedArr;
        return indexOfElementForBST;
    }

    /**
     *
     * Calculate index of element in array for BST
     *
     */
    public static int calculateIndexInArrForBST( boolean isLeftChild,
                                                 int startSubset, int endSubset,
                                                 int[] inArr,
                                                 int indexOfParentInBST){
        boolean isFirstIteration = startSubset==0 && endSubset==inArr.length-1;
        if(isFirstIteration){
                 return 0;
        }

        if(isLeftChild){
            return calculateLeftChildIndex(indexOfParentInBST);
        }

        return calculateRightChildIndex(indexOfParentInBST);


    }

    /**
     *
     * Get medium index of array
     *
     */
    public static int getMediumIndex(int startSubset, int endSubset ){
        int mediumOfSubsetDifference = (endSubset - startSubset) / 2;
        int mediumIndexOfSubset = startSubset + mediumOfSubsetDifference;
        return mediumIndexOfSubset;
    }

    /**
     *
     * Calculate array size for tree
     *
     */
    public static int calculateArraySize(int[] arr){
        return arr.length;
    }

    /**
     *
     * Sort array for low to high
     *
     */
    public static int[] sortArray(int[] arr){
        Arrays.sort(arr);
        return arr;
    }
}