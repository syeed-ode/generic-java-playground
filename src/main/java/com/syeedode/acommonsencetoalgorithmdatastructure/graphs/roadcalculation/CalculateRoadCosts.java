package com.syeedode.acommonsencetoalgorithmdatastructure.graphs.roadcalculation;

import com.syeedode.acommonsencetoalgorithmdatastructure.graphs.person.PersonService;

import java.util.Arrays;
import java.util.List;

public class CalculateRoadCosts {
    static int numTotalAvailableCities = 5;
    static int numTotalAvailableRoads = 5;
    static int numRoadsToBeRepaired = 3;

    public static void main(String [] args) {
        getMinimumCostToRepair(numTotalAvailableCities
                ,numTotalAvailableRoads
                , createConnectionList()
                , numRoadsToBeRepaired
                , createCostOfRoadsToBeRepaired());
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int getMinimumCostToRepair(int numTotalAvailableCities,
                               int numTotalAvailableRoads,
                               List<List<Integer>> roadsAvailable,
                               int numRoadsToBeRepaired,
                               List<List<Integer>> costRoadsToBeRepaired) {
        // {
        //    0   1   2   3   4   5
        //   {0,  0,  0,  0,  0,  0}
        //   {0,  0, 12,  0,  0,  8}
        //   {0, 12,  0,  0,  0,  0}
        //   {0,  0,  0,  0, 30,  0}
        //   {0,  0,  0, 30,  0,  0}
        //   {0,  8,  0,  0,  0,  0}
        // }
        // numTotalAvailableCities = 5
        // numTotalAvailableRoads = 5
        // roadsAvailable [[1,2], [2,3], [3, 4], [4, 5], [1, 5] ]
        // numRoadsToBeRepaired = 3
        // costRoadsToBeRepaired = [[1,2,12], [3,4,30], [1,5,8]]
        int maxWeight = determineMaximumWeight(costRoadsToBeRepaired);
        int costsOfEveryOtherConnectingNode = determineDefaultWeight(costRoadsToBeRepaired);
        int highestNodeId = determineMaximumNode(roadsAvailable, costRoadsToBeRepaired);
        int miniumNodeId = determineMinimumNode(roadsAvailable, costRoadsToBeRepaired);
        Integer[][] graph = buildGraph(highestNodeId, costsOfEveryOtherConnectingNode, roadsAvailable, costRoadsToBeRepaired);

        PersonService t = new PersonService(graph.length, true);
        Integer [] output = t.dijkstra(graph, miniumNodeId);
        String format = String.format("The shortest paths for source: {%d} is %s"
                , miniumNodeId
                , Arrays.asList(output), ",");
        System.out.println(format);
        int cheapestAdjustments = 0;
        for(Integer weight : output) {
            if(maxWeight > weight) {
                cheapestAdjustments += weight;
            }
        }
        return cheapestAdjustments;
    }

    private static Integer[][] buildGraph(int maxNode, int defaultCost, List<List<Integer>> connectedNodes, List<List<Integer>> roadsWithWeight) {
        Integer[][] graph = new Integer[maxNode+1][maxNode+1];
        for(List<Integer> roadConnection : connectedNodes) {
            graph[roadConnection.get(0)][roadConnection.get(1)] = defaultCost;
            graph[roadConnection.get(1)][roadConnection.get(0)] = defaultCost;
        }
        for(List<Integer> weightedRoad : roadsWithWeight) {
            graph[weightedRoad.get(0)][weightedRoad.get(1)] = weightedRoad.get(2);
            graph[weightedRoad.get(1)][weightedRoad.get(0)] = weightedRoad.get(2);
        }
        for(int currentVertex = 0; currentVertex < graph.length; currentVertex++) {
            for(int vertexUnderEval = 0; vertexUnderEval < graph[0].length; vertexUnderEval++) {
                if(graph[currentVertex][vertexUnderEval] == null) {
                    graph[currentVertex][vertexUnderEval] = 0;
                }
            }
        }
        return graph;
    }

    private static int determineDefaultWeight(List<List<Integer>> costRoadsToBeRepaired) {
        int totalCost = -1;
        for(List<Integer> roadAndCost : costRoadsToBeRepaired) {
            totalCost += roadAndCost.get(2);
        }

        return totalCost;
    }

    private static int determineMaximumWeight(List<List<Integer>> costRoadsToBeRepaired) {
        int totalCost = -1;
        for(List<Integer> roadAndCost : costRoadsToBeRepaired) {
            if(roadAndCost.get(2) > totalCost)
                totalCost = roadAndCost.get(2);
        }

        return totalCost;
    }

    private static int determineMinimumNode(List<List<Integer>> roadsAvailable, List<List<Integer>> costRoadsToBeRepaired) {
        int minimumNode = Integer.MAX_VALUE;
        for(List<Integer> roads : roadsAvailable) {
            if(minimumNode > roads.get(0)) {
                minimumNode = roads.get(0);
            }
            if(minimumNode > roads.get(1)) {
                minimumNode = roads.get(1);
            }
        }

        for(List<Integer> weightedRoads : costRoadsToBeRepaired) {
            if(minimumNode > weightedRoads.get(0)) {
                minimumNode = weightedRoads.get(0);
            }
            if(minimumNode > weightedRoads.get(1)) {
                minimumNode = weightedRoads.get(1);
            }
        }
        return minimumNode;
    }

    private static int determineMaximumNode(List<List<Integer>> roadsAvailable, List<List<Integer>> costRoadsToBeRepaired) {
        int maxiumNode = -1;
        for(List<Integer> roads : roadsAvailable) {
            if(maxiumNode < roads.get(0)) {
                maxiumNode = roads.get(0);
            }
            if(maxiumNode < roads.get(1)) {
                maxiumNode = roads.get(1);
            }
        }

        for(List<Integer> weightedRoads : costRoadsToBeRepaired) {
            if(maxiumNode < weightedRoads.get(0)) {
                maxiumNode = weightedRoads.get(0);
            }
            if(maxiumNode < weightedRoads.get(1)) {
                maxiumNode = weightedRoads.get(1);
            }
        }
        return maxiumNode;
    }

    private static List<List<Integer>> createCostOfRoadsToBeRepaired() {
        List<Integer> firstReparations = Arrays.asList(1, 2, 12);
        List<Integer> secondReparations = Arrays.asList(3, 4, 30);
        List<Integer> thirdReparations = Arrays.asList(1, 5, 8);
        return Arrays.asList(firstReparations, secondReparations, thirdReparations);
    }

    private static List<List<Integer>> createConnectionList() {
        List<Integer> firstConnection = Arrays.asList(1, 2);
        List<Integer> secondConnection = Arrays.asList(2, 3);
        List<Integer> thirdConnection = Arrays.asList(3, 4);
        List<Integer> fourthConnection = Arrays.asList(4, 5);
        List<Integer> fifthConnection = Arrays.asList(1, 5);
        return Arrays.asList(firstConnection
                , secondConnection, thirdConnection
                , fourthConnection, fifthConnection);
    }
}
