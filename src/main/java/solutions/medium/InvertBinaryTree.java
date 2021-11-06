package solutions.medium;

/*
Time complexity will be O(n).
Space will be O(h) due to recursion.
 */
public class InvertBinaryTree {
    public static void invertBinaryTree(BinaryTree tree) {
        if(tree == null) {
            return;
        }
        BinaryTree leftChild = tree.left;
        BinaryTree rightChild = tree.right;
        tree.left = rightChild;
        tree.right = leftChild;
        invertBinaryTree(leftChild);
        invertBinaryTree(rightChild);
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
