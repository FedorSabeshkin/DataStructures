package com.sabeshkin.simpleTree;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeafCountTest {


    @Test
    public void LeafCount_3() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode(0, null);
        SimpleTree tree = new SimpleTree(root);
        SimpleTreeNode leaf_1 = new SimpleTreeNode(1, root);
        tree.AddChild(root, leaf_1);
        SimpleTreeNode leaf_2 = new SimpleTreeNode(6, leaf_1);
        tree.AddChild(leaf_1, leaf_2);
        SimpleTreeNode leaf_3 = new SimpleTreeNode(3, leaf_1);
        tree.AddChild(leaf_1, leaf_3);
        SimpleTreeNode leaf_4 = new SimpleTreeNode(8, leaf_3);
        tree.AddChild(leaf_3, leaf_4);
        SimpleTreeNode leaf_5 = new SimpleTreeNode(8, leaf_3);
        tree.AddChild(leaf_3, leaf_5);


        assertEquals(3, tree.LeafCount());
    }

    @Test
    public void LeafCount_2() {
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

        assertEquals(2, tree.LeafCount());
    }

    @Test
    public void LeafCount_1() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode(0, null);
        SimpleTree tree = new SimpleTree(root);

        SimpleTreeNode leaf_1 = new SimpleTreeNode(1, root);
        tree.AddChild(root, leaf_1);

        SimpleTreeNode leaf_2 = new SimpleTreeNode(6, leaf_1);
        tree.AddChild(leaf_1, leaf_2);


        assertEquals(1, tree.LeafCount());
    }

    @Test
    public void LeafCount_Only_Root_1() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode(0, null);
        SimpleTree tree = new SimpleTree(root);


        assertEquals(1, tree.LeafCount());
    }

}