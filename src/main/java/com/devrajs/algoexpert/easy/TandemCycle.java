package com.devrajs.algoexpert.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TandemCycle {
    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        List<Integer> redList = getList(redShirtSpeeds);
        List<Integer> blueList = getList(blueShirtSpeeds);
        int sum = 0;
        int halfIndex = redShirtSpeeds.length;
        if (fastest) {
            List<Integer> combinedList = new ArrayList<>();
            combinedList.addAll(redList);
            combinedList.addAll(blueList);
            Collections.sort(combinedList);
            for (int i = halfIndex; i < combinedList.size(); i++) {
                sum += combinedList.get(i);
            }
        } else {
            Collections.sort(redList);
            Collections.sort(blueList);
            for (int i = 0; i < redList.size(); i++) {
                int maxOfTwo = Math.max(redList.get(i), blueList.get(i));
                sum += maxOfTwo;
            }
        }

        return sum;
    }

    List<Integer> getList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int val : arr) {
            list.add(val);
        }
        return list;
    }
}
