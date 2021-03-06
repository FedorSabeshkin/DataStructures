package com.sabeshkin.BinarySearchTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteNodeByKeyTest {


    // 4. в Дереве из 5-ти элементов, находит нужный узел как в середине
    @Test
    public void DeleteNodeByKey_Remove_Leaf_2() {
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

        tree.DeleteNodeByKey(2);
        BSTFind<Integer> findInfo = tree.FindNodeByKey(2);
        BSTFind<Integer> expectedFindInfo = new BSTFind(leaf_4, false, true);
        assertEquals(expectedFindInfo, findInfo);

    }

    /*	5.  В дереве из 5-ти элементов, находит нужный узел в листе
     */
    @Test
    public void DeleteNodeByKey_Remove_Leaf_6() {

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

        tree.DeleteNodeByKey(6);
        BSTFind<Integer> findInfo = tree.FindNodeByKey(6);
        BSTFind<Integer> expectedFindInfo = new BSTFind(leaf_4, false, false);
        assertEquals(expectedFindInfo, findInfo);
    }

    @Test
    public void DeleteNodeByKey_Remove_Leaf_12() {

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

        tree.DeleteNodeByKey(12);
        BSTFind<Integer> findInfo = tree.FindNodeByKey(12);
        BSTFind<Integer> expectedFindInfo = new BSTFind(root, false, false);
        assertEquals(expectedFindInfo, findInfo);
    }

    @Test
    public void DeleteNodeByKey_Remove_Leaf_4() {

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

        tree.DeleteNodeByKey(4);
        assertNotEquals(4, root.LeftChild.NodeKey);
    }

    @Test
    public void DeleteNodeByKey_Remove_Leaf_4_Check_Children() {

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
        tree.AddKeyValue(5, 5);
        tree.AddKeyValue(7, 7);

        tree.DeleteNodeByKey(4);

        assertEquals(5, root.LeftChild.NodeKey);
    }

    @Test
    public void DeleteNodeByKey_count_Classical_Way_To_Add_Child_After_Delete_One_Child() {
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
        tree.printWrapper("", tree.Root, false);
        tree.DeleteNodeByKey(4);
        tree.printWrapper("", tree.Root, false);
        assertEquals(4, tree.Count());
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
        tree.printWrapper("", tree.Root, false);
        tree.DeleteNodeByKey(4);
        tree.printWrapper("", tree.Root, false);
        assertEquals(6, tree.Count());
    }

    @Test
    public void DeleteNodeByKey_Remove_Leaf_4_Check_Children_Without_Parent() {

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
        tree.printWrapper("", tree.Root, false);
        tree.DeleteNodeByKey(4);
        tree.printWrapper("", tree.Root, false);
        assertEquals(6, root.LeftChild.NodeKey);
    }

    @Test
    public void findNodeByKey_Found_In_Leaf() {

        // 5 узлов
        BSTNode<Integer> root = new BSTNode(8, 8, null);
        BST tree = new BST(root);

        tree.AddKeyValue(4, 4);
        tree.AddKeyValue(12, 12);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(6, 6);
        tree.print("", tree.Root, false);
        System.out.println("***************************************");
        tree.DeleteNodeByKey(4);
         tree.print("", tree.Root, false);
        tree.DeleteNodeByKey(12);
        assertEquals(3, tree.Count());
    }

    @Test
    public void DeleteNodeByKey_Delete_Last_Node_Root() {

        // 5 узлов
        BSTNode<Integer> root = new BSTNode(8, 8, null);
        BST tree = new BST(root);
        tree.print("", tree.Root, false);
        System.out.println("***************************************");
        tree.DeleteNodeByKey(8);
        tree.print("", tree.Root, false);
        assertEquals(0, tree.Count());
    }

    @Test
    public void DeleteNodeByKey_Delete_All_Nodes() {

        // 5 узлов
        BSTNode<Integer> root = new BSTNode(8, 8, null);
        BST tree = new BST(root);
        tree.AddKeyValue(4, 4);
        tree.AddKeyValue(12, 12);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(6, 6);
        tree.print("", tree.Root, false);
        System.out.println("***************************************");
        tree.DeleteNodeByKey(8);
        tree.print("", tree.Root, false);
        assertEquals(4, tree.Count());
    }
}