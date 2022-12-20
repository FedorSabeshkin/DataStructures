package com.sabeshkin.linkedlist;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FuzzRemoveAllTest {

    @FuzzTest(maxDuration = "1m")
    public void testRemoveAll(FuzzedDataProvider data) {
        LinkedList linkedList = new LinkedList();
        Node node;
        int randomValue = data.consumeInt();
        for (int i = 0; i < 10; i++){
            node = new Node(randomValue);
            linkedList.addInTail(node);
        }
        linkedList.removeAll(randomValue);
        assertEquals(
                0,
                linkedList.count());
    }
}
