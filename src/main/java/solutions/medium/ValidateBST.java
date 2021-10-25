package solutions.medium;

public class ValidateBST {
    public static boolean validateBst(BST tree) {
        return validateBstUtil(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validateBstUtil(BST tree, int min, int max) {
        if(tree == null) {
            return true;
        }
        if(tree.value < min || tree.value >= max) {
            return false;
        }
        /*
        The logic is hard to understand, but here is explain.
        Each tree node tells its left child that you need to be between the minimum value I got from parent and my value
        i.e (min, tree.value)
        Similarly each tree node tells its right child that you need to be between my value and maximum value I got from parent and my value
        i.e (tree.value, maximum)
         */
        return validateBstUtil(tree.left, min, tree.value) && validateBstUtil(tree.right, tree.value, max);
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
