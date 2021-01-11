package top.clydezhou.lab.demo.algorithms.search.graph;

import top.clydezhou.lab.demo.algorithms.search.structure.UndirectedGraph;

import java.util.Random;

/**
 *
 */
public class SearchDemo {

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
        // 深度优先搜索
        search.depthFirstSearch(graph, 0, 9);
        // 广度优先搜索
        search.breathFirstSearch(graph, 0, 9);
    }
}
