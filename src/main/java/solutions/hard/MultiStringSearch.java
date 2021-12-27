package solutions.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MultiStringSearch {
    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
        // Write your code here.
        Set<String> set = new HashSet<>();
        int biggestStrlen = Integer.MIN_VALUE;
        for (String smallStr : smallStrings) {
            set.add(smallStr);
            if (smallStr.length() > biggestStrlen) {
                biggestStrlen = smallStr.length();
            }
        }
        Set<String> matchedWord = new HashSet<>();
        for (int i = 0; i < bigString.length(); i++) {
            for (int j = 1; j <= biggestStrlen && i + j <= bigString.length(); j++) {
                String subString = bigString.substring(i, i + j);
                if (set.contains(subString)) {
                    matchedWord.add(subString);
                }
            }
        }
        List<Boolean> result = new ArrayList<>();
        for(String smallStr : smallStrings) {
            if(matchedWord.contains(smallStr)) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}
