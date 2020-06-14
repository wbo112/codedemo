package com.atguigu.recursion;

public class Queue8 {


    private static int max = 8;
    private static int[] array = new int[max];
    private static int count;

    public static void main(String[] args) {
        check(0);
        System.out.println(count);
    }

    private static void check(int n) {
        if (n == max) {
            print();
            count++;
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    private static boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //1.判断是否在同一列
            //2.判断是否在统一斜线
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    private static void print() {
        System.out.println("======================");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
