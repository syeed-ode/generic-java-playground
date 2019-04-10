package com.syeedode.acommonsencetoalgorithmdatastructure.graphs.dependencies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {

    private HashMap<String, Project> projectListings = new HashMap<>();
    private List<Project> nodes = new ArrayList<>();

    public Project getOrCreateNode(String projectName) {
        if(!projectListings.containsKey(projectName)) {
            Project node = new Project(projectName);
            nodes.add(node);
            projectListings.put(projectName, node);
        }

        return projectListings.get(projectName);
    }

    public void addEdge(String dependency, String basedProject) {
        Project start = getOrCreateNode(dependency);
        Project end = getOrCreateNode(basedProject);
        start.addNeighbor(end);
    }

    public List<Project> getNodes() {
        return nodes;
    }
}
