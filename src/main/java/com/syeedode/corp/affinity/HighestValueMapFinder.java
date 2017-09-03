package com.syeedode.corp.affinity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Prints the highestValue of maps
 * TODO: Make generic, currently prints <String, Integer>
 */
public class HighestValueMapFinder {
    public Map<List<String>, Integer> findHighestAffinity(Map<List<String>, Integer> listIntegerMap) {
        Map<List<String>, Integer> stringListMap = new HashMap<>();
        int maxInfiity = 0;
        for(List<String> site : listIntegerMap.keySet()){
            Integer currentAffinity = listIntegerMap.get(site);
            if(currentAffinity > maxInfiity) {
                maxInfiity = currentAffinity;
                stringListMap.clear();
                stringListMap.put(site, currentAffinity);
            } else if(currentAffinity == maxInfiity) {
                stringListMap.put(site, currentAffinity);
            }
        }
        return stringListMap;
    }
}
