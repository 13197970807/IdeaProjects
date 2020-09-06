package month;

import java.util.Scanner;

public class Date {
    public static void main(String[] args) {

        System.out.println("请输入年份:");
        Scanner inYear = new Scanner(System.in);
        int year = inYear.nextInt();

        System.out.println("请输入月份:");
        Scanner inMonth = new Scanner(System.in);
        int month = inMonth.nextInt();

        int numDays = 0;
        switch(month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numDays = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numDays = 30;
                break;
            case 2:
                if((year % 4 == 0) && !(year % 100 == 0) || (year % 400 == 0)) {
                    numDays = 29;
                }else {
                    numDays = 28;
                }
                break;
        }
        System.out.println(year + "年" + month + "月份" + "有" + numDays + "天");
    }
}
