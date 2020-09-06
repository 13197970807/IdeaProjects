package GRAPH;

import cn.bywind.java01.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private ArrayList<String> vertexList;
    private int[][] edges;
    private int numOffEdges;
    private boolean[] isVisited;
    public static void main(String[] args) {
        //测试
        int n = 5;
        String vertexs[] = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(n);
        for(String item : vertexs) {
            graph.insertVertex(item);
        }
        graph.insertEdges(0, 1, 1);
        graph.insertEdges(0, 2, 1);
        graph.insertEdges(1, 2, 1);
        graph.insertEdges(1, 3, 1);
        graph.insertEdges(1, 4, 1);

        graph.showGraph();

        //测试dfs
        System.out.println("深度遍历DFS");
        graph.dfs();
        System.out.println("");
        System.out.println("广度遍历BFS");
        graph.bfs();
    }
    public int getNumOffVertex() {
        return vertexList.size();
    }
    public int getNumOffEdges() {
        return numOffEdges;
    }
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }
    public int getWight(int v1, int v2) {
        return edges[v1][v2];
    }
    public int getFirstNeighbor(int index) {
        for(int j = 0; j < vertexList.size(); j++) {
            if(edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }
    public int getNextNeighbor(int v1, int v2) {
        for(int j = v2 + 1; j < vertexList.size(); j++) {
            if(edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }
    private void dfs(boolean[] isVisited, int i) {
        System.out.printf(getValueByIndex(i) + "->");
        isVisited[i] = true;

        int w = getFirstNeighbor(i);
        while(w != -1) {
            if(!isVisited[w]) {
                dfs(isVisited, w);
            }
            w = getNextNeighbor(i, w);
        }
    }
    public void dfs() {
        isVisited = new boolean[5];
        for(int i = 0; i < getNumOffVertex(); i++) {
            if(!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    //广度优先
    private void bfs(boolean[] isVisited, int i) {
        int u;
        int w;
        LinkedList queue = new LinkedList();

        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;
        queue.add(i);

        while(!queue.isEmpty()) {
            u = (Integer) queue.removeFirst();
            w = getFirstNeighbor(u);
            while(w != -1) {
                if(!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "->");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNextNeighbor(u, w);
            }
        }

    }

    public void bfs() {
        isVisited = new boolean[5];
        for(int i = 0; i < vertexList.size(); i++) {
            if(!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

    public void showGraph() {
        for(int[] link : edges) {
            System.err.println(Arrays.toString(link));
        }
    }
    public Graph(int n) {
        vertexList = new ArrayList<String>(n);
        edges = new int[n][n];
    }
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }
    public void insertEdges(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOffEdges++;
    }

}
