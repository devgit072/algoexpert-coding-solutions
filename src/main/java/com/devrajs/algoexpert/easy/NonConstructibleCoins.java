package com.devrajs.algoexpert.easy;

public class NonConstructibleCoins {

    public int nonConstructibleChange(int[] coins) {
        int minimumChange = 1;
        while (true) {
            if (!isCoinChangePossible(coins, minimumChange, 0)) {
                return minimumChange;
            }
            minimumChange++;
        }
    }

    private boolean isCoinChangePossible(int[] coins, int value, int currIndex) {
        if (value == 0) {
            return true;
        }
        if (currIndex >= coins.length || value < 0) {
            return false;
        }
        return isCoinChangePossible(coins, value - coins[currIndex], currIndex + 1) || isCoinChangePossible(coins, value, currIndex + 1);
    }

}
