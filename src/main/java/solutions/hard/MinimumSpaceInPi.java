package solutions.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimumSpaceInPi {
    public static int numbersInPi(String pi, String[] numbers) {
        // First of all, lets put all numbers in the Hashmap.
        Set<String> set = new HashSet<>(Arrays.asList(numbers));
        int[] memo = new int[pi.length()+1];
        Arrays.fill(memo, -2);
        return numbersInPiUtil(pi, set, memo, 0);
    }

    public static int numbersInPiUtil(String pi, Set<String> set, int[] memo , int index) {
        if(memo[index] != -2) {
            return memo[index];
        }
        if (pi.isEmpty()) {
            return 0;
        }
        if (set.contains(pi)) {
            memo[index] = 0;
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < pi.length(); i++) {
            String subStr = pi.substring(0, i);
            if (set.contains(subStr)) {
                String subStrForNext = pi.substring(i);
                int val = numbersInPiUtil(subStrForNext, set, memo, subStrForNext.length());
                if (val != -1 && val < min) {
                    min = 1+ val;
                }
            }
        }
        if(min == Integer.MAX_VALUE) {
            memo[index] = -1;
            return -1;
        }
        memo[index] = min;
        return memo[index];
    }
}
