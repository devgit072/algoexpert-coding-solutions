package solutions.medium;

/**
 * Time complexity will be O(m*n) because we are using dyanmic programming.
 * Space complexity will be O(m*n) for using memoization.
 */
public class NumberOfWaysToReachRightBottom {
    public int numberOfWaysToTraverseGraph(int width, int height) {
        int initialXCoordinate = 0;
        int initialYCoordinate = 0;
        int[][] memoi = new int[height][width];
        for(int i = 0;i<height;i++) {
            for(int j=0;j<width;j++) {
                memoi[i][j] = -1;
            }
        }
        return numberOfWaysToTraverseGraphUtil(initialXCoordinate, initialYCoordinate, width, height, memoi);
    }
    public int numberOfWaysToTraverseGraphUtil(int x, int y, int width, int height, int[][] memoi) {
        if(!isValidCoordinates(x, y, width, height)) {
            return 0;
        }
        if(memoi[x][y] != -1) {
            return memoi[x][y];
        }
        if(x==height-1 && y==width-1) {
            return 1;
        }
        int totalWays = numberOfWaysToTraverseGraphUtil(x, y+1, width, height, memoi)
                + numberOfWaysToTraverseGraphUtil(x+1, y, width, height, memoi);
        memoi[x][y] = totalWays;
        return totalWays;
    }

    boolean isValidCoordinates(int x, int y, int width, int height) {
        if(x < 0 || y < 0 || x >=height || y >= width) {
            return false;
        }
        return true;
    }
}
