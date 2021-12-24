package solutions.hard;

/**
 * Time complexities: O(d)
 * Space complexities: O(1)
 */
public class AncestorValidation {
    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
        // Lets first check if nodeTwo found in descendants in nodeOne list.
        boolean isNode1AncestorOfNode2 = isAncestor(nodeOne, nodeTwo);
        if(isNode1AncestorOfNode2) {
            return isDescendants(nodeThree, nodeTwo);
        }

        boolean isNode3AncestorOfNode2 = isAncestor(nodeThree, nodeTwo);
        if(isNode3AncestorOfNode2) {
            return isDescendants(nodeOne, nodeTwo);
        }
        return false;
    }

    /**
     *
     * Check if node1 is ancestor of node2.
     */
    public boolean isAncestor(BST node1, BST node2) {
        if(node1 == null) {
            return false;
        }
        BST temp;
        if(node1.value > node2.value) {
            temp = node1.left;
        } else {
            temp = node1.right;
        }
        while (temp != null) {
            if(temp.value == node2.value) {
                return true;
            }
            if(temp.value > node2.value) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return false;
    }

    /**
     * Check if node1 is descendants of node2.
     */
    public boolean isDescendants(BST node1, BST node2) {
        return isAncestor(node2, node1);
    }
}
