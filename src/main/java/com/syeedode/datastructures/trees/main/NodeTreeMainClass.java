package com.syeedode.datastructures.trees.main;

import com.syeedode.datastructures.trees.NodeForTree;

/**
 * Cracking the Coding Interview
 * Chapter 4: Trees and Graphs
 * pg: 242; Problem 4.2
 * <p>
 * Breath First Search: BFS
 */
public class NodeTreeMainClass {

    public static void main(String [] args) {
        int nodesInTree[] = new int[10];
        for(int n =0; n < nodesInTree.length; n++) {
            if(n!=5) {
                nodesInTree[n] = n + 1;
            }
        }

        NodeForTree tree = NodeForTree.createMinimumBSTFromArray(nodesInTree);

        System.out.println(tree);
    }

}
