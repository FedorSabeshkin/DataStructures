package com.sabeshkin.SimpleGraph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class CollectNeighbourIndexesTest {
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
    void CollectNeighbourIndexes__Test() {
        SimpleGraph simpleGraph = initilazeMockGraph();
        ArrayList<Integer> expectedList = new ArrayList<>();
        expectedList.add(1);
        expectedList.add(2);
        expectedList.add(3);
        ArrayList<Integer> factBreadth = simpleGraph.collectNeighbourIndexes(0);
        assertEquals(3, factBreadth.size());
        assertIterableEquals(expectedList, factBreadth);
        assertTrue(!factBreadth.contains(0));
    }


    @Test
    void CollectNeighbourIndexes_Remove_Edge_A_E_Test() {
        SimpleGraph simpleGraph = initilazeMockGraph();
        // B E
        simpleGraph.RemoveEdge(1, 4);
        ArrayList<Integer> expectedList = new ArrayList<>();
        expectedList.add(3);
        ArrayList<Integer> factBreadth = simpleGraph.collectNeighbourIndexes(4);
        assertEquals(1, factBreadth.size());
        assertIterableEquals(expectedList, factBreadth);
    }


}

