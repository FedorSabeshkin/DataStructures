package com.sabeshkin.BinarySearchTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountTest {

    /* 1. Мне нужно дерево в котором есть один узел
    Поиск этого узла возвращает успех и ссылку на найденный узел
    */
    @Test
    public void findNodeByKey() {


        BSTNode<Integer> root = new BSTNode(8, 8, null);
        BST tree = new BST(root);
        assertEquals(1, tree.Count());
    }

    @Test
    public void findNodeByKey_Root_Null() {


        BST tree = new BST(null);
        assertEquals(0, tree.Count());
    }


    // 4. в Дереве из 5-ти элементов, находит нужный узел как в середине
    @Test
    public void findNodeByKey_Found_In_Middle() {
        // 5 узлов

        BSTNode<Integer> root = new BSTNode(8, 8, null);
        BST tree = new BST(root);
        tree.AddKeyValue(4, 4);
        tree.AddKeyValue(12, 12);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(6, 6);

        assertEquals(5, tree.Count());

    }

    @Test
    public void DeleteNodeByKey_Count_Add_Child_By_Method() {
        // 5 узлов
        BSTNode<Integer> root = new BSTNode(8, 8, null);
        BST tree = new BST(root);
        tree.AddKeyValue(4, 4);
        tree.AddKeyValue(12, 12);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(6, 6);
        tree.AddKeyValue(5, 5);
        tree.AddKeyValue(7, 7);

        assertEquals(7, tree.Count());
    }


    @Test
    public void Count_Classical_Way_To_Add_Child() {
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

        assertEquals(5, tree.Count());
    }


}