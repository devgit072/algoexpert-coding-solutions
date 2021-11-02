package solutions.medium;

/*
Time complexity is O(n)
Space is O(n)
 */
public class BinaryTreeDiameter {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    int max = -1;
    public int binaryTreeDiameter(BinaryTree tree) {
        if(tree == null) {
            return -1;
        }
        if(isLeaf(tree)) {
            return 0;
        }
        binaryTreeDiameterUtil(tree);
        return max;
    }

    public int binaryTreeDiameterUtil(BinaryTree node) {
        if(node == null) {
            return 0;
        }
        if(isLeaf(node)) {
            return 1;
        }
        int maxLeftHeight = binaryTreeDiameterUtil(node.left);
        int maxRighHeight = binaryTreeDiameterUtil(node.right);
        int maxOfLeftAndRight = Integer.max(maxLeftHeight, maxRighHeight);
        int valueToReturn =  maxOfLeftAndRight + 1;
        int maxLocalDiameter = maxLeftHeight + maxRighHeight;
        if(maxLocalDiameter > max) {
            max = maxLocalDiameter;
        }
        return valueToReturn;
    }

    private static boolean isLeaf(BinaryTree node) {
        if(node.left==null && node.right == null) {
            return true;
        }
        return false;
    }
}
