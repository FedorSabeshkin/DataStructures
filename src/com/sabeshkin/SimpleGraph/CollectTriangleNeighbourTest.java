package com.sabeshkin.SimpleGraph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollectTriangleNeighbourTest {
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
    void CollectTriangleNeighbour__Test() {
        SimpleGraph simpleGraph = initilazeMockGraph();
        ArrayList<Integer> expectedList = new ArrayList<>();
        expectedList.add(1);
        expectedList.add(2);
        expectedList.add(3);
        List<Integer> factBreadth = simpleGraph.collectTriangleNeighbour(0);
        assertEquals(3, factBreadth.size());
        assertIterableEquals(expectedList, factBreadth);
        assertTrue(!factBreadth.contains(0));
    }


    @Test
    void CollectTriangleNeighbour_Remove_Edge_B_D_Test() {
        SimpleGraph simpleGraph = initilazeMockGraph();
        // B E
        simpleGraph.RemoveEdge(1, 3);
        ArrayList<Integer> expectedList = new ArrayList<>();
        expectedList.add(2);
        expectedList.add(3);
        List<Integer>factBreadth = simpleGraph.collectTriangleNeighbour(0);
        assertIterableEquals(expectedList, factBreadth);
    }

    @Test
    void CollectTriangleNeighbour_Remove_Edge_A_B_Test() {
        SimpleGraph simpleGraph = initilazeMockGraph();
        // B E
        simpleGraph.RemoveEdge(0, 1);
        ArrayList<Integer> expectedList = new ArrayList<>();
        expectedList.add(2);
        expectedList.add(3);
        List<Integer>factBreadth = simpleGraph.collectTriangleNeighbour(0);
        assertIterableEquals(expectedList, factBreadth);
    }


}

