package solutions.medium;

/*
Time will be O(n) and space will be O(h)
 */
public class Successor {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        return findSuccessorUtil(tree, node);
    }

    private BinaryTree findSuccessorUtil(BinaryTree tree, BinaryTree node) {
        if (tree == null) {
            return null;
        }
        if (tree.value == node.value) {
            // If node is root , then return left most in right side.
            if (node.parent == null) {
                return getLeftMost(node.right);
            }
            // 1) If node is left child and node dont have right child then parent is successor.
            else if (node.parent.left != null && node.parent.left.value == node.value && node.right == null) {
                return node.parent;
            }
            // 2) If node is left child and node has right child, then left most element in right side will be successor.
            else if (node.parent.left != null && node.parent.left.value == node.value && node.right != null) {
                return getLeftMost(node.right);
            }
            // 3) If node is right child, then left-most element in right side will be succ.
            else if (node.parent.right != null && node.parent.right.value == node.value && node.left != null) {
                return getLeftMost(node.right);
            } // 4) If node is right child and dont have any children, then grandparent will be succ.
            else if (node.parent.right != null && node.parent.right.value == node.value && node.left == null && node.right == null) {
                if (node.parent.parent != null) {
                    return node.parent.parent;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }
        BinaryTree leftRes = findSuccessorUtil(tree.left, node);
        if (leftRes != null) {
            return leftRes;
        }
        BinaryTree rightRes = findSuccessorUtil(tree.right, node);
        if (rightRes != null) {
            return rightRes;
        }
        return null;
    }

    private BinaryTree getLeftMost(BinaryTree node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        }
        return getLeftMost(node.left);
    }
}
