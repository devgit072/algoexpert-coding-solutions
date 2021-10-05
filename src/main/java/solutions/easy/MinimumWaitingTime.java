package solutions.easy;

import java.util.Arrays;

public class MinimumWaitingTime {

    public int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        if (queries.length <= 1) {
            return 0;
        }
        int totalWatingTime = 0;
        int sumOfAllWaitingTime = 0;
        int prevElement = queries[0];
        for (int i = 1; i < queries.length; i++) {
            totalWatingTime += prevElement;
            sumOfAllWaitingTime += totalWatingTime;
            prevElement = queries[i];
        }

        return sumOfAllWaitingTime;
    }
}
