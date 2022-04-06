package com.sabeshkin.BalancedBST;

import java.util.*;

class BSTNode {
    public int NodeKey;
    public BSTNode Parent;
    public BSTNode LeftChild;
    public BSTNode RightChild;
    public int Level;

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


    /**
     * Check is balanced tree
     * @param root_node
     * @return
     */
    public boolean IsBalanced(BSTNode root_node) {
        if(isNullNode(root_node)){
            return true;
        }
        int maxDepthLeftBranch = determineMaxDepth(root_node.LeftChild, root_node.Level);
        int maxDepthRightBranch = determineMaxDepth(root_node.RightChild, root_node.Level);
        boolean isBalancedNode =Math.abs (maxDepthRightBranch - maxDepthLeftBranch)<= 1;
        boolean isBalancedLeftChild = IsBalanced( root_node.LeftChild);
        boolean isBalancedRightChild = IsBalanced( root_node.RightChild);
        return isBalancedNode && isBalancedLeftChild && isBalancedRightChild;
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

    /**
     * Print tree structure with level for each node
     *
     * @param prefix
     * @param n
     * @param isLeft
     */
    public void printLevel(String prefix, BSTNode n, boolean isLeft) {
        if (n != null) {
            printLevel(prefix + "     ", n.RightChild, false);
            System.out.println(prefix + ("|-- ") + n.NodeKey + " Level: "+ n.Level);
            printLevel(prefix + "     ", n.LeftChild, true);
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
        assert  !child.equals(parent):"Child and parent it is difference nodes";
        boolean isFirstIteration = isFirstIteration();
        if(isFirstIteration){
            Root=child;
            Root.Level = 0;
            return;
        }
        setChildLevel(parent, child);

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
            addNextRightChild(parent.RightChild,child);
            return;
        }
        setChildLevel(parent, child);
        assert child.Level - parent.Level == 1:"parent level always one less than children";
        parent.RightChild = child;
    }

    /**
     *
     *Set level of depth to node
     *
     */
    public void setChildLevel(BSTNode parent,
                              BSTNode child){
        assert Root.Level == 0:"Root level must me 0";
        child.Level = parent.Level + 1;
        assert child.Level - parent.Level == 1:"parent level always one less than children";
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


    /**
     * Determine max depth level of branch from node
     *
     * Метод определения максимальной глубины
     * Он принимает на вход узел от которого будем проверять максимальную глубину
     * и уровень глубины, его родителя
     * если узел равен нулю
     * 	    возращаю глубину родителя
     * сохраняю в переменную максимальной глубины, значение глубины рассматриваего узла (глубина родителя + 1)
     * если есть левый потомок
         * 	то вычисляю значение глубины для него, параметром глубины передаю вычисленное выше значение
         * 	результат работы метода кладу в переменную для глубины левого дерева
     * если есть правый потомок
         * 	то вычисляю значение глубины для него, параметром глубины передаю вычисленное выше значение
         * 	результат работы метода кладу в переменную для глубины правого дерева
         * возвращаю максимум из глубин левого и правого потомков
     *
     */
    public int determineMaxDepth(BSTNode rootOfSubtree, int parentLevel){
        if(isNullNode(rootOfSubtree)){
            return parentLevel;
        }
        int maxDepthLeftBranch = determineMaxDepth(rootOfSubtree.LeftChild, rootOfSubtree.Level);
        int maxDepthRightBranch = determineMaxDepth(rootOfSubtree.RightChild, rootOfSubtree.Level);
        return Math.max(maxDepthRightBranch, maxDepthLeftBranch);
    }

    /**
     *
     * Check node is null
     */
    public static boolean isNullNode(BSTNode node){
        return node==null;
    }
}