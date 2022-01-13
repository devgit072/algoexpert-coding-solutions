package solutions.veryHard;

import java.util.Stack;

/**
 * One solution could be do a leaf traversal from left to right and store the result in a stack. Do this for both tree.
 * Now compare both array. This will be O(n+m) and space will be number of leaves which will be stored the in the array.
 * We can improve upon the space. We will ue the stack to get the next leaf and space will be O(d1+d2) where d1 is
 * height of binary tree1 and d2 is height of binary tree2.
 */

public class CompareLeafTraversals {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public boolean compareLeafTraversal(BinaryTree tree1, BinaryTree tree2) {
        Stack<BinaryTree> stack1 = new Stack<>();
        Stack<BinaryTree> stack2 = new Stack<>();
        stack1.add(tree1);
        stack2.add(tree2);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            BinaryTree leafNode1 = getNextLeafNode(stack1);
            BinaryTree leafNode2 = getNextLeafNode(stack2);
            if (leafNode1 != null && leafNode2 != null) {
                if (leafNode1.value != leafNode2.value) {
                    return false;
                }
            } else if (leafNode1 == null && leafNode2 == null) {
                return true;
            } else {
                return false;
            }
        }
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    BinaryTree getNextLeafNode(Stack<BinaryTree> stack) {
        if (stack.isEmpty()) {
            return null;
        }
        if (isLeafNode(stack.peek())) {
            return stack.pop();
        }
        BinaryTree topElement = stack.pop();
        if (topElement.right != null) {
            stack.add(topElement.right);
        }
        if (topElement.left != null) {
            stack.add(topElement.left);
        }
        return getNextLeafNode(stack);
    }


    private boolean isLeafNode(BinaryTree node) {
        return node != null && node.left == null && node.right == null;
    }
}
