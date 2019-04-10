package com.syeedode.acommonsencetoalgorithmdatastructure.graphs.cities;

import java.util.*;

import static java.util.Objects.nonNull;

public class City {
    public String name;
    public Map<City, Integer> routes = new HashMap<>();

    public City(String name) {
        this.name = name;
    }

    public void addRoute(City city, Integer price) {
        if(routes.containsKey(city)) {
            routes.replace(city, price);
        } else {
            routes.put(city, price);;
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object dat) {
        City that = (City) dat;
        return this.name.equalsIgnoreCase(that.name);
    }

    @Override
    public int hashCode() {
        /** Fix ME */
        System.out.println("This is name: " + name);
        Arrays.asList(name.toCharArray())
                .stream().forEach(c -> System.out.println(c));
        return 7 * 19;
    }
}
