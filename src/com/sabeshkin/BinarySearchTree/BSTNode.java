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

    /**
     Поиск следующего по ключу узла или родителя, к которому его можно добавить
     */
    public BSTFind<T> FindNodeByKey(int key)
    {
        return FindNodeByKeyFromNode(Root, key);
    }

    /**
     Ищем соответствие с определенного узла
     */
    public BSTFind<T> FindNodeByKeyFromNode(BSTNode<T> FromNode, int key)
    {
        boolean isSameKey = key == FromNode.NodeKey;
        if(isSameKey){
            return new BSTFind(FromNode, true, false);
        }else{
            return findInChildren(key, FromNode);
        }
    }


    /**
     Метод выбора следующего узла потомка, на эквивалентность ключу поиска
     */
    private BSTFind<T> findInChildren(int keyForSearch, BSTNode<T> nodeForCheck){
        if(keyForSearch<nodeForCheck.NodeKey){
            return checkLeftChild(keyForSearch, nodeForCheck);
        }else{
            return checkRightChild(keyForSearch, nodeForCheck);
        }
    }

    /**
     Метод проверки Левого потомка
     */
    private BSTFind<T> checkLeftChild(int keyForSearch, BSTNode<T> parentForCheck){
        boolean isExistLeftChild = parentForCheck.LeftChild != null;
        if(isExistLeftChild){
            return FindNodeByKeyFromNode(parentForCheck.LeftChild, keyForSearch);
        }else{
            return new BSTFind(parentForCheck.LeftChild, false, true);
        }
    }

    /**
     Метод проверки Правого потомка
     */
    private BSTFind<T> checkRightChild(int keyForSearch, BSTNode<T> parentForCheck){
        boolean isExistRightChild = parentForCheck.RightChild != null;
        if(isExistRightChild){
            return FindNodeByKeyFromNode(parentForCheck.RightChild, keyForSearch);
        }else{
            return new BSTFind(parentForCheck.RightChild, false, true);
        }
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