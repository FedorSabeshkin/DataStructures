package com.sabeshkin.SimpleGraph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class BreathFirstSearchTest {
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

    private SimpleGraph initilazeMockGraph(){
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
        return simpleGraph;
    }

    @Test
    void BreadthFirstSearch_Several_Path_Lengths_Test() {
        SimpleGraph simpleGraph = initilazeMockGraph();
        // Breadth 3 vertex in path
        simpleGraph.RemoveEdge(0, 1);
        printTwoDimensionalArray( simpleGraph.m_adjacency);
        ArrayList<Vertex> breadthExpectedList_3 = new ArrayList<>();
        breadthExpectedList_3.add(new Vertex(1));
        breadthExpectedList_3.add(new Vertex(4));
        breadthExpectedList_3.add(new Vertex(5));
        ArrayList<Vertex> factBreadth = simpleGraph.BreadthFirstSearch(0,4);
        System.out.println("fact BreadthFirstSearch A E: " + factBreadth);
        System.out.println("expe BreadthFirstSearch A E: " + breadthExpectedList_3);
        assertEquals(3, factBreadth.size());
        assertIterableEquals(breadthExpectedList_3, factBreadth);
        simpleGraph.AddEdge(0,1);


        // 4 vertex in path
        simpleGraph.RemoveEdge(0, 1);
        ArrayList<Vertex> expectedList_4 = new ArrayList<>();
        expectedList_4.add(new Vertex(1));
        expectedList_4.add(new Vertex(3));
        expectedList_4.add(new Vertex(4));
        expectedList_4.add(new Vertex(5));
        ArrayList<Vertex> fact_4 = simpleGraph.DepthFirstSearch(0,4);
        System.out.println("DepthFirstSearch A E: "+fact_4);
        assertEquals(4, fact_4.size());
        assertIterableEquals(expectedList_4, fact_4);
        simpleGraph.AddEdge(0,1);


    }

    @Test
    void BreadthFirstSearch_Test() {
        SimpleGraph simpleGraph = initilazeMockGraph();
        printTwoDimensionalArray( simpleGraph.m_adjacency);

        ArrayList<Vertex> expectedList = new ArrayList<>();
        expectedList.add(new Vertex(1));
        expectedList.add(new Vertex(2));
        ArrayList<Vertex> fact_1 = simpleGraph.BreadthFirstSearch(0,1);
        System.out.println("BreadthFirstSearch A B: " + fact_1);
        assertEquals(2, fact_1.size());
        assertIterableEquals(expectedList, fact_1);
        // another direction
        ArrayList<Vertex> expectedList_2 = new ArrayList<>();
        expectedList_2.add(new Vertex(2));
        expectedList_2.add(new Vertex(1));
        assertIterableEquals(expectedList_2, simpleGraph.BreadthFirstSearch(1,0));



        // not exist path
        ArrayList<Vertex> expectedListNotExistPath = new ArrayList<>();
        simpleGraph.RemoveEdge(4, 1);
        simpleGraph.RemoveEdge(4, 3);
        ArrayList<Vertex> factNotExistPath = simpleGraph.BreadthFirstSearch(0,4);
        assertEquals(0, factNotExistPath.size());
        assertIterableEquals(expectedListNotExistPath, factNotExistPath);
    }


    @Test
    void BreadthFirstSearch_Comprating_With_DepthFirst_Search_Test() {
        SimpleGraph simpleGraph = initilazeMockGraph();

        ArrayList<Vertex> breadthExpectedList_3 = new ArrayList<>();
        breadthExpectedList_3.add(new Vertex(1));
        breadthExpectedList_3.add(new Vertex(4));
        breadthExpectedList_3.add(new Vertex(5));
        ArrayList<Vertex> factBreadth = simpleGraph.BreadthFirstSearch(0,4);
        System.out.println("fact BreadthFirstSearch A E: " + factBreadth);
        System.out.println("expe BreadthFirstSearch A E: " + breadthExpectedList_3);
        assertEquals(3, factBreadth.size());
        //assertIterableEquals(breadthExpectedList_3, factBreadth);


        ArrayList<Vertex> expectedList_3 = new ArrayList<>();
        expectedList_3.add(new Vertex(1));
        expectedList_3.add(new Vertex(2));
        expectedList_3.add(new Vertex(5));
        ArrayList<Vertex> fact = simpleGraph.DepthFirstSearch(0,4);
        System.out.println("DepthFirstSearch A E: " + fact);
        assertEquals(3, fact.size());
        assertIterableEquals(expectedList_3, fact);
    }
}

