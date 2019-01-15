package com.syeedode.generics;

import java.util.*;

public class GenericsMain {

    public static void main(String [] args) {
        Map<String, List<String>> userSiteMap = new HashMap<>();
        List<String> ap42Sites = Arrays.asList("yahoo","google","tweeter");
        String ap42 = "ap42";
        userSiteMap.put(ap42,ap42Sites);

//        for(String site : userSiteMap.get(ap42)) {
//            boolean foundOnce = false;
//            String siteCombination = new String();
//            for(String secondSite : userSiteMap.get(ap42)) {
//                if(!site.equals(secondSite) || (site.equals(secondSite) && foundOnce)) {
//                    if(secondSite.charAt(0) > site.charAt(0)) {
//                        siteCombination = secondSite + site;
//                    } else {
//                        siteCombination = secondSite + site;
//                    }
//                } else if(site.equals(secondSite) && !foundOnce) {
//                    foundOnce = true;
//                }
//            }
//        }
        GenericsMain program = new GenericsMain();
//        List<Character>
        // program.GeneratePermutations(ap42Sites, result, 3, );
    }

    void GeneratePermutations(List<List<Character>> Lists, List<String> result, int depth, String current)
    {
        if(depth == Lists.size())
        {
            result.add(current);
            return;
        }

        for(int i = 0; i < Lists.get(depth).size(); ++i)
        {
            GeneratePermutations(Lists, result, depth + 1, current + Lists.get(depth).get(i));
        }
    }
}
