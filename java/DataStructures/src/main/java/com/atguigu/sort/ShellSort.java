package com.atguigu.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(1000000);
        }

        System.out.println("排序前");
        //System.out.println(Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        //shellSort(arr);
        shellSort1(arr);
        System.out.println("耗时:" + (System.currentTimeMillis() - startTime));
        System.out.println("排序后");
        //System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        int temp;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }

            }
            // System.out.println("当前步长是" + gap + ",希尔排序第" + l++ + "轮后 :" + Arrays.toString(arr));
        }
    }

    public static void shellSort1(int[] arr) {
        int temp;
        int l = 1;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {


            for (int i = gap; i < arr.length; i++) {
                int j = i;
                temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                }
                arr[j]=temp;

            }
            // System.out.println("当前步长是" + gap + ",希尔排序第" + l++ + "轮后 :" + Arrays.toString(arr));
        }
    }

    public static void aShellSort(int[] arr) {
        int temp;
        int l = arr.length / 2;
        for (int i = 5; i < arr.length; i++) {
            for (int j = i - 5; j >= 0; j -= 5) {
                if (arr[j] > arr[j + 5]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }

        }
        System.out.println("希尔排序第一轮后 :" + Arrays.toString(arr));

        l /= 2;
        for (int i = 2; i < arr.length; i++) {
            for (int j = i - 2; j >= 0; j -= 2) {
                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }

        }
        System.out.println("希尔排序第二轮后 :" + Arrays.toString(arr));

        l /= 2;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j -= 1) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }
        System.out.println("希尔排序第三轮后 :" + Arrays.toString(arr));
    }
}
