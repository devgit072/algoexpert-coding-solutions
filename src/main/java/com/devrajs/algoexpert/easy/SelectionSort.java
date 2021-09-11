package com.devrajs.algoexpert.easy;

public class SelectionSort {
    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j = i; j < array.length; j++) {
                if (array[j] < min) {
                    index = j;
                    min = array[j];
                }
            }
            // swap array[i] and array[index] which contains the minimum element.
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 2, 3, 0, 9, 7, 6};
        selectionSort(arr);
    }
}
