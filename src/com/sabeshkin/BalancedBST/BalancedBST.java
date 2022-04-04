package com.sabeshkin.BalancedBST;

import java.util.*;

class BSTNode {
    public int NodeKey; // ключ узла
    public BSTNode Parent; // родитель или null для корня
    public BSTNode LeftChild; // левый потомок
    public BSTNode RightChild; // правый потомок
    public int Level; // глубина узла

    public BSTNode(int key, BSTNode parent) {
        NodeKey = key;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

class BalancedBST {
    public BSTNode Root; 

    public BalancedBST() {
        Root = null;
    }


    public boolean IsBalanced(BSTNode root_node) {
        return false; // сбалансировано ли дерево с корнем root_node
    }


    /**
     * Print tree structure
     * With line "***.." in bottom
     *
     * @param prefix
     * @param n
     * @param isLeft
     */
    public void printWrapper(String prefix, BSTNode n, boolean isLeft) {

        print(prefix, n, isLeft);
        System.out.println("***************************************");
    }

    /**
     * Print tree structure
     *
     * @param prefix
     * @param n
     * @param isLeft
     */
    public void print(String prefix, BSTNode n, boolean isLeft) {
        if (n != null) {
            print(prefix + "     ", n.RightChild, false);
            System.out.println(prefix + ("|-- ") + n.NodeKey);
            print(prefix + "     ", n.LeftChild, true);
        }
    }


    public void GenerateTree(int[] a) {

        if (a == null) {
            Root = null;
            return;
        }

        boolean isEmptyArr = a.length == 0;
        if (isEmptyArr) {
            Root = null;
            return;
        }
        int arrSize = calculateArraySize(a);
        int[] sortedInArr = sortArray(a);
        // assert sortedInArr[0]<=sortedInArr[1];
        generatePartOfBST(false, sortedInArr, 0, arrSize - 1, null);
    }

    /**
     * Generate arr of BST for subset of sorted arr from start subset to end subset indexes
     */
    public void generatePartOfBST(boolean isLeftChild, int[] sortedInArr,
                                  int startSubset, int endSubset,
                                  BSTNode parent) {

        int mediumIndex = getMediumIndex(startSubset, endSubset);
        int childNodeKey = sortedInArr[mediumIndex];
        BSTNode child = new BSTNode(childNodeKey, null);
        bindParentChild(isLeftChild, parent, child);


        boolean haveLeftPart = mediumIndex > startSubset;
        if (haveLeftPart) {
            int endLeftPartIndex = mediumIndex - 1;
            generatePartOfBST(true,
                    sortedInArr,
                    startSubset, endLeftPartIndex, child);
        }

        boolean haveRightPart = mediumIndex < endSubset;
        if (haveRightPart) {
            int startRightPartIndex = mediumIndex + 1;
            generatePartOfBST(false,
                    sortedInArr,
                    startRightPartIndex, endSubset, child);
        }
    }

    /**
     * Bind child and parent
     */
    public void bindParentChild(boolean isLeftChild, BSTNode parent,
                                BSTNode child){
        boolean isFirstIteration = isFirstIteration();
        if(isFirstIteration){
            Root=child;
            return;
        }

        child.Parent = parent;
        boolean isRightChild = !isLeftChild;
        boolean isSameKey = parent.NodeKey == child.NodeKey;
        if(isRightChild|| isSameKey){
            addNextRightChild(parent, child);
            return;
        }
        parent.LeftChild = child;

    }

    /**
     *Add right child to node
     *catch also case, when left and right child have same node key
     *
     */
    public void addNextRightChild(BSTNode parent,
                                  BSTNode child){

        boolean isSameKeyNode = parent.RightChild !=null;
        if(isSameKeyNode){
            parent.RightChild.RightChild = child;
            return;
        }
        parent.RightChild = child;
    }

    /**
     * Check that it is first iteration of algoritm
     */
    public boolean isFirstIteration() {
        return Root == null;
    }


    /**
     * Get medium index of array
     */
    public static int getMediumIndex(int startSubset, int endSubset) {
        int mediumOfSubsetDifference = (endSubset - startSubset) / 2;
        int mediumIndexOfSubset = startSubset + mediumOfSubsetDifference;
        return mediumIndexOfSubset;
    }

    /**
     * Calculate array size for tree
     */
    public static int calculateArraySize(int[] arr) {
        return arr.length;
    }

    /**
     * Sort array for low to high
     */
    public static int[] sortArray(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }
}