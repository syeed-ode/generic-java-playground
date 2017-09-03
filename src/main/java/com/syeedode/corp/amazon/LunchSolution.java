package com.syeedode.corp.amazon;

import java.util.*;

/**
 * Amazon Interview
 * <p>
 * Author: syeedode
 * Date: 5/29/17
 */
public class LunchSolution {

    public String[][] matchLunches(String[][] lunchMenuPairs,
                                   String[][] teamCuisinePreference) {
        String [] [] pairings = new String[teamCuisinePreference.length][lunchMenuPairs.length];
        for(int person = 0; person < teamCuisinePreference.length;person++) {
            StringBuffer sb = new StringBuffer();
            for(int lunchOptions = 0; lunchOptions < lunchMenuPairs.length;lunchOptions++){
                if(teamCuisinePreference[person][1].equals(lunchMenuPairs[lunchOptions][1]) || teamCuisinePreference[person][1].equals("*")) {
                    pairings[person][0] = teamCuisinePreference[person][0];
                    sb.append(lunchMenuPairs[lunchOptions][1] + ",");
                }
            }
            pairings[person][1] = sb.deleteCharAt(sb.length()-1).toString();
        }
        return pairings;
    }

    public String[][] matchLunche(String[][] lunchMenuPairs,
                                   String[][] teamCuisinePreference) {
        String [] [] pairings;
        Map<String, String> entreeCuisineHash = convertFromArrayToMap(lunchMenuPairs);
        Map<String, String> employeeCuisineHash = convertFromArrayToMap(teamCuisinePreference);
        Map<String, String> employeeEntryHash = findCuisineCorrelation(entreeCuisineHash,employeeCuisineHash);
        pairings = convertFromHashToArray(employeeEntryHash);
        return pairings;
    }

    private String[][] convertFromHashToArray(Map<String, String> employeeEntreeHash) {
        Set<String> employees = employeeEntreeHash.keySet();
        String[][] finalArrayList = new String[employees.size()][2];
        int employeeId = 0;
        for(String employee : employees){
            finalArrayList[employeeId][0] = employee;
            finalArrayList[employeeId][1] = employeeEntreeHash.get(employee);
            employeeId++;
        }
        return finalArrayList;
    }

    private Map<String, String> convertFromArrayToMap(String[][] matrix) {
        Map<String, String> hashMap = new HashMap<>();
        for(int row = 0; row < matrix.length; row++) {
            int length = matrix[row].length;
            hashMap.put(matrix[row][0],matrix[row][length-1]);
        }
        return hashMap;
    }

    private Map<String, String> findCuisineCorrelation(Map<String, String> entryCusines,  Map<String, String> emplyeeCusinePref) {
        Map<String, String> correlationResult = new HashMap<>();
        for(String employee : emplyeeCusinePref.keySet()) {
            StringBuffer cusineList = new StringBuffer();
            String employeeRequestedCuisine = emplyeeCusinePref.get(employee);

            if (Objects.nonNull(employeeRequestedCuisine)) {
                for (String entree : entryCusines.keySet()) {
                    if (employeeRequestedCuisine.equals("*") || employeeRequestedCuisine.equals(entryCusines.get(entree))) {
                        cusineList.append(entree+",");
                    }
                }
                correlationResult.put(employee,cusineList.deleteCharAt(cusineList.length()-1).toString());
            }
        }
        return correlationResult;
    }

}
