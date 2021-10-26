package solutions.medium;

public class KadaneAlgo {
    public static int kadanesAlgorithm(int[] array) {
        int maxSum = Integer.MIN_VALUE;
        int sumSoFar = 0;
        for(int i=0;i<array.length;i++) {
            sumSoFar = sumSoFar + array[i];
            if(sumSoFar > maxSum) {
                maxSum = sumSoFar;
            }
            if (sumSoFar < 0 ) {
                sumSoFar = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {-8, -7, -2, -12, 0};
        System.out.println(kadanesAlgorithm(arr));
    }
}
