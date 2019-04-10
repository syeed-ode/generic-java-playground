package com.syeedode.acommonsencetoalgorithmdatastructure.graphs.cities;

import com.syeedode.acommonsencetoalgorithmdatastructure.graphs.DijkstraService;
import com.syeedode.acommonsencetoalgorithmdatastructure.graphs.DijkstraService.CityRouter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CityTest {

    City atlanta = new City("Atlanta");
    DijkstraService service = new DijkstraService();
    City [] otherCities;


    @Test
    public void addRoute_Success() {
        setUpGraph();
        Map<City, CityRouter> output = service.dijkstra(atlanta, otherCities);
        output.keySet().stream()
                .forEach(a -> System.out.println("#CityRouter: " + output.get(a)));
    }

    private void setUpGraph() {
        City boston = new City("Boston");
        City chicago = new City("Chicago");
        City denver = new City("Denver");
        City elPaso = new City("El Paso");

        atlanta.addRoute(boston, 100);
        atlanta.addRoute(denver, 160);
        boston.addRoute(chicago, 120);
        boston.addRoute(denver, 180);
        chicago.addRoute(elPaso, 80);
        denver.addRoute(chicago, 40);
        denver.addRoute(elPaso, 140);

        otherCities = new City [] {boston, chicago, denver, elPaso};
    }
}
