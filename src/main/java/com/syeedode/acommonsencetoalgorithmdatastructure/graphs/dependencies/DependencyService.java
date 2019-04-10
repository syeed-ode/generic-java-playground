package com.syeedode.acommonsencetoalgorithmdatastructure.graphs.dependencies;

import java.util.List;
import java.util.Objects;

public class DependencyService {
    public Project[] findBuildOrder(String [] projects, String [][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
        // return orderProjects(graph.getNodes());
    }

    private Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        addAllProjectsToGraph(projects, graph);

        createEdgesForGraph(dependencies, graph);
        return graph;
    }

    private void addAllProjectsToGraph(String[] projects, Graph graph) {
        for(String project : projects) {
            graph.getOrCreateNode(project);
        }
    }

    private void createEdgesForGraph(String[][] dependencies, Graph graph) {
        for(String [] dependency : dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }
    }

    private Project[] orderProjects(List<Project> projects) {
        Project[] buildOrderArray = new Project[projects.size()];

        // Add 'roots' to the build order first
        int orderArrayIndex = addNonDependent(buildOrderArray, projects, 0);

        int toBeProecessed = 0;
        while(toBeProecessed < buildOrderArray.length) {
            Project current = buildOrderArray[toBeProecessed];

            // this indicates there are no more projects with zero
            // dependencies. Therefore there must be circular
            // dependencies.
            if(Objects.isNull(current)) {
                return null;
            }

            // Remove me as a dependency
            List<Project> children = current.getNodesDependingUponThisProjectToBeBuiltFirst();
            for(Project child : children) {
                child.decrementDependencies();
            }

            orderArrayIndex = addNonDependent(buildOrderArray, children, orderArrayIndex);
            toBeProecessed++;
        }
        return buildOrderArray;
    }
                //(buildOrderList,
    private int addNonDependent(Project[] projectArray, List<Project> projectList, int offset) {
        for(Project project : projectList) {
            // Once a project has no dependencies
            // add to the build order list
            if(project.getDependencies() == 0) {
                projectArray[offset] = project;
                offset++;
            }
        }
        return offset;
    }
}
