package solutions.hard;

public class SortKSortedArray {
    public int[] sortKSortedArray(int[] array, int k) {
        for (int i = 0; i < array.length; i++) {
            int maxLen = i + k;
            for (int j = i + 1; j <= i + k && j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
