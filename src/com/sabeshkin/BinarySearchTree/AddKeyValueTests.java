package com.sabeshkin.BinarySearchTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddKeyValueTests {


    @Test
    public void AddKeyValue_To_Left() {


        BSTNode<Integer> root = new BSTNode(8, 8, null);
        BST tree = new BST(root);
        BSTFind<Integer> findInfo = tree.FindNodeByKey(4);
        assert findInfo.Node != null: "Метод поиска не определил потенциального родителя";
        boolean wasNotNodeBeforeAdd = findInfo.Node.NodeKey != 4;
        tree.AddKeyValue(4,4);
        findInfo = tree.FindNodeByKey(4);
        boolean isInTreeAfterAdd = findInfo.Node.NodeKey == 4;
        assertTrue( wasNotNodeBeforeAdd && isInTreeAfterAdd);

    }

    @Test
    public void AddKeyValue_To_Right() {


        BSTNode<Integer> root = new BSTNode(8, 8, null);
        BST tree = new BST(root);

        tree.AddKeyValue(9,9);
        assert tree.Root.LeftChild == null :"Налево добавляем меньший узел";
        assert tree.Root.RightChild != null :"Большее значение должно добавляться справа";
        assertEquals(9, tree.Root.RightChild.NodeKey);

    }

    @Test
    public void AddKeyValue_5_Nodes_To_Right() {


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

        tree.AddKeyValue(15,15);
        assertEquals(15, leaf_12.RightChild.NodeKey);
    }

    @Test
    public void AddKeyValue_To_Left_Check_Node() {


        BSTNode<Integer> root = new BSTNode(8, 8, null);
        BST tree = new BST(root);

        tree.AddKeyValue(1,1);
        assert tree.Root.RightChild == null :"Большее значение должно добавляться справа";
        assert tree.Root.LeftChild != null :"Налево добавляем меньший узел";
        assertEquals(1, tree.Root.LeftChild.NodeKey);

    }

    @Test
    public void AddKeyValue_Key_Already_Exist() {


        BSTNode<Integer> root = new BSTNode(8, 8, null);
        BST tree = new BST(root);

        tree.AddKeyValue(8,8);
        boolean isNotHaveChildren = root.RightChild == null && root.LeftChild == null;
        assertTrue( isNotHaveChildren);

    }


}