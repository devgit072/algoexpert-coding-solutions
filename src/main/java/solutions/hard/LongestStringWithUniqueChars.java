package solutions.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class LongestStringWithUniqueChars {
    public static String longestSubstringWithoutDuplication(String str) {
        int start = 0;
        int end = 0;
        Map<Character, Integer> charToPositionMap = new HashMap<>();
        char[] chArr = str.toCharArray();
        charToPositionMap.put(chArr[0], 0);
        int max = 1;
        int startOfMax = 0;
        int endOfMax = 0;
        for (int i = 1; i < chArr.length; i++) {
            char ch = chArr[i];
            if (charToPositionMap.containsKey(ch) && charToPositionMap.get(ch) >= start) {
                start = charToPositionMap.get(ch) + 1;
            } else {
                end = i;
                if (end - start + 1 > max) {
                    max = end - start + 1;
                    startOfMax = start;
                    endOfMax = end;
                }
            }
            charToPositionMap.put(ch, i);
        }
        String maxStr = str.substring(startOfMax, endOfMax+1);
        return maxStr;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutDuplication("abcdeabcdefc"));
    }
}
