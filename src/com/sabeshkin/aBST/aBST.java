package com.sabeshkin.aBST;

import java.util.*;

class aBST
{
    public Integer Tree []; // arr of keys

    public aBST(int depth) {
        int tree_size = (2 << depth) - 1;
        Tree = new Integer[tree_size];
        for (int i = 0; i < tree_size; i++) { Tree[i] = null; }
    }

    /**
     * find key
     * @param key
     * @return
     */
    public Integer FindKeyIndex(int key) {
        boolean isEmptyTree = Tree[0] == null;
        if (isEmptyTree) {
            return 0;
        }

        int currentIdx = 0;

        while (Tree[currentIdx] != key && right(currentIdx) < Tree.length) {
            // determine direction of branch for search
            if (key < Tree[currentIdx]) {
                // check left branch
                int leftIdx = left(currentIdx);

                if (Tree[leftIdx] == null) {
                    return -leftIdx;
                }
                currentIdx = leftIdx;
            } else {
                // check right branch
                int rightIdx = right(currentIdx);

                if (Tree[rightIdx] == null) {
                    return -rightIdx;
                }
                currentIdx = rightIdx;
            }
        }

        return Tree[currentIdx] == key ? currentIdx : null;
    }

    /**
     * Add Key to tree
     * @param key
     * @return
     */
    public int AddKey(int key) {
        if (Tree[0] == null) {
            Tree[0] = key;
            return 0;
        }

        int currentIdx = 0;
        while (right(currentIdx) < Tree.length) {
            if (key < Tree[currentIdx]) {
                int leftIdx = left(currentIdx);

                if (Tree[leftIdx] == null) {
                    Tree[leftIdx] = key;
                    return leftIdx;
                }
                currentIdx = leftIdx;
            } else if (Tree[currentIdx] == key) {
                return currentIdx;
            } else {
                int rightIdx = right(currentIdx);

                if (Tree[rightIdx] == null) {
                    Tree[rightIdx] = key;
                    return rightIdx;
                }
                currentIdx = rightIdx;
            }
        }

        return -1;
    }

    /**
     * Calculate index for parent
     * @param idx
     * @return
     */
    private int getParentIndex(int idx) {
        return (idx - 1) / 2;
    }

    /**
     * Calculate index for left child
     * @param idx index of node(parent)
     * @return index of right child
     */
    private int left(int idx) {
        return 2 * idx + 1;
    }

    /**
     * Calculate index for right child
     * @param idx  index of node(parent)
     * @return index of right child
     */
    private int right(int idx) {
        return 2 * idx + 2;
    }

}