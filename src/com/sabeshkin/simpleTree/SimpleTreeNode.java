package com.sabeshkin.simpleTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class SimpleTreeNode<T> {
    public T NodeValue; // значение в узле
    public SimpleTreeNode<T> Parent; // родитель или null для корня
    public List<SimpleTreeNode<T>> Children; // список дочерних узлов или null

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
    public SimpleTreeNode<T> Root; // корень, может быть null

    public SimpleTree(SimpleTreeNode<T> root) {
        Root = root;
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
     * @param val
     * @return
     */
    public List<SimpleTreeNode<T>> FindNodesByValue(T val) {
        Predicate<SimpleTreeNode<T>> checkEqualValue = (node) -> node.NodeValue.equals(val);
        BiConsumer<List<SimpleTreeNode<T>>, SimpleTreeNode<T>> addEqualValueNode = (accumulator, node) -> {
            boolean isEqualValue = checkEqualValue.test(node);
            if(isEqualValue){
                accumulator.add(node);
            }
        };

        List<SimpleTreeNode<T>> equalValueNodes = new LinkedList<>();
        makeOnEachChildren(Root, equalValueNodes, addEqualValueNode);
        return equalValueNodes;
    }

    public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent) {
        // ваш код перемещения узла вместе с его поддеревом --
        // в качестве дочернего для узла NewParent
    }

    /**
     * Count nodes in tree
     * @return
     */
    public int Count() {
        return GetAllNodes().size();
    }

    public int LeafCount() {
        // количество листьев в дереве
        return 0;
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
}
