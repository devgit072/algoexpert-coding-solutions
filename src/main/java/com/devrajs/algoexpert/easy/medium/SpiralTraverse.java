package com.devrajs.algoexpert.easy.medium;

public class SpiralTraverse {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3, 4, 44}, {12, 13, 14, 5, 55}, {11, 16, 15, 6, 66}, {10, 9, 8, 7, 77}};
        int[][] arr1 = new int[][]{{1}};
        int[] newArr = spiralTraverse(arr1);
        for (int v : newArr) {
            System.out.print(v + "  ");
        }
    }

    public static int[] spiralTraverse(int[][] array) {
        int n = array.length;
        int m = array[0].length;
        int[] newArr = new int[n * m];
        int index = 0;
        int startRow = 0, endRow = n - 1;
        int startCol = 0, endCol = m - 1;
        while (startRow <= endRow && startCol <= endCol) {
            for (int j = startCol; j <= endCol; j++) {
                newArr[index++] = array[startRow][j];
            }
            startRow++;
            for (int i = startRow; i <= endRow; i++) {
                newArr[index++] = array[i][endCol];
            }
            endCol--;
            for (int j = endCol; j >= startCol && startRow <= endRow; j--) {
                newArr[index++] = array[endRow][j];
            }
            endRow--;
            for (int i = endRow; i >= startRow && startCol <= endCol; i--) {
                newArr[index++] = array[i][startCol];
            }
            startCol++;
        }
        return newArr;
    }
}
