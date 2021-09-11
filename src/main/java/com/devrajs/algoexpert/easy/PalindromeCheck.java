package com.devrajs.algoexpert.easy;

public class PalindromeCheck {
    public static boolean isPalindrome(String str) {
        char[] charArr = str.toCharArray();
        for (int i = 0; i < (charArr.length + 1) / 2; i++) {
            if (charArr[i] != charArr[charArr.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
