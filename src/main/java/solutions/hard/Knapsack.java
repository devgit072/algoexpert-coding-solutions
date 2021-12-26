package solutions.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Knapsack {
    static class Result {
        int totalValue;
        List<Integer> indexes;

        Result() {
            totalValue = 0;
            indexes = new ArrayList<>();
        }
    }

    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        int[] values = new int[items.length];
        int[] weights = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            values[i] = items[i][0];
            weights[i] = items[i][1];
        }

        Result result = knapsackUtil(values, weights, 0, capacity);
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(result.totalValue));
        list.add(result.indexes);
        return list;
    }

    static Result knapsackUtil(int[] values, int[] weights, int currentIndex, int remainingCapacity) {
        if(currentIndex >= values.length || remainingCapacity==0) {
            return new Result();
        }

        if(weights[currentIndex] > remainingCapacity) {
            return knapsackUtil(values, weights, currentIndex+1, remainingCapacity);
        }
        Result result1 = knapsackUtil(values, weights, currentIndex+1, remainingCapacity);
        Result result2 = knapsackUtil(values, weights, currentIndex+1, remainingCapacity - weights[currentIndex]);
        result2.totalValue += values[currentIndex];
        result2.indexes.add(currentIndex);
        if(result1.totalValue > result2.totalValue) {
            return result1;
        } else {
            return result2;
        }
    }
}
