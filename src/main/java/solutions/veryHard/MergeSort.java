package solutions.veryHard;

import java.util.Arrays;

public class MergeSort {
    public static int[] mergeSort(int[] array) {
        // Write your code here.
        mergeSortUtil(array, 0, array.length - 1);
        return array;
    }

    private static void mergeSortUtil(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSortUtil(array, low, mid);
        mergeSortUtil(array, mid + 1, high);
        mergeTwoSortedArray(array, low, mid, mid + 1, high);
    }

    private static void mergeTwoSortedArray(int[] array, int low1, int high1, int low2, int high2) {
        int[] tempArray = new int[high2 - low1 + 1];
        int i = low1;
        int j = low2;
        int temp = 0;
        while (i <= high1 && j <= high2) {
            if (array[i] < array[j]) {
                tempArray[temp++] = array[i++];
            } else if (array[i] > array[j]) {
                tempArray[temp++] = array[j++];
            } else {
                tempArray[temp++] = array[i++];
                tempArray[temp++] = array[j++];
            }
        }
        while (i <= high1) {
            tempArray[temp++] = array[i++];
        }
        while (j <= high2) {
            tempArray[temp++] = array[j++];
        }
        int index = low1;
        for (int k = 0; k < tempArray.length; k++) {
            array[index++] = tempArray[k];
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {5, 2, 9,1, 45, 12, 8};
        mergeSort(array);
        for(int i : array) {
            System.out.print("  " + i);
        }
    }
}
