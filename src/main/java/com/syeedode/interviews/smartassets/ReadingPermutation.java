package com.syeedode.interviews.smartassets;

public class ReadingPermutation {
    public static void swap(char [] swappingArray, int x, int y)
    {
        char temp;
        temp = swappingArray[x];
        swappingArray[x] = swappingArray[y];
        swappingArray[y] = temp;
    }

    /* Function to print permutations of string
       This function takes three parameters:
       1. String
       2. Starting index of the string
       3. Ending index of the string. */
    public static void permuteReadingPermutation(char [] a, int left, int right)
    {
        int i;
        if (left == right)
            System.out.println("a: " + String.valueOf(a));
        else
        {
            for (i = left; i <= right; i++)
            {
                swap(a, left, i);
                permuteReadingPermutation(a, left+1, right);
                swap(a, left, i); //backtrack
            }
        }
    }

}
