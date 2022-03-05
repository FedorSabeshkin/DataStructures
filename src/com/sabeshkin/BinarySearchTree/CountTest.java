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
        tree.AddKeyValue(4,4);
        tree.AddKeyValue(12,12);
        tree.AddKeyValue(2,2);
        tree.AddKeyValue(6,6);

        assertEquals(5, tree.Count());

    }

    /*	5.  В дереве из 5-ти элементов, находит нужный узел в листе
     */
    @Test
    public void findNodeByKey_Found_In_Leaf() {

        // 5 узлов
        BSTNode<Integer> root = new BSTNode(8, 8, null);
        BST tree = new BST(root);

        tree.AddKeyValue(4,4);
        tree.AddKeyValue(12,12);
        tree.AddKeyValue(2,2);
        tree.AddKeyValue(6,6);

        tree.DeleteNodeByKey(4);
        tree.DeleteNodeByKey(12);
        assertEquals(3, tree.Count());
    }
}