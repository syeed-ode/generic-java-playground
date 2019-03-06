package com.syeedode.acommonsencetoalgorithmdatastructure.linkedlist;

import com.syeedode.acommonsencetoalgorithmdatastructure.linkedlist.LinkedList.LinkedListResultSet;
import org.junit.Assert;
import org.junit.Test;

public class CommonSenseAlgorithmLinkedListDemoTest {

    private static final int ZEROth_INDEX = 0;
    private static final int FIRST_INDEX = 1;
    private static final int SECOND_INDEX = 2;

    private Node<String> node1 = new Node<>("once");
    private Node<String> node2 = new Node<>("upon");
    private Node<String> node3 = new Node<>("a");
    private LinkedList<String> linkedList = new LinkedList<>(node1);

    private static final String insertionItem = "timeAgain";
    public static final String middleInsertionItem = "uponAgain";
    private static final String initialInsertionItem = "onceAgain";
    private Node<String> firstNodeForInsertion = new Node<>(initialInsertionItem);
    private LinkedList<String> linkedListForInsertion = new LinkedList<>(firstNodeForInsertion);


    private void setUpLinkedList() {
        node1.next = node2;
        node2.next = node3;
    }

    @Test
    public void readPositionItemFromLinkList_ValueFound() {
        setUpLinkedList();
        int readingItem = 2;
        LinkedListResultSet<String> readResult = linkedList.read(readingItem);
        Assert.assertEquals(2, readResult.getIndex());
        Assert.assertEquals("a", readResult.getAnswerNode().data);
    }

    @Test
    public void readPositionItemFromLinkedList_PostionNotFound() {
        setUpLinkedList();
        int readingItem = 6;
        LinkedListResultSet<String> readResult = linkedList.read(readingItem);
        Assert.assertNull(readResult);
    }

    @Test
    public void searchValueItemsInLinkedList_ValuesFound() {
        setUpLinkedList();
        String searchingItem = "once";
        LinkedListResultSet<String> searchResult = linkedList.search(searchingItem);
        Assert.assertEquals(searchingItem, searchResult.getAnswerNode().data);
        Assert.assertEquals(ZEROth_INDEX, searchResult.getIndex());

        searchingItem = "a";
        searchResult = linkedList.search(searchingItem);
        Assert.assertEquals(searchingItem, searchResult.getAnswerNode().data);
        Assert.assertEquals(SECOND_INDEX, searchResult.getIndex());
    }

    @Test
    public void searchValueItemInLinkedList_ValueNotFound() {
        setUpLinkedList();
        String searchingItem = "time";
        LinkedListResultSet<String> searchResult = linkedList.search(searchingItem);
        Assert.assertNull(searchResult);
    }

    @Test
    public void insertValueAtEndOfLinkedList_Success() {
        insertOneItemAtEndOfLinkedList();

        LinkedListResultSet<String> time = linkedListForInsertion.read(FIRST_INDEX);
        Assert.assertEquals(insertionItem, time.getAnswerNode().data);

        LinkedListResultSet<String> once = linkedListForInsertion.read(ZEROth_INDEX);
        Assert.assertEquals(initialInsertionItem, once.getAnswerNode().data);

        Assert.assertEquals(SECOND_INDEX, linkedListForInsertion.numberOfNodesInTheList());
    }

    @Test
    public void insertValueInTheMiddleOfLinkedList() {
        insertThreeItemsIntoList();

        LinkedListResultSet<String> once = linkedListForInsertion.read(ZEROth_INDEX);
        Assert.assertEquals(initialInsertionItem, once.getAnswerNode().data);

        LinkedListResultSet<String> upon = linkedListForInsertion.read(FIRST_INDEX);
        Assert.assertEquals(middleInsertionItem, upon.getAnswerNode().data);

        LinkedListResultSet<String> time = linkedListForInsertion.read(SECOND_INDEX);
        Assert.assertEquals(insertionItem, time.getAnswerNode().data);
    }

    @Test
    public void deleteIndexFromMiddleOfTheList() {
        insertThreeItemsIntoList();

        linkedListForInsertion.deleteValue(1);

        LinkedListResultSet<String> time = linkedListForInsertion.read(FIRST_INDEX);
        Assert.assertEquals(insertionItem, time.getAnswerNode().data);

        Assert.assertEquals(SECOND_INDEX, linkedListForInsertion.numberOfNodesInTheList());
    }

    private void insertThreeItemsIntoList() {
        insertOneItemAtEndOfLinkedList();

        linkedListForInsertion.insertValue(ZEROth_INDEX, middleInsertionItem);
    }

    private void insertOneItemAtEndOfLinkedList() {
        linkedListForInsertion.insertValue(FIRST_INDEX, insertionItem);
    }

}
