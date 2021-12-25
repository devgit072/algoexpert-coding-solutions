package solutions.hard;

public class MaximumSubmatrixSum {
    // Lets first create sum matrix.
    public static int maximumSumSubmatrix(int[][] matrix, int size) {
        if(size > matrix.length || size > matrix[0].length) {
            return -1;
        }
        // Create sum matrix.
        int[][] sum = new int[matrix.length][matrix[0].length];
        // first lets fill the first row and column.
        int rows = matrix.length;
        int columns = matrix[0].length;
        sum[0][0] = matrix[0][0];
        // first fill the first row.
        for(int i=1;i<columns;i++) {
            sum[0][i] = sum[0][i-1] + matrix[0][i];
        }
        // Now fill the first column
        for(int i=1;i<rows;i++) {
            sum[i][0] = sum[i-1][0] + matrix[i][0];
        }
        // Now fill the remaining matrix.
        for(int i=1;i<rows;i++) {
            for (int j=1;j<columns;j++) {
                sum[i][j] = matrix[i][j] + sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1];
            }
        }
        int maxSum = Integer.MIN_VALUE;
        for(int i=size-1;i<rows;i++) {
            for (int j=size-1;j<columns;j++) {
                // lets calculate the sum from (size-1,size-1) index till (rows-1, columns-1)
                int sum1 = 0;
                int sum2 = 0;
                int sum3 = 0;
                if(i-size >= 0) {
                    sum1 = sum[i-size][j];
                }
                if(j-size >= 0) {
                    sum2 = sum[i][j-size];
                }
                if(i-size >=0 && j-size >=0) {
                    sum3 = sum[i-size][j-size];
                }
                int sumAtThisCoord = sum[i][j] -  sum1 - sum2 + sum3;
                if(sumAtThisCoord > maxSum) {
                    maxSum = sumAtThisCoord;
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{
                {5, 3, -1, 5},
                {-7, 3, 7, 4},
                {12, 8, 0, 0},
                {1, -8, -8, 2}
        };
        int[][] matrix = new int[][] {
                {2, 4},
                {5, 6},
                {-3, 2}
  };
        System.out.println(maximumSumSubmatrix(matrix, 2));
    }
}
