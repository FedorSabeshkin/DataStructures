package com.sabeshkin.BalancedBST;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalancedBSTTest {



    @Test
    public void generateBBSTArray_Empty_In() {
        BalancedBST balancedBST = new BalancedBST();
        int[] in = new int[]{};
        balancedBST.GenerateTree(in);
        assertEquals(null, balancedBST.Root);
    }

    @Test
    public void generateBBSTArray_One_Node() {
        BalancedBST balancedBST = new BalancedBST();
        int[] in = new int[]{1};
        int expected = 1;
        balancedBST.GenerateTree(in);
        assertEquals(expected, balancedBST.Root.NodeKey);
    }

    @Test
    public void generateBBSTArray_Three_Nodes(){
        BalancedBST balancedBST = new BalancedBST();
        int[] in = new int[]{1,2,3};
        int expectedLeftChild = 1;
        balancedBST.GenerateTree(in);
        assertEquals(expectedLeftChild, balancedBST.Root.LeftChild.NodeKey);
    }

    @Test
    public void generateBBSTArray_RightChild_Is_3(){
        BalancedBST balancedBST = new BalancedBST();
        int[] in = new int[]{1,2,3};
        int expectedRightChild = 3;
        balancedBST.GenerateTree(in);
        assertEquals(expectedRightChild, balancedBST.Root.RightChild.NodeKey);
    }

    @Test
    public void generateBBSTArray_Only_Right_Children_Same_All_Values_In_Arr(){
        BalancedBST balancedBST = new BalancedBST();
        int[] in = new int[]{5,5,5,5,5,5};
        balancedBST.GenerateTree(in);
        balancedBST.printWrapper("", balancedBST.Root, false);

        assertEquals(null, balancedBST.Root.LeftChild);
        assertEquals(in[0], balancedBST.Root.NodeKey);
        assertEquals(in[1], balancedBST.Root.RightChild.NodeKey);
        assertEquals(in[2], balancedBST.Root.RightChild.RightChild.NodeKey);
        assertEquals(in[3], balancedBST.Root.RightChild.RightChild.NodeKey);
        assertEquals(in[4], balancedBST.Root.RightChild.RightChild.NodeKey);
        assertEquals(in[5], balancedBST.Root.RightChild.RightChild.NodeKey);
    }


    @Test
    public void CheckLevel(){
        BalancedBST balancedBST = new BalancedBST();
        int[] in = new int[]{1,2,3,4,5};
        balancedBST.GenerateTree(in);
        balancedBST.printWrapper("", balancedBST.Root, false);
        assertEquals(0, balancedBST.Root.Level);
        assertEquals(1, balancedBST.Root.RightChild.Level);
        assertEquals(2, balancedBST.Root.RightChild.RightChild.Level);
        assertEquals(1, balancedBST.Root.LeftChild.Level);
        assertEquals(2, balancedBST.Root.LeftChild.RightChild.Level);
    }
}