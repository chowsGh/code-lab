package top.clydezhou.lab.demo.algorithms.search;

import top.clydezhou.lab.demo.algorithms.search.structure.UndirectedGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 *
 */
public class DFSDemo {
    public static void main(String[] args) {
        Searcher search = new Searcher();
        int v = 10;
        // 随机生成无向图
        UndirectedGraph graph = new UndirectedGraph(v);
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < v; i++) {
            graph.addEdge(i, random.nextInt(v));
            graph.addEdge(i, random.nextInt(v));
            graph.addEdge(i, random.nextInt(v));
        }
        System.out.println(graph);
        search.dfs(graph, 0, 9);
        System.out.println();
        search.bfs(graph, 0, 9);
    }
}

class Searcher {
    public void bfs(UndirectedGraph graph, int start, int target) {
        if (start == target)
            return;
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

    public void dfs(UndirectedGraph graph, int s, int t) {
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
        if (found == true)
            return;
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
