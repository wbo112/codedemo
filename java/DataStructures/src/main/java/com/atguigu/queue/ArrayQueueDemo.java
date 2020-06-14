package com.atguigu.queue;

import com.sun.deploy.uitoolkit.impl.fx.AppletStageManager;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show)");
            System.out.println("g(get)");
            System.out.println("h(header)");
            System.out.println("a(add)");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出来的数是:%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("取出来的数是:%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    System.out.println("程序退出");
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }
}

class ArrayQueue {

    private int maxSize;//表示数组的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//该数组用于存放数据,模拟队列

    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头部,指向队列头的前一个位置
        rear = -1;//指向队列尾部，指向队列最后的一个数据
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能加入数据");
            return;
        }
        arr[++rear] = n;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,不能取出数据");

        }

        front++;
        int r = arr[front];
        arr[front] = 0;
        return r;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = 0; i < maxSize; i++) {
            System.out.printf("%d\t", arr[i]);
        }
        System.out.println();
    }

    public int headQueue() {
        if (isEmpty()) {
            System.out.println("队列为空,没有数据");
            throw new RuntimeException("队列为空,没有数据");
        }
        return arr[front + 1];
    }

}
