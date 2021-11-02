package solutions.medium;

/*
Time complexity will O(n).
Space will be depth of binary tree.
 */
public class HeightBalancedTree {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    Boolean res = null;
    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        if(tree == null) {
            return true;
        }
        if(isLeaf(tree)) {
            return true;
        }
        binaryTreeDiameterUtil(tree);
        return res != Boolean.FALSE;
    }

    public int binaryTreeDiameterUtil(BinaryTree node) {
        if(res != null) {
            return -1;
        }
        if(node == null) {
            return 0;
        }
        if(isLeaf(node)) {
            return 1;
        }
        int maxLeftHeight = binaryTreeDiameterUtil(node.left);
        int maxRighHeight = binaryTreeDiameterUtil(node.right);
        if(Math.abs(maxLeftHeight - maxRighHeight) > 1) {
            res = Boolean.FALSE;
        }
        int maxOfLeftAndRight = Integer.max(maxLeftHeight, maxRighHeight);
        return maxOfLeftAndRight + 1;
    }

    private static boolean isLeaf(BinaryTree node) {
        if(node.left==null && node.right == null) {
            return true;
        }
        return false;
    }
}
