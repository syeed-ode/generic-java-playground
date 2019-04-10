package com.syeedode.acommonsencetoalgorithmdatastructure.graphs.dependencies;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class Project {
    private ArrayList<Project> nodesDependingUponThisProjectToBeBuiltFirst = new ArrayList<>();
    private HashMap<String, Project> hasBasedProjectBeenProcessedMap = new HashMap<>(); // has child Already been processed hasBasedProjectBeenProcessedMap
    private String name;                                    // has base class for this dependency already
    private int dependencies = 0;                           // been processed
                                                            // weight would go here because the hasBasedProjectBeenProcessedMap only
    public Project(String n) {
        name = n;
    }                  // tracks

    // this project's base class
    // [ "this" is the dependency project ]
    // neighbor is dependent upon this project
    // to be build first
    public void addNeighbor(Project node) {
        if(!hasBasedProjectBeenProcessedMap.containsKey(node.getName())) {
            nodesDependingUponThisProjectToBeBuiltFirst.add(node);
            hasBasedProjectBeenProcessedMap.put(node.getName(), node);
            node.incrementDependencies();
        }
    }

    public void incrementDependencies() { dependencies++; }

    public void decrementDependencies() { dependencies--; }

    public ArrayList<Project> getNodesDependingUponThisProjectToBeBuiltFirst() {
        return nodesDependingUponThisProjectToBeBuiltFirst;
    }

    public String getName() {
        return name;
    }

    public int getDependencies() {
        return dependencies;
    }

    @Override
    public String toString() {
        return "Project@"+ Integer.toHexString(hashCode())
                + "[" + getName()
                + ", dependencies: " + getDependencies()
                + ", numProjectsDependentUponThisProject: " + getNodesDependingUponThisProjectToBeBuiltFirst().size()
                + ", nodesDependingUponThisProjectToBeBuiltFirst: " + StringUtils.join(getNodesDependingUponThisProjectToBeBuiltFirst())
                + "]";
    }
}
