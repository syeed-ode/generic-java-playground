package com.syeedode.acommonsencetoalgorithmdatastructure.graphs.shortestpath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<String, Node> nodeCreationTrackingMap = new HashMap<>();

    public Node getOrCreateNode(String nodeAName) {
        if(!nodeCreationTrackingMap.containsKey(nodeAName)) {
            nodeCreationTrackingMap.put(nodeAName, new Node(nodeAName));
        }
        return nodeCreationTrackingMap.get(nodeAName);
    }

    public Map<String, Node> getNodeCreationTrackingMap() {
        return nodeCreationTrackingMap;
    }
}
