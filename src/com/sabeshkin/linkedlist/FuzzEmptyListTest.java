package com.sabeshkin.linkedlist;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FuzzEmptyListTest {

    @FuzzTest(maxDuration = "5s")
    void fuzzNewListAlwaysEmptyTest(FuzzedDataProvider data) {
        int index = data.consumeInt();
        LinkedList linkedList = new LinkedList();
        ArrayList<Node> foundNodes = linkedList.findAll(index);
        assertEquals(0, foundNodes.size());
    }
}
