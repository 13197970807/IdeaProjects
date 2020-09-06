package KRUSKAL1;

import javax.swing.*;
import java.util.Arrays;

public class Kruskal {

    private int edgesNum; //记录变得个数
    private char[] vertexs; //记录点顶
    private int[][] matrix; //邻接矩阵
    private static final int INF = Integer.MAX_VALUE; //最大值

    public static void main(String[] args) {
        //测试一把
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'}; //七个点顶
        int[][] matrix = {
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}
        };

        //创建类的实例
        Kruskal kruskal = new Kruskal(vertexs, matrix);

        //输出邻接矩阵
        kruskal.print();

       //打印一个这个一维数组
        EData[] edges = kruskal.getEdges();
        System.out.println("未排序" + Arrays.toString(edges));
        kruskal.sortEdges(edges);
        System.out.println("排序（小—>大）" + Arrays.toString(edges));

        kruskal.kruskal();
    }

    //构造器
    public Kruskal(char[] vertexs, int[][] matrix) {
        int vlen = vertexs.length;

        //初始化点顶
        this.vertexs = new char[vlen];
        for(int i = 0; i < vertexs.length; i++) {
            this.vertexs[i] = vertexs[i];
        }

        //初始化邻接矩阵
        this.matrix = new int[vlen][vlen];
        for(int i = 0; i < vlen; i++) {
            for(int j = 0; j < vlen; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }

        //统计一下变得个数
        for(int i = 0; i < vlen; i++) {
            for(int j = i+1; j < vlen; j++) {
                if(this.matrix[i][j] != INF) {
                    edgesNum++;
                }
            }
        }
    }

    public void kruskal() {
        int index = 0;
        int[] ends = new int[edgesNum];
        EData[] rets = new EData[edgesNum];

        EData[] edges = getEdges();
        System.out.println("图的边的集合" + Arrays.toString(edges) + "共" + edges.length);

        sortEdges(edges);

        for(int i = 0; i < edgesNum; i++) {
            int p1 = getPosition(edges[i].start);

            int p2 = getPosition(edges[i].end);

            int m = getEnd(ends, p1);

            int n  = getEnd(ends, p2);

            if(m != n) {
                ends[m] = n;
                rets[index++] = edges[i];
            }

        }
        System.out.println("最小生成树为:" + Arrays.toString(rets));

    }

    //打印邻接矩阵
    public void print() {
        System.out.println("这时邻接矩阵:\n");
        for(int i = 0; i < vertexs.length; i++) {
            for(int j = 0; j < vertexs.length; j++) {
                System.out.printf("%12d", matrix[i][j]);
            }
            System.out.println("");
        }
    }

    //对边进行冒泡排序 （weight）

    private void sortEdges(EData[] edges) {
        for(int i = 0; i < edges.length - 1; i++) {
            for(int j = 0; j < edges.length - 1 -i; j++) {
                if(edges[j].weight > edges[j + 1].weight) {
                    EData tmp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = tmp;
                }
            }
        }
    }
    private int getPosition(char ch) {
        for(int i = 0; i < vertexs.length; i++) {
            if(vertexs[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    private EData[] getEdges() {
        int index = 0;
        EData[] edges = new EData[edgesNum];
        for(int i = 0; i < vertexs.length; i++) {
            for(int j = i+1; j < vertexs.length; j++) {
                if(matrix[i][j] != INF) {
                    edges[index++] = new EData(vertexs[i], vertexs[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }
    private int getEnd(int [] ends, int i) {
        while(ends[i] != 0) {
            i = ends[1];
        }
        return i;
    }

}

//创建一个关于边的类

class EData{
    char start;
    char end;
    int weight;

    //构造器
    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    //重写一下toString, 目的: 便于输出
    public String toString () {
        return "EData [<" + start + ", " + end + ">= " + weight + "]";
    }

}
