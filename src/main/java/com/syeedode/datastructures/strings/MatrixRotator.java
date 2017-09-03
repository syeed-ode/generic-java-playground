package com.syeedode.datastructures.strings;


import java.util.Objects;

/**
 * Cracking the Coding Interview
 * Chapter 1: Arrays and Strings
 * pg: ; Problem 1.7
 * <p>
 * <p>
 * Author: syeedode
 * Date: 5/19/17
 */
public class MatrixRotator {

    public Integer [][] rotate(Integer[][] matrix) {
        // VALIDITY CHECK RETURNS
        int lengthOfWholeMatrix = matrix.length;
        int lengthOfRowOrColumn = matrix[0].length;
        if(lengthOfWholeMatrix == 0 || lengthOfWholeMatrix != lengthOfRowOrColumn) return null;

        int n = lengthOfWholeMatrix;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last  = n - 1 - layer;
            for(int i = first; i < last; i++) {
                int offset = i - first;
                Integer firstI = matrix[first][i];
                int top = firstI; // save top
                Integer lastOffsetCommaFirst = matrix[last - offset][first];
                matrix[first][i] = lastOffsetCommaFirst;
                Integer lastCommaLastOffset = matrix[last][last - offset];
                matrix[last - offset][first] = lastCommaLastOffset;
                Integer iCommaLast = matrix[i][last];
                matrix[last][last - offset]  = iCommaLast;
                matrix[i][last] = top;
            }
        }
        return matrix;
    }

    public void printMatrix(Integer [][] matrix) {
        if(Objects.isNull(matrix)) return;
        int numberOfRows = matrix.length;
        int numberOfColumns = matrix[0].length;
        if(numberOfRows == 0 || numberOfColumns == 0) return;
        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {
                System.out.print(matrix[row][column] + ", ");
            }
            System.out.println();
        }
    }
}
