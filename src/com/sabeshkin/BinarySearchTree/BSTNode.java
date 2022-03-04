package com.sabeshkin.BinarySearchTree;

import java.io.*;
import java.util.*;


class BSTNode<T>
{
    public int NodeKey; // ключ узла
    public T NodeValue; // значение в узле
    public BSTNode<T> Parent; // родитель или null для корня
    public BSTNode<T> LeftChild; // левый потомок
    public BSTNode<T> RightChild; // правый потомок

    public BSTNode(int key, T val, BSTNode<T> parent)
    {
        NodeKey = key;
        NodeValue = val;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

// промежуточный результат поиска
class BSTFind<T>
{
    // null если в дереве вообще нету узлов
    public BSTNode<T> Node;

    // true если узел найден
    public boolean NodeHasKey;

    // true, если родительскому узлу надо добавить новый левым
    public boolean ToLeft;

    public BSTFind() { Node = null; }

    /**
     * Constructor for tests
     * @param Node
     * @param NodeHasKey
     * @param NodeHasKey
     */
    public BSTFind(BSTNode<T> Node, boolean NodeHasKey, boolean ToLeft) {
        this.Node = Node;
        this.NodeHasKey = NodeHasKey;
        this.ToLeft = ToLeft;
    }

    /**
     * Create object with found node
     * @param Node found node
     * @return
     */
    public static BSTFind createFoundNodeInfo(BSTNode Node){
        return new BSTFind(Node, true, false);
    }
    /**
     * Override equals
     * We check equals Node, NodeHasKey and NodeHasKey fields
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        boolean isSameObject = obj == this;
        if (isSameObject) {
            return true;
        }
        boolean isAnotherClassObject = !(obj instanceof BSTFind);
        if (isAnotherClassObject) {
            return false;
        }
        BSTFind<T> bstFindForCheck  = (BSTFind<T>) obj;
        boolean isEqualNode = this.Node.equals(bstFindForCheck.Node);
        boolean isEqualNodeHasKey = this.NodeHasKey == bstFindForCheck.NodeHasKey;
        boolean isEqualToLeft = this.ToLeft == bstFindForCheck.ToLeft;

        return isEqualNode && isEqualNodeHasKey && isEqualToLeft;
    }
}

class BST<T>
{
    BSTNode<T> Root; // корень дерева, или null

    public BST(BSTNode<T> node)
    {
        Root = node;
    }

    public BSTFind<T> FindNodeByKey(int key)
    {
        // ищем в дереве узел и сопутствующую информацию по ключу
        return null;
    }

    public boolean AddKeyValue(int key, T val)
    {
        // добавляем ключ-значение в дерево
        return false; // если ключ уже есть
    }

    public BSTNode<T> FinMinMax(BSTNode<T> FromNode, boolean FindMax)
    {
        // ищем максимальный/минимальный ключ в поддереве
        return null;
    }

    public boolean DeleteNodeByKey(int key)
    {
        // удаляем узел по ключу
        return false; // если узел не найден
    }

    public int Count()
    {
        return 0; // количество узлов в дереве
    }

}