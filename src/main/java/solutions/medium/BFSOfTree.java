package solutions.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BFSOfTree {
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            Queue<Node> queue = new ArrayDeque<>();
            queue.add(this);
            while (!queue.isEmpty()) {
                Node node = queue.remove();
                array.add(node.name);
                List<Node> children = node.children;
                for(Node n : children) {
                    queue.add(n);
                }
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
