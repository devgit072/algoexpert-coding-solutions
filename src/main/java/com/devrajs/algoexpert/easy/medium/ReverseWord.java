package com.devrajs.algoexpert.easy.medium;

public class ReverseWord {
    public String reverseWordsInString(String string) {
        char[] arr = string.toCharArray();
        int i = 0;
        while (i < arr.length) {
            int startIndex = i;
            int endIndex = i;
            while (true) {
                endIndex++;
                if (endIndex == arr.length) {
                    endIndex--;
                    break;
                }
                if(arr[endIndex] == ' ') {
                    endIndex--;
                    break;
                }
            }
            if (startIndex != endIndex) {
                // reverse the string.
                for (int k = 0; k < (endIndex - startIndex+1)/2; k++) {
                    char temp = arr[startIndex + k];
                    arr[startIndex + k] = arr[endIndex - k];
                    arr[endIndex - k] = temp;
                }
            }
            i = endIndex + 1;
            while (i < arr.length && arr[i] == ' ') {
                i++;
            }
        }
        int len = arr.length-1;
        for(int k=0;k<(arr.length+1)/2;k++) {
            char temp = arr[k];
            arr[k] = arr[len - k];
            arr[len - k] = temp;
        }
        return new String(arr);
    }
}
