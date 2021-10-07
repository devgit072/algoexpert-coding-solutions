package solutions.medium;

public class ThreeNumberSort {
    public static int[] threeNumberSort(int[] array, int[] order) {
        int currIndex = 0;
        for (int j = 0; j < order.length - 1; j++) {
            int currNum = order[j];
            while (currIndex < array.length && array[currIndex] == currNum) {
                currIndex++;
            }
            int i = currIndex + 1;
            while (i < array.length) {
                if (array[i] == currNum) {
                    int temp = array[currIndex];
                    array[currIndex] = array[i];
                    array[i] = temp;
                    while (currIndex < array.length && array[currIndex] == currNum) {
                        currIndex++;
                        i = currIndex + 1;
                    }
                } else {
                    i++;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[] {7, 8, 9, 7, 8, 9, 9, 9, 9, 9, 9, 9};
        int[] order = new int[] {8, 7, 9};
        int[] sorted = threeNumberSort(array, order);
    }
}
