package com.atguigu.stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
//        arrayStack.push(1);
//        arrayStack.push(10);
//        arrayStack.list();
//        arrayStack.pop();
//        arrayStack.push(12);
//        arrayStack.list();
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("=============================");
            System.out.println("show:表示显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:表示添加数据到栈(入栈)");
            System.out.println("pop:表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择");
            System.out.println("=============================");
            key = scanner.next();
            switch (key) {
                case "show":
                    arrayStack.list();
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                case "push":
                    System.out.println("请输入一个数字");
                    arrayStack.push(scanner.nextInt());
                    break;
                case "pop":
                    System.out.printf("当前出栈的数据是 %d", arrayStack.pop());
                    break;
                default:
                    break;
            }
        }
    }
}

class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("当前栈已满");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("当前栈已空");
            throw new RuntimeException("当前栈已满");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈空,没有数据");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}
