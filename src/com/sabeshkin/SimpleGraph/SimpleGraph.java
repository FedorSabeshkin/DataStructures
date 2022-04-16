package com.sabeshkin.SimpleGraph;

import java.util.*;

class Vertex
{
    public int Value;
    public Vertex(int val)
    {
        Value = val;
    }
}

class SimpleGraph
{
    Vertex [] vertex;
    int [][] m_adjacency;
    int max_vertex;
    final int EXIST_EDGE = 1;
    final int NOT_EXIST_EDGE = 0;
    final Vertex EMPTY = null;
    int MAX_INDEX;

    public SimpleGraph(int size)
    {
        max_vertex = size;
        m_adjacency = new int [size][size];
        vertex = new Vertex[size];
        MAX_INDEX = size-1;
    }

    /**
     * Add Vertex
     *
     */
    public void AddVertex(int value)
    {

        Vertex vertexForAdd = new Vertex(value);
        setToFirstEmptyIndex(vertexForAdd);
    }

    /**
     * Set vertex to first empty index
     * @param vertexForAdd
     */
    public void setToFirstEmptyIndex(Vertex vertexForAdd)
    {

        for(int i=0; i<max_vertex; i++){
            if(vertex[i]==EMPTY){
                vertex[i] = vertexForAdd;
                return;
            }
        }
    }




    /**
     *
     * Remove Vertex
     *
     */
    public void RemoveVertex(int v)
    {
        if(isValidIndex(v)) {
            vertex[v] = null;
            removeAllEdgesOfVertex(v);
        }
    }

    /**
     * Remove All Edges Of Vertex
     *
     */
    public void removeAllEdgesOfVertex(int indexOfVertex){
        for(int i=0; i<max_vertex; i++){
            RemoveEdge(indexOfVertex, i);
        }
//        assert m_adjacency[0][indexOfVertex]==0:"Edge must be removed";
//        assert m_adjacency[0][MAX_INDEX]==0:"Last edge also must be removed";
    }

    /**
     * Is exist edge
     * @param v1
     * @param v2
     * @return
     */
    public boolean IsEdge(int v1, int v2)
    {
        if(isValidIndex(v1) && isValidIndex(v2)) {
            return m_adjacency[v1][v2] == EXIST_EDGE;
        }
        return false;
    }

    /**
     *
     * Add Edge
     *
     */
    public void AddEdge(int v1, int v2)
    {
        if(isValidIndex(v1) && isValidIndex(v2)) {
            m_adjacency[v1][v2] = EXIST_EDGE;
            m_adjacency[v2][v1] = EXIST_EDGE;
        }
    }

    /**
     *
     * Remove Edge
     *
     */
    public void RemoveEdge(int v1, int v2)
    {
        if(isValidIndex(v1) && isValidIndex(v2)){
            m_adjacency[v1][v2] = NOT_EXIST_EDGE;
            m_adjacency[v2][v1] = NOT_EXIST_EDGE;
        }
    }

    /**
     * Check it is valid index
     * @param index
     * @return
     */
    private boolean isValidIndex(int index) {
        return index >= 0 && index < max_vertex;
    }
}