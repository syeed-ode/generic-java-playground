package com.syeedode.acommonsencetoalgorithmdatastructure.graphs;

import com.syeedode.acommonsencetoalgorithmdatastructure.graphs.cities.City;
import org.springframework.util.CollectionUtils;

import java.util.*;

import static java.util.Objects.nonNull;

public class DijkstraService {
    public static class CityRouter {
        private City city;
        private Integer price;

        private CityRouter(City city, Integer price) {
            this.city = city;
            this.price = price;
        }

        @Override
        public String toString() {
            return city + ", Price: " + price;
        }
    }

    public Map<City, CityRouter> dijkstra(City startingCity, City [] otherCities) {
        /**
         * cityRoutePriceTable
         *
         * This table holds all of the prices
         * from the given city to all other destinations
         * and the city it took to get there
         */
        Map<City, CityRouter> cityRoutePriceTable = new HashMap<>();

        /**
         * In our examples this will end up being:
         * {atlanta => [0, null], boston => [100, atlanta],
         *  chicago => [200, denver], denver => [160, atlanta],
         *  elPaso => [280, chicago]}
         */
        cityRoutePriceTable.put(startingCity, new CityRouter(startingCity, 0));

        // When initializing our data we set up all other cities
        // having an infinite cost - since the cost and teh path
        // to get to each other city is unknown
        for(City city : otherCities) {
            cityRoutePriceTable.put(city, new CityRouter(null, Integer.MAX_VALUE));
        }

        List<City> visitedCities = new ArrayList<>();
        City currentCity = startingCity;

        /**
         * This is the nuts and bolts of the algorithm.
         */
        while(nonNull(currentCity)) {
            // Add current city
            visitedCities.add(currentCity);

            for(City city : currentCity.routes.keySet()) {
                // If the route from the starting city to the
                // other city is cheaper than the currently
                // recorded in the cityRoutePriceTable table
                // we update it.
                Integer priceInfo = currentCity.routes.get(city);
                int currentCityPrice = priceInfo + cityRoutePriceTable.get(currentCity).price;
                if(cityRoutePriceTable.get(city).price > currentCityPrice) {
                    cityRoutePriceTable.get(city).price = currentCityPrice;
                    cityRoutePriceTable.get(city).city = city;
                }
            }

            // We determine which city to visit next
            currentCity = null;
            Integer cheapestRouteFromCurrentCity = Integer.MAX_VALUE;

            // We check all available routes
            for(City city : cityRoutePriceTable.keySet()) {
                CityRouter priceInfo = cityRoutePriceTable.get(city);

                // if this route is the cheapest from this city
                // and it has not yet been visited yet, it should
                // be marked as the city we'll visit next
                if(priceInfo.price < cheapestRouteFromCurrentCity && !visitedCities.contains(city)) {
                    cheapestRouteFromCurrentCity = priceInfo.price;
                    currentCity = city;
                }
            }
        }

        return cityRoutePriceTable;

    }

    private boolean isPriceUninitialized(Map<City, Map<City, Integer>> cityRoutePriceTable, City city) {
        Map<City, Integer> obj = cityRoutePriceTable.get(city);
        if(!CollectionUtils.isEmpty(obj)) {
            Set<City> set = obj.keySet();
            City value = set.stream().findFirst().get();
            return Objects.isNull(value) || Objects.isNull(obj.get(value));
        }
        return true;
    }
}
