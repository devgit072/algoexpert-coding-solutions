package solutions.hard;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LargestRectangleOptimized {
    public static int largestRectangleUnderSkyline(List<Integer> buildings) {
        if(buildings.isEmpty()) {
            return 0;
        }
        Stack<Integer[]> stack = new Stack<>();
        int maxArea = buildings.get(0);
        stack.push(new Integer[] {0, buildings.get(0)});
        for(int i=1;i<buildings.size();i++) {
            Integer[] stackTopIndex = stack.peek();
            if(buildings.get(i) > stackTopIndex[1]) {
                stack.push(new Integer[] {i, buildings.get(i)});
            } else {
                int lastIndexPopped = -1;
                while (!stack.isEmpty() && stack.peek()[1] >= buildings.get(i)) {
                    Integer[] popped = stack.pop();
                    lastIndexPopped = popped[0];
                    int area = (popped[1] * (i - popped[0]));
                    if(area > maxArea) {
                        maxArea = area;
                    }
                }
                int indexToBePushed = lastIndexPopped;
                if(stack.isEmpty()) {
                    indexToBePushed = 0;
                }
                stack.push(new Integer[] {indexToBePushed, buildings.get(i)});
            }
        }
        int lastIndex = buildings.size();
        while (!stack.isEmpty()) {
            Integer[] topElements = stack.pop();
            int area = topElements[1] * (lastIndex - topElements[0]);
            if(area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleUnderSkyline(Arrays.asList(1, 3, 3, 3, 3, 1, 5, 3, 2)));
        //System.out.println(largestRectangleUnderSkyline(Arrays.asList(2, 1, 5, 6, 2, 3)));
    }
}
