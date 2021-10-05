package solutions.easy;

public class ThreeLargestNumber {
    public static int[] findThreeLargestNumbers(int[] array) {
        int largestNumber = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE, thirdLargest = Integer.MIN_VALUE;
        for (int j : array) {
            if (j >= largestNumber) {
                thirdLargest = secondLargest;
                secondLargest = largestNumber;
                largestNumber = j;
            } else if (j >= secondLargest) {
                thirdLargest = secondLargest;
                secondLargest = j;
            } else if (j >= thirdLargest) {
                thirdLargest = j;
            }
        }
        return new int[]{thirdLargest, secondLargest, largestNumber};
    }
}
