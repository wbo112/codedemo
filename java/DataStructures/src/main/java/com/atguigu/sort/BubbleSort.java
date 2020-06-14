package com.atguigu.sort;


import java.util.Arrays;
import java.util.Random;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        bubbleSort();
        System.out.println("简化版本:");
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100000);
        }
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        bubbleSort(arr);
        System.out.println("耗时:" + (System.currentTimeMillis() - startTime));
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));


        bubbleSort(arr);

    }

    private static void bubbleSort() {
        int[] arr = {3, 9, -1, 10, -2};

        int temp = 0;
        for (int j = 0; j < arr.length - 1; j++) {
            if (arr[j] > arr[j + 1]) {

              temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }

        }

        System.out.println("第一次排序后:" + Arrays.toString(arr));
        for (int j = 0; j < arr.length - 2; j++) {
            if (arr[j] > arr[j + 1]) {


                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }

        }

        System.out.println("第二次排序后:" + Arrays.toString(arr));
        for (int j = 0; j < arr.length - 3; j++) {
            if (arr[j] > arr[j + 1]) {


                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }

        }

        System.out.println("第三次排序后:" + Arrays.toString(arr));
        for (int j = 0; j < arr.length - 4; j++) {
            if (arr[j] > arr[j + 1]) {


                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }

        }

        System.out.println("第四次排序后:" + Arrays.toString(arr));
    }

    //冒泡排序
    private static void bubbleSort(int[] arr) {
        int temp;
        boolean flag = false;//表示是否进行过交换
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }

            }
            if (!flag) {
                break;
            }
            flag = false;
            //System.out.printf("第%d次排序后:%s\n", i, Arrays.toString(arr));
        }
    }

}
