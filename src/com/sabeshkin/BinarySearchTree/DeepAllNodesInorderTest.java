package com.sabeshkin.BinarySearchTree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeepAllNodesInorderTest {

    /* 1. Мне нужно дерево в котором есть один узел
    Поиск этого узла возвращает успех и ссылку на найденный узел
    */
    @Test
    public void WideAllNodes() {


        BSTNode<Integer> root = new BSTNode(8, 8, null);
        BST tree = new BST(root);
        assertEquals(1, tree.DeepAllNodes(BST.IN_ORDER).size());
    }

    @Test
    public void WideAllNodes_Root_Null() {


        BST tree = new BST(null);
        assertEquals(0, tree.DeepAllNodes(BST.IN_ORDER).size());
    }


    // 4. в Дереве из 5-ти элементов, находит нужный узел как в середине
    @Test
    public void WideAllNodes_Found_In_Middle() {
        // 5 узлов

        BSTNode<Integer> root = new BSTNode(8, 8, null);
        BST tree = new BST(root);
        tree.AddKeyValue(4, 4);
        tree.AddKeyValue(12, 12);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(6, 6);

        assertEquals(5, tree.DeepAllNodes(BST.IN_ORDER).size());

    }

    @Test
    public void WideAllNodes_Count_Add_Child_By_Method() {
        BSTNode<Integer> root = new BSTNode(8, 8, null);
        BST tree = new BST(root);
        tree.AddKeyValue(4, 4);
        tree.AddKeyValue(12, 12);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(6, 6);
        tree.AddKeyValue(5, 5);
        tree.AddKeyValue(7, 7);

        assertEquals(7, tree.DeepAllNodes(BST.IN_ORDER).size());
    }


    @Test
    public void WideAllNodes_Classical_Way_To_Add_Child() {
        // 5 узлов
        BSTNode<Integer> root = new BSTNode(8, 8, null);
        BST tree = new BST(root);

        //first
        BSTNode leaf_4 = new BSTNode(4, 4, root);
        root.LeftChild = leaf_4;
        BSTNode leaf_12 = new BSTNode(12, 12, root);
        root.RightChild = leaf_12;

        //second left
        BSTNode leaf_2 = new BSTNode(2, 2, leaf_4);
        leaf_4.LeftChild = leaf_2;
        BSTNode leaf_6 = new BSTNode(6, 6, leaf_4);
        leaf_4.RightChild = leaf_6;

        assertEquals(5, tree.DeepAllNodes(BST.IN_ORDER).size());
    }

    @Test
    public void WideAllNodes_Count_Add_Child_By_Method_First_Is_2() {
        BSTNode<Integer> root = new BSTNode(8, 8, null);
        BST tree = new BST(root);
        tree.AddKeyValue(4, 4);
        tree.AddKeyValue(12, 12);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(6, 6);
        tree.AddKeyValue(5, 5);
        tree.AddKeyValue(7, 7);
        assertEquals(2, ((BSTNode) tree.DeepAllNodes(BST.IN_ORDER).get(0)).NodeKey);
    }

    @Test
    public void WideAllNodes_Count_Add_Child_By_Method_Last_Is_14() {
        BSTNode<Integer> root = new BSTNode(8, 8, null);
        BST tree = new BST(root);
        tree.AddKeyValue(4, 4);
        tree.AddKeyValue(12, 12);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(6, 6);
        tree.AddKeyValue(10, 10);
        tree.AddKeyValue(14, 14);
        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(9, 9);
        tree.AddKeyValue(11, 11);
        int lastIndex = tree.DeepAllNodes(BST.IN_ORDER).size() - 1;
        assertEquals(14, ((BSTNode) tree.DeepAllNodes(BST.IN_ORDER).get(lastIndex)).NodeKey);
    }

    @Test
    public void WideAllNodes_Inorder_Count_Add_Child_By_Method_Last_Is_12() {
        BSTNode<Integer> root = new BSTNode(8, 8, null);
        BST tree = new BST(root);
        tree.AddKeyValue(4, 4);
        tree.AddKeyValue(12, 12);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(6, 6);
        tree.AddKeyValue(10, 10);
        tree.AddKeyValue(14, 14);
        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(9, 9);
        tree.AddKeyValue(11, 11);

        BSTNode leaf_1 = new BSTNode(1);
        BSTNode leaf_2 = new BSTNode(2);
        BSTNode leaf_4 = new BSTNode(4);
        BSTNode leaf_6 = new BSTNode(6);
        BSTNode leaf_8 = new BSTNode(8);
        BSTNode leaf_9 = new BSTNode(9);
        BSTNode leaf_11 = new BSTNode(11);
        BSTNode leaf_10 = new BSTNode(10);
        BSTNode leaf_12 = new BSTNode(12);
        BSTNode leaf_14 = new BSTNode(14);


        BSTNode[] array = {leaf_1, leaf_2, leaf_4, leaf_6, leaf_8, leaf_9, leaf_10, leaf_11, leaf_12, leaf_14};
        List<BSTNode> expectedList = Arrays.asList(array);

        List<BSTNode> result = tree.DeepAllNodes(BST.IN_ORDER);
        System.out.println(result);
        assertEquals(expectedList, result);
    }

    @Test
    public void WideAllNodes_Inorder_Count_Add_Child_By_Method_Last_Is_Not() {
        BSTNode<Integer> root = new BSTNode(8, 8, null);
        BST tree = new BST(root);
        tree.AddKeyValue(4, 4);
        tree.AddKeyValue(12, 12);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(6, 6);
        tree.AddKeyValue(10, 10);
        tree.AddKeyValue(14, 14);
        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(9, 9);
        tree.AddKeyValue(11, 11);

        // mock nodes
        BSTNode leaf_1 = new BSTNode(1);
        BSTNode leaf_2 = new BSTNode(2);
        BSTNode leaf_4 = new BSTNode(4);
        BSTNode leaf_6 = new BSTNode(6);
        BSTNode leaf_8 = new BSTNode(8);
        BSTNode leaf_9 = new BSTNode(9);
        BSTNode leaf_11 = new BSTNode(11);
        BSTNode leaf_10 = new BSTNode(10);
        BSTNode leaf_12 = new BSTNode(12);
        BSTNode leaf_14 = new BSTNode(14);


        BSTNode[] array = {leaf_2, leaf_1, leaf_4, leaf_6, leaf_8, leaf_9, leaf_10, leaf_11, leaf_12, leaf_14};
        List<BSTNode> expectedList = Arrays.asList(array);
        assertNotEquals(expectedList, tree.DeepAllNodes(BST.IN_ORDER));
    }

    @Test
    public void WideAllNodes_Inorder() {
        BSTNode<Integer> root = new BSTNode(8, 8, null);
        BST tree = new BST(root);
        tree.AddKeyValue(4, 4);
        tree.AddKeyValue(13, 13);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(6, 6);
        tree.AddKeyValue(11, 11);
        tree.AddKeyValue(14, 14);
        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(5, 5);
        tree.AddKeyValue(7, 7);
        tree.AddKeyValue(9, 9);
        tree.AddKeyValue(10, 10);
        tree.AddKeyValue(12, 12);
        tree.printWrapper("", tree.Root, false);
        BSTNode leaf_1 = new BSTNode(1);
        BSTNode leaf_2 = new BSTNode(2);
        BSTNode leaf_4 = new BSTNode(4);
        BSTNode leaf_5 = new BSTNode(5);
        BSTNode leaf_6 = new BSTNode(6);
        BSTNode leaf_7 = new BSTNode(7);
        BSTNode leaf_8 = new BSTNode(8);
        BSTNode leaf_9 = new BSTNode(9);
        BSTNode leaf_11 = new BSTNode(11);
        BSTNode leaf_10 = new BSTNode(10);
        BSTNode leaf_12 = new BSTNode(12);
        BSTNode leaf_13 = new BSTNode(13);
        BSTNode leaf_14 = new BSTNode(14);

        BSTNode[] array = {leaf_1, leaf_2, leaf_4, leaf_5, leaf_6,
                leaf_7, leaf_8, leaf_9, leaf_10, leaf_11,
                leaf_12, leaf_13, leaf_14};
        List<BSTNode> expectedList = Arrays.asList(array);
        List<BSTNode> result = tree.DeepAllNodes(BST.IN_ORDER);
        System.out.println(result);
        assertIterableEquals(expectedList, result);
    }

    @Test
    public void WideAllNodes_Inorder_Right_Branch() {
        BSTNode<Integer> root = new BSTNode(8, 8, null);
        BST tree = new BST(root);
        tree.AddKeyValue(13, 13);
        tree.AddKeyValue(11, 11);
        tree.AddKeyValue(14, 14);
        tree.AddKeyValue(9, 9);
        tree.AddKeyValue(10, 10);
        tree.AddKeyValue(12, 12);
        tree.printWrapper("", tree.Root, false);
        BSTNode leaf_8 = new BSTNode(8);
        BSTNode leaf_9 = new BSTNode(9);
        BSTNode leaf_11 = new BSTNode(11);
        BSTNode leaf_10 = new BSTNode(10);
        BSTNode leaf_12 = new BSTNode(12);
        BSTNode leaf_13 = new BSTNode(13);
        BSTNode leaf_14 = new BSTNode(14);

        BSTNode[] array = {leaf_8, leaf_9, leaf_10, leaf_11,
                leaf_12, leaf_13, leaf_14};
        List<BSTNode> expectedList = Arrays.asList(array);
        List<BSTNode> result = tree.DeepAllNodes(BST.IN_ORDER);
        System.out.println(result);
        assertIterableEquals(expectedList, result);
    }

    @Test
    public void WideAllNodes_Inorder_Right_Branch_Only_Doubled_Items() {
        BSTNode<Integer> root = new BSTNode(8, 8, null);
        BST tree = new BST(root);
        tree.AddKeyValue(13, 13);
        tree.AddKeyValue(11, 11);
        tree.AddKeyValue(14, 14);
        tree.AddKeyValue(12, 12);
        tree.printWrapper("", tree.Root, false);
        BSTNode leaf_8 = new BSTNode(8);
        BSTNode leaf_11 = new BSTNode(11);
        BSTNode leaf_12 = new BSTNode(12);
        BSTNode leaf_13 = new BSTNode(13);
        BSTNode leaf_14 = new BSTNode(14);

        BSTNode[] array = {leaf_8,  leaf_11,
                leaf_12, leaf_13, leaf_14};
        List<BSTNode> expectedList = Arrays.asList(array);
        List<BSTNode> result = tree.DeepAllNodes(BST.IN_ORDER);
        System.out.println(result);
        assertIterableEquals(expectedList, result);
    }

    @Test
    public void WideAllNodes_Inorder_Left_Branch_With_Child_For_Minimal_Node() {
        BSTNode<Integer> root = new BSTNode(8, 8, null);
        BST tree = new BST(root);

        tree.AddKeyValue(5, 5);
        tree.AddKeyValue(6, 6);
        tree.AddKeyValue(3, 3);
        tree.AddKeyValue(4, 4);
        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(7, 7);
        tree.printWrapper("", tree.Root, false);
        BSTNode leaf_1 = new BSTNode(1);
        BSTNode leaf_2 = new BSTNode(2);
        BSTNode leaf_3 = new BSTNode(3);
        BSTNode leaf_4 = new BSTNode(4);
        BSTNode leaf_5 = new BSTNode(5);
        BSTNode leaf_6 = new BSTNode(6);
        BSTNode leaf_7 = new BSTNode(7);
        BSTNode leaf_8 = new BSTNode(8);

        BSTNode[] array = {leaf_1, leaf_2, leaf_3, leaf_4, leaf_5, leaf_6,
                leaf_7, leaf_8};
        List<BSTNode> expectedList = Arrays.asList(array);
        List<BSTNode> result = tree.DeepAllNodes(BST.IN_ORDER);
        System.out.println(result);
        assertIterableEquals(expectedList, result);
    }

}