package com.devrajs.algoexpert.easy.easy;

public class CaesarCipher {
    public static void main(String[] args) {
        caesarCypherEncryptor("xyz", 2);
    }

    public static String caesarCypherEncryptor(String str, int key) {
        key = key % 26;
        char[] chArr = str.toCharArray();
        char[] newChar = new char[chArr.length];
        for (int i = 0; i < chArr.length; i++) {
            newChar[i] = getChar(chArr[i], key);
        }
        System.out.println(newChar);
        return new String(newChar);
    }

    public static char getChar(char ch, int key) {
        char a = 'a';
        char z = 'z';
        if (ch + key <= 'z') {
            return (char) ((int) ch + key);
        } else {
            int over = ch + key - z;
            return (char) ((int) a + over - 1);
        }
    }
}
