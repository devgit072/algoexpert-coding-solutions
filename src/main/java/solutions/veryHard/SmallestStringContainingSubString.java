package solutions.veryHard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SmallestStringContainingSubString {
    public static String smallestSubstringContaining(String bigString, String smallString) {
        Map<Character, Integer> smallStringMap = new HashMap<>();
        Map<Character, Integer> bigStringMap = new HashMap<>();
        for(int i=0;i<smallString.length();i++) {
            Character ch = smallString.charAt(i);
            if(smallStringMap.containsKey(ch)) {
                smallStringMap.put(ch, smallStringMap.get(ch) + 1);
            } else {
                smallStringMap.put(ch, 1);
            }
        }
        Map<Character, Integer> charToIndexMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        String minStr = "";
        Set<Character> matchedChars = new HashSet<>();
        while (right < bigString.length()) {
            char ch = bigString.charAt(right);
            if(!charToIndexMap.containsKey(ch)) {
                charToIndexMap.put(ch, right);
            }
            if(smallStringMap.containsKey(ch)) {
                if(bigStringMap.containsKey(ch)) {
                    bigStringMap.put(ch, bigStringMap.get(ch) + 1);
                } else {
                    bigStringMap.put(ch, 1);
                }
                while (true) {
                    char chAtLeft = bigString.charAt(left);
                    if(!smallStringMap.containsKey(chAtLeft)) {
                        left++;
                    } else if(bigStringMap.get(chAtLeft) > smallStringMap.get(chAtLeft)) {
                        left++;
                        bigStringMap.put(chAtLeft, bigStringMap.get(chAtLeft) - 1);
                    } else {
                        break;
                    }
                }
                if(bigStringMap.get(ch).equals(smallStringMap.get(ch))) {
                    matchedChars.add(ch);
                }
                if(smallStringMap.size() == matchedChars.size()) {
                    String str = bigString.substring(left, right+1);
                    if(str.length() < minLength) {
                        minLength = str.length();
                        minStr = str;
                    }
                }
            }
            right++;
        }
        return minStr;
    }

    public static void main(String[] args) {
        String bigStr = "abcdefghijklmnopqrstuvwxyz";
        String small = "aajjttwwxxzz";
        System.out.println(smallestSubstringContaining(bigStr, small));
    }
}
