package com.syeedode.acommonsencetoalgorithmdatastructure.graphs.dijkstra;

// A Java program for Dijkstra's single source shortest path algorithm.
// The program is for adjacency matrix representation of the graph
import com.syeedode.acommonsencetoalgorithmdatastructure.graphs.person.PersonService;
import com.sun.deploy.util.StringUtils;



import java.util.*;
import java.lang.*;
import java.io.*;

class ShortestPath_2
{
    // A utility function to find the vertex with minimum distance value,
    // from the set of vertices not yet included in shortest path tree
    static final int V=9;
    int minDistance(int dist[], Boolean sptSet[]) // compares every vertex's minimum distance to that of every other node. Once the vertex with minimum distance has been determined, set it as the vertex being processed
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index=-1;
        // min = minium distance of all nodes left to be processed // min_index: vertex with the current minimum distance from source
        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    // A utility function to print the constructed distance array
    void printSolution(int dist[], int n)
    {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i+" tt "+dist[i]);
    }

    // Function that implements Dijkstra's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    // representation
    void dijkstra(int graph[][], int src)
    {
        // The output array. dist[i] will hold
        // the shortest distance from src to i
        int currentDistance[] = new int[V];

        // sptSet[i] will true
        // if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean sptSet[] = new Boolean[V];

        // Initialize all distances as INFINITE (i.e. no node has a minimum distance set)
        // stpSet[] as false [has the vertex's minimum distance been determined?]
        for (int i = 0; i < V; i++)
        {
            currentDistance[i] = Integer.MAX_VALUE; // indicates no path found from the source vertex to the current vertex being processed
            sptSet[i] = false;
        }

        // Distance of source vertex from itself is always 0
        // this is the most critical point. This assures that
        // minDistance() always references the vertex in question
        // i.e. source vertex
        currentDistance[src] = 0;

        // Find shortest path for all vertices // the numeric count is not used; it just assures we find the minimum distance V times
        for (int count = 0; count < V-1; count++)
        {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration. // establish which vertex is the current vertex being processed
            int u = minDistance(currentDistance, sptSet); // current vertex being processed

            // Mark the picked vertex as processed // confirm the shortest path for this vertex has been met
            sptSet[u] = true;

            // Update dist value of the **adjacent** vertices of the
            // establish vertex under evaluation // picked vertex.
            for (int v = 0; v < V; v++)

                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!sptSet[v]
                            // have we found the shortest path from source vertex to vertex under evaluation
                    && currentDistance[u] != Integer.MAX_VALUE
                        // do we have a path (connection) from the source vertex to the current vertex being processed // assures the current vertex being processed is available for processing
                    && graph[u][v]!=0
                            // does a path exists [is there a connection]? from current vertex being process to vertex under evaluation
                    && currentDistance[u]+graph[u][v] < currentDistance[v])
                            // takes the current distance from the source to the current vertex being processed (0 in first path)
                            // +
                            // distance from vertex being processed to vertex under evaluation
                            // <
                            // current distance of the vertex under evaluation (initially all vertexes
                            // except source are set to Infinity)
                {
                    currentDistance[v] = currentDistance[u] + graph[u][v]; // sets the current distance of the vertex under evaluation
                }
        }

        // print the constructed distance array
        printSolution(currentDistance, V);
    }

    // Driver method
    public static void main (String[] args)
    {
        /* Let us create the example graph discussed above */
//        int graph[][] = new int[][]{
//                {0,  4,  0,  0,  0,  0,  0,  8,  0},
//                {4,  0,  8,  0,  0,  0,  0, 11,  0},
//                {0,  8,  0,  7,  0,  4,  0,  0,  2},
//                {0,  0,  7,  0,  9, 14,  0,  0,  0},
//                {0,  0,  0,  9,  0, 10,  0,  0,  0},
//                {0,  0,  4, 14, 10,  0,  2,  0,  0},
//                {0,  0,  0,  0,  0,  2,  0,  1,  6},
//                {8, 11,  0,  0,  0,  0,  1,  0,  7},
//                {0,  0,  2,  0,  0,  0,  6,  7,  0}
//        };
//        ShortestPath_2 t = new ShortestPath_2();
//        t.dijkstra(graph, 0);
        Integer graph[][] = new Integer[][]{
              // 0   1   2   3   4   5   6   7   8
                {0,  4,  0,  0,  0,  0,  0,  5,  0},
                {4,  0,  8,  0,  0,  0,  0, 11,  0},
                {0,  8,  0,  7,  0,  1,  0,  0,  2},
                {0,  0,  7,  0,  9, 14,  0,  0,  0},
                {0,  0,  0,  9,  0, 10,  0,  0,  0},
                {0,  0,  1, 14, 10,  0,  2,  0,  0},
                {0,  0,  0,  0,  0,  2,  0,  1,  4},
                {5, 11,  0,  0,  0,  0,  1,  0,  7},
                {0,  0,  2,  0,  0,  0,  4,  7,  0}
        };
//        PersonService t = new PersonService(graph.length);
//        int sourceVertex = 1;
//        Integer [] output = t.dijkstra(graph, sourceVertex);
//        String format = String.format("The shortest paths for source: {%d} is %s"
//                , sourceVertex
//                , Arrays.asList(output), ",");
//        System.out.println(format);
//        List<Integer> collection = Arrays.asList(output);
//        System.out.println(collection);
        // StringUtils.join(collection,",");
    }
}
//This code is contributed by Aakash Hasija
