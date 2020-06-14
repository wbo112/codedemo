package com.atguigu.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    private List<String> vertexList;
    private int[][] edges;
    private int numOfEdges;
    private boolean[] isVisited;

    public static void main(String[] args) {
        int n = 5;
        String[] vertexs = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(5);
        for (String vertex : vertexs
        ) {
            graph.insertVertex(vertex);

        }
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.showGraph();
        System.out.println("深度遍历:");
        //graph.dfs();
        graph.bfs();
    }

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>();
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    //根据v1一个邻接节点的第一个邻接节点
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //根据v1一个邻接节点下标大于v2的一个邻接节点
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }

        }
        return -1;
    }

    public void dfs(int i) {
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(w);
            }
            w = getNextNeighbor(i, w);
        }
    }

    public void dfs() {
        for (int i = 0; i < getNumofVertex(); i++) {
            if (!isVisited[i]) {
                dfs(i);
            }
        }
    }

    private void bfs(int i) {
        int u;
        int w;
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.println(getValueByIndex(i) + "==>");
        isVisited[i] = true;
        queue.add(i);
        while (!queue.isEmpty()) {
            u = queue.removeFirst();
            w = getFirstNeighbor(u);
            while (w != -1) {
                if (!isVisited[i]) {
                    queue.add(w);
                    System.out.println(getValueByIndex(i) + "==>");
                    isVisited[i] = true;
                }
                w = getNextNeighbor(u, w);

            }
        }
    }

    private void bfs() {
        for (int i = 0; i < getNumofVertex(); i++) {
            if (!isVisited[i]) {
                bfs(i);
            }
        }
    }

    private String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public int getNumofVertex() {
        return vertexList.size();
    }

    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }
}
