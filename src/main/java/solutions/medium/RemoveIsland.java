package solutions.medium;

public class RemoveIsland {
    /*
    This solution time-complexity is O(m*n) and space is O(m*n)
    */
    public int[][] removeIslands(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        boolean[][] borderCoordinates = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                isBorderIsland(i, j, matrix, visited, borderCoordinates);
            }
        }
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (!borderCoordinates[i][j] && matrix[i][j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }

    public boolean isBorderIsland(int x, int y, int[][] matrix, boolean[][] visited, boolean[][] borderCoordinates) {
        if (!validCoordinates(x, y, matrix)) {
            return false;
        }

        if (visited[x][y]) {
            return borderCoordinates[x][y];
        }

        visited[x][y] = true;
        if (matrix[x][y] == 0) {
            return false;
        }
        if (isBorderCoordinates(x, y, matrix)) {
            borderCoordinates[x][y] = true;
            return true;
        }
        boolean val = isBorderIsland(x, y - 1, matrix, visited, borderCoordinates)
                || isBorderIsland(x - 1, y, matrix, visited, borderCoordinates)
                || isBorderIsland(x, y + 1, matrix, visited, borderCoordinates)
                || isBorderIsland(x + 1, y, matrix, visited, borderCoordinates);
        borderCoordinates[x][y] = val;
        return val;
    }

    public static boolean validCoordinates(int x, int y, int[][] matrix) {
        return x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length;
    }

    public static boolean isBorderCoordinates(int x, int y, int[][] matrix) {
        return x == 0 || y == 0 || x == matrix.length - 1 || y == matrix[0].length - 1;
    }

    /*
    Another better solution is to do only border traversal and do DFS. Convert all 1 into 2.
    And at last, convert all 1 into 0 because all left-over 1 are the one which has not been touched by DFS.
    This will be better than above solution, because we don't have to touch the internal 1's and hence it will be
    bettern O(m*n)
     */
}
