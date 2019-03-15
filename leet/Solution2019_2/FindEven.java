package leet.Solution2019_2;

import java.util.LinkedList;
import java.util.List;

//802
public class FindEven {
    /**
     * In a directed graph, we start at some node and every turn, walk along a directed edge of the graph.
     * If we reach a node that is terminal (that is, it has no outgoing directed edges), we stop.
     * <p>
     * Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node.
     * More specifically, there exists a natural number K so that for any choice of where to walk,
     * we must have stopped at a terminal node in less than K steps.
     * <p>
     * Which nodes are eventually safe?  Return them as an array in sorted order.
     * <p>
     * The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.
     * The graph is given in the following form:
     * graph[i] is a list of labels j such that (i, j) is a directed edge of the graph.
     * <p>
     * Example:
     * Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
     * Output: [2,4,5,6]
     * Here is a diagram of the above graph.
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new LinkedList<>();
        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; ++i) {
            if (dfs(graph, i, colors))
                ans.add(i);
        }
        return ans;
    }

    private boolean dfs(int[][] graph, int v, int[] colors) {
        if (colors[v] != 0)
            return colors[v] == 1;
        colors[v] = 2; //being visited
        for (int i : graph[v]) {
            if (!dfs(graph, i, colors))
                return false;
        }
        colors[v] = 1; //already visited
        return true;
    }


}
