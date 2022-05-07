package com.sabeshkin.SimpleGraph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class WeakVerticesTest {
    public static void printTwoDimensionalArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.printf("%d \t ", a[i][j]);
            }
            System.out.println();
        }
        System.out.println("+++++++++++");
    }

    private SimpleGraph initilazeMockGraph(){
        return BreathFirstSearchTest.initilazeMockGraph();
    }

    @Test
    void WeakVertices_Remove_Edge_A_E_Test() {
        SimpleGraph simpleGraph = initilazeMockGraph();
        // B E
        simpleGraph.RemoveEdge(1, 4);
        ArrayList<Vertex> expectedList_3 = new ArrayList<>();
        expectedList_3.add(new Vertex(5));
        ArrayList<Vertex> factBreadth = simpleGraph.WeakVertices();
        System.out.println("expe  A E: " + expectedList_3);
        System.out.println("fact  A E: " + factBreadth);
        assertEquals(1, factBreadth.size());
        assertIterableEquals(expectedList_3, factBreadth);
    }

    @Test
    void WeakVertices_Remove_Edge_A_E_And_A_B_Test() {
        SimpleGraph simpleGraph = initilazeMockGraph();
        // A B
        simpleGraph.RemoveEdge(0, 1);
        // B E
        simpleGraph.RemoveEdge(1, 4);
        ArrayList<Vertex> expectedList_3 = new ArrayList<>();
        expectedList_3.add(new Vertex(2));
        expectedList_3.add(new Vertex(5));
        ArrayList<Vertex> factBreadth = simpleGraph.WeakVertices();
        System.out.println("expe  A E: " + expectedList_3);
        System.out.println("fact  A E: " + factBreadth);
        assertEquals(2, factBreadth.size());
        assertIterableEquals(expectedList_3, factBreadth);
    }

    @Test
    void WeakVertices_All_Strong_Test() {
        SimpleGraph simpleGraph = initilazeMockGraph();
        ArrayList<Vertex> expectedList_3 = new ArrayList<>();
        ArrayList<Vertex> factBreadth = simpleGraph.WeakVertices();
        assertEquals(0, factBreadth.size());
        assertIterableEquals(expectedList_3, factBreadth);
    }
}

