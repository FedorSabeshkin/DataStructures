package com.sabeshkin.simpleTree;

import java.util.*;

public class SimpleTreeNode<T>
{
    public T NodeValue; // значение в узле
    public SimpleTreeNode<T> Parent; // родитель или null для корня
    public List<SimpleTreeNode<T>> Children; // список дочерних узлов или null

    public SimpleTreeNode(T val, SimpleTreeNode<T> parent)
    {
        NodeValue = val;
        Parent = parent;
        Children = null;
    }

    /**
     * Create empty list for children in node
     */
    public void createEmptyChildrenList(){
        Children = new ArrayList<>();
    }
}

class SimpleTree<T>
{
    public SimpleTreeNode<T> Root; // корень, может быть null

    public SimpleTree(SimpleTreeNode<T> root)
    {
        Root = root;
    }

    /**
     * Add child to node
     * @param ParentNode
     * @param NewChild
     */
    public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild)
    {
        if(ParentNode.Children == null){
            ParentNode.createEmptyChildrenList();
        }
        assert ParentNode.Children != null : "You must create children list";
        ParentNode.Children.add(NewChild);
        assert ParentNode.Children.contains(NewChild): "Children was't added";
        NewChild.Parent = ParentNode;
        assert NewChild.Parent.equals(ParentNode): "Parent was't added";
    }


    /**
     * Remove not root node
     * @param NodeToDelete
     */
    public void DeleteNode(SimpleTreeNode<T> NodeToDelete)
    {
        boolean isChildNode = !NodeToDelete.equals(Root);
        if(isChildNode){
            assert NodeToDelete.Parent.Children != null : "You must have children list";
            NodeToDelete.Parent.Children.remove(NodeToDelete);
        }
    }

    public List<SimpleTreeNode<T>> GetAllNodes()
    {
        // ваш код выдачи всех узлов дерева в определённом порядке
        return null;
    }

    public List<SimpleTreeNode<T>> FindNodesByValue(T val)
    {
        // ваш код поиска узлов по значению
        return null;
    }

    public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent)
    {
        // ваш код перемещения узла вместе с его поддеревом --
        // в качестве дочернего для узла NewParent
    }

    public int Count()
    {
        // количество всех узлов в дереве
        return 0;
    }

    public int LeafCount()
    {
        // количество листьев в дереве
        return 0;
    }
}
