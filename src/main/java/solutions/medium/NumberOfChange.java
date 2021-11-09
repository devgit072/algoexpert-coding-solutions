package solutions.medium;

import java.util.Arrays;

public class NumberOfChange {
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] memoi = new int[n + 1];
        memoi[0] = 1; // number of ways to make a change for 0 is 1
        // Lets build up a bottom up cache.
        for(int d : denoms) {
            for(int val=1;val <= n;val++) {
                if(d <= val) {
                    memoi[val] = memoi[val] + memoi[val-d];
                }
            }
        }
        return memoi[n];
    }


    public static void main(String[] args) {
        //int[] arr = new int[]{1, 5, 10, 25};
        int[] arr = new int[]{1, 2, 3};
        System.out.println(numberOfWaysToMakeChange(4, arr));
    }
}
