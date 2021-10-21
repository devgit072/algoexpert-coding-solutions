package solutions.medium;

import java.util.ArrayList;
import java.util.List;

public class RiverSize {
    public static List<Integer> riverSizes(int[][] matrix) {
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int value = riverSizeUtil(matrix, i, j, memo);
                if (value != 0) {
                    list.add(value);
                }
            }
        }
        return list;
    }

    public static int riverSizeUtil(int[][] matrix, int x, int y, int[][] memo) {
        if (!validCoordinates(x, y, matrix)) {
            return 0;
        }
        if (memo[x][y] != -1) {
            return 0;
        }
        if (matrix[x][y] == 0) {
            memo[x][y] = 1;
            return 0;
        } else {
            memo[x][y] = 1;
            return 1 + riverSizeUtil(matrix, x, y - 1, memo)
                    + riverSizeUtil(matrix, x - 1, y, memo)
                    + riverSizeUtil(matrix, x, y + 1, memo)
                    + riverSizeUtil(matrix, x + 1, y, memo);
        }
    }

    public static boolean validCoordinates(int x, int y, int[][] matrix) {
        if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
            return false;
        }
        return true;
    }
}
