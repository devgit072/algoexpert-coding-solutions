package solutions.hard;

/**
 * Time complexities: O(n)
 * Space complexities: O(n)
 */

public class SubarraySort {
    public static int[] subarraySort(int[] array) {
        int minNumber = Integer.MAX_VALUE;
        int minNumberIndex = -1;
        int maxNumberIndex = -1;
        int maxNumber = Integer.MIN_VALUE;
        int index = 0;
        while (index < array.length - 1) {
            if(array[index] > array[index + 1]) {
                int currentSmallestNumber = array[index + 1];
                if(currentSmallestNumber < minNumber) {
                    minNumber = currentSmallestNumber;
                    minNumberIndex = index + 1;
                }
            }
            index++;
        }

        index = array.length - 1;
        while (index > 0) {
            if(array[index - 1] > array[index]) {
                int currentMaxNumber = array[index - 1];
                if(currentMaxNumber > maxNumber) {
                    maxNumber = currentMaxNumber;
                    maxNumberIndex = index - 1;
                }
            }
            index--;
        }
        // Now we have found the smallest and biggest number which are out of order.
        // Lets find their original position.
        if(minNumberIndex == -1) {
            return new int[] {-1, -1};
        }
        index = minNumberIndex-1;
        while (index >= 0) {
            if(minNumber < array[index]) {
                minNumberIndex = index;
            }
            index--;
        }
        index = maxNumberIndex + 1;
        while (index <= array.length-1) {
            if(maxNumber > array[index]) {
                maxNumberIndex = index;
            }
            index++;
        }
        return new int[] {minNumberIndex, maxNumberIndex};
    }
}
