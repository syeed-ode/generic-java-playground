package com.syeedode.acommonsencetoalgorithmdatastructure.graphs.shortestpath;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class Node {
    private String name;
    private Map<String, Integer> weightNodeMap = new HashMap<>();
    private Map<String, Node> adjancentNodeMap = new HashMap<>();

    public Node(String nodeName) {
        name = nodeName;
    }

    public Node addConnection(Node node, int weight) {
        if(!weightNodeMap.containsKey(node.getName())) {
            weightNodeMap.put(node.getName(), weight);
            adjancentNodeMap.put(node.getName(), node);
        }
        return adjancentNodeMap.get(node.getName());
    }

    @Override
    public String toString() {
        return "Node@" + Integer.toHexString(hashCode()) + "["
                + "name: " + getName()
                + ", connections: "
//                + weightNodeMap.keySet()
//                    .stream()
//                    .map(key -> key
//                            + "->"
//                            + weightNodeMap.get(key)).collect(toList())
                + StringUtils.join(weightNodeMap)
                ;
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getWeightNodeMap() {
        return weightNodeMap;
    }
}
