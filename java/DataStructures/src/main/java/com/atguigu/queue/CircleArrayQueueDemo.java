package com.atguigu.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleQueue circleQueue = new CircleQueue(3);
        char key;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show)");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    circleQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();

                    circleQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = circleQueue.getQueue();
                        System.out.printf("取出来的数是:%d", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = circleQueue.headQueue();
                        System.out.printf("取出来的数是:%d", res);
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
class CircleQueue {

    private int maxSize;//表示数组的最大容量

    // ??? 疑问 感觉front指向队列第一个元素的话，初始化为-1  是不是更好  ?
    private int front;//队列头:指向队列的第一个元素

    private int rear;//队列尾:指向队列最后一个元素的后一个位置
    private int[] arr;//该数组用于存放数据,模拟队列

    public CircleQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];

    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear+1)%maxSize==front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能加入数据");
            return;
        }
        arr[rear] = n;
        rear=(rear+1)%maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,不能取出数据");

        }


        int r = arr[front];
        front=(front+1)%maxSize;
        return r;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = front; i < front+size(); i++) {
            System.out.printf("arr[%d]=%d\n", i%maxSize,arr[i%maxSize]);
        }
        System.out.println();
    }

    public int headQueue() {
        if (isEmpty()) {
            System.out.println("队列为空,没有数据");
            throw new RuntimeException("队列为空,没有数据");
        }
        return arr[front];
    }
    public  int size(){
        return (rear+maxSize-front)%maxSize;
    }
}