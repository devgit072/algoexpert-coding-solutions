package solutions.hard;

import java.util.Arrays;

public class MinimumRewards {
    /**
     * Brute force solution: For every index, go left and check how many consecutive left elements are smaller. Note the value as l.
     * Similary, for every index, go right and check how many consecutive elements are smaller and note the value as r.
     * For this index, the answer will be max(l, r).
     * This is brute force solution and will take O(n^2) and space as O(1)
     */
    public static int minRewards(int[] scores) {
        int[] rewards = new int[scores.length];
        Arrays.fill(rewards, 1);
        for (int i = 0; i < scores.length; i++) {
            // For this index i, check how many elements are smaller than this in left side.
            int l = i;
            while (l - 1 >= 0 && scores[l - 1] < scores[l]) {
                l--;
            }
            int leftR = i - l + 1;

            // For this index i, check how many elements are smaller than this in right side.
            int r = i;
            while (r + 1 < scores.length && scores[r] > scores[r + 1]) {
                r++;
            }
            int rightR = r - i + 1;
            rewards[i] = Math.max(leftR, rightR);
        }
        int sum = 0;
        for (int r : rewards) {
            System.out.print("  " + r);
            sum += r;
        }
        System.out.println();
        System.out.println(sum);
        return sum;
    }


    /**
     * We can just optimize above solution.
     * We will maintain two arrays: leftToRight and rightToLeft.
     * In leftToRight,we will start from index 0 to last and  for every index if the left element is smaller then we will just set the reward as (reward of left) + 1
     * In rightToLeft we will start from last to 0 and for every index if the right element is smaller then we will just set the reward as (reward of right) + 1
     */
    public static int optimized(int[] scores) {
        int[] leftToRight = new int[scores.length];
        int[] rightToLeft = new int[scores.length];
        Arrays.fill(leftToRight, 1);
        Arrays.fill(rightToLeft, 1);

        for (int i = 1; i < scores.length; i++) {
            if (scores[i - 1] < scores[i]) {
                leftToRight[i] = leftToRight[i - 1] + 1;
            }
        }
        for (int i = scores.length - 2; i >= 0; i--) {
            if (scores[i] > scores[i + 1]) {
                rightToLeft[i] = rightToLeft[i + 1] + 1;
            }
        }
        int[] rewards = new int[scores.length];
        for(int i=0;i<scores.length;i++) {
            rewards[i] = Math.max(leftToRight[i], rightToLeft[i]);
        }
        int sum = 0;
        for (int r : rewards) {
            System.out.print("  " + r);
            sum += r;
        }
        System.out.println();
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        optimized(new int[]{8, 4, 2, 1, 3, 6, 7, 9, 5});
        //optimized(new int[]{5, 10});
    }
}
