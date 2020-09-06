package Game;

import java.util.Scanner;

public class Game {
    //1.属性定义,(常量)
    static final int FGVALUE = 20;//单个仙女草的需花费20个金币
    static final int GSVALUE = 16;//单个银河草的需花费16个金币
    static final int FGLIFE = 30;//单个仙女草可恢复30生命值
    static final int GSLIFE = 20;//单个银河草可恢复20生命值
    public static void main(String[] args) {
//        System.out.println("Sam_liu");

        int goldcoin = 100;//初始化输入的金币数量
        int max_fg = 0;//输出仙女草的的最大数的定义
        int max_gs = 0;//输出银河草的的最大数的定义
        int max_life = 0;//输出最大的生命值的定义

        //创建Scanner实例
        Scanner in = new Scanner(System.in);
        goldcoin = in.nextInt();
        for(int fg_loop = 0; fg_loop <= (goldcoin / FGVALUE); fg_loop++) {
            for(int gs_loop = 0; gs_loop <= (goldcoin / GSVALUE); gs_loop++) {
                if(((fg_loop * FGVALUE + gs_loop * GSVALUE) <= goldcoin) && (fg_loop * FGLIFE + gs_loop * GSLIFE) > max_life ) {
                    max_fg = fg_loop;
                    max_gs = gs_loop;
                    max_life = FGLIFE * fg_loop + GSLIFE * gs_loop;

                }
            }
        }
        System.out.println(max_fg);
        System.out.println(max_gs);
        System.out.println(max_life);
    }
}
