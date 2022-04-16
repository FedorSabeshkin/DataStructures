package com.sabeshkin.SimpleGraph;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddVertexTest {

    @Test
    void Simplest_Case_AddVertex() {

        SimpleGraph simpleGraph = new SimpleGraph(5);

        simpleGraph.AddVertex(1);
        assertEquals(1, simpleGraph.vertex[0].Value);
    }

    @Test
    void AddVertex() {
        SimpleGraph simpleGraph = new SimpleGraph(5);

        IntStream.rangeClosed(0, 4).forEach(
                number -> {
                    simpleGraph.AddVertex(number);
                    assertEquals(number, simpleGraph.vertex[number].Value);
                }
        );
    }

//    @Test
//    void AddVertex_After_Remove() {
//        SimpleGraph simpleGraph = new SimpleGraph(5);
//        IntStream.rangeClosed(1, 5).forEach(
//                number -> simpleGraph.AddVertex(number)
//        );
//        // A
//        simpleGraph.AddEdge(0, 1);
//        simpleGraph.AddEdge(0, 2);
//        simpleGraph.AddEdge(0, 3);
//        // B
//        simpleGraph.AddEdge(1, 0);
//        simpleGraph.AddEdge(1, 3);
//        simpleGraph.AddEdge(1, 4);
//        // C
//        simpleGraph.AddEdge(3, 0);
//        simpleGraph.AddEdge(2, 3);
//        // D
//        simpleGraph.AddEdge(3, 0);
//        simpleGraph.AddEdge(3, 1);
//        simpleGraph.AddEdge(3, 2);
//        simpleGraph.AddEdge(3, 3);
//        simpleGraph.AddEdge(3, 4);
//        // E
//        simpleGraph.AddEdge(4, 1);
//
//        int indexForRemove = 2;
//        simpleGraph.RemoveVertex(indexForRemove);
//
//        int addedValue = 8;
//        simpleGraph.AddVertex(addedValue);
//
//
//        // Check that removed from vertex arr
//        assertEquals(addedValue, simpleGraph.vertex[indexForRemove]);
//    }
}