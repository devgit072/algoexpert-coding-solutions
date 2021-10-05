package com.devrajs.algoexpert.easy.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] array) {
        if(array.length == 0) {
            return array;
        }
        int[] res = new int[array.length];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int i=1;
        boolean secondIteration = false;
        while(i < array.length && i != stack.peek()) {
            if(!secondIteration && array[i] <= array[stack.peek()]) {
                stack.push(i);
            } else {
                while(!stack.isEmpty() && array[stack.peek()] < array[i]) {
                    int index = stack.pop();
                    res[index] = array[i];
                }
                if(!secondIteration) {
                    stack.push(i);
                }
            }
            i++;
            if(i== stack.peek()) {
                break;
            }
            if(i==array.length) {
                if(secondIteration) {
                    break;
                }
                secondIteration = true;
                i=0;
            }
        }
        while (!stack.isEmpty()) {
            res[stack.pop()] = -1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5, 6, 6, 6, 7, -1, 5};
        int[] res = nextGreaterElement(arr);
        System.out.println(Arrays.toString(res));
    }
}
