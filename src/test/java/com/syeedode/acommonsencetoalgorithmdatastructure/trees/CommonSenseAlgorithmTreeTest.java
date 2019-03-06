package com.syeedode.acommonsencetoalgorithmdatastructure.trees;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static com.syeedode.acommonsencetoalgorithmdatastructure.trees.InsertionValueEnum.*;
import static java.lang.Integer.valueOf;

public class CommonSenseAlgorithmTreeTest extends AbstractTreeTest{

    @Test
    public void insertOneItem_Success() {
        insertOneItemIntoTree();

        assertRootNodeIsCorrect();
    }

    @Test
    public void insertTwoItems_Success() {
        insertFirstTwoValues();

        assertRootNodeIsCorrect();
        Assert.assertEquals(valueOf(FIRST_NODE_TWENTYFIVE), tree.left.data);
    }

    @Test
    public void insertLeftSideOfEnum_Success() {
        buildFullTree();
    }

    @Test
    public void searchForSpecificValue_ValueFound() {
        buildFullTree();
        Integer expectedValue = FIFTY_SIX.getValue();
        Integer expectedLeft  = FIFTY_TWO.getValue();
        Integer expectedRight = SIXTY_ONE.getValue();
        NodeInTree<Integer> actualNode = serice.searchData(expectedValue, tree);

        Assert.assertEquals(expectedValue, actualNode.data);
        Assert.assertEquals(expectedLeft, actualNode.left.data);
        Assert.assertEquals(expectedRight, actualNode.right.data);
    }
}
