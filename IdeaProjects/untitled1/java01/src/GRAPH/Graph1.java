package GRAPH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph1 {

    private ArrayList<String> vertexList;
    private int[][] edges;
    private int numOfEdges;
    private boolean[] isVisited;


    public static void main(String[] args) {
        //测试
        int n = 5;
        String vertexs [] = {"A", "B", "C", "D", "E"};
        Graph1 graph1 = new Graph1(n);
        for(String item : vertexs) {
            graph1.insertVertex(item);
        }
        graph1.insertEdges(0, 1, 1);
        graph1.insertEdges(0, 2, 1);
        graph1.insertEdges(1, 2, 1);
        graph1.insertEdges(1, 3, 1);
        graph1.insertEdges(1, 4, 1);

        graph1.showGraph();

        System.out.print("图的深度遍历");

        graph1.dfs();
        System.out.println("");
        System.out.print("图的广度遍历");
        graph1.bfs();
    }
    //创建构造函数
    public Graph1(int n) {
       vertexList = new ArrayList<String>(n);
       edges = new int[n][n];
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
        for(int j = v2 +1; j < vertexList.size(); j++) {
            if(edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }
    private void dfs(boolean[] isVisited, int i) {
        System.out.print(getVertex(i) + "->");
        isVisited[i] = true;

        int w = getFirstNeighbor(i);
        while(w != -1) {
            if(!isVisited[i]) {
                dfs(isVisited, w);
            }
            w = getNextNeighbor(i, w);
        }

    }
    public void dfs() {
        isVisited = new boolean[5];
        for(int i = 0; i < vertexList.size(); i++) {
            if(!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    //BFS（广度遍历）
    private void bfs(boolean[] isVisited, int i) {
        int u;
        int w;
        LinkedList queue = new LinkedList();

        System.out.print(getVertex(i) + "->");
        isVisited[i] = true;
        queue.addLast(i);

        while(!queue.isEmpty()) {
            u = (Integer)queue.removeFirst();
            w = getFirstNeighbor(u);

            while(w != -1) {
                if(!isVisited[w]) {
                    System.out.print(getVertex(w) + "->");
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

    //常用方法
    public int getOfVertexNum() {
        return vertexList.size();
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public String getVertex(int i) {
        return vertexList.get(i);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    public void insertEdges(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
    public void showGraph() {
        for(int[] link : edges) {
            System.err.println(Arrays.toString(link));
        }
    }

}
