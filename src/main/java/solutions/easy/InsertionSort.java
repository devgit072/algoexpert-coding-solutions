package solutions.easy;

public class InsertionSort {
    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            int currValue = array[i];
            while (j >= 0 && currValue < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = currValue;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2, 0, 5, 8, 6};
        insertionSort(arr);
        for (int a : arr) {
            System.out.print("  " + a);
        }
    }
}
