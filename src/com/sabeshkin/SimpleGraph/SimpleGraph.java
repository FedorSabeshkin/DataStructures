package com.sabeshkin.SimpleGraph;

import java.util.*;
import java.util.stream.*;

class Vertex {
    public int Value;
    public boolean Hit;

    public Vertex(int val) {
        Value = val;
        Hit = false;
    }


}

class SimpleGraph {
    Vertex[] vertex;
    int[][] m_adjacency;
    int max_vertex;
    final int EXIST_EDGE = 1;
    final int NOT_EXIST_EDGE = 0;
    final Vertex EMPTY = null;
    int MAX_INDEX;
    final int NOT_FOUND_UNHINT = -1;


    public SimpleGraph(int size) {
        max_vertex = size;
        m_adjacency = new int[size][size];
        vertex = new Vertex[size];
        MAX_INDEX = size - 1;
    }

    public ArrayList<Vertex> DepthFirstSearch(int VFrom, int VTo) {
        // Узлы задаются позициями в списке vertex.
        // Возвращается список узлов -- путь из VFrom в VTo.
        // Список пустой, если пути нету.
        return null;
    }

    /**
     * Select unhint child or
     *
     * @param vertexIndex
     * @return
     */
    public int selectUnhitVertex(int vertexIndex) {
        // find index of unhint element
        OptionalInt unhitNeighborOptinal = IntStream.rangeClosed(0, max_vertex - 1).filter(anotherVertexIndex -> isEdgeNeighbor(vertexIndex, anotherVertexIndex)).filter(index -> !vertex[index].Hit).findFirst();
        if (unhitNeighborOptinal.isPresent()) {
            return unhitNeighborOptinal.getAsInt();
        }
        return NOT_FOUND_UNHINT;
    }

    /**
     * Check is that vertexIndex is have edge with anotherVertexIndex
     *
     * @param vertexIndex
     * @param anotherVertexIndex
     * @return
     */
    public boolean isEdgeNeighbor(int vertexIndex, int anotherVertexIndex) {
        return m_adjacency[vertexIndex][anotherVertexIndex] == EXIST_EDGE;
    }

    /**
     * Hit vertex
     *
     * @param indexOfVertex
     */
    public void hitVertex(int indexOfVertex) {
        Vertex vertexObject = vertex[indexOfVertex];
        vertexObject.Hit = true;
    }

    /**
     * Set vertex object by index to stack
     *
     * @param indexOfVertex
     * @param stack
     * @return
     */
    public ArrayList<Vertex> setVertexToStack(int indexOfVertex, ArrayList<Vertex> stack) {
        Vertex vertexObject = vertex[indexOfVertex];
        stack.add(vertexObject);
        return stack;
    }

    /**
     * Find searchedVertexIndex from more remote neighbours
     * @param parentIndex
     * @param searchedVertexIndex
     * @param stack
     * @return
     */
    public ArrayList<Vertex> selectFromDeeperLevel(int parentIndex, int searchedVertexIndex, ArrayList<Vertex> stack) {
        boolean isFoundVertex = isHaveVertexInClosestChildren(parentIndex, searchedVertexIndex);
        if (isFoundVertex) {
            stack = setVertexToStack(searchedVertexIndex, stack);
            return stack;
        }
        // 4b)
        // select from deeper Children
        int nextParent = selectUnhitVertex(parentIndex);
        boolean isHavenextParent = nextParent != -1;
        if (isHavenextParent) {
            return searchPath(nextParent, searchedVertexIndex, stack);
        }
        // 5
        int lastStackElementIndex = stack.size() - 1;
        stack.get(lastStackElementIndex);
        boolean isEmptyStack = stack.size() == 0 if (isEmptyStack) {
            return stack;
        }
        return selectFromDeeperLevel(parentIndex, searchedVertexIndex, stack);
    }

    /**
     * Search path from parent to searchedVertex
     * @param parentIndex
     * @param searchedVertexIndex
     * @param stack
     * @return
     */
    public ArrayList<Vertex> searchPath(int parentIndex, int searchedVertexIndex, ArrayList<Vertex> stack) {

        hitVertex(parentIndex);
        // 3
        setVertexToStack(parentIndex, stack);
        return selectFromDeeperLevel(parentIndex, searchedVertexIndex, stack);
    }

    /**
     * Add Vertex
     */
    public void AddVertex(int value) {

        Vertex vertexForAdd = new Vertex(value);
        setToFirstEmptyIndex(vertexForAdd);
    }

    /**
     * Set vertex to first empty index
     *
     * @param vertexForAdd
     */
    public void setToFirstEmptyIndex(Vertex vertexForAdd) {

        for (int i = 0; i < max_vertex; i++) {
            if (vertex[i] == EMPTY) {
                vertex[i] = vertexForAdd;
                return;
            }
        }
    }


    /**
     * Remove Vertex
     */
    public void RemoveVertex(int v) {
        if (isValidIndex(v)) {
            vertex[v] = null;
            removeAllEdgesOfVertex(v);
        }
    }

    public void acrossMatrixRow(int indexOfVertex) {
        for (int i = 0; i < max_vertex; i++) {

        }
    }

    /**
     * Remove All Edges Of Vertex
     */
    public void removeAllEdgesOfVertex(int indexOfVertex) {
        for (int i = 0; i < max_vertex; i++) {
            RemoveEdge(indexOfVertex, i);
        }
//        assert m_adjacency[0][indexOfVertex]==0:"Edge must be removed";
//        assert m_adjacency[0][MAX_INDEX]==0:"Last edge also must be removed";
    }

    /**
     * Is exist edge
     *
     * @param v1
     * @param v2
     * @return
     */
    public boolean IsEdge(int v1, int v2) {
        if (isValidIndex(v1) && isValidIndex(v2)) {
            return m_adjacency[v1][v2] == EXIST_EDGE;
        }
        return false;
    }

    /**
     * Add Edge
     */
    public void AddEdge(int v1, int v2) {
        if (isValidIndex(v1) && isValidIndex(v2)) {
            m_adjacency[v1][v2] = EXIST_EDGE;
            m_adjacency[v2][v1] = EXIST_EDGE;
        }
    }

    /**
     * Remove Edge
     */
    public void RemoveEdge(int v1, int v2) {
        if (isValidIndex(v1) && isValidIndex(v2)) {
            m_adjacency[v1][v2] = NOT_EXIST_EDGE;
            m_adjacency[v2][v1] = NOT_EXIST_EDGE;
        }
    }

    /**
     * Check it is valid index
     *
     * @param index
     * @return
     */
    private boolean isValidIndex(int index) {
        return index >= 0 && index < max_vertex;
    }
}