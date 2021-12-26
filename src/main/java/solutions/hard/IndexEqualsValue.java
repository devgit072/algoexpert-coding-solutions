package solutions.hard;

public class IndexEqualsValue {
    public int indexEqualsValue(int[] array) {
        return binarySearch(array, 0, array.length-1);
    }

    private int binarySearch(int[] array, int start, int high) {
        if(start > high) {
            return -1;
        }
        int mid = (start + high)/2;
        int midResult = -1;
        if(array[mid] == mid) {
            midResult = mid;
            int furtherResult = binarySearch(array, start, mid-1);
            if(furtherResult != -1) {
                midResult = furtherResult;
            }
            return midResult;
        } else if(array[mid] > mid) {
            return binarySearch(array, start, mid-1);
        } else {
            return binarySearch(array, mid+1, high);
        }
    }
    // -50, 1, 2, 3, 4

}
