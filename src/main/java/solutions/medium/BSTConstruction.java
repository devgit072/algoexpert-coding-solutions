package solutions.medium;

public class BSTConstruction {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            BST node = this;
            BST prev = null;
            while (node != null) {
                prev = node;
                if (value < node.value) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
            if (prev.value > value) {
                prev.left = new BST(value);
            } else {
                prev.right = new BST(value);
            }
            return this;
        }

        public boolean contains(int value) {
            BST node = this;
            while (node != null) {
                if (node.value == value) {
                    return true;
                }
                if (value < node.value) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
            return false;
        }

        public BST remove(int value) {
            if(isLeafNode(this)) {
                return this;
            }
            // remove the root element
            if(this.value == value) {
                if(this.left == null) {
                    int rightChildValue = this.right.value;
                    this.value = rightChildValue;
                    this.right = removeUtil(this.right, rightChildValue);
                } else if (this.right == null) {
                    int leftChildValue = this.left.value;
                    this.value = leftChildValue;
                    this.left = removeUtil(this.left, leftChildValue);
                } else {
                    int minValue = getMin(this.right).value;
                    this.value = minValue;
                    this.right = removeUtil(this.right, minValue);
                }
            } else {
                return removeUtil(this, value);
            }
            return this;
        }

        public BST removeUtil(BST bst, int value) {
            if(bst == null) {
                return null;
            }
            if(bst.value > value) {
                bst.left = removeUtil(bst.left, value);
            } else if (bst.value < value) {
                bst.right = removeUtil(bst.right, value);
            } else {
                if(bst.left == null) {
                    return bst.right;
                } else if(bst.right == null) {
                    return bst.left;
                } else {
                    int val = getMin(bst.right).value;
                    bst.value = val;
                    bst.right = removeUtil(bst.right, val);
                }
            }
            return bst;
        }

        private BST getMin(BST node) {
            if (node == null) {
                return null;
            }
            if (node.left == null) {
                return node;
            }
            return getMin(node.left);
        }

        boolean isLeafNode(BST bst) {
            return bst.left == null && bst.right == null;
        }
    }

    public static void main(String[] args) {
        BST bst = new BST(10);
        bst.insert(5);
        bst = bst.remove(10);
        System.out.println(bst.value);
    }
}
