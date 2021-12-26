package solutions.hard;

import java.util.ArrayList;
import java.util.List;

public class UndescorifyString {
    public static String underscorifySubstring(String str, String substring) {
        // First find the indexes of substring in the string.
        List<Integer> indexes = new ArrayList<>();
        int beginIndex = 0;
        while (true) {
            int index = str.indexOf(substring, beginIndex);
            if (index == -1) {
                break;
            }
            indexes.add(index);
            beginIndex = index + 1;
        }
        if(indexes.size() == 0) {
            return str;
        }
        int i = 0;
        String result = "";
        List<String> words = new ArrayList<>();
        int firstIndex = indexes.get(0);
        String firstWord = str.substring(0, firstIndex);
        words.add(firstWord);
        int endIndex = -1;
        while (i < indexes.size()) {
            int startIndex = indexes.get(i);
            int currentBeginIndex = startIndex;
            int tempIndex = i + 1;
            while (tempIndex < indexes.size() && currentBeginIndex + substring.length() >= indexes.get(tempIndex)) {
                currentBeginIndex = indexes.get(tempIndex);
                tempIndex = tempIndex + 1;
            }
            i = tempIndex;
            int currentEndIndex = currentBeginIndex + substring.length();
            endIndex = currentEndIndex;
            String word = str.substring(startIndex, currentEndIndex);
            words.add(word);
            if(i<indexes.size()) {
                String anotherWord = str.substring(currentEndIndex, indexes.get(i));
                words.add(anotherWord);
            }
        }
        if(endIndex != -1) {
            String endWord = str.substring(endIndex);
            words.add(endWord);
        }
        System.out.println(words);
        String finalResult = "";
        for(String w : words) {
            String wordToBeAdded = w;
            if(w.startsWith(substring)) {
                wordToBeAdded = "_"+wordToBeAdded+"_";
            }
            finalResult += wordToBeAdded;
        }
        return finalResult;
    }

    public static void main(String[] args) {
        System.out.println(underscorifySubstring("testhellotesttestestworldtest", "test"));
    }
}
