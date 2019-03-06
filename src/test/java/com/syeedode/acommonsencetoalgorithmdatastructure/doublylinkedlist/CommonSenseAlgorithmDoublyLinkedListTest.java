package com.syeedode.acommonsencetoalgorithmdatastructure.doublylinkedlist;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.springframework.util.Assert;
import sun.jvm.hotspot.debugger.windbg.DLL;

public class CommonSenseAlgorithmDoublyLinkedListTest {

    private DoublyLinkedList<String> emptyLinkedList = new DoublyLinkedList<>();

    private static final String ONCE = "once";
    private static final String UPON = "upon";
    private static final String A    = "a";
    private static final String TIME = "time";

    @Test
    public void insertOneItemIntoEmptyList() {
        emptyLinkedList.insertAtEndOfDoublyLinkedList(ONCE);
        Assert.notNull(emptyLinkedList);
    }

    @Test
    public void deleteFirstItemInList() {
        insertFourItemsIntoTheList();
        NodeForDoubly<String> removedNode = emptyLinkedList.removeFromFrontOfDoublyLinkedList();
        assertEquals(ONCE, removedNode.data);
    }

    private void insertFourItemsIntoTheList() {
        emptyLinkedList.insertAtEndOfDoublyLinkedList(ONCE);
        emptyLinkedList.insertAtEndOfDoublyLinkedList(UPON);
        emptyLinkedList.insertAtEndOfDoublyLinkedList(A);
        emptyLinkedList.insertAtEndOfDoublyLinkedList(TIME);
    }
}
