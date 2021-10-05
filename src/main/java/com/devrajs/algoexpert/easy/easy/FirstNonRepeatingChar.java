package com.devrajs.algoexpert.easy.easy;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingChar {
    public int firstNonRepeatingCharacter(String string) {
        char[] chArr = string.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : chArr) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        for (int i = 0; i < chArr.length; i++) {
            if (map.get(chArr[i]).equals(1)) {
                return i;
            }
        }
        return -1;
    }
}
