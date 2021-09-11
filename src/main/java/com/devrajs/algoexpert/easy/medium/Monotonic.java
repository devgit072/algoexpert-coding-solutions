package com.devrajs.algoexpert.easy.medium;

public class Monotonic {
    public static boolean isMonotonic(int[] array) {
        if (array.length < 2) {
            return true;
        }
        int l = 0;
        int r = 1;
        boolean increasing = false;
        while (r < array.length && array[l] == array[r]) {
            r++;
        }
        // r == array.length means all elements in the array are same.
        if (r == array.length) {
            return true;
        }
        if (array[l] < array[r]) {
            increasing = true;
        }
        return checkMonotonicity(array, increasing);
    }

    private static boolean checkMonotonicity(int[] array, boolean increasing) {
        int index = 1;
        while (index < array.length) {
            if (increasing) {
                if (array[index - 1] > array[index]) {
                    return false;
                }
            } else {
                if (array[index - 1] < array[index]) {
                    return false;
                }
            }
            index++;
        }

        return true;
    }
}
