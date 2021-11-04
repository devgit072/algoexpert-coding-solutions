package solutions.medium;

import java.util.List;

/*
Time complexity will be O(n)
and space will be O(1)
 */
public class ConstructBSTWithMinHeight {
    public static BST minHeightBst(List<Integer> array) {
        return minHeightBstUtil(array, 0, array.size() - 1);
    }

    private static BST minHeightBstUtil(List<Integer> array, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }
        int midIndex = (startIndex + endIndex + 1) / 2;
        BST bst = new BST(array.get(midIndex));
        bst.left = minHeightBstUtil(array, startIndex, midIndex - 1);
        bst.right = minHeightBstUtil(array, midIndex + 1, endIndex);
        return bst;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }

}
