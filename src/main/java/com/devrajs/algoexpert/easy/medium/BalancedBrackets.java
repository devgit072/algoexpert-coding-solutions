package com.devrajs.algoexpert.easy.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class BalancedBrackets {
    public static boolean balancedBrackets(String str) {
        char[] arr = str.toCharArray();
        if (arr.length == 0) {
            return true;
        }
        if(arr.length == 1) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        stack.push(arr[0]);
        for(int i=1;i<arr.length;i++) {
            if(stack.isEmpty()) {
                if(arr[i] == '(' || arr[i] == '{' || arr[i] == '[' || arr[i] == ')' || arr[i] == '}' || arr[i] == ']') {
                    stack.push(arr[i]);
                }
                continue;
            }
            char topChar = stack.peek();
            if(topChar == '(' && arr[i] == ')') {
                stack.pop();
            } else if(topChar == '{' && arr[i] == '}') {
                stack.pop();
            } else if(topChar == '[' && arr[i] == ']') {
                stack.pop();
            } else if (arr[i] == '(' || arr[i] == '{' || arr[i] == '[' || arr[i] == ')' || arr[i] == '}' || arr[i] == ']') {
                stack.push(arr[i]);
            }
        }
        return stack.isEmpty();
    }
}
