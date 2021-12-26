package solutions.hard;

public class WaterArea {
    public static int waterArea(int[] heights) {
        if(heights.length == 0) {
            return 0;
        }
        // First lets complete maximum from right to left.
        int[] rightToLeftMax = new int[heights.length];
        rightToLeftMax[heights.length - 1] = heights[heights.length - 1];
        for (int i = heights.length - 2; i >= 0; i--) {
            rightToLeftMax[i] = Math.max(heights[i], rightToLeftMax[i + 1]);
        }
        // Next calculate maximum from left to right.
        int[] leftToRightMax = new int[heights.length];
        leftToRightMax[0] = heights[0];
        for (int i = 1; i < heights.length; i++) {
            leftToRightMax[i] = Math.max(leftToRightMax[i - 1], heights[i]);
        }
        // Next calculate area at each point and sum it up.
        int totalWater = 0;
        for (int i = 1; i < heights.length-1; i++) {
            int leftMax = leftToRightMax[i-1];
            int rightMax = rightToLeftMax[i+1];
            int maxOverall = Math.min(leftMax, rightMax);
            int heightDiff = maxOverall - heights[i];
            if(heightDiff <= 0) {
                continue;
            }
            totalWater += heightDiff;
        }
        return totalWater;
    }

    public static void main(String[] args) {
        int[] heights = new int[] {0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};
        System.out.println(waterArea(heights));
    }
}
