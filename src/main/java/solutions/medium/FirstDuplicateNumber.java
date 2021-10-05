package solutions.medium;

public class FirstDuplicateNumber {
    public static int firstDuplicateValue(int[] array) {
        int numberToAdd = array.length + 1;
        for (int i = 0; i < array.length; i++) {
            int index = (array[i] % numberToAdd) - 1;
            array[index] += numberToAdd;
            if (array[index] / numberToAdd >= 2) {
                return index+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 3, 3, 2, 4};
        System.out.println(firstDuplicateValue(arr));
    }
}
