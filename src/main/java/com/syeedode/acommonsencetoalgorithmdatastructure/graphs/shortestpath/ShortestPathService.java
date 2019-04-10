package com.syeedode.acommonsencetoalgorithmdatastructure.graphs.shortestpath;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ShortestPathService {


    public int determineShortestPath(int [][] graphNodesAndWeights) {
        Graph graph = buildGraph(graphNodesAndWeights);
        Map<String, Integer> shortestPathMap = constructShortestPathMap(graph);
        return 0;
    }

    private Graph buildGraph(int[][] graphStructure) {
        Graph graph = new Graph();
        for(int [] nodeWithWeight : graphStructure) {
            String nodeAName = String.valueOf(nodeWithWeight[0]);
            String nodeBName = String.valueOf(nodeWithWeight[1]);
            int weight = nodeWithWeight[2];
            Node nodeA = graph.getOrCreateNode(nodeAName);
            Node nodeB = graph.getOrCreateNode(nodeBName);
            nodeA.addConnection(nodeB, weight);
            nodeB.addConnection(nodeA, weight);
        }
        return graph;
    }

    private Map<String, Integer> constructShortestPathMap(Graph graph) {
        Map<String, Map<String, Integer>> nodeWeightMap = new HashMap<>();
        Set<String> allNodeNames = graph.getNodeCreationTrackingMap().keySet();

        for(String currentNode : allNodeNames) {
            if(!nodeWeightMap.containsKey(currentNode)) {

            }
        }
        return null;
    }
}
