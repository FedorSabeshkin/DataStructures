package com.sabeshkin.simpleTree;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GetAllNodesTest {


    @Test
    public void GetAllNodes_Is_Equal_Content() {
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

        List<SimpleTreeNode<Integer>> expectedList = new LinkedList();
        expectedList.add(root);
        expectedList.add(leaf_1);
        expectedList.add(leaf_2);
        expectedList.add(leaf_3);
        expectedList.add(leaf_4);
        expectedList.add(leaf_5);


        List<SimpleTreeNode<Integer>> allNodes = tree.GetAllNodes();
        assertEquals(expectedList, allNodes);
    }

    @Test
    public void GetAllNodes_Resul_List_Size_Is_5() {
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

        List<SimpleTreeNode<Integer>> expectedList = new LinkedList();
        expectedList.add(root);
        expectedList.add(leaf_1);
        expectedList.add(leaf_2);
        expectedList.add(leaf_3);
        expectedList.add(leaf_5);


        List<SimpleTreeNode<Integer>> allNodes = tree.GetAllNodes();
        assertEquals(expectedList, allNodes);
    }

}