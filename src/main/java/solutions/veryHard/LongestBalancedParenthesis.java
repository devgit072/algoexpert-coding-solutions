package solutions.veryHard;

import java.util.Stack;

public class LongestBalancedParenthesis {
    /*
    This is a hard problem. There are two solution for this:
    One is stack based solution which is O(n) time and O(n) space.
    Another solution is O(n) time and O(1) space. This is a clever solution.
     */
    public int longestBalancedSubstring(String string) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        char[] chArr = string.toCharArray();
        int max = 0;
        for (int i = 0; i < chArr.length; i++) {
            if (chArr[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    // It says that from stack.peek() onwards index string is valid and hence it can
                    // considered as balanced string.
                    int diff = i - stack.peek();
                    if (diff > max) {
                        max = diff;
                    }
                }
            }
        }
        return max;
    }

    public int anotherSolution(String string) {
        char[] chArr = string.toCharArray();
        int max = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < chArr.length; i++) {
            if (chArr[i] == '(') {
                left++;
            } else {
                right++;
            }
            if (right > left) {
                left = 0;
                right = 0;
            } else if (left == right) {
                int diff = 2 * left;
                if (diff > max) {
                    max = diff;
                }
            }
        }
        left = 0;
        right = 0;
        for (int i = chArr.length - 1; i >= 0; i--) {
            if (chArr[i] == '(') {
                left++;
            } else {
                right++;
            }
            if (right > left) {
                left = 0;
                right = 0;
            } else if (left == right) {
                int diff = 2 * left;
                if (diff > max) {
                    max = diff;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        //String str = "((((((()()()())()))((())))()";
        //String str = "()(()";
        String str = "())()(()())";
        System.out.println(new LongestBalancedParenthesis().longestBalancedSubstring(str));
    }
}
