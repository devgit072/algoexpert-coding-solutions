package solutions.medium;

import java.util.Arrays;

public class MaxSubsetNoAdjacent {
    public static int maxSubsetSumNoAdjacent(int[] array) {
        int[] memo = new int[array.length];
        Arrays.fill(memo, -1);
        int max = Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++) {
            maxSubsetSumNoAdjacentUtil(array, i, memo);
            if(max < memo[i]) {
                max = memo[i];
            }
        }
        if(max == Integer.MIN_VALUE) {
            max = 0;
        }
        return max;
    }

    public static int maxSubsetSumNoAdjacentUtil(int[] array, int currIndex, int[] memo) {
        if(currIndex >= array.length) {
            return 0;
        }
        if(memo[currIndex] != -1) {
            return memo[currIndex];
        }
        int sum = array[currIndex];
        int maxSum = Integer.MIN_VALUE;
        for(int i=2;currIndex + i < array.length;i++) {
            int sumNext = maxSubsetSumNoAdjacentUtil(array, currIndex + i, memo);
            if(maxSum < sumNext) {
                maxSum = sumNext;
            }
        }
        if(maxSum > 0) {
            sum += maxSum;
        }
        memo[currIndex] = sum;
        return memo[currIndex];
    }

    public static void main(String[] args) {
        int[] arr = new int[] {75, 105, 120, 75, 90, 135};
        System.out.println(maxSubsetSumNoAdjacent(arr));
    }
}
