package com.atguigu.binarysearchnorecursion;

/**
 * 二分查找
 */
public class BinarySearchNoRecur {
    public static void main(String[] args) {
        int[]  arr={1,3,5,6,7,8,9,10,13};
        int index=binarySearch(arr,1);
        System.out.println("index = "+index);
    }

    /**
     *
     * @param arr   待查找的数组，arr是升序
     * @param target   要查找的数字
     * @return
     */
    public static int binarySearch(int[] arr,int target){
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }
}
