package com.devrajs.algoexpert.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortedSquare {

    public static void main(String[] args) {

    }

    public int[] sortedSquaredArray(int[] array) {
        List<Integer> squaredValueList = new ArrayList<>();
        for (int j : array) {
            squaredValueList.add(j * j);
        }
        Collections.sort(squaredValueList);
        int[] squaredValues = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            squaredValues[i] = squaredValueList.get(i);
        }
        return squaredValues;
    }
}
