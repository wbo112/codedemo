package com.atguigu.tree;

/**
 * 数组 二叉树前序遍历输出
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder(0);
    }
}

class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        preOrder(0);
    }

    //二叉树前序遍历
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空,不能遍历");
            return;
        }
        if (index < arr.length) {
            System.out.println(arr[index]);
        } else {
            return;
        }
        if ((index * 2 + 1) < arr.length) {
            preOrder(index * 2 + 1);
        }
        if ((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }
    }
}