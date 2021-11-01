package solutions.medium;

import java.util.Arrays;

public class NumberOfChange {
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] memoi = new int[n + 1];
        Arrays.fill(memoi, -1);
        //memoi[0] = 0;
        int value = numberOfWaysToMakeChangeUtil(0, n, denoms, memoi);
        if (value == -1) {
            return 0;
        }
        return memoi[n];
    }

    public static int numberOfWaysToMakeChangeUtil(int currValue, int target, int[] denoms, int[] memoi) {
        if (currValue == target) {
            System.out.println("Done");
            return 0;
        } else if (currValue > target) {
            return -1;
        }
        if (memoi[currValue] != -1) {
            return memoi[currValue];
        }
        int totalCount = 0;
        for (int i = 0; i < denoms.length; i++) {
            int count = numberOfWaysToMakeChangeUtil(currValue + denoms[i], target, denoms, memoi);
            if (count != -1) {
                totalCount++;
            }
        }
        if (totalCount == 0) {
            memoi[currValue] = -1;
        } else {
            memoi[currValue] = totalCount;
        }

        return memoi[currValue];
    }

    public static void main(String[] args) {
        //int[] arr = new int[]{1, 5, 10, 25};
        int[] arr = new int[]{1, 2, 3};
        System.out.println(numberOfWaysToMakeChange(4, arr));
    }
}
