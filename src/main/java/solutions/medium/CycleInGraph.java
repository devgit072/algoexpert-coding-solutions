package solutions.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class CycleInGraph {
    public boolean cycleInGraph(int[][] edges) {
        int numberOfEdges = edges.length;
        boolean[] nodeProcessed = new boolean[numberOfEdges];
        boolean[] nodeVisitedInCurrentLine = new boolean[numberOfEdges];
        // check from every node if there is any cycle
        for(int i=0;i<numberOfEdges;i++) {
            if(cycleInCurrentLine(nodeProcessed, nodeVisitedInCurrentLine, i, edges)) {
                return true;
            }
        }
        return false;
    }

    public boolean cycleInCurrentLine(boolean[] nodeProcessed, boolean[] nodeVisitedInCurrentLine, int node, int[][] edges) {
        if(nodeVisitedInCurrentLine[node]) {
            return true;
        }
        // don't process the node which has been already processed.
        if(nodeProcessed[node]) {
            return false;
        }
        int[] edgesForNode = edges[node];
        nodeProcessed[node] = true;
        nodeVisitedInCurrentLine[node] = true;
        for(int e : edgesForNode) {
            if(cycleInCurrentLine(nodeProcessed, nodeVisitedInCurrentLine, e, edges)) {
                return true;
            }
        }
        // make it false when we wil check for cycle from other nodes.
        nodeVisitedInCurrentLine[node] = false;
        return false;
    }
}
