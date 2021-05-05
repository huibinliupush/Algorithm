package com.bin.algorithm.leetcode;

public class SetZeroes {


    public static void main(String[] args) {

    }


    public void setZeroes(int[][] matrix) {
        if (matrix == null) {
            printMatrix(matrix);
            return;
        }

        int rowNum = matrix.length;

        if (rowNum <= 0) {
            printMatrix(matrix);
            return;
        }

        for (int rowIndex = 0; rowIndex < rowNum; rowIndex++) {
            int[] colMatrix = matrix[rowIndex];
            int colNum = colMatrix.length;
            for (int colIndex = 0; colIndex < colNum; colIndex++) {
                int data = matrix[rowIndex][colIndex];
                if (data == 0) {
                    //所在行清0

                }
            }
        }
        return;
    }

    private void printMatrix(int[][] matrix) {
        System.out.println(matrix);
    }
}
