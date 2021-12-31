package solutions.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSort {
    /**
     * Radix sort works based on counting sort.
     * If the range of the numbers are small, then counting and radix sort are very efficient algorithm. Both works
     * in linear time.
     * In radix sort, first we sort on first digit, then we sort on second digit, and then we sort on third digit
     * and so on. At the end, the array gets sorted.
     */
    /**
     * Lets first write how a counting sort works in order to understand its implementation.
     */
    static int[] countingSort(int[] arr) {
        int maxNumber = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > maxNumber) {
                maxNumber = i;
            }
        }
        // We know that the numbers are in the range of [0, maxNumber]
        int[] count = new int[maxNumber + 1];
        for (int i : arr) {
            count[i] = count[i] + 1;
        }
        for (int i = 1; i <= maxNumber; i++) {
            count[i] = count[i] + count[i - 1];
        }
        /*
        This can also be used for counting sort, but it is not used as standard.
        int arrayIndex = 0;
        int index = 0;
        int prevCount = 0;
        while (index <= maxNumber) {
            int endCount = count[index];
            for(int i = prevCount;i<endCount;i++) {
                arr[arrayIndex++] = index;
            }
            prevCount = endCount;
            index++;
        }*/
        int[] outputArr = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int indexInTheOutputArray = count[arr[i]] - 1;
            outputArr[indexInTheOutputArray] = arr[i];
            --count[arr[i]];
        }

        for (int i = 0; i < outputArr.length; i++) {
            arr[i] = outputArr[i];
        }
        return arr;
    }

    public static ArrayList<Integer> radixSort(ArrayList<Integer> array) {
        int d=1;
        int[] arr = new int[array.size()];
        for(int i =0;i<arr.length;i++) {
            arr[i] = array.get(i);
        }
        int maxNumber = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > maxNumber) {
                maxNumber = i;
            }
        }
        while (true) {
            arr = countingSortForRadix(arr, d);
            d++;
            if(maxNumber/Math.pow(10, (d-1)) == 0) {
                break;
            }
        }
        ArrayList<Integer> output = new ArrayList<>();
        for (int j : arr) {
            output.add(j);
        }
        return output;
    }

    private static int[] countingSortForRadix(int[] arr, int digit) {
        // Since we are sorting the numbers based on digit, the maximum number which need to be sorted is [0-9]
        int[] count = new int[10]; // for 0-9
        for (int i : arr) {
            int divider = (int) Math.pow(10, digit - 1);
            int numberAtThisDigit = (i / divider) % 10;
            count[numberAtThisDigit]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] = count[i] + count[i - 1];
        }
        int[] output = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--) {
            int divider = (int) Math.pow(10, digit - 1);
            int numberAtThisDigit = (arr[i] / divider) % 10;
            int indexForOutputArray = count[numberAtThisDigit] - 1;
            output[indexForOutputArray] = arr[i];
            count[numberAtThisDigit]--;
        }
        for(int i=0;i<output.length;i++) {
            arr[i] = output[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 0, 2, 1, 6, 4, 3);

        //int[] arr = new int[]{1, 0, 2, 1, 6, 4, 3};
        //ArrayList<Integer> sortedList = radixSort(list);
        /*for(int i : sortedList) {
            System.out.print(i + "    ");
        }*/
    }
}
