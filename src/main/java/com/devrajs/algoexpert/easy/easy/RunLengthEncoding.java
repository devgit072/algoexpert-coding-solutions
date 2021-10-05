package com.devrajs.algoexpert.easy.easy;

public class RunLengthEncoding {

    public static String runLengthEncoding(String string) {
        char[] chArr = string.toCharArray();
        StringBuilder newStr = new StringBuilder();
        int currIndex = 0;
        while (currIndex < chArr.length) {
            int currentCharCount = 1;
            char currCh = chArr[currIndex];
            int ind = currIndex + 1;
            while (ind < chArr.length && currCh == chArr[ind]) {
                currentCharCount++;
                ind++;
                if (currentCharCount == 9) {
                    break;
                }
            }
            newStr.append(currentCharCount).append(currCh);
            currIndex = ind;
        }
        return newStr.toString();
    }
}
