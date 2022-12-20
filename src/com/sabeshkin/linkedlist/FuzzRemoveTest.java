package com.sabeshkin.linkedlist;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FuzzRemoveTest {

    @FuzzTest(maxDuration = "5s")
    public void testRemoveNumberOne(FuzzedDataProvider data) {
        LinkedList linkedList = new LinkedList();
        Node node;
        int randomValue = 0;
        for (int i = 0; i < 10; i++){
            randomValue = data.consumeInt();
            node = new Node(randomValue);
            linkedList.addInTail(node);
        }
        assertEquals(
                true,
                linkedList.remove(randomValue));
    }
}
