package com.syeedode.leagerachin_fikir.yonas.display;

public class DisplayPatternService {

    public static void displayPattern(int n) {
        for(int j = 1; j < n + 1; j++) {
            printAllIntegerPerLine(j, n);
            System.out.println();
        }
    }

    private static void printAllIntegerPerLine(int n, int max) {
        for(int i = n; i < max; i++){
            System.out.print("\t");
        }
        for(int i = n; i > 0; i--) {
            System.out.print(i+"\t");
        }
    }
}
