package com.sabeshkin.simpleTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DeleteNodeTest {

    /**
     * Create SimpleTree with 2 nodes with passed values: root and one child in this.
     * @return
     */
    public <T, M> SimpleTree createTreeWithRootAndChild(T rootValue, M childValue) {
        SimpleTreeNode<Integer> root = new SimpleTreeNode(rootValue, null); // create root
        SimpleTreeNode leaf = new SimpleTreeNode(childValue, null); // create leaf
        SimpleTree tree = new SimpleTree(root);
        tree.AddChild(root, leaf);
        return  tree;
    }


    /**
     * Create SimpleTree with 2 nodes with default values: root and one child in this.
     * @return
     */
    public  SimpleTree createTreeWithRootAndChild() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode(12, null); // create root
        SimpleTreeNode leaf = new SimpleTreeNode(0, null); // create leaf
        SimpleTree tree = new SimpleTree(root);
        tree.AddChild(root, leaf);
        return  tree;
    }


    @Test
    public void DeleteNode_Children_Less_Than_Previous() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode(12, null); // create root
        SimpleTreeNode leaf = new SimpleTreeNode(0, null); // create leaf
        SimpleTree tree = new SimpleTree(root);
        tree.AddChild(root, leaf);

        int previousChildrenSize = tree.Root.Children.size();
        tree.DeleteNode(leaf);
        int actualChildrenSize = tree.Root.Children.size();
        boolean isOneDifference = previousChildrenSize-actualChildrenSize == 1;
        assertTrue(isOneDifference);
    }

    @Test
    public void DeleteNode_Not_Delete_Root() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode(12, null); // create root
        SimpleTreeNode leaf = new SimpleTreeNode(0, null); // create leaf
        SimpleTree tree = new SimpleTree(root);
        tree.AddChild(root, leaf);
        tree.DeleteNode(root);
        assertTrue(tree.Root != null);
    }


    @Test
    public void DeleteNode_Without_Side_Effect_For_Parent() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode(12, null); // create root
        SimpleTreeNode leaf = new SimpleTreeNode(0, null); // create leaf
        SimpleTree tree = new SimpleTree(root);
        tree.AddChild(root, leaf);
        tree.DeleteNode(leaf);
        assertTrue(tree.Root != null);
    }
}