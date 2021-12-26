package solutions.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Zigzag {
    static class Coordinates {
        int x;
        int y;

        Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        List<Coordinates> topAndRightSide = new ArrayList<>();
        List<Coordinates> leftAndBottomSide = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int rows = array.size();
        int columns = array.get(0).size();
        for (int i = 0; i < columns; i++) {
            topAndRightSide.add(new Coordinates(0, i));
        }
        for (int i = 1; i < rows; i++) {
            topAndRightSide.add(new Coordinates(i, columns - 1));
        }
        for (int i = 0; i < rows; i++) {
            leftAndBottomSide.add(new Coordinates(i, 0));
        }
        for (int i = 1; i < columns; i++) {
            leftAndBottomSide.add(new Coordinates(rows - 1, i));
        }

        int index = 0;
        boolean upDown = true;
        while (index < leftAndBottomSide.size()) {
            Coordinates index1 = topAndRightSide.get(index);
            Coordinates index2 = leftAndBottomSide.get(index);

            if (upDown) {
                int x1 = index1.x;
                int y1 = index1.y;
                int x2 = index2.x;
                int y2 = index2.y;

                int i = x1;
                int j = y1;

                while (i <= x2 && j >= y2) {
                    System.out.print("  " + array.get(i).get(j));
                    result.add(array.get(i).get(j));
                    i++;
                    j--;
                }
                upDown = false;
            } else {
                int x1 = index2.x;
                int y1 = index2.y;
                int x2 = index1.x;
                int y2 = index1.y;
                int i=x1;
                int j=y1;
                while (i >=x2 && j <= y2) {
                    System.out.print("  " + array.get(i).get(j));
                    result.add(array.get(i).get(j));
                    i--;
                    j++;
                }
                upDown = true;
            }
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 3, 4, 10),
                Arrays.asList(2, 5, 9, 11),
                Arrays.asList(6, 8, 12, 15),
                Arrays.asList(7, 13, 14, 16)
        );
        zigzagTraverse(matrix);
    }
}

