package solutions.medium;

public class LongestPeak {
    public static int longestPeak(int[] array) {
        if (array.length < 3) {
            return 0;
        }
        int globalStartIndex = -1;
        int globalEndIndex = -1;
        int diff = 0;
        int startIndex = -1;
        int endIndex = -1;
        int currIndex = 0;
        while (currIndex < array.length - 1) {
            startIndex = currIndex;
            while (currIndex < array.length-1 && array[currIndex] < array[currIndex + 1]) {
                currIndex++;
            }
            if (startIndex == currIndex) {
                currIndex++;
                continue;
            }
            int temp = currIndex;
            while (currIndex+1 < array.length && array[currIndex] > array[currIndex + 1]) {
                currIndex++;
            }
            if (currIndex == temp) {
                continue;
            }
            endIndex = currIndex;
            if ((globalEndIndex - globalStartIndex) < (endIndex - startIndex)) {
                globalEndIndex = endIndex;
                globalStartIndex = startIndex;
                diff = (globalEndIndex - globalStartIndex)+1;
            }
        }
        return diff;
    }
}