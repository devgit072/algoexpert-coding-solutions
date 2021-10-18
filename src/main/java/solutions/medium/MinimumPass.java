package solutions.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MinimumPass {
    static class Pair {
        int x,y;

        public Pair(int i, int j) {
            this.x = i;
            this.y = j;
        }
    }

    // The time complexity for this solution would be (m*n)*k where k is number of passes. Assuming k as constant, we
    // can say that time complexity would be m*n only.
    public int minimumPassesOfMatrixLessOptimised(int[][] matrix) {
        int x_len = matrix.length;
        int y_len = matrix[0].length;
        int pass = 0;
        while(true) {
            //System.out.println("okay");
            boolean turnedPositive = false;
            List<Pair> addedCoordinates = new ArrayList<>();
            for (int i = 0; i < x_len; i++) {
                for (int j = 0; j < y_len; j++) {
                    //System.out.println("Here");
                    int val = matrix[i][j];
                    if(val < 0 ) {
                        // left
                        if(validCoordinates(i,j-1, x_len, y_len) && matrix[i][j-1] > 0 ) {
                            addedCoordinates.add(new Pair(i,j));
                            continue;
                        }
                        // above
                        if(validCoordinates(i-1,j, x_len, y_len) && matrix[i-1][j] > 0 ) {
                            addedCoordinates.add(new Pair(i,j));
                            continue;
                        }
                        // right
                        if(validCoordinates(i,j+1, x_len, y_len) && matrix[i][j+1] > 0 ) {
                            addedCoordinates.add(new Pair(i,j));
                            continue;
                        }
                        // down
                        if(validCoordinates(i+1,j, x_len, y_len) && matrix[i+1][j] > 0 ) {
                            addedCoordinates.add(new Pair(i,j));
                        }
                    }
                }
            }
            if(addedCoordinates.size() <= 0) {
                break;
            } else {
                pass++;
                for(Pair p : addedCoordinates) {
                    matrix[p.x][p.y] *= -1;
                }
            }
        }
        for(int i=0;i<x_len;i++) {
            for(int j=0;j<y_len;j++) {
                if(matrix[i][j] < 0) {
                    return -1;
                }
            }
        }
        return pass;
    }

    public boolean validCoordinates(int x,int y, int x_len, int y_len) {
        return x >= 0 && y >= 0 && x < x_len && y < y_len;
    }

    // We have a better solution than above. We can solve in m*n time complexities.
    /*
    The idea is use to BFS and use two queue. We will traverse the matrix and store the indices of each positive number
    in the queue. Next we will dequeue each element from primary queue and store the indices of neighbor indices which
    has been turned negative to positive in the secondary queue. Next we will dequeue the secondary queue and store the
    indices of neighbor elements which could be turned from positive to negative. Every time queue gets empty, we increase
    the number of passes.
     */

    public int minimumPassesOfMatrix(int[][] matrix) {
        int x_len = matrix.length;
        int y_len = matrix[0].length;
        Queue<Pair> primaryQueue = new ArrayDeque<>();
        Queue<Pair> secondaryQueue = new ArrayDeque<>();
        int minimumPasses = 0;
        for (int i = 0; i < x_len; i++) {
            for (int j = 0; j < y_len; j++) {
                if(matrix[i][j] > 0) {
                    primaryQueue.add(new Pair(i,j));
                }
            }
        }
        while(!primaryQueue.isEmpty() || !secondaryQueue.isEmpty()) {
            // at any point of time either primaryQueue or secondaryQueue will not be empty.
            boolean convertedToPositive = false;
            while(!primaryQueue.isEmpty()) {
                Pair p = primaryQueue.remove();
                int i = p.x;
                int j = p.y;
                // check if left element is negative
                if(validCoordinates(i,j-1, x_len, y_len) && matrix[i][j-1] < 0 ) {
                    matrix[i][j-1] = matrix[i][j-1] * -1;
                    secondaryQueue.add(new Pair(i,j-1));
                    convertedToPositive = true;
                }
                // check if above element is negative
                if(validCoordinates(i-1,j, x_len, y_len) && matrix[i-1][j] < 0 ) {
                    matrix[i-1][j] = matrix[i-1][j] * -1;
                    secondaryQueue.add(new Pair(i-1,j));
                    convertedToPositive = true;
                }
                // check if right side element is negative
                if(validCoordinates(i,j+1, x_len, y_len) && matrix[i][j+1] < 0 ) {
                    matrix[i][j+1] = matrix[i][j+1] * -1;
                    secondaryQueue.add(new Pair(i,j+1));
                    convertedToPositive = true;
                }
                // check if down element is negative
                if(validCoordinates(i+1,j, x_len, y_len) && matrix[i+1][j] < 0 ) {
                    matrix[i+1][j] = matrix[i+1][j] * -1;
                    secondaryQueue.add(new Pair(i+1,j));
                    convertedToPositive = true;
                }
            }
            if(convertedToPositive) {
                minimumPasses++;
                convertedToPositive = false;
            }
            while(!secondaryQueue.isEmpty()) {
                Pair p = secondaryQueue.remove();
                int i = p.x;
                int j = p.y;
                // check if left element is negative
                if(validCoordinates(i,j-1, x_len, y_len) && matrix[i][j-1] < 0 ) {
                    matrix[i][j-1] = matrix[i][j-1] * -1;
                    primaryQueue.add(new Pair(i,j-1));
                    convertedToPositive = true;
                }
                // check if above element is negative
                if(validCoordinates(i-1,j, x_len, y_len) && matrix[i-1][j] < 0 ) {
                    matrix[i-1][j] = matrix[i-1][j] * -1;
                    primaryQueue.add(new Pair(i-1,j));
                    convertedToPositive = true;
                }
                // check if right side element is negative
                if(validCoordinates(i,j+1, x_len, y_len) && matrix[i][j+1] < 0 ) {
                    matrix[i][j+1] = matrix[i][j+1] * -1;
                    primaryQueue.add(new Pair(i,j+1));
                    convertedToPositive = true;
                }
                // check if down element is negative
                if(validCoordinates(i+1,j, x_len, y_len) && matrix[i+1][j] < 0 ) {
                    matrix[i+1][j] = matrix[i+1][j] * -1;
                    primaryQueue.add(new Pair(i+1,j));
                    convertedToPositive = true;
                }
            }
            if(convertedToPositive) {
                minimumPasses++;
            }
        }

        return minimumPasses;
    }
    public static void main(String[] args) {
        MinimumPass m = new MinimumPass();
        int[][] matrix = new int[][] {{0,-1,-3,2,0}, {1,-2,-5,-1,-3}, {3,0,0,-4,-1}};
        //System.out.println(matrix.length);
        //System.out.println(matrix[0].length);
        System.out.println(m.minimumPassesOfMatrix(matrix));
    }
}
