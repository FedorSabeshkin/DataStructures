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

    /**
     * Constructor
     * for creation mock nodes
     * for list of expected tree traverse methods
     *
     * @param key
     */
    public BSTNode(int key) {
        NodeKey = key;
        NodeValue = null;
        Parent = null;
        LeftChild = null;
        RightChild = null;
    }

    /**
     * Show NodeKey of node
     *
     * @return
     */
    @Override
    public String toString() {
        return this.NodeKey + "";
    }

    /**
     * We compare only  NodeKey
     * for easy check right traversal order in Unit tests
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

        boolean isAnotherClassObject = !(obj instanceof BSTNode);
        if (isAnotherClassObject) {
            return false;
        }
        BSTNode<T> bstNodeForCheck = (BSTNode<T>) obj;
        boolean isEqualNodeKey = this.NodeKey == bstNodeForCheck.NodeKey;

        return isEqualNodeKey;
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
        if (Root != null) {
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
     *
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
        if (FromNode == null) {
            return null;
        }

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
     * Print tree structure
     * With line "***.." in bottom
     *
     * @param prefix
     * @param n
     * @param isLeft
     */
    public void printWrapper(String prefix, BSTNode<T> n, boolean isLeft) {

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
    public void print(String prefix, BSTNode<T> n, boolean isLeft) {
        if (n != null) {
            print(prefix + "     ", n.RightChild, false);
            System.out.println(prefix + ("|-- ") + n.NodeKey);
            print(prefix + "     ", n.LeftChild, true);
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


        if (isLeaf(toDelete)) {
            boolean isRoot = toDelete.equals(Root);
            if (isRoot) {
                Root = null;
                return true;
            }

            deleteLeaf(toDelete);
            return true;
        }

        boolean isHaveOnlyLeftChild = toDelete.LeftChild != null && toDelete.RightChild == null;
        if (isHaveOnlyLeftChild) {
            replaceNode(toDelete, toDelete.LeftChild);
            return true;
        }

        boolean isHaveOnlyRightChild = toDelete.LeftChild == null && toDelete.RightChild != null;
        if (isHaveOnlyRightChild) {
            replaceNode(toDelete, toDelete.RightChild);
            return true;
        }


        deleteNodeWithBothChildren(toDelete);
        return true;
    }

    /**
     * Delete node with both - left and right children
     */
    public void deleteNodeWithBothChildren(BSTNode<T> toDelete) {
        BSTNode<T> minChild = findMin(toDelete.RightChild);
        // remove minChild from old place
        BSTNode<T> rightChild = toDelete.RightChild;
        BSTNode<T> leftChild = toDelete.LeftChild;
        if (isLeaf(minChild)) {
            deleteLeaf(minChild);
        } else {
            replaceNode(minChild, minChild.RightChild);
        }
        // set minChild to place toDelete node
        if (toDelete.Parent == null) {
            minChild.Parent = null;
        } else {
            replaceNode(toDelete, minChild);
        }

        setChildren(minChild, leftChild, rightChild);
    }

    /**
     * Set children to new parent
     *
     * @param newParent
     * @param leftChild
     * @param rightChild
     */
    public void setChildren(BSTNode<T> newParent, BSTNode<T> leftChild, BSTNode<T> rightChild) {
        boolean isNotRecursiveParentRightChild = !newParent.equals(rightChild);
        if (isNotRecursiveParentRightChild) {
            newParent.RightChild = rightChild;
        }
        boolean isNotRecursiveParentLeftChild = !newParent.equals(leftChild);
        if (isNotRecursiveParentLeftChild) {
            newParent.LeftChild = leftChild;
        }
        rightChild.Parent = newParent;
        leftChild.Parent = newParent;
    }

    /**
     * Check node is leaf
     */
    public boolean isLeaf(BSTNode<T> node) {
        return node.LeftChild == null && node.RightChild == null;
    }

    /**
     * Replace node
     */
    public void replaceNode(BSTNode<T> toReplace, BSTNode<T> replacer) {
        boolean isRoot = toReplace.equals(Root);
        boolean isLeftChild = toReplace.NodeKey < toReplace.Parent.NodeKey;
        if (isLeftChild) {
            toReplace.Parent.LeftChild = replacer;
        } else {
            toReplace.Parent.RightChild = replacer;
        }
        replacer.Parent = toReplace.Parent;
        if (isRoot) {
            Root = replacer;
        }
        toReplace.Parent = null;
    }

    /**
     * delete leaf
     */
    public void deleteLeaf(BSTNode<T> toDelete) {
        boolean isLeftChild = toDelete.NodeKey < toDelete.Parent.NodeKey;
        if (isLeftChild) {
            toDelete.Parent.LeftChild = null;
        } else {
            toDelete.Parent.RightChild = null;
        }
        toDelete.Parent = null;
    }


    /**
     * Counting the number of elements in a tree
     *
     * @return
     */
    public int Count() {
        return countNode(Root);
    }

    /**
     * Count node and all children
     *
     * @param node
     * @return
     */
    public int countNode(BSTNode<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNode(node.LeftChild) + countNode(node.RightChild);
    }

    /**
     * Breadth-first search - BFS
     * We put the root in the queue children
     *
     * @return
     */
    public ArrayList<BSTNode> WideAllNodes() {
        Queue<BSTNode> children = new LinkedList<>();
        Queue<BSTNode> parents = new LinkedList<>();
        ArrayList<BSTNode> visitedNodes = new ArrayList<>();
        children.offer(Root);
        int amountNodesOfTree = Count();
        while (visitedNodes.size() < amountNodesOfTree) {
            accumulateParents(children, visitedNodes, parents);
            accumulateChildren(children, visitedNodes, parents);
        }
        return visitedNodes;
    }

    /**
     * After that, I run through the parents in turn and call the method on each of the nodes in it,
     * which adds elements to the children queue
     */
    public void accumulateChildren(Queue<BSTNode> children, ArrayList<BSTNode> visitedNodes, Queue<BSTNode> parents) {
        BSTNode<T> node;
        while ((node = parents.poll()) != null) {
            boolean isLeftExist = node.LeftChild != null;
            if (isLeftExist) {
                children.offer(node.LeftChild);
            }
            boolean isRightExist = node.RightChild != null;
            if (isRightExist) {
                children.offer(node.RightChild);
            }
        }
    }

    /**
     * We take the children queue to which we added children of one level below
     * * We go through it and add each element to the list
     * * after adding it to the list
     * * I add it to the parents queue - elements that I will run through and collect children
     */
    public void accumulateParents(Queue<BSTNode> children, ArrayList<BSTNode> visitedNodes, Queue<BSTNode> parents) {
        BSTNode<T> node;
        while ((node = children.poll()) != null) {
            visitedNodes.add(node);
            parents.offer(node);
        }
    }


    public static int PRE_ORDER = 2;
    public static int POST_ORDER = 1;
    public static int IN_ORDER = 0;

    /**
     * Depth-first search - DFS
     *
     * @return
     */
    public ArrayList<BSTNode> DeepAllNodes(int order) {
        ArrayList<BSTNode> visitedNodes = new ArrayList<>();
        if (order == PRE_ORDER) {
            return DeepAllNodesPreOrder(Root, visitedNodes);
        }
        if (order == POST_ORDER) {
            return null;
        }
        //inorderTraversal(Root, visitedNodes);
        inOrder(Root, visitedNodes);
        return visitedNodes;
    }

    public void postorderTraversal(BSTNode root, ArrayList<BSTNode> visitedNodes) {
        if (root != null) {
            inorderTraversal(root.LeftChild, visitedNodes);
            visitedNodes.add(root);
            inorderTraversal(root.RightChild, visitedNodes);
        }
    }

    public void inorderTraversal(BSTNode root, ArrayList<BSTNode> visitedNodes) {
        if (root != null) {
            inorderTraversal(root.LeftChild, visitedNodes);
            visitedNodes.add(root);
            inorderTraversal(root.RightChild, visitedNodes);
        }
    }

    /**
     * Add leaf to list
     * and check subtree
     * if it exist
     */
    public void inOrder(BSTNode node, List<BSTNode> visitedNodes) {
        if (node != null) {
            BSTNode leftestChild = FinMinMax(node, false);
            visitedNodes.add(leftestChild);
            if (isExistRightChild(leftestChild)) {
                inOrder(leftestChild.RightChild, visitedNodes);
                return;
            }

            boolean isNotExistRightChild = !isExistRightChild(leftestChild);
            if (isNotExistRightChild) {
                traverseParent(leftestChild, visitedNodes);
            }
        }
    }


    /**
     * Add parent to list
     * and check right subtree
     * if it exist
     */
    public void traverseParent(BSTNode node, List<BSTNode> visitedNodes) {
        BSTNode parent = node.Parent;
        boolean isExistParent = parent != null;
        if (isExistParent) {
            boolean fromLeft = ascendedFromLeft(node, parent);
            if (fromLeft) {
                visitedNodes.add(parent);
            }

            boolean fromRight = !fromLeft;

            if (fromRight || !isExistRightChild(parent)) {
                traverseParent(parent, visitedNodes);
            } else {
                inOrder(parent.RightChild, visitedNodes);
            }
        }
    }

    /**
     * Check right child is exist
     */
    public boolean isExistRightChild(BSTNode node) {
        return node.RightChild != null;
    }

    /**
     * Determine is ascended from the left child
     */
    public boolean ascendedFromLeft(BSTNode child, BSTNode parent) {
        return child.NodeKey < parent.NodeKey;
    }


    /**
     * Depth-first search - DFS by node in Pre Order by root
     *
     * @return
     */
    public ArrayList<BSTNode> DeepAllNodesPreOrder(BSTNode<T> node, ArrayList<BSTNode> visitedNodes) {
        if (node != null) {
            visitedNodes.add(node);
            DeepAllNodesPreOrder(node.LeftChild, visitedNodes);
            DeepAllNodesPreOrder(node.RightChild, visitedNodes);
        }

        return visitedNodes;
    }
}