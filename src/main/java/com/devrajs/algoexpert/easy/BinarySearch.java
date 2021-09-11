package com.devrajs.algoexpert.easy;

public class BinarySearch {
    public static int binarySearch(int[] array, int target) {
        return binarySearchUtil(array, 0, array.length, target);
    }

    public static int binarySearchUtil(int[] array, int low, int high, int target) {
        if (low >= array.length || low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (array[mid] == target) {
            return mid;
        } else if (target < array[mid]) {
            return binarySearchUtil(array, low, mid - 1, target);
        } else {
            return binarySearchUtil(array, mid + 1, high, target);
        }
    }
}
