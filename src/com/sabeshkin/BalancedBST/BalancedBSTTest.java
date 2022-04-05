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

        assertEquals(3, balancedBST.Root.RightChild.RightChild.RightChild.Level);
        /**
         * Check determineMaxDepth()
         */
        assertEquals(5,balancedBST.determineMaxDepth(balancedBST.Root, 0));
        assertEquals(0,balancedBST.determineMaxDepth(balancedBST.Root.LeftChild, 0));
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

        BalancedBST balancedBSTAllSame = new BalancedBST();
        int[] inAllSame = new int[]{5,5,5,5,5,5};
        balancedBSTAllSame.GenerateTree(inAllSame);
        balancedBSTAllSame.printWrapper("", balancedBSTAllSame.Root, false);
        assertEquals(0, balancedBSTAllSame.Root.Level);
        assertEquals(1, balancedBSTAllSame.Root.RightChild.Level);
        assertEquals(2, balancedBSTAllSame.Root.RightChild.RightChild.Level);
        assertEquals(3, balancedBSTAllSame.Root.RightChild.RightChild.RightChild.Level);
    }

    @Test
    public void CheckLevelAllSame(){
        BalancedBST balancedBSTAllSame = new BalancedBST();
        int[] inAllSame = new int[]{5,5,5,5,5,5};
        balancedBSTAllSame.GenerateTree(inAllSame);
        //balancedBSTAllSame.printWrapper("", balancedBSTAllSame.Root, false);
        balancedBSTAllSame.printLevel("", balancedBSTAllSame.Root, false);
        assertEquals(0, balancedBSTAllSame.Root.Level);
        assertEquals(1, balancedBSTAllSame.Root.RightChild.Level);
        assertEquals(2, balancedBSTAllSame.Root.RightChild.RightChild.Level);
        assertEquals(3, balancedBSTAllSame.Root.RightChild.RightChild.RightChild.Level);
        assertEquals(false,balancedBSTAllSame.IsBalanced(balancedBSTAllSame.Root));
    }

    @Test
    public void determineMaxDepth_Test(){
        BalancedBST balancedBST = new BalancedBST();
        int[] in = new int[]{1,2,3,4,5};
        balancedBST.GenerateTree(in);
        balancedBST.printWrapper("", balancedBST.Root, false);
        /**
         * Check determineMaxDepth()
         */
        assertEquals(2,balancedBST.determineMaxDepth(balancedBST.Root, 0));
        assertEquals(2,balancedBST.determineMaxDepth(balancedBST.Root.LeftChild, 0));
        assertEquals(2,balancedBST.determineMaxDepth(balancedBST.Root.LeftChild.RightChild, 1));
        assertEquals(0,balancedBST.determineMaxDepth(null, 0));
        assertEquals(1000,balancedBST.determineMaxDepth(null, 1000));

        assertEquals(true,balancedBST.IsBalanced(balancedBST.Root));

        BalancedBST moreBalancedBST = new BalancedBST();
        int[] moreIn = new int[]{1,2,3,4,5, 6, 7, 8, 9, 10, 11 , 12};
        moreBalancedBST.GenerateTree(moreIn);
        moreBalancedBST.printWrapper("", moreBalancedBST.Root, false);
        assertEquals(true,moreBalancedBST.IsBalanced(moreBalancedBST.Root));

    }


}