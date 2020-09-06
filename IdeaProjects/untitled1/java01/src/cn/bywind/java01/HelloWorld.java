package cn.bywind.java01;

public class HelloWorld {
    public static void main(String args[]) {
        //创建一个原始的二维数组 11 * 11
        //0, 表示没有棋子，1表示黑子 2表示蓝子
        System.out.println("这是原始的二维数组");
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][2] = 1;
        chessArr1[6][6] = 2;
        //输出原始的二维数组
        for(int[] row : chessArr1) {
            for(int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将二维数组 转 稀疏数组的思路
        //1.先遍历二维数组得到非零的数据的个数
        int sum = 0;
        for(int i = 0; i < chessArr1.length; i++) {
            for(int j = 0; j < 11; j++) {
                if(chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("原始值中共有" + sum + "棋子");

        //2.创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //遍历二维数组，将非零的值存放到稀疏数组中;
        int count = 0; //count由于记录是第几个非零数据

        for(int i = 0; i < chessArr1.length; i++) {
            for(int j = 0; j < 11; j++) {
                if(chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        //输出稀疏数组的形式
        System.out.println("这是稀疏数组");

        for(int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
            System.out.println();
        }

        //将稀疏数组恢复成原二维数组

        int chessArr2[][] = new int [sparseArr[0][0]][sparseArr[0][1]];

        //输出恢复后的二维数组
        for(int[] row : chessArr2) {
            for(int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //稀疏数组遍历
        System.out.println("恢复后的原二位数据");

        for(int i = 1; i < sparseArr.length; i++){
            for(int j = 0; j < 3; j++) {
                chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
            }
        }

        for(int[] row : chessArr2) {
            for(int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }


    }
}
