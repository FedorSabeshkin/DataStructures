package com.sabeshkin.BinarySearchTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    /* 1. Мне нужно дерево в котором есть один узел
    Поиск этого узла возвращает успех и ссылку на найденный узел
    */
    @Test
    public void findNodeByKey() {


        BSTNode<Integer> root = new BSTNode(8, 8, null);
        BST tree = new BST(root);

        BSTFind<Integer> findInfo = tree.FindNodeByKey(8);
        BSTFind<Integer> expectedFindInfo = new BSTFind(root, true, false);
        assertEquals(expectedFindInfo, findInfo);

    }

    /*
    2. Повторный поиск узла в этом дереве снова возвращает успех
    */
    @Test
    public void findNodeByKey_Rerun_Without_Side_Effects() {

        BSTNode<Integer> root = new BSTNode(8, 8, null);
        BST tree = new BST(root);

        BSTFind<Integer> findInfo = tree.FindNodeByKey(8);
        BSTFind<Integer> nextFindInfo = tree.FindNodeByKey(8);
        BSTFind<Integer> expectedFindInfo = new BSTFind(root, true, false);
        assertEquals(expectedFindInfo, nextFindInfo);

    }
    /*

    3. В  дереве с одним элементов возвращается объект с информацией о том, что узел не найден
    когда ищу узел, с ключом 4
    */
    @Test
    public void findNodeByKey_Didnt_Found_Node() {


        BSTNode<Integer> root = new BSTNode(8, 8, null);
        BST tree = new BST(root);

        BSTFind<Integer> findInfo = tree.FindNodeByKey(4);
        BSTFind<Integer> expectedFindInfo = new BSTFind(root, false, true);
        assertNotEquals(expectedFindInfo, findInfo);

    }

    // 4. в Дереве из 5-ти элементов, находит нужный узел как в середине
    @Test
    public void findNodeByKey_Found_In_Middle() {
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

        BSTFind<Integer> findInfo = tree.FindNodeByKey(4);
        BSTFind<Integer> expectedFindInfo = new BSTFind(leaf_4, true, false);
        assertEquals(expectedFindInfo, findInfo);

    }

    /*	5.  В дереве из 5-ти элементов, находит нужный узел в листе
     */
    @Test
    public void findNodeByKey_Found_In_Leaf() {

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
        
        BSTFind<Integer> findInfo = tree.FindNodeByKey(2);
        BSTFind<Integer> expectedFindInfo = new BSTFind(leaf_2, true, false);
        assertEquals(expectedFindInfo, findInfo);
    }
}