package solutions.medium;

import java.util.HashMap;
import java.util.Map;

public class MinCharsToFormWord {

    public static char[] minimumCharactersForWords(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        int totalCount = 0;
        for (String w : words) {
            char[] arr = w.toCharArray();
            Map<Character, Integer> localMap = new HashMap<>();
            for (char ch : arr) {
                if (localMap.containsKey(ch)) {
                    localMap.put(ch, localMap.get(ch) + 1);
                    if(localMap.get(ch) > map.get(ch)) {
                        map.put(ch, localMap.get(ch));
                        totalCount++;
                    }
                } else {
                    localMap.put(ch, 1);
                    if(!map.containsKey(ch)) {
                        map.put(ch, 1);
                        totalCount++;
                    }
                }
            }
        }
        char[] res = new char[totalCount];
        int i = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            for (int k = 0; k < count; k++) {
                res[i++] = c;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = new String[] {"this", "that", "did", "deed", "them!", "a"};
        char[] res = minimumCharactersForWords(words);
        System.out.println(res);
    }
}
