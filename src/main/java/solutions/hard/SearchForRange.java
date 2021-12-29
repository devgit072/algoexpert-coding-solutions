package solutions.hard;

public class SearchForRange {
    public static int[] searchForRange(int[] array, int target) {
        return searchForRangeUtil(array, target, 0, array.length - 1);
    }

    public static int[] searchForRangeUtil(int[] array, int target, int low, int high) {
        if (low > high) {
            return new int[]{-1, -1};
        }
        int mid = (low + high) / 2;
        if (array[mid] == target) {
            int[] resultFromLeftSide;
            int[] resultFromRightSide;
            int leftIndex = mid;
            int rightIndex = mid;
            if (mid - 1 >= 0 && array[mid - 1] == target) {
                resultFromLeftSide = searchForRangeUtil(array, target, low, mid - 1);
                leftIndex = resultFromLeftSide[0];
            }
            if (mid + 1 <= high && array[mid + 1] == target) {
                resultFromRightSide = searchForRangeUtil(array, target, mid + 1, high);
                rightIndex = resultFromRightSide[1];
            }
            return new int[]{leftIndex, rightIndex};
        } else if (array[mid] > target) {
            return searchForRangeUtil(array, target, low, mid - 1);
        } else {
            return searchForRangeUtil(array, target, mid + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2, 3, 4, 4, 4, 5, 6};
        int[] res = searchForRange(arr, 41);
        System.out.println(res[0] + "   " + res[1]);
    }
}
