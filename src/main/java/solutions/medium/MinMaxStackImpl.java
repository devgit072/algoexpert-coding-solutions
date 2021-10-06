package solutions.medium;

import java.util.ArrayList;
import java.util.List;

public class MinMaxStackImpl {
    static class MinMaxStack {
        private List<Integer> list;
        private List<Integer> maxList;
        private List<Integer> minList;
        MinMaxStack() {
            list = new ArrayList<>();
            maxList = new ArrayList<>();
            minList = new ArrayList<>();
        }
        public int peek() {
            if(list == null || list.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return list.get(list.size()-1);
        }

        public int pop() {
            if(list == null || list.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            int val = peek();
            list.remove(list.size() - 1);
            minList.remove(minList.size() - 1);
            maxList.remove(maxList.size() - 1);
            return val;
        }

        public void push(Integer number) {
            list.add(number);
            if(minList.isEmpty() || minList.get(minList.size() - 1) > number) {
                minList.add(number);
            } else {
                minList.add(getMin());
            }
            if(maxList.isEmpty() || maxList.get(maxList.size() - 1) < number) {
                maxList.add(number);
            } else {
                maxList.add(getMax());
            }
        }

        public int getMin() {
            if(minList == null || minList.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return minList.get(minList.size() - 1);
        }

        public int getMax() {
            if(maxList == null || maxList.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return maxList.get(maxList.size() - 1);
        }
    }

    public static void main(String[] args) {
        MinMaxStack minMaxStack = new MinMaxStack();
        minMaxStack.push(5);
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMax());
        System.out.println(minMaxStack.peek());
        minMaxStack.push(7);
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMax());
        System.out.println(minMaxStack.peek());
        minMaxStack.push(2);
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMax());
        System.out.println(minMaxStack.peek());
        System.out.println(minMaxStack.pop());
        System.out.println(minMaxStack.pop());
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMax());
        System.out.println(minMaxStack.peek());
    }
}
