package com.atguigu.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 归并排序
 */
public class MergetSort {

    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println("归并排序后" + Arrays.toString(arr));


        arr = new int[8000000];
        temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100000);
        }

        System.out.println("排序前");
       // System.out.println(Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println("耗时:" + (System.currentTimeMillis() - startTime));
        System.out.println("排序后");
       // System.out.println(Arrays.toString(arr));


    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * @param arr   排序的原始数组
     * @param left  排序数组的左边索引
     * @param mid   排序数组的中间索引
     * @param right 排序数组的右边索引
     * @param temp  中转数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        int tempLeft = left;
        t = 0;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }
    }
}
