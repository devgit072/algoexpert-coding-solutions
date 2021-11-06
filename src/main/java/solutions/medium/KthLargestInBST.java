package solutions.medium;

/*
Time complexity will be O(n)
and Space will be O(h) for recursive.
*/
public class KthLargestInBST {
    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public int findKthLargestValueInBst(BST tree, int k) {
        int val = findKthLargestValueInBstUtil(tree, k);
        return val;
    }

    int globalCurrIndex = 0;

    private int findKthLargestValueInBstUtil(BST node, int k) {
        if (node == null) {
            return -1;
        }
        if (node.right != null) {
            int rightValue = findKthLargestValueInBstUtil(node.right, k);
            if (rightValue != -1) {
                return rightValue;
            }
        }
        globalCurrIndex++;
        if (globalCurrIndex == k) {
            return node.value;
        }
        if (node.left != null) {
            return findKthLargestValueInBstUtil(node.left, k);
        }
        return -1;
    }
}
