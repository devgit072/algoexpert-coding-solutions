package solutions.hard;

import java.util.Arrays;

public class MinimumJumps {
    public static int minNumberOfJumps(int[] array) {
        // Write your code here.
        int[] memo = new int[array.length];
        Arrays.fill(memo, -1);
        minJumpsUtil(array, 0, memo);
        return memo[0];
    }

    public static int minJumpsUtil(int[] array, int index, int[] memo) {
        if (index >= array.length ) {
            return Integer.MAX_VALUE;
        }

        if(memo[index] != -1) {
            return memo[index];
        }
        if (array.length - 1 == index) {
            memo[index] = 0;
            return 0;
        }
        if(array[index] == 0) {
            memo[index] = 0;
            return memo[index];
        }

        int minSteps = Integer.MAX_VALUE;
        int steps = array[index];
        for (int i = 1; i <= steps; i++) {
            int nextSteps = minJumpsUtil(array, index + i, memo);
            if (nextSteps != Integer.MAX_VALUE) {
                if (1 + nextSteps < minSteps) {
                    minSteps = 1 + nextSteps;
                }
            }
        }
        memo[index] = minSteps;
        return minSteps;
    }
}
