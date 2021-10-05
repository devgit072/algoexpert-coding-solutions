package solutions.medium;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(List<String> words) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : words) {
            String sortedStr = sortString(str);
            if(map.containsKey(sortedStr)) {
                map.get(sortedStr).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortedStr, list);
            }
        }
        // Write your code here.
        List<List<String>> list =  new ArrayList<>();
        for(Map.Entry<String, List<String>> entryMap : map.entrySet()) {
            List<String> l = entryMap.getValue();
            list.add(l);
        }
        return list;
    }

    static String sortString(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
