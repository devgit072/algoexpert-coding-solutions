package com.devrajs.algoexpert.easy.medium;

import java.util.Arrays;

public class SmallestDifferenceInTwoArrays {
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int p1 = 0;
        int p2 = 0;
        int globalMin = Integer.MAX_VALUE;
        int num1 = -1;
        int num2 = -1;
        while (p1 < arrayOne.length && p2 < arrayTwo.length) {
            int diff = Math.abs(arrayOne[p1] - arrayTwo[p2]);
            if (diff < globalMin) {
                globalMin = diff;
                num1 = arrayOne[p1];
                num2 = arrayTwo[p2];
            }
            if (arrayOne[p1] < arrayTwo[p2]) {
                p1++;
            } else if (arrayOne[p1] > arrayTwo[p2]) {
                p2++;
            } else {
                p1++;
                p2++;
            }
        }
        return new int[]{num1, num2};
    }
}
