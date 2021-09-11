package com.devrajs.algoexpert.easy;

import java.util.ArrayList;
import java.util.List;

public class BranchSum {
    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> sumList = new ArrayList<>();
        branchSumsUtil(root, sumList, 0);
        return sumList;
    }

    public static void branchSumsUtil(BinaryTree node, List<Integer> sumTillLeaf, int sumSoFar) {
        if (node == null) {
            return;
        }
        int sum = sumSoFar + node.value;
        if (node.left == null && node.right == null) {
            sumTillLeaf.add(sum);
        }
        branchSumsUtil(node.left, sumTillLeaf, sum);
        branchSumsUtil(node.right, sumTillLeaf, sum);
    }

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}