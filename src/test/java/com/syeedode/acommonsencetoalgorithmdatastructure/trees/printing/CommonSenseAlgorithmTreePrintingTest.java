package com.syeedode.acommonsencetoalgorithmdatastructure.trees.printing;

import com.syeedode.acommonsencetoalgorithmdatastructure.trees.AbstractTreeTest;
import com.syeedode.acommonsencetoalgorithmdatastructure.trees.TraverseAndOrderPrintService;
import org.junit.Test;

import static com.syeedode.acommonsencetoalgorithmdatastructure.trees.StringInsertionEnum.*;

public class CommonSenseAlgorithmTreePrintingTest extends AbstractTreeTest {
    TraverseAndOrderPrintService<String> printService = new TraverseAndOrderPrintService<>();
    @Test
    public void printOneNodeTree() {
        stringTree = stringSerice.insertData(MOBY.valueOf(), stringTree);

        printService.personalOrderedTraverseTreeAndPrint(stringTree);
    }

    @Test
    public void printFourNodeTree() {
        stringTree = stringSerice.insertData(MOBY.valueOf(), stringTree);
        stringTree = stringSerice.insertData(GREAT.valueOf(), stringTree);
        stringTree = stringSerice.insertData(ROBBY.valueOf(), stringTree);
        stringTree = stringSerice.insertData(ALICE.valueOf(), stringTree);

        printService.personalOrderedTraverseTreeAndPrint(stringTree);
    }

    @Test
    public void printThreeNodeTreeWithDifferentOrder() {
        stringTree = stringSerice.insertData(MOBY.valueOf(), stringTree);
        stringTree = stringSerice.insertData(ALICE.valueOf(), stringTree);
        stringTree = stringSerice.insertData(ROBBY.valueOf(), stringTree);
        stringTree = stringSerice.insertData(GREAT.valueOf(), stringTree);

        printService.personalOrderedTraverseTreeAndPrint(stringTree);
    }
}
