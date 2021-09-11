package com.devrajs.algoexpert.easy;

import java.util.*;

public class CheckSubsequence {

    public static void main(String[] args) {
        //Integer[] array = new int[]{5, 1, 22, 25, 6, -1, 8, 10};
        //int[] sequence = new int[] {1, 6, -1, -2};
        System.out.println(isValidSubsequence(Arrays.asList(1, 1, 1, 1, 1, 1), Arrays.asList(1, 1, 1)));
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        Map<Integer, List<Integer>> elementAndItsPositionsMap = new HashMap<>();
        for (int i = 0; i < array.size(); i++) {
            int element = array.get(i);
            if (elementAndItsPositionsMap.containsKey(element)) {
                List<Integer> positions = elementAndItsPositionsMap.get(element);
                positions.add(i);
            } else {
                List<Integer> newList = new ArrayList<>();
                newList.add(i);
                elementAndItsPositionsMap.put(element, newList);
            }
        }
        Map<Integer, Integer> positionIndex = new HashMap<>();
        for (Integer val : array) {
            positionIndex.put(val, 0);
        }

        int prevPos = -1;
        for (Integer val : sequence) {
            if (!elementAndItsPositionsMap.containsKey(val)) {
                return false;
            }
            List<Integer> positionList = elementAndItsPositionsMap.get(val);
            int currentPos = positionList.get(positionIndex.get(val));
            if (currentPos <= prevPos) {
                return false;
            }
            if (elementAndItsPositionsMap.get(val).size() > positionIndex.get(val) + 1) {
                positionIndex.put(val, positionIndex.get(val) + 1);
            }
            prevPos = currentPos;
        }
        return true;
    }
}
