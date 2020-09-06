package month;

import java.util.Scanner;

public class GetDade {
    public static void main(String[] args) {
        GetDade date = new GetDade();
        int monthList[]  = new int[12];
        int numDays = 0;
        for(int i = 0; i < monthList.length; i++) {
            monthList[i] = i+1;
        }

        System.out.println("请输入年份");
        Scanner inYear = new Scanner(System.in);
        int year = inYear.nextInt();
        System.out.println("请输入月份");
        Scanner inMonth = new Scanner(System.in);
        int month = inMonth.nextInt();

        if((year % 4 == 0) && !(year % 100 == 0) || (year % 400 == 0)) {
            if(month == 2) {
                numDays = 29;
            }else {
                numDays = 28;
            }
        }else{
            for(int j = 0; j < 12; j++) {
                if(!(monthList[j] % 2 == 0) || (month == 1)) {
                    numDays = 31;
                }else if (monthList[j] % 2 == 0) {
                    numDays = 30;
                }
            }
        }

        System.out.println(year + "年" + month + "月份" + "有" + numDays + "天");



    }
}
