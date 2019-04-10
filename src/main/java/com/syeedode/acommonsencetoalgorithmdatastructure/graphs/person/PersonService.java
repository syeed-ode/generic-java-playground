package com.syeedode.acommonsencetoalgorithmdatastructure.graphs.person;

public class PersonService {

    private final int totalNumberofNodes;
    private final boolean bufferRequired;

    public PersonService(int totalNumberofNodes, boolean bufferNeeded) {
        bufferRequired = bufferNeeded;
        this.totalNumberofNodes = totalNumberofNodes;
    }

    public static void main(String [] args) {
        /* Let us create the example graph discussed above */
        Integer graph[][] = new Integer[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
//        PersonService t = new PersonService(graph.length);
//        int sourceVertex = 1;
//        t.dijkstra(graph, sourceVertex);

    }

    public Integer[] dijkstra(Integer[][] graph, int sourceVertex) {

        boolean hasVertexShortestPathBeenFound[] = new boolean[totalNumberofNodes];
        Integer currentDistanceFromSourceToVertex[] = new Integer[totalNumberofNodes];

        /**
         * set the current distance from the source vertex to every other vertex
         * to INFINITY.
         */
        initializeTables(hasVertexShortestPathBeenFound, currentDistanceFromSourceToVertex);

        /**
         * initializing the distance from the source vertex to itself to
         * zero. This assures it it the first node processed
         */
        currentDistanceFromSourceToVertex[sourceVertex] = 0;

        /**
         * begin cycling based upon number of vertexes. Vertex selection depends
         * upon obtaining the vertex with the minimal distance to the source
         * vertex -- NOT the count iterator
         */
        int cycles = bufferRequired ? totalNumberofNodes - 1 : totalNumberofNodes;
        for(int count=0; count < cycles; count++) {
            /**
             * To calculate the distance of any vertex to the source requires us to
             * start with the vertex that has the shortest distance
             */
            int currentVertexBeingProcessed = minimumDistanceFromSource(
                      hasVertexShortestPathBeenFound
                    , currentDistanceFromSourceToVertex);
            hasVertexShortestPathBeenFound[currentVertexBeingProcessed] = true;

            for(int vertexUnderEvaluation=0; vertexUnderEvaluation < totalNumberofNodes; vertexUnderEvaluation++) {

                if(        ! hasVertexShortestPathBeenFound[vertexUnderEvaluation]
                        && currentDistanceFromSourceToVertex[currentVertexBeingProcessed] != Integer.MAX_VALUE
                        && graph[currentVertexBeingProcessed][vertexUnderEvaluation] != 0
                        && (currentDistanceFromSourceToVertex[currentVertexBeingProcessed]
                            + graph[currentVertexBeingProcessed][vertexUnderEvaluation]
                            < currentDistanceFromSourceToVertex[vertexUnderEvaluation]))
                {
                    currentDistanceFromSourceToVertex[vertexUnderEvaluation] =
                            currentDistanceFromSourceToVertex[currentVertexBeingProcessed]
                            + graph[currentVertexBeingProcessed][vertexUnderEvaluation];
                }
            }

        }

        return currentDistanceFromSourceToVertex;
    }

    private int minimumDistanceFromSource(boolean[] hasVertexShortestPathBeenFound, Integer[] currentDistanceFromSourceToVertex) {
        int shortestDietanceForAllVertexes = Integer.MAX_VALUE;
        int vertexMinimumDistanceToSource = -1;
        for(int vertex=0; vertex < totalNumberofNodes; vertex++) {
            if(hasVertexShortestPathBeenFound[vertex] == false
                    && currentDistanceFromSourceToVertex[vertex] < shortestDietanceForAllVertexes){
                shortestDietanceForAllVertexes = currentDistanceFromSourceToVertex[vertex];
                vertexMinimumDistanceToSource = vertex;
            }
        }
        return vertexMinimumDistanceToSource;
    }


    private void initializeTables(boolean[] shortestPathTable, Integer[] distanceTable) {
        for(int vertex = 0; vertex < totalNumberofNodes; vertex++) {
            shortestPathTable[vertex] = false;
            distanceTable[vertex] = Integer.MAX_VALUE;
        }
    }
}
