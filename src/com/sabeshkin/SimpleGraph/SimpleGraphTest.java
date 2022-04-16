package com.sabeshkin.SimpleGraph;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class SimpleGraphTest {

    @Test
    void constructor_Zero_Size() {
        SimpleGraph simpleGraph = new SimpleGraph(0);
    }

    @Test
    void removeVertex() {
        SimpleGraph simpleGraph = new SimpleGraph(5);
        IntStream.rangeClosed(1, 5).forEach(
                number -> simpleGraph.AddVertex(number)
        );
        // A
        simpleGraph.AddEdge(0,1);
        simpleGraph.AddEdge(0,2);
        simpleGraph.AddEdge(0,3);
        // B
        simpleGraph.AddEdge(1,0);
        simpleGraph.AddEdge(1,3);
        simpleGraph.AddEdge(1,4);
        // C
        simpleGraph.AddEdge(3,0);
        simpleGraph.AddEdge(2,3);
        // D
        simpleGraph.AddEdge(3,0);
        simpleGraph.AddEdge(3,1);
        simpleGraph.AddEdge(3,2);
        simpleGraph.AddEdge(3,3);
        simpleGraph.AddEdge(3,4);
        // E
        simpleGraph.AddEdge(4,1);
        int indexForRemove=1;
        simpleGraph.RemoveVertex(indexForRemove);
        // Check that all edges for vertex removed
        IntStream.rangeClosed(0, 4).forEach(
                number -> assertEquals(0, simpleGraph.m_adjacency[indexForRemove][number])
        );
        IntStream.rangeClosed(0, 4).forEach(
                number -> assertEquals(0, simpleGraph.m_adjacency[number][indexForRemove])
        );
        // Check that removed from vertex arr
        assertEquals(null, simpleGraph.vertex[indexForRemove]);
    }
}