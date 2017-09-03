package com.syeedode.datastructures.strings;

import java.util.Objects;

/**
 * Cracking the Coding Interview
 * Chapter 1: Arrays and Strings
 * pg: 204; Problem 1.8
 *
 *
 * Author: syeedode
 * Date: 5/19/17
 */
public class MatrixNullifier {

    public void setZeros(int [][] matrix) {
        if(Objects.isNull(matrix) || Objects.isNull(matrix[0])) return;

        boolean[] row    = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        // Store the row and column index with value 0
        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        // Nullify rows
        for(int i = 0; i < row.length; i++) {
            if(row[i]) nullifyRow(matrix, i);
        }

        for(int j = 0; j < column.length; j++) {
            if(column[j]) nullifyColumn(matrix,j);
        }
    }

    public void setZerosModified(int [][] matrix) {
        boolean rowHasZero = false;
        boolean colHasZero = false;

        for(int j = 0; j < matrix[0].length; j++) {
            if(matrix[0][j] == 0) {
                rowHasZero = true;
                break;
            }
        }

        // Check if first column has a zero
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                colHasZero = true;
                break;
            }
        }

        // Check for zeros in rest of the array
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Nullify rows based on values in first column
        for(int i = 1; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                nullifyRow(matrix, i);
            }
        }

        // Nullify column based on values in first rows
        for(int i = 1; i < matrix.length; i++) {
            if(matrix[0][i] == 0) {
                nullifyColumn(matrix, i);
            }
        }

        // Nullify first row
        if(rowHasZero) {
            nullifyRow(matrix, 0);
        }

        // Nullify first column
        if(colHasZero) {
            nullifyColumn(matrix, 0);
        }
    }

    private void nullifyRow(int[][] matrix, int row) {
        for(int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    private void nullifyColumn(int [][] matrix, int col) {
        for(int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
}
