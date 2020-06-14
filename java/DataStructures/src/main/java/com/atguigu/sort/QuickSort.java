package com.atguigu.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序  (当前理解还不是很深刻)
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70};
        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
        arr = new int[8000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(1000000);
        }

        System.out.println("排序前");
        //System.out.println(Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        //shellSort(arr);
        quickSort(arr, 0, arr.length - 1);

        System.out.println("耗时:" + (System.currentTimeMillis() - startTime));
        System.out.println("排序后");
       // System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }

    }
}
