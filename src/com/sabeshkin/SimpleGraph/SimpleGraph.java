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

    /**
     * We compare only  Value
     * for easy check right DepthFirstSearch() in Unit tests
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        boolean isSameObject = obj == this;
        if (isSameObject) {
            return true;
        }

        boolean isAnotherClassObject = !(obj instanceof Vertex);
        if (isAnotherClassObject) {
            return false;
        }
        Vertex bstNodeForCheck = (Vertex) obj;
        boolean isEqualValue = this.Value == bstNodeForCheck.Value;

        return isEqualValue;
    }

    /**
     * Show Value of vertex
     *
     * @return
     */
    @Override
    public String toString() {
        return this.Value + "";
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

    /**
     * Search path between vertex by their indexes
     * @param VFrom
     * @param VTo
     * @return
     */
    public ArrayList<Vertex> DepthFirstSearch(int VFrom, int VTo) {
        clearSearchInfo();
        ArrayList<Vertex> stack = new ArrayList<>();
        return searchPath(VFrom, VTo, stack);
    }

    /**
     * Clear all hit about search
     */
    public void clearSearchInfo(){
        IntStream.rangeClosed(0, max_vertex - 1).forEach(
                vertexIndex -> vertex[vertexIndex].Hit = false
        );
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
        return IsEdge(vertexIndex, anotherVertexIndex);
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
     *
     * @param parentIndex
     * @param searchedVertexIndex
     * @param stack
     * @return
     */
    public ArrayList<Vertex> selectFromDeeperLevel(int parentIndex, int searchedVertexIndex, ArrayList<Vertex> stack) {
        boolean isFoundVertex = isHaveSearchedInClosestChildren(parentIndex, searchedVertexIndex);
        if (isFoundVertex) {
            stack = setVertexToStack(searchedVertexIndex, stack);
            return stack;
        }
        // 4b)
        // select from deeper Children
        int nextParent = selectUnhitVertex(parentIndex);
        boolean isHaveNextParent = nextParent != -1;
        if (isHaveNextParent) {
            return searchPath(nextParent, searchedVertexIndex, stack);
        }
        // 5
        if(stack.size() > 0){
            int lastStackElementIndex = stack.size() - 1;
            // remove uppest element
            stack.remove(lastStackElementIndex);
        }
        boolean isEmptyStack = stack.size() == 0;
        if (isEmptyStack) {
            return stack;
        }

        int lastStackElementIndex = stack.size() - 1;
        // remove uppest element
        nextParent = stack.remove(lastStackElementIndex);
        return selectFromDeeperLevel(parentIndex, searchedVertexIndex, stack);
    }

    /**
     * @param vertexIndex
     * @param searchedVertexIndex
     * @return
     */
    public boolean isHaveSearchedInClosestChildren(int vertexIndex, int searchedVertexIndex) {

        OptionalInt searchedNeighborOptinal = IntStream.rangeClosed(0, max_vertex - 1)
                .filter(anotherVertexIndex -> isEdgeNeighbor(vertexIndex, anotherVertexIndex))
                .filter(index -> index == searchedVertexIndex).findFirst();
        return searchedNeighborOptinal.isPresent();
    }

    /**
     * Search path from parent to searchedVertex
     *
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