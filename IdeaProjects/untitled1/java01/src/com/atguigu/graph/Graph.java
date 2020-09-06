package com.atguigu.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {

    private ArrayList<String> vertexList; //存儲頂點的一個集合
    private int[][] edges; //存储图的对应的连接矩阵
    private int numOffEdges; //表示边的个数
    //定义一个数组boolean[],记入某个节点是否被访问过
    private boolean[] isVisited;

    public static void main(String args[]) {
        //测试一把是否OK
        int n = 5; //节点的个数
        String Vertexs[] = {"A", "B", "C", "D", "E"};
        //创建一个图对象
        Graph graph = new Graph(n);
        //循环的添加点顶
        for(String vertex : Vertexs) {
            graph.insertVertex(vertex);
        }
        //添加边
        //A-B A-C B-C B-D B-E
        graph.insertEdge(0, 1, 1); //A-B
        graph.insertEdge(0, 2, 1); //A-C
        graph.insertEdge(1, 2, 1); //B-C
        graph.insertEdge(1, 3, 1); //B-D
        graph.insertEdge(1, 4, 1); //B-E

        //显示邻接矩阵
        graph.showGraph();

        //测试一把，我们DFS遍历是否ok
//        System.out.println("深度优先遍历");
//        graph.dfs(); //A->B->C->D->E

        System.out.println();

        //测试一把，我们BFS遍历是否ok
        System.out.println("广度优先遍历");
        graph.bfs(); //A->B->C->D->E
    }
    //构造器
    public Graph(int n) {
        //初始化矩阵和ArrayList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOffEdges = 0;
        isVisited = new boolean[5];
    }
    //得到第一个邻接节点的下标
    /*
    * @param index
    * @param 如果存在返回对应的下标，否则返回-1
    * */
    public int getFistNeighbor(int index) {
        for(int j = 0; j < vertexList.size(); j++) {
            if(edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }
    //根据前一个邻接的下表来获取下个邻接节点
    public int getNextNeighbor(int v1, int v2) {
        for(int j = v2 + 1; j < vertexList.size(); j++) {
            if(edges[v1][v2] > 0) {
                return j;
            }
        }
        return -1;
    }
    //深度优先遍历算法
    //i 第一次就是 0
    private void dfs(boolean[] isVisited, int i) {
        //首先我们访问该节点，输出
        System.out.print(getValueByIndex(i) + "->");
        //将节点设置为已访问的节点
        isVisited[i] = true;
        //查找节点i的第一个邻接节点W
        int w = getFistNeighbor(i);
        while(w != -1) {
            //说明有邻接节点
            if(!isVisited[w]) {
                dfs(isVisited, w);
            }
            //如果w节点被访问过
            w = getNextNeighbor(i, w);
        }
    }
    //对dfs进行重载，遍历我们所有的接点，并进行dfs
    public void dfs () {
        //遍历所有的节点，进行dfs[回溯]
        for(int i = 0; i < getNumOffVertex(); i++) {
            if(!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }
    //对一个节点广度优先遍历的方法
    private void bfs(boolean[] isVisited, int i) {
        int u; //表示队列的一个头节点对应的下标
        int w; //邻接节点w
        //队列，节点访问的顺序
        LinkedList queue = new LinkedList();
        //访问节点，输出节点信息
        System.out.print(getValueByIndex(i) + "->");
        //标记为已访问节点
        isVisited[i] = true;
        //将节点加入队列
        queue.addLast(i);
        while(!queue.isEmpty()) {
            //取出队列的头接点
            u = (Integer)queue.removeFirst();
            //得到第一个邻接点的下标
            w = getFistNeighbor(u);
            while(w != -1) {
                //找到了
                //是否访问过
                if(!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "->");
                    //标记为已访问节点
                    isVisited[w] = true;
                    //将节点加入队列
                    queue.addLast(w);
                }
                //以u为我们的起始点，找w后面的一个节点
                w = getNextNeighbor(u, w); //体现广度优先
            }
        }
    }
    //遍历所有的节点，都进行广度优先搜索
    public void bfs() {
        for(int i = 0; i < getNumOffVertex(); i++) {
            if(!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

    //图中常用的方法
    //返回节点的个数
    public int getNumOffVertex() {
        return vertexList.size();
    }
    //显示图的对应的矩阵
    public void showGraph() {
        for(int [] link : edges) {
            System.err.println(Arrays.toString(link));
        }
    }
    //得到边得个数
    public int getNumOffEdges() {
        return numOffEdges;
    }
    //返回节点对应的数据
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }
    //返回v1,v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }
    //插入节点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
        //添加边

    }
    /*
    * @param v1 表示顶的下标即第几个点顶 “A”-"B"  "A"->0 "B"->1
    * @param v2 第二个点顶的下标
    * @param weight 表示权值
    *
    * */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOffEdges++;
    }
}
