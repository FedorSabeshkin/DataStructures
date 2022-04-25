package com.sabeshkin.simpleTree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EvenTreesTest {


    @Test
    public void EvenTrees_Test() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode(1, null);
        SimpleTree tree = new SimpleTree(root);
        // first level
        SimpleTreeNode leaf_2 = new SimpleTreeNode(2, root);
        tree.AddChild(root, leaf_2);
        SimpleTreeNode leaf_3 = new SimpleTreeNode(3, root);
        tree.AddChild(root, leaf_3);
        SimpleTreeNode leaf_6 = new SimpleTreeNode(6, root);
        tree.AddChild(root, leaf_6);
        // second
        SimpleTreeNode leaf_5 = new SimpleTreeNode(5, leaf_2);
        tree.AddChild(leaf_2, leaf_5);
        SimpleTreeNode leaf_7 = new SimpleTreeNode(8, leaf_2);
        tree.AddChild(leaf_2, leaf_7);

        SimpleTreeNode leaf_4 = new SimpleTreeNode(4, leaf_3);
        tree.AddChild(leaf_3, leaf_4);

        SimpleTreeNode leaf_8 = new SimpleTreeNode(8, leaf_6);
        tree.AddChild(leaf_6, leaf_8);
        // third
        SimpleTreeNode leaf_9 = new SimpleTreeNode(9, leaf_8);
        tree.AddChild(leaf_8, leaf_9);
        SimpleTreeNode leaf_10 = new SimpleTreeNode(8, leaf_8);
        tree.AddChild(leaf_8, leaf_10);
        Integer expectedArr[] = new Integer[]{1, 3, 1, 6};
        ArrayList<Integer> expected = new ArrayList(Arrays.asList(expectedArr));
        ArrayList<Integer> fact = tree.EvenTrees();
        printArray(fact.toArray());
        assertArrayEquals(expected.toArray(), fact.toArray());
    }
    public void printArray(Object[] array){

        System.out.println(Arrays.toString(array));
    }
    @Test
    public void EvenTrees_Only_Root_Element() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode(1, null);
        SimpleTree tree = new SimpleTree(root);
        Integer expectedArr[] = new Integer[]{};
        ArrayList<Integer> expected = new ArrayList(Arrays.asList(expectedArr));
        ArrayList<Integer> fact = tree.EvenTrees();
        assertArrayEquals(expected.toArray(), fact.toArray());
    }

    @Test
    public void EvenTrees_Root_Is_Null_Size_Is_Zero() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode(null, null);
        SimpleTree tree = new SimpleTree(root);
        ArrayList<Integer> fact = tree.EvenTrees();
        assertEquals(0, fact.size());
    }

    @Test
    public void notIsSeveralNodesInTree_Empty_Test() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode(null, null);
        SimpleTree tree = new SimpleTree(root);
        assertTrue(tree.notIsSeveralNodesInTree());
    }

    @Test
    public void notIsSeveralNodesInTree_Only_Root_Test() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode(1, null);
        SimpleTree tree = new SimpleTree(root);
        assertTrue(tree.notIsSeveralNodesInTree());
    }

    @Test
    public void notIsSeveralNodesInTree_Several_Children() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode(1, null);
        SimpleTree tree = new SimpleTree(root);
        // first level
        SimpleTreeNode leaf_2 = new SimpleTreeNode(2, root);
        tree.AddChild(root, leaf_2);
        SimpleTreeNode leaf_3 = new SimpleTreeNode(3, root);
        tree.AddChild(root, leaf_3);
        SimpleTreeNode leaf_6 = new SimpleTreeNode(6, root);
        tree.AddChild(root, leaf_6);
        // second
        SimpleTreeNode leaf_5 = new SimpleTreeNode(5, leaf_2);
        tree.AddChild(leaf_2, leaf_5);
        SimpleTreeNode leaf_7 = new SimpleTreeNode(8, leaf_2);
        tree.AddChild(leaf_2, leaf_7);

        SimpleTreeNode leaf_4 = new SimpleTreeNode(4, leaf_3);
        tree.AddChild(leaf_3, leaf_4);

        SimpleTreeNode leaf_8 = new SimpleTreeNode(8, leaf_6);
        tree.AddChild(leaf_6, leaf_8);
        // third
        SimpleTreeNode leaf_9 = new SimpleTreeNode(9, leaf_8);
        tree.AddChild(leaf_8, leaf_9);
        SimpleTreeNode leaf_10 = new SimpleTreeNode(8, leaf_8);
        tree.AddChild(leaf_8, leaf_10);
        assertFalse(tree.notIsSeveralNodesInTree());
    }

}