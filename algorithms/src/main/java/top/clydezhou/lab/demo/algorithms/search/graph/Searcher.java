package top.clydezhou.lab.demo.algorithms.search.graph;

import top.clydezhou.lab.demo.algorithms.search.structure.UndirectedGraph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author clyde
 * @date 2021-01-11 22:16
 */
public class Searcher {
    public void breathFirstSearch(UndirectedGraph graph, int start, int target) {
        if (start == target) {
            return;
        }
        int v = graph.getNodeCount();

        boolean[] visited = new boolean[v];
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        LinkedList<Integer>[] adjacencyList = graph.getAdjacencyList();
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adjacencyList[w].size(); ++i) {
                int q = adjacencyList[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == target) {
                        print(prev, start, target);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    private void print(int[] prev, int s, int t) { // 递归打印s->t的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    boolean found = false; // 全局变量或者类成员变量

    public void depthFirstSearch(UndirectedGraph graph, int s, int t) {
        found = false;
        int v = graph.getNodeCount();
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        LinkedList<Integer>[] adj = graph.getAdjacencyList();
        recurDfs(s, t, visited, prev, adj);
        print(prev, s, t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev, LinkedList<Integer>[] adj) {
        if (found == true) {
            return;
        }
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev, adj);
            }
        }
    }
}
