package com.atguigu.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100000);
        }

        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        insertSort(arr);
        System.out.println("耗时:" + (System.currentTimeMillis() - startTime));
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));

        // insertSort(arr);
        //System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        int insertVal;
        int insertIndex;
        for (int i = 1; i < arr.length; i++) {


            insertVal = arr[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex != i - 1) {
                arr[insertIndex + 1] = insertVal;
            }

        }
    }


    public static void aInsertSort(int[] arr) {

        //第一轮
        int insertVal = arr[1];
        int insertIndex = 1 - 1;
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertVal;
        System.out.println("第一轮插入");
        System.out.println(Arrays.toString(arr));

        //第二轮
        insertVal = arr[2];
        insertIndex = 2 - 1;
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertVal;
        System.out.println("第二轮插入");
        System.out.println(Arrays.toString(arr));
        //第三轮
        insertVal = arr[3];
        insertIndex = 3 - 1;
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertVal;
        System.out.println("第三轮插入");
        System.out.println(Arrays.toString(arr));

        //第四轮
        insertVal = arr[4];
        insertIndex = 4 - 1;
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertVal;
        System.out.println("第四轮插入");
        System.out.println(Arrays.toString(arr));
    }
}
