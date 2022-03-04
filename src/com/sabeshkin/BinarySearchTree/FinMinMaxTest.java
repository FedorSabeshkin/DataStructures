package com.sabeshkin.BinarySearchTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FinMinMaxTest {


    @Test
    public void FinMinMax_Max_From_Root() {
        BSTNode<Integer> root = new BSTNode(8, 8, null);
        BST tree = new BST(root);
        BSTNode<Integer> maxNode = tree.FinMinMax(root, true);
        assertEquals(root, maxNode);
    }

    @Test
    public void FinMinMax_Min_From_Root() {
        BSTNode<Integer> root = new BSTNode(8, 8, null);
        BST tree = new BST(root);
        BSTNode<Integer> maxNode = tree.FinMinMax(root, false);
        assertEquals(root, maxNode);
    }



    // 4. в Дереве из 5-ти элементов, находит нужный узел как в середине
    @Test
    public void FinMinMax_Max_From_Leaf_4() {
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

        BSTNode<Integer> maxNode = tree.FinMinMax(leaf_4, true);
        assertEquals(leaf_6, maxNode);

    }

    /*	5.  В дереве из 5-ти элементов, находит нужный узел в листе
     */
    @Test
    public void FinMinMax_Min_From_Leaf_6() {

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

        BSTNode<Integer> minNode = tree.FinMinMax(leaf_6, false);
        assertEquals(leaf_6, minNode);

    }
}