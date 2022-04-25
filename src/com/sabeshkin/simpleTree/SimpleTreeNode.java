package com.sabeshkin.simpleTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.*;

public class SimpleTreeNode<T> {
    public T NodeValue;
    public SimpleTreeNode<T> Parent;
    public List<SimpleTreeNode<T>> Children;
    public int level = 0;
    public int descendantAmount;

    public SimpleTreeNode(T val, SimpleTreeNode<T> parent) {
        NodeValue = val;
        Parent = parent;
        Children = null;
    }

    /**
     * Create empty list for children in node
     */
    public void createEmptyChildrenList() {
        Children = new ArrayList<>();
    }

    /**
     * Check have or not node children
     *
     * @return
     */
    public boolean isHaveChildren() {
        return Children != null && Children.size() > 0;
    }
}

class SimpleTree<T> {
    public SimpleTreeNode<T> Root;

    public SimpleTree(SimpleTreeNode<T> root) {
        Root = root;
        size++;
    }

    private int size = 0;



    /**
     * Count and set descendants
     * @return
     */
    public void descendantCount() {

        descendantCountNode(Root);
    }

    public void descendantCountNode(SimpleTreeNode<T> node){
        int amountOfDescendant = 0;
        node.descendantAmount = node.Children.size();
    }
    /**
     * Find and collect pairs for break chain
     * @return
     */
    public ArrayList<T> findEvenPairsForBreakChain() {

        int expectedArr[] = new int[]{};
        ArrayList<T> expected = new ArrayList(Arrays.asList(expectedArr));
        return expected;
    }

    /**
     * create Empty ArrayList
     * @return
     */
    public ArrayList<T> createEmptyArrayList() {
        return new ArrayList<>();
    }

    /**
     * check that object is null
     * @param objectForCheck
     * @return
     */
    public boolean isNull(Object objectForCheck) {
        return  objectForCheck == null;
    }

    /**
     * Check that haven't children
     * @param node
     * @return
     */
    public boolean notHaveChildren(SimpleTreeNode<T> node) {
        return  isNull(node.Children) || node.Children.size() == 0;
    }

    /**
     * Check that we have several nodes in tree
     * @return
     */
    public boolean notIsSeveralNodesInTree() {
        return isNull(Root) || notHaveChildren(Root);
    }

    /**
     * Add child to node
     *
     * @param ParentNode
     * @param NewChild
     */
    public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild) {
        if (ParentNode.Children == null) {
            ParentNode.createEmptyChildrenList();
        }
        assert ParentNode.Children != null : "You must create children list";
        ParentNode.Children.add(NewChild);
        assert ParentNode.Children.contains(NewChild) : "Children was't added";
        NewChild.Parent = ParentNode;
        assert NewChild.Parent.equals(ParentNode) : "Parent was't added";
        size++;
    }


    /**
     * Remove not root node
     *
     * @param NodeToDelete
     */
    public void DeleteNode(SimpleTreeNode<T> NodeToDelete) {
        boolean isChildNode = !NodeToDelete.equals(Root);
        if (isChildNode) {
            assert NodeToDelete.Parent.Children != null : "You must have children list";
            NodeToDelete.Parent.Children.remove(NodeToDelete);
            size--;
        }
    }

    /**
     * Get all nodes from Tree
     *
     * @return all nodes
     */
    public List<SimpleTreeNode<T>> GetAllNodes() {
        BiConsumer<List<SimpleTreeNode<T>>, SimpleTreeNode<T>> addAnyChildren = (accumulator, node) -> accumulator.add(node);
        List<SimpleTreeNode<T>> allNodes = new LinkedList<>();
        makeOnEachChildren(Root, allNodes, addAnyChildren);
        return allNodes;
    }

    /**
     * Find nodes by value
     *
     * @param val
     * @return
     */
    public List<SimpleTreeNode<T>> FindNodesByValue(T val) {
        Predicate<SimpleTreeNode<T>> checkEqualValue = (node) -> node.NodeValue.equals(val);
        BiConsumer<List<SimpleTreeNode<T>>, SimpleTreeNode<T>> addEqualValueNode = (accumulator, node) -> {
            boolean isEqualValue = checkEqualValue.test(node);
            if (isEqualValue) {
                accumulator.add(node);
            }
        };

        List<SimpleTreeNode<T>> equalValueNodes = new LinkedList<>();
        makeOnEachChildren(Root, equalValueNodes, addEqualValueNode);
        return equalValueNodes;
    }

    /**
     * Move node to new parent
     * and remove it from previous parent
     *
     * @param OriginalNode
     * @param NewParent
     */
    public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent) {
        SimpleTreeNode<T> previousParent = OriginalNode.Parent;
        previousParent.Children.remove(OriginalNode);
        AddChild(NewParent, OriginalNode);
    }

    /**
     * Count nodes in tree
     *
     * @return
     */
    public int Count() {
        assert size > -1 : "Can't size less 0(zero)";
        return size;
    }

    /**
     * Count leaf nodes
     *
     * @return
     */
    public int LeafCount() {
        Predicate<SimpleTreeNode<T>> checkLeaf = (node) -> !node.isHaveChildren();
        BiConsumer<List<SimpleTreeNode<T>>, SimpleTreeNode<T>> addLeaf = (accumulator, node) -> {
            boolean isLeaf = checkLeaf.test(node);
            if (isLeaf) {
                assert node.Children == null || node.Children.size() == 0 : "It is't leaf";
                accumulator.add(node);
            }
        };

        List<SimpleTreeNode<T>> leafNodes = new LinkedList<>();
        makeOnEachChildren(Root, leafNodes, addLeaf);
        return leafNodes.size();
    }


    /**
     * Call function on each children
     * and pass general accumulator
     *
     * @param node
     * @param accumulator
     * @param consumer
     */
    public void makeOnEachChildren(SimpleTreeNode<T> node, List<SimpleTreeNode<T>> accumulator, BiConsumer<List<SimpleTreeNode<T>>, SimpleTreeNode<T>> consumer) {
        consumer.accept(accumulator, node);
        boolean isHaveChildren = node.isHaveChildren();
        if (isHaveChildren) {
            enumerationOfChildren(node.Children, accumulator, consumer);
        }
    }


    /**
     * Pass consumer on each children
     * and pass general accumulator
     *
     * @param children
     * @param accumulator
     * @param consumer
     */
    public void enumerationOfChildren(List<SimpleTreeNode<T>> children, List<SimpleTreeNode<T>> accumulator, BiConsumer<List<SimpleTreeNode<T>>, SimpleTreeNode<T>> consumer) {
        children.stream().forEach(node -> makeOnEachChildren(node, accumulator, consumer));
    }

    /**
     * Calculate and set level for all nodes
     */
    public void calculateLevelForNode() {
        Consumer<SimpleTreeNode<T>> setActualLevel = (node) -> {
            if (node.Parent != null) {
                SimpleTreeNode<T> parent = node.Parent;
                int parentLevel = parent.level;
                assert parentLevel >= 0 : "Parent have't level";
                int level = parentLevel + 1;
                node.level = level;
            } else {
                node.level = 0;
            }
        };
        makeOnEach(Root, setActualLevel);
    }

    /**
     * Call function from consumer on each node
     *
     * @param node
     * @param consumer
     */
    public void makeOnEach(SimpleTreeNode<T> node, Consumer<SimpleTreeNode<T>> consumer) {
        consumer.accept(node);
        boolean isHaveChildren = node.isHaveChildren();
        if (isHaveChildren) {
            enumerationOfEach(node.Children, consumer);
        }
    }

    /**
     * Call makeOnEach(...) on each node child
     *
     * @param children
     * @param consumer
     */
    public void enumerationOfEach(List<SimpleTreeNode<T>> children, Consumer<SimpleTreeNode<T>> consumer) {
        children.stream().forEach(node -> makeOnEach(node, consumer));
    }

    /**
     * Count children of node
     * @param root
     * @return
     */
    private int countChildrenOfNode(SimpleTreeNode<T> root) {
        int nodes = 1;
        if (isNull(root.Children)) {
            return nodes;
        }
        for (SimpleTreeNode<T> child : root.Children) {
            nodes += countChildrenOfNode(child);
        }
        return nodes;
    }
    /**
     *
     * @return pairs of parent and child between should remove of edge
     */
    public ArrayList<T> EvenTrees() {
        ArrayList<T> nodePairs = new ArrayList<>();
        if (Root != null && Count() % 2 == 0) {
            findEdgesToRemove(Root, nodePairs);
        }
        return nodePairs;
    }

    /**
     * find edge for remove for make forest
     * @param root
     * @param nodePairs
     */
    private void findEdgesToRemove(SimpleTreeNode<T> root, List<T> nodePairs) {
        if (isNull(root.Children)) {
            return;
        }
        for (SimpleTreeNode<T> child : root.Children) {
            addEdgeForRemove(child, nodePairs);
            findEdgesToRemove(child, nodePairs);
        }
    }

    /**
     * Check and if true, add edge for remove
     * @param child
     * @param nodePairs
     */
    private void addEdgeForRemove(SimpleTreeNode<T> child, List<T> nodePairs){
        boolean isEvenAmountOfChildren = countChildrenOfNode(child) % 2 == 0;
        if (isEvenAmountOfChildren) {
            nodePairs.add(child.Parent.NodeValue);
            nodePairs.add(child.NodeValue);
        }
    }
}
