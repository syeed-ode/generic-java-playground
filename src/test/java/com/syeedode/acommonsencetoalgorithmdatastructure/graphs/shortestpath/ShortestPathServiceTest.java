package com.syeedode.acommonsencetoalgorithmdatastructure.graphs.shortestpath;

import org.junit.Test;

public class ShortestPathServiceTest {
    ShortestPathService service = new ShortestPathService();

    @Test
    public void determineShortestPath_Success() {
        System.out.println("Hello ");
        service.determineShortestPath(nodesWithWeieght);
    }

    private int [][] nodesWithWeieght = { {0, 1, 4}
                                        , {0, 7, 8}
                                        , {1, 7, 11}
                                        , {8, 7, 7}
                                        , {2, 1, 8}
                                        , {2, 8, 2}
                                        };
}
