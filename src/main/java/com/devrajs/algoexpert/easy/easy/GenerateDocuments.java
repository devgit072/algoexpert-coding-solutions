package com.devrajs.algoexpert.easy.easy;

import java.util.HashMap;
import java.util.Map;

public class GenerateDocuments {
    public static void main(String[] args) {
        String str1 = "aheaollabbhb";
        String str2 = "hello";
        System.out.println(generateDocument(str1, str2));
    }

    public static boolean generateDocument(String characters, String document) {
        Map<Character, Integer> charMap = getMap(characters);
        Map<Character, Integer> documentMap = getMap(document);
        return checkMapEquality(charMap, documentMap);
    }

    public static Map<Character, Integer> getMap(String str) {
        char[] chArr = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chArr.length; i++) {
            Character ch = chArr[i];
            if (map.containsKey(ch)) {
                int count = map.get(ch);
                map.put(ch, count + 1);
            } else {
                map.put(ch, 1);
            }
        }
        return map;
    }

    public static boolean checkMapEquality(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            Character ch = entry.getKey();
            Integer value = entry.getValue();
            if (!map1.containsKey(ch) || map1.get(ch) < value) {
                return false;
            }
        }
        return true;
    }
}
