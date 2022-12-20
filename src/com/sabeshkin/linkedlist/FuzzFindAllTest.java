package com.sabeshkin.linkedlist;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FuzzFindAllTest {

    @FuzzTest(maxDuration = "1m")
    void fuzzNewListAlwaysEmptyTest(FuzzedDataProvider data) {
        int number = data.consumeInt();
        LinkedList linkedList = new LinkedList();
        linkedList.addInTail(new Node(number));
        ArrayList<Node> foundNodes = linkedList.findAll(number);
        assertEquals(1, foundNodes.size());
    }
}
