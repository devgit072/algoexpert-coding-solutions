package solutions.hard;

import java.util.Arrays;

public class QuickSelect {
    public static int quickselect(int[] array, int k) {
        while (true) {
            int pivot = k-1;
            int pivotValue = array[k-1];
            int start = 0;
            int end = array.length - 1;
            while (array[start] < pivotValue) {
                start++;
            }
            while (array[end] > pivotValue) {
                end--;
            }
            if(start == pivot && end == pivot) {
                return pivotValue;
            } else {
                // swap start and end.
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
    }

    public static int quickselectUnoptimized(int[] array, int k) {
        int start = 0;
        k = k-1;
        int end = array.length-1;
        while (start < k || end > k) {
            if(start < k && end > k && array[start] > array[end]) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
            if(start < k && array[start] > array[k]) {
                int temp = array[k];
                array[k] = array[start];
                array[start] = temp;
                end=array.length-1;
            }
            if(k < end && array[k] > array[end]) {
                int temp = array[k];
                array[k] = array[end];
                array[end] = temp;
                start = 0;
                int tempIndex = 0;
                while (tempIndex < k) {
                    if(array[tempIndex] > array[k]) {
                        int t = array[k];
                        array[k] = array[tempIndex];
                        array[tempIndex] = t;
                    }
                    tempIndex++;
                }
            }
            start++;
            end--;
        }
        return array[k];
    }

    public static void main(String[] args) {
        System.out.println(quickselect(new int[] {8, 3, 2, 5, 1, 7, 4, 6}, 2));
    }
}
