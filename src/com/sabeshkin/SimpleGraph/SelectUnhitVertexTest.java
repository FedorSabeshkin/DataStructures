package com.sabeshkin.SimpleGraph;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SelectUnhitVertexTest {
    public static void printTwoDimensionalArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.printf("%d \t ", a[i][j]);
            }
            System.out.println();
        }
        System.out.println("+++++++++++");
    }
    @Test
    void constructor_Zero_Size() {
        SimpleGraph simpleGraph = new SimpleGraph(0);
    }

    @Test
    void selectUnhitVertex_Test() {
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
        printTwoDimensionalArray( simpleGraph.m_adjacency);


        // Check that removed from vertex arr
        assertEquals(1, simpleGraph.selectUnhitNeighbour(0));
        simpleGraph.hitVertex(1);
        assertEquals(2, simpleGraph.selectUnhitNeighbour(0));
        simpleGraph.hitVertex(2);
        assertEquals(3, simpleGraph.selectUnhitNeighbour(0));
        simpleGraph.hitVertex(3);
        assertEquals(-1, simpleGraph.selectUnhitNeighbour(0));
    }
}

