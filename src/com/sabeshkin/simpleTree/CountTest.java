package com.sabeshkin.simpleTree;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountTest {


    @Test
    public void Count_Is_5() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode(0, null);
        SimpleTree tree = new SimpleTree(root);
        SimpleTreeNode leaf_1 = new SimpleTreeNode(1, root);
        tree.AddChild(root, leaf_1);
        SimpleTreeNode leaf_2 = new SimpleTreeNode(6, leaf_1);
        tree.AddChild(leaf_1, leaf_2);
        SimpleTreeNode leaf_3 = new SimpleTreeNode(3, leaf_1);
        tree.AddChild(leaf_1, leaf_3);
        SimpleTreeNode leaf_5 = new SimpleTreeNode(8, leaf_3);
        tree.AddChild(leaf_3, leaf_5);
        assertEquals(5, tree.Count());
    }

    @Test
    public void Count_Is_6() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode("Hello", null);
        SimpleTree tree = new SimpleTree(root);
        SimpleTreeNode leaf_1 = new SimpleTreeNode("World", root);
        tree.AddChild(root, leaf_1);
        SimpleTreeNode leaf_2 = new SimpleTreeNode("My", leaf_1);
        tree.AddChild(leaf_1, leaf_2);
        SimpleTreeNode leaf_3 = new SimpleTreeNode("Name", leaf_1);
        tree.AddChild(leaf_1, leaf_3);
        SimpleTreeNode leaf_4 = new SimpleTreeNode("Is", leaf_3);
        tree.AddChild(leaf_3, leaf_4);
        SimpleTreeNode leaf_5 = new SimpleTreeNode("Tree!", leaf_3);
        tree.AddChild(leaf_3, leaf_5);
        assertEquals(6, tree.Count());
    }

    @Test
    public void Count_Only_Root_Is_1() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode("Hello", null);
        SimpleTree tree = new SimpleTree(root);
        assertEquals(1, tree.Count());
    }


}