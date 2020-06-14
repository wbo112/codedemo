package com.atguigu.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100000);
        }
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        aSelectSort(arr);
        System.out.println("耗时:" + (System.currentTimeMillis() - startTime));
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    public static void aSelectSort(int[] arr) {
        int minIndex = 0;
        int min; 
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                min = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }

    public static void selectSort(int[] arr) {

//第一轮

        int minIndex = 0;
        int min;
        for (int i = 0 + 1; i < arr.length; i++) {
            if (arr[minIndex] > arr[i]) {
                minIndex = i;
            }
        }
        if (minIndex != 0) {
            min = arr[minIndex];
            arr[minIndex] = arr[0];
            arr[0] = min;
        }
        //第二轮

        minIndex = 1;

        for (int i = 1 + 1; i < arr.length; i++) {
            if (arr[minIndex] > arr[i]) {
                minIndex = i;
            }
        }
        if (minIndex != 1) {
            min = arr[minIndex];
            arr[minIndex] = arr[1];
            arr[1] = min;
        }
        //第三轮

        minIndex = 2;

        for (int i = 2 + 1; i < arr.length; i++) {
            if (arr[minIndex] > arr[i]) {
                minIndex = i;
            }
        }
        if (minIndex != 2) {
            min = arr[minIndex];
            arr[minIndex] = arr[2];
            arr[2] = min;
        }
    }
}
