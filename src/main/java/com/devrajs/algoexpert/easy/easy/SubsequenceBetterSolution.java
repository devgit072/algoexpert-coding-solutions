package com.devrajs.algoexpert.easy.easy;

import java.util.List;

public class SubsequenceBetterSolution {
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int i = 0;
        int j = 0;
        while (i < sequence.size() && j < array.size()) {
            if (sequence.get(i).equals(array.get(j))) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == sequence.size();
    }
}
