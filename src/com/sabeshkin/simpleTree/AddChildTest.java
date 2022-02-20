package com.sabeshkin.simpleTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddChildTest {

    @Test
    public void createEmptyChildrenList_Children_Exist() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode(1, null);
        SimpleTree tree = new SimpleTree(root);
        root.createEmptyChildrenList();
        assertEquals(0, root.Children.size());
    }

    @Test
    public void addChild_Parent_Exist() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode(1, null); // create root
        SimpleTreeNode leaf = new SimpleTreeNode(12, null); // create leaf
        SimpleTree tree = new SimpleTree(root);
        tree.AddChild(root, leaf);
        assertTrue(leaf.Parent.equals(root));
    }

    @Test
    public void addChild_Children_Exist() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode(1, null); // create root
        SimpleTreeNode leaf = new SimpleTreeNode(12, null); // create leaf
        SimpleTree tree = new SimpleTree(root);
        tree.AddChild(root, leaf);
        assertTrue(root.Children.contains(leaf));
    }
}