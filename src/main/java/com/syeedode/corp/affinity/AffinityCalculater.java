package com.syeedode.corp.affinity;

import java.util.*;

public class AffinityCalculater {

    // private AffMapPrinter printer = new AffMapPrinter();

    private final Map<String,Integer> siteAffinityCounter = new HashMap<>();
    private final Map<String,List<String>> userSiteMap = new HashMap<>();
    private final Set<String> siteSet = new HashSet<>();
    private final Map<List<String>,Integer> affinityMap = new HashMap<>();

    public Map<List<String>,Integer> calculateAffinity(List<Affinity> affinityList) {
        buildUserSiteListHash(affinityList);
        calculateAffinity();
        return affinityMap;
    }

    private void buildUserSiteListHash(List<Affinity> affinities)  {
        if(Objects.nonNull(affinities) && !affinities.isEmpty()) {
            for(Affinity a : affinities) {
                List<String> userSiteList = userSiteMap.get(a.getUser());
                if(Objects.isNull(userSiteList)){
                    userSiteList = new ArrayList<>();
                }
                siteSet.add(a.getSite());
                userSiteList.add(a.getSite());
                userSiteMap.put(a.getUser(),userSiteList);
            }
        }
    }

    private Map<String,Integer> calculateAffinity() {
        Set<String> usersAlreadyChecked = new HashSet<>();
        for(String  baseUser : userSiteMap.keySet()) {
            for(String compareToUser : userSiteMap.keySet()) {
                if(!usersAlreadyChecked.contains(compareToUser)){
                    List<String> matchingSite = userSiteMap.get(baseUser);
                    List<String> otherSiteList = userSiteMap.get(compareToUser);
                    List<List<String>> siteForAffChecking = buildAffinitySearchList(matchingSite);
                    calculateAffinityForEachSearchList(siteForAffChecking, otherSiteList);
                    // printer.printAffinityMap(affinityMap);
                }
            }
            usersAlreadyChecked.add(baseUser);
        }
        return siteAffinityCounter;
    }

    private void calculateAffinityForEachSearchList(List<List<String>> siteForAffChecking, List<String> compareToSite) {
        boolean allSitesFound = false;
        for(List<String> affinitySite : siteForAffChecking) {
            for(String individualSite : affinitySite) {
                if(compareToSite.contains(individualSite)) {
                    allSitesFound = true;
                } else {
                    allSitesFound = false;
                    break;
                }
            }
            if(allSitesFound){
                populateFoundSiteAffinity(affinityMap, affinitySite);
            }
        }
    }

    private void populateFoundSiteAffinity(Map<List<String>, Integer> affinityMap, List<String> affinitySite) {
        if(affinityMap.containsKey(affinitySite)){
            Integer i = affinityMap.get(affinitySite);
            i++;
            affinityMap.put(affinitySite,i);
        } else {
            affinityMap.put(affinitySite,1);
        }
    }

    private List<List<String>> buildAffinitySearchList(List<String> evaluationSite) {
        List<List<String>> siteEvaluationList = new ArrayList<>();
        siteEvaluationList.add(evaluationSite);
        for(int i = 0; i < evaluationSite.size(); i++) {
            siteEvaluationList.add(Arrays.asList(evaluationSite.get(i)));
            List<String> siteBuilder = new ArrayList<>();
            for(int j = evaluationSite.size() - 1; j >= 0; j--){
                if(i!=j){
                    siteBuilder.add(evaluationSite.get(j));
                }
            }
            if(!siteBuilder.isEmpty()) {
                siteEvaluationList.add(siteBuilder);
            }
        }
        return siteEvaluationList;
    }

    private String highestAffinity() {
        Integer max = -1, temp;
        String site = new String();
        StringBuffer sb = new StringBuffer();
        for(String s : siteAffinityCounter.keySet()) {
            temp = siteAffinityCounter.get(s);
            if(temp > max) {
                max = temp;
                site = s;
            } else if (temp == max) {
                sb.append(s + "," + site);
                site = sb.toString();
            }
        }
        return site;
    }
}
