package com.devrajs.algoexpert.easy;

import java.util.Arrays;
import java.util.List;

public class SpecialArr {

    public static void main(String[] args) {
        List<Object> arr = Arrays.asList(5, 2, Arrays.asList(7, -1), 3, Arrays.asList(6, Arrays.asList(-13, 8), 4));
        System.out.println(productSum(arr));
    }

    public static int productSum(List<Object> array) {
        int sum = 0;
        for (Object e : array) {
            sum += productUtil(e, 1);
        }
        return sum;
    }

    public static int productUtil(Object element, int level) {
        int sum = 0;
        if (element instanceof List) {
            List subList = (List) element;
            for (Object e : subList) {
                int sumValue = level * productUtil(e, (level + 1));
                sum += sumValue;
            }
        } else {
            sum = ((Integer) element) * level;
        }
        return sum;
    }
}