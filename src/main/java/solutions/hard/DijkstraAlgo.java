package solutions.hard;

import java.util.*;

/**
 * Dijkstra algorithm uses Greedy algorithm to find the shortest distance from given node to al other node. A* is considered as better algorithm.
 */
public class DijkstraAlgo {
    public static int[] dijkstrasAlgorithm(int start, int[][][] edges) {
        int numberOfVertices = edges.length;
        if (numberOfVertices == 0) {
            return new int[]{};
        }
        Set<Integer> visited = new HashSet<>();
        // Mark the start vertices as visited.
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> vertexAndDistance = new HashMap<>();
        queue.add(start);
        vertexAndDistance.put(start, 0);
        while (!queue.isEmpty()) {
            int currentVertex = queue.remove();
            if (visited.contains(currentVertex)) {
                continue;
            }
            int distanceFromStartVertexToCurrentVertex = vertexAndDistance.get(currentVertex);
            int[][] edgesForCurrentVertex = edges[currentVertex];
            for (int[] distanceForVertex : edgesForCurrentVertex) {
                int v = distanceForVertex[0];
                queue.add(v);
                int d = distanceForVertex[1];
                if (vertexAndDistance.containsKey(v)) {
                    int existingDistance = vertexAndDistance.get(v);
                    if (distanceFromStartVertexToCurrentVertex + d < existingDistance) {
                        vertexAndDistance.put(v, distanceFromStartVertexToCurrentVertex + d);
                    }
                } else {
                    vertexAndDistance.put(v, distanceFromStartVertexToCurrentVertex + d);
                }
            }
            visited.add(currentVertex);
        }
        int[] result = new int[numberOfVertices];
        Arrays.fill(result, -1);
        for (Map.Entry<Integer, Integer> entry : vertexAndDistance.entrySet()) {
            int v = entry.getKey();
            int d = entry.getValue();
            result[v] = d;
        }
        return result;
    }

    public static void main(String[] args) {
        int start = 0;
        int[][][] edges = new int[][][] {
                new int[][] {{1,7}},
                new int[][] {{2, 6}, {3, 20}, {4, 3}},
                new int[][] {{3, 14}},
                new int[][] {{4, 2}},
                new int[][] {},
                new int[][] {}
        };

        int[] result = dijkstrasAlgorithm(start, edges);
        for(int v : result) {
            System.out.print("    " + v);
        }
    }
}