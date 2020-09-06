package cn.bywind.java01;

public class Array {
    public static void main(String args[]) {
        int CteateArray[][] = new int[11][11];
        CteateArray[1][2] = 1;
        CteateArray[2][3] = 2;
        for(int[] row : CteateArray) {
            for (int data : row){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        int sum = 0;

        for(int i = 0; i < CteateArray.length; i++) {
            for(int j = 0; j < 11; j++) {
                if(CteateArray[i][j] !=0) {
                    sum++;
                }
            }
        }

        System.out.println("五子棋的个数为" + sum);

        int MinArray[][] = new int[sum+1][3];

        MinArray[0][0] = 11;
        MinArray[0][1] = 11;
        MinArray[0][2] = sum;

        int number = 0;

        for(int i = 0; i < CteateArray.length; i++) {
            for(int j = 0; j < 11; j++) {
                if(CteateArray[i][j] !=0) {
                    number++;
                    MinArray[number][0] = i;
                    MinArray[number][1] = j;
                    MinArray[number][2] = CteateArray[i][j];
                }
            }
        }

        for(int i = 0; i<MinArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", MinArray[i][1], MinArray[i][1], MinArray[i][2]);
            System.out.println();
        }
    }
}

//**********************************************************************************************************************