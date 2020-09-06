package test;
import java.util.Scanner;
public class Test {
    static int x;
    static int y;
    public static void main(String[] args) {
//        int a = 13;
//        int b = 5;
//        int c = a++%b;
//        System.out.println(c);//3

//        int x =3; int y = 3;
//        switch(x + 3) {
//            case 6: y = 1;
//            default: y += 1;
//        }
//        System.out.println(c)

//        int a = 3, b = 4, c = 5, d = 6;
//        if(a < 4 || c > d) {
//            System.out.println("who");
//        } else {
//            System.out.println("why");
//        }

//        int a = 10;
//        int t = 0;
//        do {
//            t = a++;
//            System.out.println("ci");
//        } while (t <= 5);
        //10

        //数字类型(number):byte,short,int,long,float,double
        //字符型(string): char
        //布尔类型(boolean): true, false

        //简单数据类型的优先级
        //(byte,int,char) -> long -> float -> double

//        int a , b, c;
//        String istrue;
//        Scanner in = new Scanner(System.in);
//        a = in.nextInt();
//        b = in.nextInt();
//        c = in.nextInt();
//        if(a+b > c && a+c > b && c+a > b) {
//            istrue = "能组成三角形";
//        } else {
//            istrue = "不能组成三角形";
//        }
//        System.out.println("边长为" + a + "," + b + "," + c + "的三边," + istrue);

//        Test test = new Test();
//        int goodNum = 20;
//        int bastNum = 12;
//        int MCNum = 122;
//        int VNum = 14;
//        int TNum = MCNum / VNum;
//        int x1,y1;
//        for(int a = 1; a <= MCNum / goodNum; a++) {
//            for(int b = 1; b <= MCNum /bastNum; b++) {
//                if(((a * goodNum + b * bastNum) == MCNum) && ((a + b) == TNum)) {
//                    x1 = a;
//                    y1 = b;
//                    test.setNUMBER(x1,y1);
//                }
//            }
//        }
//        System.out.println(x + "晴天," + y + "雨天");

        //Java语言的特点:
        //1.简单性 2.面向对象 3.跨平台 4.分布式 5.动态性 6.是安全的 7，是多线程的 8，是动态的 9.是解释执行的 10.是健壮的
//        final double number = 23.344D;
//        System.out.println(number);

//        for(int i = 0; i <= 5; i++) {
//            if(i == 3) {
//                continue;
//            }else if(i >= 5) {
//                return;
//            }
//            System.out.println(i);
//        }


        int x = 2;
        int y = 3;
        int z = 1;
        x += y--/++z;
        int g =y--/++z;
        System.out.println(x);

    }
//    public void setNUMBER(int g, int h) {
//        x = g;
//        y = h;
//    }
}
