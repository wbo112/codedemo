package com.atguigu.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 二分查找，需要数据是有序的
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 6, 6, 6, 6, 6, 7, 8, 9, 10, 12, 15, 16, 18};
        int resIndex = binarySearch(arr, 0, arr.length - 1, 6);
        System.out.println(resIndex);
        System.out.println(binarySearchAll(arr, 0, arr.length - 1, 165));
    }

    /**
     * @param arr     数组
     * @param left    左边索引
     * @param right   右边索引
     * @param findVal 要查找的值
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        int mid = (left + right) / 2;
        if (left > right) {
            return -1;
        }
        int midValue = arr[mid];
        if (findVal < midValue) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else if (findVal > midValue) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else {
            return mid;
        }
    }


    public static List<Integer> binarySearchAll(int[] arr, int left, int right, int findVal) {
        int mid = (left + right) / 2;
        if (left > right) {
            return Collections.emptyList();
        }
        int midValue = arr[mid];
        if (findVal < midValue) {
            return binarySearchAll(arr, left, mid - 1, findVal);
        } else if (findVal > midValue) {
            return binarySearchAll(arr, mid + 1, right, findVal);
        } else {
            List<Integer> list = new ArrayList<>();
            int leftIndex = mid - 1;
            while (leftIndex >= 0 && arr[leftIndex] == findVal) {
                list.add(leftIndex);
                leftIndex--;
            }
            list.add(mid);
            int rightIndex = mid + 1;
            while (rightIndex <= arr.length && arr[rightIndex] == findVal) {
                list.add(rightIndex);
                rightIndex++;
            }
            return list;
        }
    }
}
