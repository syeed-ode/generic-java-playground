package com.syeedode.interviews.smartassets;


import java.util.HashSet;
import java.util.Set;

import static com.syeedode.interviews.smartassets.ReadingPermutation.permuteReadingPermutation;

public class CalculatePermutationPersonalAttempt {

    private static Set<String> completedList = new HashSet<>();

    static void swap(char [] swappingArray, int x, int y) {
        System.out.println("\n\tIn swap with swappingArray: " + String.valueOf(swappingArray) + ", x: " + x + ", y: " + y);
        char temp = swappingArray[x];
        System.out.println("\t\tchar "
                + "temp: " + temp);
        swappingArray[x] = swappingArray[y];
        System.out.println("\t\tswappingArray[x] = swappingArray[y];: "
                + " swappingArray["+x+"]: " + swappingArray[x]);
        swappingArray[y] = temp;
        System.out.println("\t\tswappingArray[y] = temp;: "
                + " swappingArray["+y+"]: " + swappingArray[y]);
        System.out.println("\tOn the way out of swap: " + String.valueOf(swappingArray) + " x: " + x + ", y: " + y + "");
    }

    /* Function to print permutations of string
       This function takes three parameters:
       1. String
       2. Starting index of the string
       3. Ending index of the string. */
    static void permuteCalculatePermutationPersonalAttempt(char [] charsToPermutate, int startingPosition, int endPosition) {
        String stringValueOfCharsToPermutate = String.valueOf(charsToPermutate);
        System.out.println("\n\n\nAt the very top of permuteCalculatePermutationPersonalAttempt. "
                + "permuteCalculatePermutationPersonalAttempt(char [] charsToPermutate, int startingPosition, int endPosition)"
                + "\n\tpermuteCalculatePermutationPersonalAttempt(" + stringValueOfCharsToPermutate
                + ", " + startingPosition + ", " + endPosition + ")"
                + ", completedList: " + completedList);
        int i;
        if (startingPosition == endPosition) {
            System.out.println("(startingPosition == endPosition)"
                    + "\n\tstartingPosition: " + startingPosition + ", endPosition: " + endPosition
                    + ", charsToPermutate: " + stringValueOfCharsToPermutate);
        } else {
            if(!completedList.contains(stringValueOfCharsToPermutate)) {
                completedList.add(stringValueOfCharsToPermutate);
                System.out.println("In permuteCalculatePermutationPersonalAttempt prior to for loop it doesn't contain: " + stringValueOfCharsToPermutate
                        + ", now the completedList is: " + completedList);
            } else {
                System.out.println("In permuteCalculatePermutationPersonalAttempt prior to for loop contains: " + stringValueOfCharsToPermutate
                        + " the completedList is: " + completedList);
            }
            for (i = startingPosition + 1; i <= endPosition; i++) {
                System.out.println("\nIn the top permuteCalculatePermutationPersonalAttempt prior to swap, charsToPermutate: " + stringValueOfCharsToPermutate
                        + "\nfor (i = startingPosition + 1; i <= endPosition; i++) {"
                        + "\n\tstartingPosition: " + startingPosition + " endPosition: " + endPosition + ", i: " + i
                        + " \n\tswap(charsToPermutate, startingPosition, i);"
                        + " \n\tswap(" + stringValueOfCharsToPermutate + ", " + startingPosition + ", " + i + ")"
                        + " \n\tcompletedList: " + completedList);
                swap(charsToPermutate, startingPosition, i);
                System.out.println("\n\tIn permuteCalculatePermutationPersonalAttempt after swap, charsToPermutate: " + stringValueOfCharsToPermutate
                        + " startingPosition: " + startingPosition + ", endPosition: " + endPosition
                        + " i: " + i + ", charsToPermutate: " + String.valueOf(charsToPermutate)
                        + " \n\t\tcompletedList: " + completedList);
                completedList.add(String.valueOf(charsToPermutate));
                System.out.println("\tAfter first add completedList: " + completedList);
                System.out.println("\tIn permuteCalculatePermutationPersonalAttempt prior to permuteCalculatePermutationPersonalAttempt, charsToPermutate: " + String.valueOf(charsToPermutate)
                        + "\n\tcalling permuteCalculatePermutationPersonalAttempt"
                        + "\n\t\tpermuteCalculatePermutationPersonalAttempt(charsToPermutate, startingPosition+1, endPosition);"
                        + "\n\t\tpermuteCalculatePermutationPersonalAttempt("+String.valueOf(charsToPermutate) + ", " + (startingPosition+1) + ", " + endPosition);
                permuteCalculatePermutationPersonalAttempt(charsToPermutate, startingPosition+1, endPosition);
                System.out.println("In permuteCalculatePermutationPersonalAttempt after permuteCalculatePermutationPersonalAttempt: " + String.valueOf(charsToPermutate)
                        + " startingPosition: " + startingPosition + " endPosition: " + endPosition
                        + " i: " + i + ", charsToPermutate: " + String.valueOf(charsToPermutate)
                        + " completedList: " + completedList
                        + " about to call add <need to question this add>");
                completedList.add(String.valueOf(charsToPermutate));
                System.out.println("\tAfter permuteCalculatePermutationPersonalAttempt add, completedList: " + completedList
                        + ", just added charsToPermutate: " + String.valueOf(charsToPermutate)
                        + "\n\tswap(charsToPermutate, startingPosition, i)"
                        + " \n\tswap(" + String.valueOf(charsToPermutate) + ", " + startingPosition + "," + i
                        + "");
                swap(charsToPermutate, startingPosition, i); //backtrack
                System.out.println("\tIn permuteCalculatePermutationPersonalAttempt after second swap: " + String.valueOf(charsToPermutate)
                        + " startingPosition: " + startingPosition + ", endPosition: " + endPosition
                        + " i: " + i + ", charsToPermutate: " + String.valueOf(charsToPermutate)
                        + " \n\t\tcompletedList: " + completedList);
                completedList.add(String.valueOf(charsToPermutate));
                System.out.println("\tAfter third add" + completedList);
            }
        }
        System.out.println("\tAt the end of permuteCalculatePermutationPersonalAttempt, completedList: " + completedList + "\n");
    }

    /* Driver program to test CalculatePermutationPersonalAttempt functions */
    public static void mainCalculatePermuationAttempt(String [] args) {
        char [] charactersToPermutate = "ABC".toCharArray();
        int numberOfCharacters = charactersToPermutate.length;
        System.out.println("******************************************"
                + "\nIn main about to kick off things. With charactersToPermutate: "
                + String.valueOf(charactersToPermutate)
                + "\n\tpermuteCalculatePermutationPersonalAttempt(charactersToPermutate, 0, numberOfCharacters - 1)"
                + "\n\tcharactersToPermutate: " + String.valueOf(charactersToPermutate) + ", 0, " + (numberOfCharacters - 1)
                + " \n\tcompletedList: " + completedList);
        permuteCalculatePermutationPersonalAttempt(charactersToPermutate, 0, numberOfCharacters - 1);
    }

    /* Driver program to test ReadingPermutation functions */
    public static void  main(String [] args)
    {
        char str[] = "ABC".toCharArray();
        int n = str.length;
        permuteReadingPermutation(str, 0, 2);
    }
}
