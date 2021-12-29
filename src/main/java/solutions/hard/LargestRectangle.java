package solutions.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestRectangle {
    /**
     * Lets solve first using O(n^2) solution.
     */
    public static int largestRectangleUnderSkyline(List<Integer> buildings) {
        // Write your code here.
        int maxArea = 0;
        for (int i = 0; i < buildings.size(); i++) {
            int minimumHeightSeen = Integer.MAX_VALUE;
            for (int j = i; j >= 0; j--) {
                int heightAti = buildings.get(i);
                int heightAtj = buildings.get(j);
                minimumHeightSeen = Math.min(minimumHeightSeen, Math.min(heightAti, heightAtj));
                int area = minimumHeightSeen * (i-j+1);
                if(area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleUnderSkyline(Arrays.asList(1, 3, 3, 2, 4, 1, 5, 3, 2)));
    }
}
