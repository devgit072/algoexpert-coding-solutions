package solutions.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxIncreasingSubsequence {
    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        // Lets initialize two array: one for DP and another one for sequence.
        int[] dp = new int[array.length];
        int[] charSequence = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            dp[i] = array[i];
            charSequence[i] = i;
        }
        int max = array[0];
        int maximumSumIndex = 0;
        for (int j = 1; j < array.length; j++) {
            for (int i = 0; i < j; i++) {
                if (array[j] > array[i] && dp[i] + array[j] > dp[j]) {
                    dp[j] = dp[i] + array[j];
                    if (max < dp[j]) {
                        max = dp[j];
                        maximumSumIndex = j;
                    }
                    charSequence[j] = i;
                } else {
                    if (max < dp[j]) {
                        max = dp[j];
                        maximumSumIndex = j;
                    }
                }
            }
        }
        // Lets find the subsequence of maximum sum.
        ArrayList<Integer> sequence = new ArrayList<>();
        int index = maximumSumIndex;
        while (true) {
            sequence.add(array[index]);
            if (charSequence[index] == index) {
                break;
            }
            index = charSequence[index];
        }
        Collections.sort(sequence);
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(max));
        list.add(sequence);
        return list;
    }
}
