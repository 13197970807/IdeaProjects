package STACK;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        //测试
        ArrayStack arrayStack = new ArrayStack(4);
        Scanner scanner = new Scanner(System.in);
        String key = "";
        boolean loop = true;
        while(loop) {
            System.out.println("show:表示显示栈");
            System.out.println("exit:表示退出程序");
            System.out.println("push:表示入栈");
            System.out.println("pop:表示出栈");
            System.out.println("请输入你的选择！");
            key = scanner.next();
            switch(key) {
                case "show":
                    arrayStack.list();
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop":
                    try{
                        int res = arrayStack.pop();
                        System.out.printf("出战的数据是%d\n", res);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
    }
}

//创建一个类
class ArrayStack {
    private int maxsize;
    private int[] stack;
    private int top = -1;

    //构造器
    public ArrayStack(int maxsize) {
        this.maxsize = maxsize;
        stack = new int[this.maxsize];
    }
    public boolean isFull() {
        return top == maxsize -1;
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public void push(int value) {
        if(isFull()) {
            System.out.println("栈已满");
        }
        top++;
        if(top <= maxsize) {
            stack[top] = value;
        }
    }
    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        top--;
        int value = stack[top];
        return value;
    }
    public void list() {
        if(isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for(int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}