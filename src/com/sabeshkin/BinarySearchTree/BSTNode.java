package com.sabeshkin.BinarySearchTree;

import java.io.*;
import java.util.*;


class BSTNode<T> {
    public int NodeKey;
    public T NodeValue;
    public BSTNode<T> Parent;
    public BSTNode<T> LeftChild;
    public BSTNode<T> RightChild;

    public BSTNode(int key, T val, BSTNode<T> parent) {
        NodeKey = key;
        NodeValue = val;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

// result of search
class BSTFind<T> {
    // null if tree ha
    public BSTNode<T> Node;

    // true if node with this key found
    public boolean NodeHasKey;

    // true, if we should add node to parent
    public boolean ToLeft;

    public BSTFind() {
        Node = null;
    }

    /**
     * Constructor for tests
     *
     * @param Node
     * @param NodeHasKey
     * @param NodeHasKey
     */
    public BSTFind(BSTNode<T> Node, boolean NodeHasKey, boolean ToLeft) {
        this.Node = Node;
        this.NodeHasKey = NodeHasKey;
        this.ToLeft = ToLeft;
    }

    /**
     * Create object with found node
     *
     * @param Node found node
     * @return
     */
    public static BSTFind createFoundNodeInfo(BSTNode Node) {
        return new BSTFind(Node, true, false);
    }

    /**
     * Override equals
     * We check equals Node, NodeHasKey and NodeHasKey fields
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        boolean isSameObject = obj == this;
        if (isSameObject) {
            return true;
        }
        boolean isAnotherClassObject = !(obj instanceof BSTFind);
        if (isAnotherClassObject) {
            return false;
        }
        BSTFind<T> bstFindForCheck = (BSTFind<T>) obj;
        boolean isEqualNode = this.Node.equals(bstFindForCheck.Node);
        boolean isEqualNodeHasKey = this.NodeHasKey == bstFindForCheck.NodeHasKey;
        boolean isEqualToLeft = this.ToLeft == bstFindForCheck.ToLeft;

        return isEqualNode && isEqualNodeHasKey && isEqualToLeft;
    }
}

class BST<T> {
    BSTNode<T> Root; // root of tree or null
    private int size = 0;

    public BST(BSTNode<T> node) {
        Root = node;
        if(Root!=null){
            size = 1;
        }
    }

    /**
     * Finding the next node or parent by key to which it can be added
     */
    public BSTFind<T> FindNodeByKey(int key) {
        return FindNodeByKeyFromNode(Root, key);
    }

    /**
     * Looking for a match from a specific node
     */
    public BSTFind<T> FindNodeByKeyFromNode(BSTNode<T> FromNode, int key) {

        if (Root == null) {
            BSTFind<T> result = new BSTFind<>();
            result.NodeHasKey = false;
            result.ToLeft = false;
            return result;
        }
        boolean isSameKey = key == FromNode.NodeKey;
        if (isSameKey) {
            return new BSTFind(FromNode, true, false);
        } else {
            return findInChildren(key, FromNode);
        }
    }


    /**
     * Method for selecting the next descendant node, for equivalence to the search key
     */
    private BSTFind<T> findInChildren(int keyForSearch, BSTNode<T> nodeForCheck) {
        assert nodeForCheck != null : "The node whose descendants will be checked cannot be null";
        if (keyForSearch < nodeForCheck.NodeKey) {
            return checkLeftChild(keyForSearch, nodeForCheck);
        } else {
            return checkRightChild(keyForSearch, nodeForCheck);
        }
    }

    /**
     * Left Child Validation Method
     */
    private BSTFind<T> checkLeftChild(int keyForSearch, BSTNode<T> parentForCheck) {
        boolean isExistLeftChild = parentForCheck.LeftChild != null;
        if (isExistLeftChild) {
            return FindNodeByKeyFromNode(parentForCheck.LeftChild, keyForSearch);
        } else {
            return new BSTFind(parentForCheck, false, true);
        }
    }

    /**
     * Right Child Validation Method
     */
    private BSTFind<T> checkRightChild(int keyForSearch, BSTNode<T> parentForCheck) {
        boolean isExistRightChild = parentForCheck.RightChild != null;
        if (isExistRightChild) {
            return FindNodeByKeyFromNode(parentForCheck.RightChild, keyForSearch);
        } else {
            return new BSTFind(parentForCheck, false, false);
        }
    }


    /**
     * Adding a new key-value node
     * @param key
     * @param val
     * @return
     */
    public boolean AddKeyValue(int key, T val) {
        BSTFind<T> findNodeInfo = FindNodeByKey(key);

        BSTNode<T> parent = findNodeInfo.Node;
        if (parent == null) {
            Root = new BSTNode<>(key, val, null);
            return true;
        }

        boolean isExist = findNodeInfo.NodeHasKey;
        if (isExist) {
            return false;
        } else {
            addNotExistNode(findNodeInfo, key, val);
            size++;
            return true;
        }
    }

    /**
     * We add the child to the position calculated for him in the tree
     *
     * @param findNodeInfo
     * @param key
     * @param val
     */
    private void addNotExistNode(BSTFind<T> findNodeInfo, int key, T val) {
        if (findNodeInfo.ToLeft) {
            assert findNodeInfo.Node != null : "The lookup method did not identify a potential parent";
            findNodeInfo.Node.LeftChild = new BSTNode(key, val, findNodeInfo.Node);
        } else {
            findNodeInfo.Node.RightChild = new BSTNode(key, val, findNodeInfo.Node);
        }
    }

    /**
     * We are looking for the maximum / minimum key in the subtree
     *
     * @param FromNode
     * @param FindMax
     * @return
     */
    public BSTNode<T> FinMinMax(BSTNode<T> FromNode, boolean FindMax) {
        if (FromNode == null) { return null; }

        if (FindMax) {
            return findMax(FromNode);
        } else {
            return findMin(FromNode);
        }
    }


    /**
     * Finding max node
     */
    public BSTNode<T> findMax(BSTNode<T> node) {
        boolean isHaveRightChild = node.RightChild != null;
        if (isHaveRightChild) {
            return findMax(node.RightChild);
        } else {
            return node;
        }
    }


    /**
     * Finding the min node
     */
    public BSTNode<T> findMin(BSTNode<T> node) {
        boolean isHaveLeftChild = node.LeftChild != null;
        if (isHaveLeftChild) {
            return findMin(node.LeftChild);
        } else {
            return node;
        }
    }

    /**
     * Removing a node by key,
     * If it exists in the tree
     *
     * @param key
     * @return
     */
    public boolean DeleteNodeByKey(int key) {
        BSTFind<T> findResult = FindNodeByKey(key);
        boolean isNotExistNodeWithKey = !findResult.NodeHasKey;
        if (isNotExistNodeWithKey) {
            return false;
        }

        BSTNode toDelete = findResult.Node;
        BSTNode<T> toDeleteParent = toDelete.Parent;

        if(isLeaf(toDelete)){
            deleteLeaf(toDelete);
            return true;
        }

        boolean isHaveOnlyLeftChild = toDelete.LeftChild!=null && toDelete.RightChild == null;
        if(isHaveOnlyLeftChild){
            replaceNode(toDelete, toDelete.LeftChild);
            return true;
        }

        boolean isHaveOnlyRightChild = toDelete.LeftChild==null && toDelete.RightChild != null;
        if(isHaveOnlyRightChild){
            replaceNode(toDelete, toDelete.RightChild);
            return true;
        }


        deleteNodeWithBothChildren(toDelete);
        return true;
    }

    /**
     *	Delete node with both - left and right children
     */
    public void deleteNodeWithBothChildren(BSTNode<T> toDelete){
        BSTNode<T> minChild = findMin(toDelete.RightChild);
        // remove minChild from old place
        if(isLeaf(minChild)){
            deleteLeaf(minChild);
        }else{
            replaceNode(minChild, minChild.RightChild);
        }

        // set minChild to place toDelete node
        if(toDelete.Parent==null){
            minChild.Parent = null;
        }else{
            replaceNode(toDelete, minChild);
        }
    }

    /**
     *	Check node is leaf
     */
    public boolean isLeaf(BSTNode<T> node){
        return node.LeftChild==null && node.RightChild == null;
    }

    /**
     *	Replace node
     */
    public void replaceNode(BSTNode<T> toReplace, BSTNode<T> replacer){
        boolean isLeftChild = toReplace.NodeKey < toReplace.Parent.NodeKey;
        if (isLeftChild) {
            toReplace.Parent.LeftChild = replacer;
        } else {
            toReplace.Parent.RightChild = replacer;
        }
        replacer.Parent = toReplace.Parent;
        toReplace.Parent = null;
    }

    /**
     *	delete leaf
     */
    public void deleteLeaf(BSTNode<T> toDelete){
        boolean isLeftChild = toDelete.NodeKey < toDelete.Parent.NodeKey;
        if (isLeftChild) {
            toDelete.Parent.LeftChild = null;
        } else {
            toDelete.Parent.RightChild = null;
        }
        toDelete.Parent = null;
    }




    /**
     * Removing an existing node from the tree
     *
     * @param key
     */
    public void DeleteExistNodeByKey(BSTFind<T> findResult, int key) {
        BSTNode<T> toDelete = findResult.Node;
        BSTNode<T> toDeleteParent = toDelete.Parent;

        BSTNode<T> toReplace = toDelete.RightChild == null
                ? toDelete.LeftChild
                : FinMinMax(toDelete.RightChild, false);

        if (toReplace != null) {

            toReplace.Parent.LeftChild = toReplace.RightChild;
            if (toReplace.RightChild != null) {
                toReplace.RightChild.Parent = toReplace.Parent;
            }
            toReplace.Parent = toDeleteParent;

            toReplace.RightChild = toDelete.RightChild;
            if (toDelete.RightChild != null) {
                toDelete.RightChild.Parent = toReplace;
            }

            toReplace.LeftChild = toDelete.LeftChild;
            if (toDelete.LeftChild != null) {
                toDelete.LeftChild.Parent = toReplace;
            }
        }

        if (toDeleteParent != null) {

            if (toDeleteParent.LeftChild == toDelete) {
                toDeleteParent.LeftChild = toReplace;
            } else {
                toDeleteParent.RightChild = toReplace;
            }

        } else {
            Root = toReplace;
        }

        toDelete.LeftChild = null;
        toDelete.RightChild = null;
        toDelete.Parent = null;
    }

    /**
     * Counting the number of elements in a tree
     *
     * @return
     */
    public int Count() {
        return countNode(Root,0);
        //return size; // количество узлов в дереве
    }

    public int countNode(BSTNode<T> node, int stage){

        //base case
        if(node==null) {
            return 0;
        }
        //recursive call to left child and right child and
        // add the result of these with 1 ( 1 for counting the root)
        stage++;
        return 1 + countNode(node.LeftChild, stage) + countNode(node.RightChild, stage);
    }
}