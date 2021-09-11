package com.devrajs.algoexpert.easy;

public class BSTClosest {

    public static int findClosestValueInBst(BST tree, int target) {
        if (tree == null) {
            return Integer.MIN_VALUE;
        }
        BST closestNode = new BST(tree.value);
        traverseBSTUtil(tree, target, closestNode);
        return closestNode.value;
    }

    public static void traverseBSTUtil(BST tree, int target, BST closestNode) {
        if (tree == null) {
            return;
        }
        if (Math.abs(tree.value - target) < Math.abs(closestNode.value - target)) {
            closestNode.value = tree.value;
        }
        traverseBSTUtil(tree.left, target, closestNode);
        traverseBSTUtil(tree.right, target, closestNode);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
