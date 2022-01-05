package solutions.hard;

import java.util.*;

/**
 * Topological sorting has many real life use case, like event scheduling, event dependencies, etc.
 * For example lets consider courses prerequisite. If the course B depends on course A and all prerequisites are given, then you can print
 * the courses order in which a student can enroll.
 * Topological sort can work in O(V+E) because each vertex and edge will be visited once.
 * Also Topological ordering are not unique. There could be many possible order of nodes.
 * If there is cycle in the graph, then Topological sort can't be printed.
 */

/**
 * Only point to remember is that Topological sorting can be solved using stack based DFS.
 */
public class TopologicalSorting {
    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
        Map<Integer, Set<Integer>> dependecies = new HashMap<>();
        for (Integer[] dependency : deps) {
            // Assume nodeA -> NodeB
            int nodeA = dependency[0];
            int nodeB = dependency[1];
            if (dependecies.containsKey(nodeA)) {
                dependecies.get(nodeA).add(nodeB);
            } else {
                Set<Integer> s = new HashSet<>();
                s.add(nodeB);
                dependecies.put(nodeA, s);
            }
        }

        Stack<Integer> stack = new Stack<>();
        Set<Integer> hashSetForStack = new HashSet<>();
        Stack<Integer> resultStack = new Stack<>();
        Set<Integer> visitedNodes = new HashSet<>();
        for (Integer node : jobs) {
            boolean res = visitNode(node, stack, visitedNodes, dependecies, resultStack, hashSetForStack);
            if (!res) {
                return Collections.emptyList();
            }
        }
        List<Integer> resultList = new ArrayList<>();
        while (!resultStack.isEmpty()) {
            resultList.add(resultStack.pop());
        }
        return resultList;
    }

    private static boolean visitNode(int node, Stack<Integer> stack, Set<Integer> visitedNodes, Map<Integer, Set<Integer>> dependencies, Stack<Integer> resultStack, Set<Integer> hashSetForStack) {
        if (visitedNodes.contains(node)) {
            return true;
        }
        if(hashSetForStack.contains(node)) {
            return false;
        } else {
            hashSetForStack.add(node);
        }
        stack.add(node);
        Set<Integer> dependencyForThisNode = new HashSet<>();
        if (dependencies.containsKey(node)) {
            dependencyForThisNode = dependencies.get(node);
        }
        for (Integer nextNode : dependencyForThisNode) {
            if (visitedNodes.contains(nextNode)) {
                continue;
            }
            boolean isNoCyle = visitNode(nextNode, stack, visitedNodes, dependencies, resultStack, hashSetForStack);
            if (!isNoCyle) {
                return false;
            }
        }
        resultStack.add(node);
        hashSetForStack.remove(node);
        visitedNodes.add(node);
        return true;
    }

    public static void main(String[] args) {
        List<Integer> jobs = Arrays.asList(1, 2, 3, 4);
        List<Integer[]> deps = Arrays.asList(new Integer[]{1, 2}, new Integer[]{1, 3}, new Integer[]{3, 2}, new Integer[]{4, 2}, new Integer[]{4, 3});
        List<Integer> order = topologicalSort(jobs, deps);
        for (Integer o : order) {
            System.out.print("   " + o);
        }
    }
}
