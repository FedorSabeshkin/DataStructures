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

    public SimpleGraph(int size)
    {
        max_vertex = size;
        m_adjacency = new int [size][size];
        vertex = new Vertex[size];
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

        final Vertex EMPTY = null;
        for(int i=0; i<max_vertex; i++){
            if(vertex[i]==EMPTY){
                vertex[i] = vertexForAdd;
                return;
            }
        }
    }



    // здесь и далее, параметры v -- индекс вершины
    // в списке  vertex
    public void RemoveVertex(int v)
    {
        // ваш код удаления вершины со всеми её рёбрами
    }

    /**
     * Is exist edge
     * @param v1
     * @param v2
     * @return
     */
    public boolean IsEdge(int v1, int v2)
    {
        return m_adjacency[v1][v2] == EXIST_EDGE;
    }

    /**
     *
     * Add Edge
     *
     */
    public void AddEdge(int v1, int v2)
    {
        m_adjacency[v1][v2] = EXIST_EDGE;
        m_adjacency[v2][v1] = EXIST_EDGE;
    }

    /**
     *
     * Remove Edge
     *
     */
    public void RemoveEdge(int v1, int v2)
    {
        m_adjacency[v1][v2] = NOT_EXIST_EDGE;
        m_adjacency[v2][v1] = NOT_EXIST_EDGE;
    }
}