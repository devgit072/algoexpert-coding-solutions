package solutions.hard;

public class MaxPathSum {
    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class ValueHolder {
        public int value;
    }


    public static int maxPathSum(BinaryTree tree) {
        if(tree==null) {
            return 0;
        }

        ValueHolder valueHolder = new ValueHolder();
        valueHolder.value = Integer.MIN_VALUE;
        maxPathSumUtil(tree, valueHolder);
        return valueHolder.value;
    }

    public static int maxPathSumUtil(BinaryTree tree, ValueHolder valueHolder) {
        if(tree==null) {
            return 0;
        }
        int nodeValue = tree.value;
        int leftValue = maxPathSumUtil(tree.left, valueHolder);
        if(leftValue<0) {
            leftValue = 0;
        }
        int rightValue = maxPathSumUtil(tree.right, valueHolder);
        if(rightValue<0) {
            rightValue = 0;
        }
        if(nodeValue + leftValue + rightValue > valueHolder.value) {
            valueHolder.value = nodeValue + leftValue + rightValue;
        }
        return nodeValue + Math.max(leftValue, rightValue);
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left= new BinaryTree(3);
        root.right= new BinaryTree(2);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);

        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);

        System.out.println(maxPathSum(root));
    }
}
