package com.sabeshkin.simpleTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateLevelForNodeTest {

    @Test
    public void CalculateLevelForNode_Leaf_9_Level_Is_3() {
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

        tree.calculateLevelForNode();
        assertEquals(3, leaf_9.level);
    }

    @Test
    public void CalculateLevelForNode_Leaf_2_Level_Is_4() {
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

        tree.calculateLevelForNode();
        assertEquals(4, leaf_2.level);
    }

    @Test
    public void CalculateLevelForNode_Root_Level_Is_0() {
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

        tree.calculateLevelForNode();
        assertEquals(0, root.level);
    }

    @Test
    public void CalculateLevelForNode_Leaf_3_Level_Is_2() {
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

        tree.calculateLevelForNode();
        assertEquals(2, leaf_3.level);
    }

}