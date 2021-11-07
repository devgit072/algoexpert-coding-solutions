package solutions.medium;

import java.util.ArrayList;

public class ConstructBSTFromPreOrderTraversal {
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        BST root = null;
        for (Integer val : preOrderTraversalValues) {
            root = insertInBST(root, val);
        }
        return root;
    }

    private BST insertInBST(BST root, int value) {
        if (root == null) {
            root = new BST(value);
            return root;
        }
        BST node = root;
        BST parent = null;
        while (node != null) {
            parent = node;
            if (node.value > value) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        if (parent.value > value) {
            parent.left = new BST(value);
        } else {
            parent.right = new BST(value);
        }

        return root;
    }
}
