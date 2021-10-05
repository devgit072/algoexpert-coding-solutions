package solutions.easy;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            dfsUtil(this, array);
            return array;
        }

        public void dfsUtil(Node node, List<String> array) {
            if (node == null) {
                return;
            }
            array.add(node.name);
            for (Node child : node.children) {
                dfsUtil(child, array);
            }
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
