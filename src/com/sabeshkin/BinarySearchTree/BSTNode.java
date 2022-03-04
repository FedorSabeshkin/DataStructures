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
       // assert Node != null :"Нельзя подавать null в объект по найденному узлу";
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
    private int size = 0;

    public BST(BSTNode<T> node)
    {
        Root = node;
        size = 1;
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
        assert nodeForCheck != null :"Узел у которого будем проверять потомков, не может быть null";
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
            return new BSTFind(parentForCheck, false, true);
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
            return new BSTFind(parentForCheck, false, false);
        }
    }


    /*
	Добавление нового узла с ключ-значение
	*/
    public boolean AddKeyValue(int key, T val)
    {
        BSTFind<T> findNodeInfo = FindNodeByKey(key);
        boolean isExist = findNodeInfo.NodeHasKey;
        if(isExist){
            return false;
        }else{
            addNotExistNode(findNodeInfo, key, val);
            size++;
            return true;
        }
    }

    /**
     * Добавляем ребенка на вычесленную для него позицию в дереве
     * @param findNodeInfo
     * @param key
     * @param val
     */
    private void addNotExistNode(BSTFind<T> findNodeInfo, int key, T val){
        if(findNodeInfo.ToLeft){
            assert findNodeInfo.Node != null: "Метод поиска не определил потенциального родителя";
            findNodeInfo.Node.LeftChild = new BSTNode(key, val, findNodeInfo.Node);
        }else{
            findNodeInfo.Node.RightChild = new BSTNode(key, val, findNodeInfo.Node);
        }
    }

    /**
     * Ищем максимальный/минимальный ключ в поддереве
     * @param FromNode
     * @param FindMax
     * @return
     */
    public BSTNode<T> FinMinMax(BSTNode<T> FromNode, boolean FindMax)
    {
        if(FindMax){
            return findMax(FromNode);
        }else{
            return findMin(FromNode);
        }
    }


    /**
     * Поиск max узла
     */
    public BSTNode<T> findMax(BSTNode<T> node)
    {
        boolean isHaveRightChild = node.RightChild != null;
        if(isHaveRightChild){
            return findMax(node.RightChild);
        }else{
            return node;
        }
    }


    /**
     * Поиск min узла
     */
    public BSTNode<T> findMin(BSTNode<T> node)
    {
        boolean isHaveLeftChild = node.LeftChild != null;
        if(isHaveLeftChild){
            return findMin(node.LeftChild);
        }else{
            return node;
        }
    }

    /**
     * Удаление узла по ключу,
     * Если он существует в дереве
     * @param key
     * @return
     */
    public boolean DeleteNodeByKey(int key)
    {
        BSTFind<T> findResult = FindNodeByKey(key);
        boolean isNotExistNodeWithKey = !findResult.NodeHasKey;
        if (isNotExistNodeWithKey) {
            return false;
        }

        BSTNode<T> toDelete = findResult.Node;
        BSTNode<T> toDeleteParent = toDelete.Parent;

        BSTNode<T> toReplace = toDelete.RightChild == null
                ? toDelete.LeftChild
                : FinMinMax(toDelete.RightChild, false);

        if (toReplace != null) {
            toReplace.Parent.LeftChild = toReplace.RightChild;
            if (toReplace.RightChild != null) { toReplace.RightChild.Parent = toReplace.Parent; }
            toReplace.Parent = toDeleteParent;

            toReplace.RightChild = toDelete.RightChild;
            if (toDelete.RightChild != null) { toDelete.RightChild.Parent = toReplace;}

            toReplace.LeftChild = toDelete.LeftChild;
            if (toDelete.LeftChild != null) { toDelete.LeftChild.Parent = toReplace; }
        }

        if (toDeleteParent != null) {
            if (toDeleteParent.LeftChild == toDelete) {
                toDeleteParent.LeftChild = toReplace;
            } else {
                toDeleteParent.RightChild = toReplace;
            }
        } else {
            Root = toReplace;
        }

        toDelete.LeftChild = null;
        toDelete.RightChild = null;
        toDelete.Parent = null;

        size--;
        return true;
    }

    /**
     * Подсчет кол-ва элементов в дереве
     * @return
     */
    public int Count()
    {
        return size; // количество узлов в дереве
    }

}