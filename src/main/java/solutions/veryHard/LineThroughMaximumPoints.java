package solutions.veryHard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In order to solve any algorithminc question related to points and line we have to know two things:
 * a) How to calculate the slope i.e m
 * b) How to calculate the line equation which is y=mx+b
 * <p>
 * To calculate slope, we just have to do m=(y1-y2)/(x1-x2)
 * Now we have value of m, now just calculate the value of b by subsituting the x and y values from one of the points.
 */
public class LineThroughMaximumPoints {
    class LineEquation {
        // Line equation: y=mx+b;
        double m;
        double b;
    }

    public int lineThroughPoints(int[][] points) {
        int totalPoints = points.length;
        if (totalPoints <= 2) {
            return totalPoints;
        }
        int maxCount = Integer.MIN_VALUE;
        List<Integer[]> maxPoints = new ArrayList<>();
        List<LineEquation> equationList = new ArrayList<>();
        for (int i = 0; i < totalPoints; i++) {
            for (int j = i + 1; j < totalPoints; j++) {
                int[] point1 = points[i];
                int[] point2 = points[j];
                LineEquation equation = getLineEquation(point1[0], point1[1], point2[0], point2[1]);
                equationList.add(equation);
            }
        }

        for (LineEquation equation : equationList) {
            int count = 0;
            List<Integer[]> listOfPoints = new ArrayList<>();
            for (int[] point : points) {
                if (checkIfPointIsInLine(point[0], point[1], equation)) {
                    listOfPoints.add(new Integer[]{point[0], point[1]});
                    count++;
                    if (maxCount < count) {
                        maxPoints = listOfPoints;
                        maxCount = count;
                    }
                }
            }
        }
        return maxCount;
    }

    boolean areEqual(LineEquation equation1, LineEquation equation2) {
        return equation1.m == equation2.m && equation1.b == equation2.b;
    }

    boolean checkIfPointIsInLine(int x, int y, LineEquation equation) {
        double ySide = y;
        double xSide = (x * equation.m) + equation.b;
        if (ySide == xSide) {
            return true;
        }
        return false;
    }

    private LineEquation getLineEquation(int x1, int y1, int x2, int y2) {
        int y1_y2 = y1 - y2;
        int x1_x2 = x1 - x2;
        double slope;
        if (x1_x2 == 0) {
            slope = 1.0;
        } else {
            slope = (double) y1_y2 / x1_x2;
        }
        // Now calculate the value of b. b=y-mx
        double b;
        if (x1 == y1) {
            b = y2 - (slope * x2);
        } else {
            b = y1 - (slope * x1);
        }
        LineEquation equation = new LineEquation();
        equation.m = slope;
        equation.b = b;
        return equation;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{
                new int[]{1, 1},
                new int[]{1, 2},
                new int[]{1, 3},
                new int[]{1, 4},
                new int[]{1, 5},
                new int[]{2, 1},
                new int[]{2, 2},
                new int[]{2, 3},
                new int[]{2, 4},
                new int[]{2, 5},
                new int[]{3, 1},
                new int[]{3, 2},
                new int[]{3, 4},
                new int[]{3, 5},
                new int[]{4, 1},
                new int[]{4, 2},
                new int[]{4, 3},
                new int[]{4, 4},
                new int[]{4, 5},
                new int[]{5, 1},
                new int[]{5, 2},
                new int[]{5, 3},
                new int[]{5, 4},
                new int[]{5, 5},
                new int[]{6, 6},
                new int[]{2, 6}
        };
        System.out.println(new LineThroughMaximumPoints().lineThroughPoints(points));
    }
}