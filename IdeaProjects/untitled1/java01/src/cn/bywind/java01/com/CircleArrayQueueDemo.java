package cn.bywind.java01.com;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        //测试一把
        System.out.println("测试数组模拟环形队列的代码");
        CircleArray arrayQueue = new CircleArray(4); //说明设置4，其队列的有效数字为3
        char key = ' '; //接受用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):数据出队列");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e){
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int res = arrayQueue.headQueue();
                        System.out.printf("队列的头的数据是%d\n", res);
                    } catch(Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e'://退出程序
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序已退出");
    }
}
class CircleArray {
    private int maxSize; //表示数组的最大容量
    private int front; //指向队列的头部的第一个元素
    private int rear; //指向队列的尾部的后一个位置
    private int[] arr; //给数据用于存放数据，模拟队列

    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }
    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }
    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }
    //添加数据到队列
    public void addQueue(int n) {
        //1.判断队列是否满
        if(isFull()) {
            System.out.println("队列已满！，加不了数据");
            return;
        }
        //直接将数据加入
        arr[rear] = n;
        //将rear 后移，这里必须考虑取模
        rear = (rear +1) % maxSize;
    }
    //获取队列的数据,出队列
    public int getQueue() {
        //判断队列是否为空
        if(isEmpty()) {
            throw new RuntimeException("队列为空，队列出不了数据");
        }
        //这里需要分析出front是指向队列的第一个元素
        //1.先把front对应的保存到一个临时变量中
        //2.将front后移,取模
        //3. 将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }
    public void showQueue() {
        //遍历
        if(isEmpty()) {
            System.out.println("队列是空的，打印不了");
            return;
        }
        //思路: 从front开始遍历，遍历对少个元素
        //
        for(int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }
    //求出当前队列的有效数据的个数
    public int size() {
        //rear = 1
        //front = 0
        // maxSize = 3
        return (rear + maxSize - front) % maxSize;
    }
    //显示队列的头部
    public int headQueue() {
        if(isEmpty()) {
            throw new RuntimeException("队列头为空, 没有头数据");
        }
        return arr[front];
    }
}
