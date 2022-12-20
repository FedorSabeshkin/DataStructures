package com.sabeshkin.linkedlist;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FuzzCountTest {

    @FuzzTest(maxDuration = "1m")
    void fuzzLinkedListCountTest(FuzzedDataProvider data) {
        int amountOfNode = data.consumeInt(0, 1_000);
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < amountOfNode; i++) {
            Node node = new Node(data.consumeInt());
            linkedList.addInTail(node);
        }
        assertEquals(amountOfNode, linkedList.count());
    }
}
