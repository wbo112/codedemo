package com.atguigu.tree;

import java.util.Arrays;
import java.util.Random;

/**
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 6, 8, 5, 9, 16, 7, 343, 223, 12, 123, 13, 52, 111};
        heapSort(arr);

        arr = new int[8000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100000);
        }

        System.out.println("排序前");

        long startTime = System.currentTimeMillis();
        heapSort(arr);
        System.out.println("耗时:" + (System.currentTimeMillis() - startTime));
        System.out.println("排序后");
    }

    public static void heapSort(int[] arr) {
        System.out.println("堆排序");
//        adjustHeap(arr, 1, arr.length);
//        System.out.println("第一次" + Arrays.toString(arr));
//        adjustHeap(arr, 0, arr.length);
//        System.out.println("第二次" + Arrays.toString(arr));
        for (int i = arr.length / 2 - 1; i >= 0; i--) {

            adjustHeap(arr, i, arr.length);
        }
        int temp;
        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i);
        }
       // System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr    待调整的数组
     * @param i      表示非叶子结点在数组中的索引
     * @param lenght 表示对多少个元素进行调整
     */
    public static void adjustHeap(int[] arr, int i, int lenght) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < lenght; k = k * 2 + 1) {
            //说明左子结点小于右子结点的值
            if ((k + 1) < lenght && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}
