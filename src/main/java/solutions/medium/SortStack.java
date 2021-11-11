package solutions.medium;

import java.util.ArrayList;
import java.util.List;

public class SortStack {

    public static ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        if (stack.isEmpty()) {
            return stack;
        }
        int popped = stack.remove(stack.size() - 1);
        sortStack(stack);
        insertElement(stack, popped);
        return stack;
    }

    public static void insertElement(ArrayList<Integer> stack, int element) {
        if (stack.isEmpty() || stack.get(stack.size() - 1) <= element) {
            stack.add(element);
            return;
        }
        int currentTopElement = stack.remove(stack.size() - 1);
        insertElement(stack, element);
        stack.add(currentTopElement);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-5);
        list.add(2);
        list.add(-2);
        list.add(4);
        list.add(3);
        list.add(1);
        sortStack(list);
    }
}
