package solutions.easy;

import java.util.HashSet;
import java.util.Set;

public class TwoNumberSum {
    private static int[] twoSum(int[] array, int targetSum) {
        Set<Integer> set = new HashSet<>();
        for (int val : array) {
            set.add(val);
        }
        for (int val : array) {
            int remainingSum = targetSum - val;
            if (val != remainingSum && set.contains(remainingSum)) {
                return new int[]{val, remainingSum};
            }
        }
        return new int[0];
    }
}
