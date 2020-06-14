package com.atguigu.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 基数排序
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));


        arr = new int[8000000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100000);
        }

        System.out.println("排序前");
        // System.out.println(Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        radixSort(arr);
        System.out.println("耗时:" + (System.currentTimeMillis() - startTime));
        System.out.println("排序后");
    }

    private static void radixSort(int[] arr) {
        boolean flag=false;
        int q = 0;
        while (true) {
            int[][] bucket = new int[10][arr.length];
            int[] bucketElmentCounts = new int[10];
            int digitOfElement;
            for (int j = 0; j < arr.length; j++) {
                digitOfElement = arr[j] / Double.valueOf(Math.pow(10, q)).intValue() % 10;
                if (digitOfElement != 0) {
                    flag = true;
                }
                bucket[digitOfElement][bucketElmentCounts[digitOfElement]++] = arr[j];
            }
            q++;
            if (!flag) {
                break;
            }
            flag = false;
            int index = 0;
            int bucketElementCount;
            for (int k = 0; k < bucketElmentCounts.length; k++) {
                bucketElementCount = bucketElmentCounts[k];
                for (int l = 0; l < bucketElementCount; l++) {
                    arr[index++] = bucket[k][l];
                }
            }
            //System.out.println("第一轮，对个位进行排序处理 :" + Arrays.toString(arr));
        }
    }


    public static void aRadixSort(int[] arr) {
        int[][] bucket = new int[10][arr.length];
        int[] bucketElmentCounts = new int[10];
        int digitOfElement;
        for (int j = 0; j < arr.length; j++) {
            digitOfElement = arr[j] % 10;
            bucket[digitOfElement][bucketElmentCounts[digitOfElement]++] = arr[j];
        }
        int index = 0;
        int bucketElementCount;
        for (int k = 0; k < bucketElmentCounts.length; k++) {
            bucketElementCount = bucketElmentCounts[k];
            for (int l = 0; l < bucketElementCount; l++) {
                arr[index++] = bucket[k][l];
            }
        }
        System.out.println("第一轮，对个位进行排序处理 :" + Arrays.toString(arr));

        bucketElmentCounts = new int[10];
        for (int j = 0; j < arr.length; j++) {
            digitOfElement = arr[j] / 10 % 10;
            bucket[digitOfElement][bucketElmentCounts[digitOfElement]++] = arr[j];
        }
        index = 0;
        for (int k = 0; k < bucketElmentCounts.length; k++) {
            bucketElementCount = bucketElmentCounts[k];
            for (int l = 0; l < bucketElementCount; l++) {
                arr[index++] = bucket[k][l];
            }
        }
        System.out.println("第二轮，对个位进行排序处理 :" + Arrays.toString(arr));


    }
}

