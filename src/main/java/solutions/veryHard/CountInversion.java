package solutions.veryHard;

public class CountInversion {
    public int countInversions(int[] array) {
        int value = splitAndMerge(array, 0, array.length - 1);
        return value;
    }

    private static int splitAndMerge(int[] array, int low, int high) {
        if (low >= high) {
            return 0;
        }
        int mid = (low + high) / 2;
        int count1 = splitAndMerge(array, low, mid);
        int count2 = splitAndMerge(array, mid + 1, high);
        return mergeArray(array, low, mid, mid + 1, high) + count1 + count2;
    }

    private static int mergeArray(int[] array, int low1, int high1, int low2, int high2) {
        int[] tempSpace = new int[high2 - low1 + 1];
        int inversionCount = 0;
        int i = low1;
        int j = low2;
        int tempIndex = 0;
        while (i <= high1 && j <= high2) {
            if (array[i] <= array[j]) {
                tempSpace[tempIndex++] = array[i++];
            } else if (array[i] > array[j]) {
                tempSpace[tempIndex++] = array[j++];
                int remainingIndex = high1 - i + 1;
                inversionCount = inversionCount + remainingIndex;
            }
        }

        while (i <= high1) {
            tempSpace[tempIndex++] = array[i++];
        }
        while (j <= high2) {
            tempSpace[tempIndex++] = array[j++];
        }
        int indexOfTemp = 0;
        for (int k = low1; k <= high2; k++) {
            array[k] = tempSpace[indexOfTemp++];
        }
        return inversionCount;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 2, 2, 1, 1, 1, 1, 3, 3, 3, 3};
        System.out.println();
        System.out.println(new CountInversion().countInversions(arr));
        for(int i : arr) {
            System.out.print("  " + i);
        }
    }
}
