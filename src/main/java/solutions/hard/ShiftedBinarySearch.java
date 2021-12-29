package solutions.hard;

public class ShiftedBinarySearch {
    public static int shiftedBinarySearch(int[] array, int target) {
        int pivotPiont = getRotationPoint(array, 0, array.length-1);
        System.out.println(pivotPiont);
        if(pivotPiont == -1) {
            return binarySearch(array, target, 0, array.length-1);
        } else {
            int value1 = binarySearch(array, target, 0, pivotPiont-1);
            if(value1 != -1) {
                return value1;
            } else {
                return binarySearch(array, target, pivotPiont, array.length-1);
            }
        }
    }

    static int binarySearch(int[] array, int target, int low, int high) {
        if(low > high) {
            return -1;
        }
        if(array[low] > target) {
            return -1;
        }
        if(array[high] < target) {
            return -1;
        }
        int mid = (low + high) / 2;
        if(array[mid] == target) {
            return mid;
        } else if(array[mid] > target) {
            return binarySearch(array, target, low, mid-1);
        } else {
            return binarySearch(array, target, mid+1, high);
        }
    }


    /**
     * Get the index of array where rotation happened.
     */
    private static int getRotationPoint(int[] array, int low, int high) {
        if (low > high) {
            return -1;
        }
        if (array[low] <= array[high]) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (mid - 1 >= 0 && array[mid - 1] > array[mid]) {
            return mid;
        } else if (mid + 1 <= high && array[mid] > array[mid + 1]) {
            return mid + 1;
        } else {
            int value1 = getRotationPoint(array, low, mid - 1);
            if (value1 != -1) {
                return value1;
            }
            return getRotationPoint(array, mid, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 23, 111, 1};
        System.out.println(shiftedBinarySearch(arr, 111));
    }
}
