package top.clydezhou.lab.demo.algorithms.search.structure;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 无向图
 */
public class UndirectedGraph {
    private int v; // 顶点的个数

    private LinkedList<Integer>[] adjacencyList; // 邻接表

    public UndirectedGraph(int v) {
        this.v = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) { // 无向图一条边存两次
        if (adjacencyList[s].contains(t)) {
            return;
        }
        if (s == t) {
            return;
        }
        adjacencyList[s].add(t);
        adjacencyList[t].add(s);
    }

    public int getNodeCount() {
        return v;
    }

    public LinkedList<Integer>[] getAdjacencyList() {
        return adjacencyList;
    }

    @Override
    public String toString() {
        return "UndirectedGraph{" + "v=" + v + ", adjacencyList=" + Arrays.toString(adjacencyList) + '}';
    }
}
