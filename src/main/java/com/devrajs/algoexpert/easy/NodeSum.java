package com.devrajs.algoexpert.easy;

public class NodeSum {
    public static int nodeDepths(BinaryTree root) {
        // Write your code here.
        ValueHolder valueHolder = new ValueHolder();
        valueHolder.sum = 0;
        nodeDepthsUtil(root, 0, valueHolder);
        return valueHolder.sum;
    }

    public static void nodeDepthsUtil(BinaryTree node, int currentDepth, ValueHolder valueHolder) {
        if (node == null) {
            return;
        }
        valueHolder.sum = valueHolder.sum + currentDepth;
        nodeDepthsUtil(node.left, currentDepth + 1, valueHolder);
        nodeDepthsUtil(node.right, currentDepth + 1, valueHolder);
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    static class ValueHolder {
        int sum;
    }
}
