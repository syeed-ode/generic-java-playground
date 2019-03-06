package com.syeedode.acommonsencetoalgorithmdatastructure.trees.deletion;

import com.syeedode.acommonsencetoalgorithmdatastructure.trees.AbstractTreeTest;
import com.syeedode.acommonsencetoalgorithmdatastructure.trees.InsertionValueEnum;
import com.syeedode.acommonsencetoalgorithmdatastructure.trees.NodeInTree;
import org.junit.Test;

import static com.syeedode.acommonsencetoalgorithmdatastructure.trees.InsertionValueEnum.*;
import static java.lang.Integer.valueOf;
import static org.junit.Assert.*;

public class CommonSenseAlgorithmTreeDeletionTest extends AbstractTreeTest {

//    @Test
//    public void valueNotFoundInTree_ReturnsNull() {
//        insertFirstTwoValues();
//        NodeInTree nullNode = serice.deleteNode(LESS_THAN_VALUE_NOT_EXIST_IN_NODE, tree);
//
//        Assert.assertNull(nullNode);
//    }

    @Test
    public void noTreeExists_ReturnsNullWithNoExceptions(){
        NodeInTree<Integer> nullNode = serice.personalDeleteNode(LESS_THAN_VALUE_NOT_EXIST_IN_NODE, null);
        assertNull(nullNode);
    }

    @Test
    public void pd_oneItemInTreeDeleteOnlyItem_Success_ReturnNullTree() {
        insertOneItemIntoTree();
        assertEquals(valueOf(ROOT_DATA_FIFTY), tree.data);

        NodeInTree<Integer> nullTree =
                serice.personalDeleteNode(ROOT_DATA_FIFTY, tree);

        assertNull(nullTree);
    }

    @Test
    public void pd_twoItemsInTreeDeleteFirstItem_Success_ReturnLeftNode() {
        insertFirstTwoValues();
        assertEquals(valueOf(ROOT_DATA_FIFTY), tree.data);

        NodeInTree<Integer> nodeTwentyFive = serice.personalDeleteNode(ROOT_DATA_FIFTY, tree);

        assertNotNull(nodeTwentyFive);
        assertNotNull(nodeTwentyFive.data);
        assertEquals(valueOf(FIRST_NODE_TWENTYFIVE), nodeTwentyFive.data);
        assertEquals(nodeTwentyFive.data, tree.data);
    }

    @Test
    public void d_threeItemsInsertedDeleteTopNode() {
        insertFirstTwoValues();
        serice.insertData(SEVENTY_FIVE.getValue(),tree);
        serice.insertData(FIFTY_SIX.getValue(),tree);

        NodeInTree<Integer>  nodeToEevaluate = serice.deleteNode(ROOT_DATA_FIFTY,tree);

        assertNotNull(nodeToEevaluate);
    }

    NodeInTree<Integer> node = new NodeInTree<>();
    NodeInTree<Integer> nodeToDelete = new NodeInTree<>();

    @Test
    public void basecaseForLift() {
        node = serice.insertData(FIFTY_SIX.getValue(), node);
        insertFirstTwoValues();
        serice.insertData(SEVENTY_FIVE.getValue(),tree);
        serice.insertData(FIFTY_SIX.getValue(),tree);

        NodeInTree<Integer> baseCaseResult = serice.lift(node, tree);

        assertNull(baseCaseResult);
    }

//    @Test
//    public void pd_twoItemsInTreeDeleteSecondItem_ReturnsDeleteItem_AssureTreeHasOnlyOneItem() {
//        insertFirstTwoValues();
//        NodeInTree<Integer> deletedNode = serice.personalDeleteNode(FIRST_NODE_TWENTYFIVE, tree);
//        assertNotNull(deletedNode);
//    }
//
    @Test
    public void d_removeOnlyItemInTree_ReturnNull_AssureTreeHasNoNodesLeft() {
        insertOneItemIntoTree();

        NodeInTree<Integer> nullNode = serice.deleteNode(ROOT_DATA_FIFTY, tree);
        assertNull(nullNode);
        assertNotNull(tree);
        assertEquals(valueOf(ROOT_DATA_FIFTY), tree.data);
        assertNull(tree.left);
        assertNull(tree.right);
    }

    @Test
    public void d_removeFirstItemWithTwoItemsInTheTree_ReturnNull_AssureTreeHasOneNodeLeft() {
        insertFirstTwoValues();

        NodeInTree<Integer> oneNodeLeftNode = serice.deleteNode(ROOT_DATA_FIFTY, tree);
        assertNotNull(oneNodeLeftNode);
        assertNotNull(tree);
        assertEquals(valueOf(ROOT_DATA_FIFTY), tree.data);
        assertEquals(valueOf(FIRST_NODE_TWENTYFIVE), oneNodeLeftNode.data);
        assertNull(oneNodeLeftNode.left);
        assertNull(oneNodeLeftNode.right);
    }

    @Test
    public void d_removeFirstItemWithThreeItemsInTheTree_ReturnNull_AssureTreeHasNoNodesLeft() {
        insertFirstTwoValues();
        serice.insertData(SEVENTY_FIVE.getValue(),tree);

        NodeInTree<Integer> oneNodeLeftNode = serice.deleteNode(ROOT_DATA_FIFTY, tree);
        assertNotNull(oneNodeLeftNode);
        assertNotNull(tree);
        assertEquals(valueOf(FIRST_NODE_TWENTYFIVE), oneNodeLeftNode.left.data);
        assertEquals(SEVENTY_FIVE.getValue(), oneNodeLeftNode.data);
        assertNull(oneNodeLeftNode.left);
        assertNull(oneNodeLeftNode.right);
    }

    @Test
    public void d_removeFirstItemWithSixItemsInTheTree_ReturnNull_AssureTreeHasNoNodesLeft() {
        insertFirstTwoValues();
        serice.insertData(SEVENTY_FIVE.getValue(),tree);
        serice.insertData(EIGHTY_NINE.getValue(),tree);
        serice.insertData(FIFTY_SIX.getValue(),tree);
        serice.insertData(SIXTY_ONE.getValue(),tree);

        NodeInTree<Integer> oneNodeLeftNode = serice.deleteNode(ROOT_DATA_FIFTY, tree);
        assertNotNull(oneNodeLeftNode);
        assertNotNull(tree);
        assertEquals(valueOf(FIRST_NODE_TWENTYFIVE), oneNodeLeftNode.left.data);
        assertEquals(FIFTY_SIX.getValue(), oneNodeLeftNode.data);
        assertNotNull(oneNodeLeftNode.left);
        assertNotNull(oneNodeLeftNode.right);
    }

//
//    @Test
//    public void pd_oneItemInTreeGreaterThanNodeDoesNotExists_ReturnNull_AssureTreeHasOnlyOneItem() {
//        insertOneItemIntoTree();
//
//        NodeInTree<Integer> nullNode =
//                serice.personalDeleteNode(GREATER_THAN_VALUE_NOT_EXIST_IN_NODE, tree);
//        assertNull(nullNode);
//        assertNotNull(tree);
//        assertEquals(valueOf(ROOT_DATA_FIFTY), tree.data);
//        assertNull(tree.left);
//        assertNull(tree.right);
//    }
//

}
