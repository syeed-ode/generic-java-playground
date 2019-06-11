package com.syeedode.leagerachin_fikir.yonas.display;

public class DisplayPatternServiceRefactored {
    public static void displayPattern(int n) {
        for(int rowBeingProcessed = 1; rowBeingProcessed < n + 1; rowBeingProcessed++) {
            printAllIntegersForCurrentRow(rowBeingProcessed, n);
            prepareToProcessNextRow();
        }
    }

    private static void prepareToProcessNextRow() {
        System.out.println();
    }

    private static void printAllIntegersForCurrentRow(int currentRowNumber, int totalNumberOfRows) {
        determineNumberOfPrecedingTabsOnThisRow(currentRowNumber, totalNumberOfRows);
        for(int i = currentRowNumber; i > 0; i--) {
            System.out.print(i+"\t");
        }
    }

    private static void determineNumberOfPrecedingTabsOnThisRow(int currentRowBeingProcessed, int totalNumberOfRowsBeingProcessed) {
        for(int i = currentRowBeingProcessed; i < totalNumberOfRowsBeingProcessed; i++){
            System.out.print("\t");
        }
    }
}
