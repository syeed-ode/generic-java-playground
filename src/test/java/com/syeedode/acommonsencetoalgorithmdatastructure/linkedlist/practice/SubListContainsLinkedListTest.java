package com.syeedode.acommonsencetoalgorithmdatastructure.linkedlist.practice;

import com.syeedode.acommonsencetoalgorithmdatastructure.linkedlist.LinkedList;
import com.syeedode.acommonsencetoalgorithmdatastructure.linkedlist.Node;
import org.junit.Assert;
import org.junit.Test;

import static com.syeedode.acommonsencetoalgorithmdatastructure.linkedlist.practice.StoryLinkedListEnum.*;

public class SubListContainsLinkedListTest {

    LinkedList<String> ignoredListForNow = new LinkedList<>(new Node("Once"));

    LinkedList<String> sublist;
    SubListContainsLinkedList<String> sublistContaingService =
            new SubListContainsLinkedList<String>(new Node(ONCE.valueOf()));



    @Test
    public void twoWordsContainsOneWordOnFirstTry_success() {
        setup();
        Assert.assertTrue(sublistContaingService.isSubList(sublist));
    }

    @Test
    public void twoWordsContainsOneWordOnSecondTry_success() {
        setupSecondWord();
        Assert.assertTrue(sublistContaingService.isSubList(sublist));
    }

    @Test
    public void twoWordsContainsBothWordOnSecondTry_success() {
        setup();
        sublist.insertValue(1,UPON.valueOf());
        Assert.assertTrue(sublistContaingService.isSubList(sublist));
    }

    @Test
    public void twoWordsContainsTwoWordButOnlySecondWordExists_assertFalse() {
        setup();
        sublist.insertValue(1,A.valueOf());
        Assert.assertFalse(sublistContaingService.isSubList(sublist));
    }

    @Test
    public void fourWordsContainsSecondTwoWords_success() {
        setUpFourWordSuccess();
        Assert.assertTrue(sublistContaingService.isSubList(sublist));
    }

    @Test
    public void fourWordsFirstWordMatchesButLastTwoReallyMatch_success() {
        jumbleUpWordBuytMatch();
        Assert.assertTrue(sublistContaingService.isSubList(sublist));
    }

    private void setup() {
        sublistContaingService.insertValue(1, UPON.valueOf());
        sublist = new LinkedList<>(new Node(ONCE.valueOf()));
    }

    private void setUpFourWordSuccess(){
        setup();
        sublistContaingService.insertValue(2, A.valueOf());
        sublistContaingService.insertValue(3, TIME.valueOf());
        sublist = new LinkedList<>(new Node(A.valueOf()));
        sublist.insertValue(1, TIME.valueOf());
    }

    private void setUpFourWordFailThenSuccess(){
        setup();
        sublistContaingService.insertValue(2, A.valueOf());
        sublistContaingService.insertValue(3, TIME.valueOf());
        sublist = new LinkedList<>(new Node(A.valueOf()));
        sublist.insertValue(1, TIME.valueOf());
    }
    private void setupSecondWord() {
        sublistContaingService.insertValue(1, UPON.valueOf());
        sublist = new LinkedList<>(new Node(UPON.valueOf()));
    }

    private void setupGoodFirstWordBadSecondGoodFourthNFifth() {
        sublistContaingService =
                new SubListContainsLinkedList<String>(new Node(A.valueOf()));
        sublistContaingService.insertValue(1, UPON.valueOf());
        sublistContaingService.insertValue(2, A.valueOf());
        sublistContaingService.insertValue(3, TIME.valueOf());
        sublist = new LinkedList<>(new Node(A.valueOf()));
        sublist.insertValue(1, TIME.valueOf());
    }

    private void jumbleUpWordBuytMatch() {
        sublistContaingService =
                new SubListContainsLinkedList<String>(new Node(ONCE.valueOf()));
        sublistContaingService.insertValue(1, UPON.valueOf());
        sublistContaingService.insertValue(2, A.valueOf());
        sublistContaingService.insertValue(3, ONCE.valueOf());
        sublistContaingService.insertValue(4, UPON.valueOf());
        sublistContaingService.insertValue(5, A.valueOf());
        sublistContaingService.insertValue(6, TIME.valueOf());
        sublistContaingService.insertValue(7, ONCE.valueOf());

        sublist = new LinkedList<>(new Node(ONCE.valueOf()));
        sublist.insertValue(1, UPON.valueOf());
        sublist.insertValue(2, A.valueOf());
        sublist.insertValue(3, TIME.valueOf());
    }
}
