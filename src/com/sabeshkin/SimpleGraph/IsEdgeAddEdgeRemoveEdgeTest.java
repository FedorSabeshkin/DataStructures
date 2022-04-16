package com.sabeshkin.SimpleGraph;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class IsEdgeAddEdgeRemoveEdgeTest {

    @Test
    void After_Remove_IsEdge() {
        SimpleGraph simpleGraph = new SimpleGraph(5);
        IntStream.rangeClosed(1, 5).forEach(
                number -> simpleGraph.AddVertex(number)
        );
        // E
        simpleGraph.AddEdge(4, 1);
        assertTrue( simpleGraph.IsEdge(4,1));
        simpleGraph.RemoveEdge(4, 1);
        assertFalse( simpleGraph.IsEdge(4,1));
    }

    @Test
    void IsEdge_Test() {
        SimpleGraph simpleGraph = new SimpleGraph(5);
        IntStream.rangeClosed(1, 5).forEach(
                number -> simpleGraph.AddVertex(number)
        );
        // A
        simpleGraph.AddEdge(0, 1);
        assertTrue( simpleGraph.IsEdge(0,1));
        simpleGraph.AddEdge(0, 2);
        simpleGraph.AddEdge(0, 3);
        // B
        assertFalse( simpleGraph.IsEdge(1,0));
        simpleGraph.AddEdge(1, 0);
        assertTrue( simpleGraph.IsEdge(1,0));
    }
}