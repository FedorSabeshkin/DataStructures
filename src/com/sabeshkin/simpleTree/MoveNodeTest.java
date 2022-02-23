package com.sabeshkin.simpleTree;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class MoveNodeTest {

    @Test
    public void MoveNode_leaf_9() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode(0, null);
        SimpleTree tree = new SimpleTree(root);
        SimpleTreeNode leaf_1 = new SimpleTreeNode(1, root);
        tree.AddChild(root, leaf_1);
        SimpleTreeNode leaf_6 = new SimpleTreeNode(6, leaf_1);
        tree.AddChild(leaf_1, leaf_6);
        SimpleTreeNode leaf_3 = new SimpleTreeNode(3, leaf_1);
        tree.AddChild(leaf_1, leaf_3);
        SimpleTreeNode leaf_8_1 = new SimpleTreeNode(8, leaf_3);
        tree.AddChild(leaf_3, leaf_8_1);
        SimpleTreeNode leaf_8_2 = new SimpleTreeNode(8, leaf_3);
        tree.AddChild(leaf_3, leaf_8_2);

        SimpleTreeNode leaf_9 = new SimpleTreeNode(9, leaf_3);
        tree.AddChild(leaf_3, leaf_9);

        SimpleTreeNode leaf_2 = new SimpleTreeNode(2, leaf_9);
        tree.AddChild(leaf_9, leaf_2);

        tree.MoveNode(leaf_9, leaf_6);
        assertTrue(leaf_6.Children.contains(leaf_9));
    }

    @Test
    public void MoveNode_Leaf_9_Changed_Parent_To_Leaf_6() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode(0, null);
        SimpleTree tree = new SimpleTree(root);
        SimpleTreeNode leaf_1 = new SimpleTreeNode(1, root);
        tree.AddChild(root, leaf_1);
        SimpleTreeNode leaf_6 = new SimpleTreeNode(6, leaf_1);
        tree.AddChild(leaf_1, leaf_6);
        SimpleTreeNode leaf_3 = new SimpleTreeNode(3, leaf_1);
        tree.AddChild(leaf_1, leaf_3);
        SimpleTreeNode leaf_8_1 = new SimpleTreeNode(8, leaf_3);
        tree.AddChild(leaf_3, leaf_8_1);
        SimpleTreeNode leaf_8_2 = new SimpleTreeNode(8, leaf_3);
        tree.AddChild(leaf_3, leaf_8_2);

        SimpleTreeNode leaf_9 = new SimpleTreeNode(9, leaf_3);
        tree.AddChild(leaf_3, leaf_9);

        SimpleTreeNode leaf_2 = new SimpleTreeNode(2, leaf_9);
        tree.AddChild(leaf_9, leaf_2);

        tree.MoveNode(leaf_9, leaf_6);
        assertTrue(leaf_9.Parent.equals(leaf_6));
    }

    @Test
    public void MoveNode_leaf_9_With_Children() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode(0, null);
        SimpleTree tree = new SimpleTree(root);
        SimpleTreeNode leaf_1 = new SimpleTreeNode(1, root);
        tree.AddChild(root, leaf_1);
        SimpleTreeNode leaf_6 = new SimpleTreeNode(6, leaf_1);
        tree.AddChild(leaf_1, leaf_6);
        SimpleTreeNode leaf_3 = new SimpleTreeNode(3, leaf_1);
        tree.AddChild(leaf_1, leaf_3);
        SimpleTreeNode leaf_8_1 = new SimpleTreeNode(8, leaf_3);
        tree.AddChild(leaf_3, leaf_8_1);
        SimpleTreeNode leaf_8_2 = new SimpleTreeNode(8, leaf_3);
        tree.AddChild(leaf_3, leaf_8_2);

        SimpleTreeNode leaf_9 = new SimpleTreeNode(9, leaf_3);
        tree.AddChild(leaf_3, leaf_9);

        SimpleTreeNode leaf_2 = new SimpleTreeNode(2, leaf_9);
        tree.AddChild(leaf_9, leaf_2);

        tree.MoveNode(leaf_9, leaf_6);
        assertTrue(leaf_9.Children.contains(leaf_2));
    }

    @Test
    public void MoveNode_Leaf_3_Not_Contains_Leaf_9() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode(0, null);
        SimpleTree tree = new SimpleTree(root);
        SimpleTreeNode leaf_1 = new SimpleTreeNode(1, root);
        tree.AddChild(root, leaf_1);
        SimpleTreeNode leaf_6 = new SimpleTreeNode(6, leaf_1);
        tree.AddChild(leaf_1, leaf_6);
        SimpleTreeNode leaf_3 = new SimpleTreeNode(3, leaf_1);
        tree.AddChild(leaf_1, leaf_3);
        SimpleTreeNode leaf_8_1 = new SimpleTreeNode(8, leaf_3);
        tree.AddChild(leaf_3, leaf_8_1);
        SimpleTreeNode leaf_8_2 = new SimpleTreeNode(8, leaf_3);
        tree.AddChild(leaf_3, leaf_8_2);

        SimpleTreeNode leaf_9 = new SimpleTreeNode(9, leaf_3);
        tree.AddChild(leaf_3, leaf_9);

        SimpleTreeNode leaf_2 = new SimpleTreeNode(2, leaf_9);
        tree.AddChild(leaf_9, leaf_2);

        tree.MoveNode(leaf_9, leaf_6);
        assertFalse(leaf_3.Children.contains(leaf_9));
    }

}