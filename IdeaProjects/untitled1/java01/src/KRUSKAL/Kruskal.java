package KRUSKAL;

public class Kruskal {
    private int edgeNum; //记录边的个数
    private char[] vertexs; //点顶个数
    private int[][] matrix; //邻接矩阵
    private static final int INF = Integer.MAX_VALUE; //使用INF表示俩个点顶不连通

    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int matrix[][] = {
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}
        };
        Kruskal kruskal = new Kruskal(vertexs, matrix);
        //输出构建的是否正确
        kruskal.print();
    }

    //构造器
    public Kruskal(char[] vertexs, int[][] matrix) {
        //初始化点的个数和变得个数
        int vlen = vertexs.length;

        //初始化点顶
        this.vertexs = new char[vlen];
        for(int i = 0; i < vertexs.length; i++) {
            this.vertexs[i] = vertexs[i];
        }

        //初始化边
        this.matrix = new int[vlen][vlen];
        for(int i = 0; i < vlen; i++) {
            for(int j = 0; j < vlen; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }

        //统计边
        for(int i = 0; i < vlen; i++) {
            for(int j = 0; j < vlen; j++) {
                if(this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }

    }
    //打印邻接矩阵
    public void print() {
        System.out.println("邻接矩阵为: \n");
        for(int i = 0; i < vertexs.length; i++) {
            for(int j = 0; j < vertexs.length; j++) {
                System.out.printf("%12d", matrix[i][j]);
            }
            System.out.println(""); //换行
        }
    }
}
//创建一个边的类Edata

class Edata {
    char start;
    char end;
    int weight;

    public Edata(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    //
    public String toString () {
        return "EData [start=" + start + ", end=" + end + ", weight=" + weight + "]";
    }
}
