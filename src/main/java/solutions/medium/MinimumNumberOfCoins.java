package solutions.medium;

import java.util.Arrays;

public class MinimumNumberOfCoins {
    static int counter=0;
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] memoi = new int[n + 1];
        Arrays.fill(memoi, -1);
        memoi[0] = 0;
        minNumberOfCoinsForChangeUtil(n, denoms, memoi);
        return memoi[n];
    }

    public static int minNumberOfCoinsForChangeUtil(int n, int[] denoms, int[] memoi) {
        if (n == 0) {
            return 0;
        } else if (n < 0) {
            return -1;
        }
        if(memoi[n] != -1) {
            return memoi[n];
        }
        int minimum = Integer.MAX_VALUE;
        System.out.println("Debug for " + n);
        System.out.println(counter++);
        for (int i = 0; i < denoms.length; i++) {
            int count = minNumberOfCoinsForChangeUtil(n - denoms[i], denoms, memoi);
            if (count != -1) {
                if (count + 1 < minimum) {
                    minimum = count + 1;
                }
            }
        }

        if (minimum == Integer.MAX_VALUE) {
            memoi[n] = -1;
        } else {
            memoi[n] = minimum;
        }
        return memoi[n];
    }

    public static void main(String[] args) {
        //int[] arr = new int[] {1,5,10};
        //int[] arr = new int[]{1, 5, 10};
        int[] arr = new int[] {39, 45, 130, 40, 4, 1};
        System.out.println(minNumberOfCoinsForChange(135, arr));
    }
}
