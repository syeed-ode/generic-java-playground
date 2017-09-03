package com.syeedode.corp.affinity;

import com.sun.deploy.util.StringUtils;

import java.util.List;
import java.util.Map;

public class AffMapPrinter {

    HighestValueMapFinder highestValueFinder = new HighestValueMapFinder();

    public void printAffinityMap(Map<List<String>, Integer> stringListMap) {
        for(List<String> site : stringListMap.keySet()){
            System.out.println("Site(s): " + StringUtils.join(site,",")
                    + " - infinity: " + stringListMap.get(site));
        }
    }

    public void printHighestAffinity(Map<List<String>, Integer> listIntegerMap) {
        Map<List<String>, Integer> stringListMap = highestValueFinder.findHighestAffinity(listIntegerMap);
        for(List<String> site : stringListMap.keySet()){
            System.out.println("Highest affinity site: " + StringUtils.join(site,",")
                    + " - infinity: " + stringListMap.get(site));
        }
    }

}
