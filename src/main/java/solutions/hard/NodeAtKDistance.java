package solutions.hard;

import java.util.ArrayList;
import java.util.List;

public class NodeAtKDistance {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    /**
     * First of all find the target node. From that node find the two possible nodes which is at distance k. There can be either 0,1 or 2 such nodes.
     * Second, for every node above, find the distance target is at. If it is at distance p, then find nodes at other sides which is at k-p.
     * Combine arraylist of both result.
     */
    public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {

        ArrayList<Integer> finalResult = new ArrayList<>();

        BinaryTree node = findTargetNode(tree, target);
        ArrayList<Integer> listAtDistanceK = findAllNodesAtDistanceK(node, k);
        if(!listAtDistanceK.isEmpty()) {
            finalResult.addAll(listAtDistanceK);
        }
        ArrayList<Integer> list1 = findNodesDistanceKUtil(tree, target, k);
        if(!list1.isEmpty()) {
            finalResult.addAll(list1);
        }
        return finalResult;
    }

    public ArrayList<Integer> findNodesDistanceKUtil(BinaryTree tree, int target, int k) {
        if(tree == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> list = new ArrayList<>();
        int distanceFromLeftChild = findDistanceOfTargetNode(tree.left, target);
        if(distanceFromLeftChild != -1) {
            // It means child is at left side.
            int distanceOfTargetNode = distanceFromLeftChild + 1;
            int remainingDistanceForRightSide = k - distanceOfTargetNode;
            ArrayList<Integer> nodeFromRightSide = findAllNodesAtDistanceK(tree.right, remainingDistanceForRightSide - 1);
            if(!nodeFromRightSide.isEmpty()) {
                list.addAll(nodeFromRightSide);
            }
            ArrayList<Integer> furtherList = findNodesDistanceKUtil(tree.left, target, k);
            if(!furtherList.isEmpty()) {
                list.addAll(furtherList);
            }
        }
        if(distanceFromLeftChild == -1) {
            int distanceFromRightChild = findDistanceOfTargetNode(tree.right, target);
            if(distanceFromRightChild != -1) {
                // It means child is at left side.
                int distanceOfTargetNode = distanceFromRightChild + 1;
                int remainingDistanceForLeftSide = k - distanceOfTargetNode;
                ArrayList<Integer> nodeFromLeftSide = findAllNodesAtDistanceK(tree.left, remainingDistanceForLeftSide - 1);
            }
            ArrayList<Integer> furtherList = findNodesDistanceKUtil(tree.right, target, k);
            if(!furtherList.isEmpty()) {
                list.addAll(furtherList);
            }
        }
        return list;
    }

    public int findDistanceOfTargetNode(BinaryTree node, int targetNode) {
        if (node == null) {
            return -1;
        }
        if (node.value == targetNode) {
            return 0;
        }
        int leftDistance = findDistanceOfTargetNode(node.left, targetNode);
        if (leftDistance != -1) {
            return 1 + leftDistance;
        }

        int rightDistance = findDistanceOfTargetNode(node.right, targetNode);
        if (rightDistance != -1) {
            return 1 + rightDistance;
        }
        return -1;
    }

    public ArrayList<Integer> findAllNodesAtDistanceK(BinaryTree node, int k) {
        if(k < 0 || node == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        if(k == 0) {
            list.add(k);
            return list;
        }
        ArrayList<Integer> leftList = findAllNodesAtDistanceK(node.left, k-1);
        if(!leftList.isEmpty()) {
            list.addAll(leftList);
        }

        ArrayList<Integer> rightList = findAllNodesAtDistanceK(node.right, k-1);
        if(!rightList.isEmpty()) {
            list.addAll(rightList);
        }

        return list;
    }

    public BinaryTree findTargetNode(BinaryTree node, int target) {
        if(node == null) {
            return null;
        }
        if(node.value == target) {
            return node;
        }
        BinaryTree leftNode = findTargetNode(node.left, target);
        if(leftNode != null) {
            return leftNode;
        }
        BinaryTree rightNode = findTargetNode(node.right, target);
        return rightNode;
    }
}
