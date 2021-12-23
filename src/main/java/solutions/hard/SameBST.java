package solutions.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SameBST {
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne.isEmpty() && arrayTwo.isEmpty()) {
            return true;
        }
        if(arrayOne.isEmpty() || arrayTwo.isEmpty()) {
            return false;
        }
        if (!arrayOne.get(0).equals(arrayTwo.get(0)) || (arrayOne.size() != arrayTwo.size())) {
            return false;
        }
        if(arrayOne.size() == 1) {
            return true;
        }

        int root1 = arrayOne.get(0);
        List<Integer> leftTree1 = new ArrayList<>();
        List<Integer> rightTree1 = new ArrayList<>();
        int i = 1;
        while (i < arrayOne.size()) {
            if (arrayOne.get(i) < root1) {
                leftTree1.add(arrayOne.get(i));
            } else {
                rightTree1.add(arrayOne.get(i));
            }
            i++;
        }

        int root2 = arrayTwo.get(0);
        List<Integer> leftTree2 = new ArrayList<>();
        List<Integer> rightTree2 = new ArrayList<>();
        i = 1;
        while (i < arrayTwo.size()) {
            if (arrayTwo.get(i) < root2) {
                leftTree2.add(arrayTwo.get(i));
            } else {
                rightTree2.add(arrayTwo.get(i));
            }
            i++;
        }
        return sameBsts(leftTree1, leftTree2) && sameBsts(rightTree1, rightTree2);
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2, 11);
        List<Integer> list2 = Arrays.asList(10, 8, 5, 15, 2, 12, 11, 94, 81);
        System.out.println(sameBsts(list1, list2));
    }
}
