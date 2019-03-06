package com.syeedode.acommonsencetoalgorithmdatastructure.trees;

import org.junit.Assert;

import java.util.Arrays;

import static java.lang.Integer.valueOf;

public abstract class AbstractTreeTest {
    protected TreeService<Integer> serice = new TreeService<>();
    protected NodeInTree<Integer> tree = new NodeInTree<>();
    protected TreeService<String> stringSerice = new TreeService<>();
    protected NodeInTree<String> stringTree = new NodeInTree<>();

    protected int ROOT_DATA_FIFTY                      = 50;
    protected int FIRST_NODE_TWENTYFIVE                = 25;
    protected int LESS_THAN_VALUE_NOT_EXIST_IN_NODE    =  3;
    protected int GREATER_THAN_VALUE_NOT_EXIST_IN_NODE = 91;

    protected void insertOneItemIntoTree() {
        tree = serice.insertData(ROOT_DATA_FIFTY, null);
    }

    protected void insertFirstTwoValues() {
        insertOneItemIntoTree();
        serice.insertData(FIRST_NODE_TWENTYFIVE, tree);
    }

    protected void buildFullTree() {
        insertFirstTwoValues();
        Arrays.stream(InsertionValueEnum.values())
                .forEach(enumVal -> serice.insertData(enumVal.getValue(),tree));
    }

    protected void assertRootNodeIsCorrect() {
        Assert.assertEquals(valueOf(ROOT_DATA_FIFTY), tree.data);
        Assert.assertNull(tree.right);
    }
}
