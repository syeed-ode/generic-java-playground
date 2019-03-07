package com.syeedode.acommonsencetoalgorithmdatastructure.trees;

import java.util.Objects;

import static com.syeedode.acommonsencetoalgorithmdatastructure.trees.TreeService.nodeNotValid;

public class TraverseAndOrderPrintService<T extends Comparable<T>> {

    public void personalOrderedTraverseTreeAndPrint(NodeInTree<T> tree) {
        if(nodeNotValid(tree)) {
            return;
        }

        if(Objects.isNull(tree.left) && Objects.isNull(tree.right)) {
            System.out.println(tree.data);
        } else {
            personalOrderedTraverseTreeAndPrint(tree.left);
            System.out.println(tree.data);
            personalOrderedTraverseTreeAndPrint(tree.right);
        }
    }
}
