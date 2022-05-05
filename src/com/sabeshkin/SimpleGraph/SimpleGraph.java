package com.sabeshkin.SimpleGraph;

import java.util.*;

class Vertex {
    public int Value;
    public boolean Hit;
    public int Level;

    public Vertex(int val) {
        Value = val;
        Hit = false;
    }

    /**
     * We compare only  Value
     * for easy check right DepthFirstSearch() in Unit tests
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        boolean isSameObject = obj == this;
        if (isSameObject) {
            return true;
        }

        boolean isAnotherClassObject = !(obj instanceof Vertex);
        if (isAnotherClassObject) {
            return false;
        }
        Vertex bstNodeForCheck = (Vertex) obj;
        boolean isEqualValue = this.Value == bstNodeForCheck.Value;

        return isEqualValue;
    }

    /**
     * Show Value of vertex
     *
     * @return
     */
    @Override
    public String toString() {
        return this.Value + "";
    }

}

class SimpleGraph {
    Vertex[] vertex;
    int[][] m_adjacency;
    int max_vertex;
    final int EXIST_EDGE = 1;
    final int NOT_EXIST_EDGE = 0;
    final Vertex EMPTY = null;
    int MAX_INDEX;
    final int NOT_FOUND_UNHIT = -1;
    ArrayList<Integer> shortestPathIndexes;

    public SimpleGraph(int size) {
        max_vertex = size;
        m_adjacency = new int[size][size];
        vertex = new Vertex[size];
        MAX_INDEX = size - 1;
    }


    public ArrayList<Vertex> BreadthFirstSearch(int VFrom, int VTo) {
        if (!isValidIndex(VFrom) || !isValidIndex(VTo)) {
            return new ArrayList<>();
        }
        clearSearchInfo();
        shortestPathIndexes.add(VFrom);
        hitVertex(VFrom);
        boolean isSamePoint = VFrom == VTo;
        if (isSamePoint) {
            return stackIndexToVertex(shortestPathIndexes);
        }
        Queue<Integer> queuePath = new LinkedList<>();
        performPath(VFrom, VTo, queuePath);
        return stackIndexToVertex(shortestPathIndexes);
    }

    /**
     * Add index to path, and remove prev added
     * if prev is a part of not optimal path
     **/
    public void addIndexToPath(int indexForAdd) {
        int lastIndexInArr = shortestPathIndexes.size() - 1;
        int lastAddedIndex = shortestPathIndexes.get(lastIndexInArr);
        Vertex lastAddedVertex = vertex[lastAddedIndex];
        Vertex vertexForAdd = vertex[indexForAdd];
        boolean isLastLessNextLevel = lastAddedVertex.Level < vertexForAdd.Level;
        if (isLastLessNextLevel) {
            shortestPathIndexes.add(indexForAdd);
            return;
        }
        shortestPathIndexes.remove(lastIndexInArr);
        shortestPathIndexes.add(indexForAdd);
    }

    /**
     * Perform path to vertex and set it to queue
     **/
    public Queue<Integer> performPath(int consideredIndex, int searchedIndex, Queue<Integer> queuePath) {
        int unhitNeighbourIndex = selectUnhitVertex(consideredIndex);
        boolean isExistUnhitNeighbour = unhitNeighbourIndex != NOT_FOUND_UNHIT;
        if (isExistUnhitNeighbour) {
            return addNeighbourToPath(consideredIndex, unhitNeighbourIndex, searchedIndex, queuePath);
        }
        boolean isExistIndexToConside = queuePath.size() > 0;
        if (isExistIndexToConside) {
            int nextConsideredIndex = queuePath.poll();
            addIndexToPath(nextConsideredIndex);
            return performPath(nextConsideredIndex, searchedIndex, queuePath);
        }
        clearSearchInfo();
        return queuePath;
    }

    /**
     * Add Neighbour To Path
     **/
    public Queue<Integer> addNeighbourToPath(int consideredIndex, int unhitNeighbourIndex, int searchedIndex, Queue<Integer> queuePath) {
        hitVertex(unhitNeighbourIndex);
        Vertex consideredVertex = vertex[consideredIndex];
        Vertex unhitNeighbour = vertex[unhitNeighbourIndex];
        unhitNeighbour.Level = consideredVertex.Level + 1;

        queuePath.add(unhitNeighbourIndex);
        boolean isFoundPathEnd = unhitNeighbourIndex == searchedIndex;
        if (isFoundPathEnd) {
            shortestPathIndexes.add(searchedIndex);
            return queuePath;
        }
        return performPath(consideredIndex, searchedIndex, queuePath);
    }


    /**
     * Search path between vertex by their indexes
     *
     * @param VFrom
     * @param VTo
     * @return
     */
    public ArrayList<Vertex> DepthFirstSearch(int VFrom, int VTo) {
        if (!isValidIndex(VFrom) || !isValidIndex(VTo)) {
            return new ArrayList<>();
        }
        clearSearchInfo();
        ArrayList<Integer> stack = new ArrayList<>();
        stack = searchPath(VFrom, VTo, stack);
        return stackIndexToVertex(stack);
    }

    /**
     * Stack of indexes to stack of Vertex object
     *
     * @param stack
     * @return
     */
    public ArrayList<Vertex> stackIndexToVertex(ArrayList<Integer> stack) {
        ArrayList<Vertex> stackOfVertex = new ArrayList<>();
        stack.forEach(index -> stackOfVertex.add(vertex[index]));
        return stackOfVertex;
    }

    /**
     * Clear all hit about search
     */
    public void clearSearchInfo() {
        for (int vertexIndex = 0; vertexIndex < max_vertex; vertexIndex++) {
            clearParams(vertexIndex);
        }
        shortestPathIndexes = new ArrayList<>();
    }

    /**
     * Clear search params of Vertex object
     *
     * @param vertexIndex
     */
    public void clearParams(int vertexIndex) {
        Vertex vertexObject = vertex[vertexIndex];
        if (vertexObject != EMPTY) {
            vertexObject.Hit = false;
            vertexObject.Level = 0;
        }
    }

    /**
     * Find index of unhint element or return NOT_FOUND_UNHIT
     *
     * @param vertexIndex
     * @return
     */
    public int selectUnhitVertex(int vertexIndex) {

        OptionalInt unhitNeighborOptinal = java.util.stream.IntStream.rangeClosed(0, max_vertex - 1).filter(anotherVertexIndex -> isEdgeNeighbor(vertexIndex, anotherVertexIndex)).filter(index -> !vertex[index].Hit).findFirst();

        if (unhitNeighborOptinal.isPresent()) {
            return unhitNeighborOptinal.getAsInt();
        }
        return NOT_FOUND_UNHIT;
    }

    /**
     * Check is that vertexIndex is have edge with anotherVertexIndex
     *
     * @param vertexIndex
     * @param anotherVertexIndex
     * @return
     */
    public boolean isEdgeNeighbor(int vertexIndex, int anotherVertexIndex) {
        return IsEdge(vertexIndex, anotherVertexIndex);
    }

    /**
     * Hit vertex
     *
     * @param indexOfVertex
     */
    public void hitVertex(int indexOfVertex) {
        Vertex vertexObject = vertex[indexOfVertex];
        vertexObject.Hit = true;
    }

    /**
     * Set vertex object by index to stack
     *
     * @param indexOfVertex
     * @param stack
     * @return
     */
    public ArrayList<Integer> setVertexToStack(int indexOfVertex, ArrayList<Integer> stack) {
        stack.add(indexOfVertex);
        return stack;
    }

    /**
     * Find searchedVertexIndex from more remote neighbours
     *
     * @param parentIndex
     * @param searchedVertexIndex
     * @param stack
     * @return
     */
    public ArrayList<Integer> selectFromDeeperLevel(int parentIndex, int searchedVertexIndex, ArrayList<Integer> stack) {
        boolean isFoundVertex = isHaveSearchedInClosestChildren(parentIndex, searchedVertexIndex);
        if (isFoundVertex) {
            stack = setVertexToStack(searchedVertexIndex, stack);
            return stack;
        }
        return findOnAnotherBranch(parentIndex, searchedVertexIndex, stack);
    }

    /**
     * Find vertex between more remote nodes
     *
     * @param parentIndex
     * @param searchedVertexIndex
     * @param stack
     * @return
     */
    public ArrayList<Integer> findOnAnotherBranch(int parentIndex, int searchedVertexIndex, ArrayList<Integer> stack) {
        int nextNeighbour = selectUnhitVertex(parentIndex);
        boolean isNextNeighbour = nextNeighbour != -1;
        if (isNextNeighbour) {
            return searchPath(nextNeighbour, searchedVertexIndex, stack);
        }
        return findFromPrevVertex(parentIndex, searchedVertexIndex, stack);

    }

    /**
     * Start find searchedVertex from another neighbours of vertex
     *
     * @param parentIndex
     * @param searchedVertexIndex
     * @param stack
     * @return
     */
    public ArrayList<Integer> findFromPrevVertex(int parentIndex, int searchedVertexIndex, ArrayList<Integer> stack) {
        stack = removeLastFromStack(stack);
        boolean isEmptyStack = stack.size() == 0;
        if (isEmptyStack) {
            return stack;
        }
        int lastStackElementIndex = stack.size() - 1;
        int indexForStartDeep = stack.get(lastStackElementIndex);
        vertex[indexForStartDeep].Hit = true;
        return selectFromDeeperLevel(indexForStartDeep, searchedVertexIndex, stack);
    }

    /**
     * Remove last element of stack if last element is exist
     *
     * @param stack
     * @return changed or empty stack
     */
    private ArrayList<Integer> removeLastFromStack(ArrayList<Integer> stack) {
        if (stack.size() > 0) {
            int lastStackElementIndex = stack.size() - 1;
            stack.remove(lastStackElementIndex);
        }
        return stack;
    }

    /**
     * @param vertexIndex
     * @param searchedVertexIndex
     * @return
     */
    public boolean isHaveSearchedInClosestChildren(int vertexIndex, int searchedVertexIndex) {

        OptionalInt searchedNeighborOptional = java.util.stream.IntStream.rangeClosed(0, max_vertex - 1).filter(anotherVertexIndex -> isEdgeNeighbor(vertexIndex, anotherVertexIndex)).filter(index -> index == searchedVertexIndex).findFirst();
        return searchedNeighborOptional.isPresent();
    }

    /**
     * Search path from parent to searchedVertex
     *
     * @param parentIndex
     * @param searchedVertexIndex
     * @param stack
     * @return
     */
    public ArrayList<Integer> searchPath(int parentIndex, int searchedVertexIndex, ArrayList<Integer> stack) {

        hitVertex(parentIndex);
        setVertexToStack(parentIndex, stack);
        return selectFromDeeperLevel(parentIndex, searchedVertexIndex, stack);
    }

    /**
     * Add Vertex
     */
    public void AddVertex(int value) {

        Vertex vertexForAdd = new Vertex(value);
        setToFirstEmptyIndex(vertexForAdd);
    }

    /**
     * Set vertex to first empty index
     *
     * @param vertexForAdd
     */
    public void setToFirstEmptyIndex(Vertex vertexForAdd) {

        for (int i = 0; i < max_vertex; i++) {
            if (vertex[i] == EMPTY) {
                vertex[i] = vertexForAdd;
                return;
            }
        }
    }


    /**
     * Remove Vertex
     */
    public void RemoveVertex(int v) {
        if (isValidIndex(v)) {
            vertex[v] = null;
            removeAllEdgesOfVertex(v);
        }
    }


    /**
     * Remove All Edges Of Vertex
     */
    public void removeAllEdgesOfVertex(int indexOfVertex) {
        for (int i = 0; i < max_vertex; i++) {
            RemoveEdge(indexOfVertex, i);
        }
    }

    /**
     * Is exist edge
     *
     * @param v1
     * @param v2
     * @return
     */
    public boolean IsEdge(int v1, int v2) {
        if (isValidIndex(v1) && isValidIndex(v2)) {
            return m_adjacency[v1][v2] == EXIST_EDGE;
        }
        return false;
    }

    /**
     * Add Edge
     */
    public void AddEdge(int v1, int v2) {
        if (isValidIndex(v1) && isValidIndex(v2)) {
            m_adjacency[v1][v2] = EXIST_EDGE;
            m_adjacency[v2][v1] = EXIST_EDGE;
        }
    }

    /**
     * Remove Edge
     */
    public void RemoveEdge(int v1, int v2) {
        if (isValidIndex(v1) && isValidIndex(v2)) {
            m_adjacency[v1][v2] = NOT_EXIST_EDGE;
            m_adjacency[v2][v1] = NOT_EXIST_EDGE;
        }
    }

    /**
     * Check it is valid index
     *
     * @param index
     * @return
     */
    private boolean isValidIndex(int index) {
        return index >= 0 && index < max_vertex;
    }
}