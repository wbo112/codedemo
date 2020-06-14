package com.atguigu.linkedlist;

import java.util.Objects;

/**
 * 约瑟夫问题  通过环形列表
 */
public class Josepfu {
    public static void main(String[] args) {
        // 测试一把看看构建环形链表，和遍历是否ok
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(125);// 加入5个小孩节点
        circleSingleLinkedList.showBoy();

        //测试一把小孩出圈是否正确
        circleSingleLinkedList.countBoy(10, 20, 125); // 2->4->1->5->3
        //String str = "7*2*2-5+1-5+3-3";
    }
}

//环形的单向链表
class CircleSingleLinkedList {
    private Boy first = new Boy(-1);


    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("添加不合理,return");
            return;
        }
        Boy curBoy = null;
        Boy boy;
        for (int i = 1; i <= nums; i++) {
            boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    public void showBoy() {
        if (first.getNo() == -1) {
            System.out.println("链表为空");
            return;
        }
        Boy curBoy = first.getNext();
        while (curBoy != first) {
            // System.out.println(curBoy);
            curBoy = curBoy.getNext();
        }
    }

    // 根据用户的输入，计算出小孩出圈的顺序

    /**
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums     表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if (first.getNo() == -1 || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误,请重新输入");
            return;
        }

        for (int i = 0; i < startNo - 1; i++) {

            first = first.getNext();
        }
        Boy preBoy = first;
        while (preBoy.getNext() != preBoy.getNext().getNext()) {
            for (int i = 0; i < countNum; i++) {
                preBoy = first;
                first = first.getNext();
            }
            System.out.printf("当前出栈的是 %d\n", first.getNo());
            preBoy.setNext(first.getNext());

        }
    }
}

//表示一个节点
class Boy {
    private int no;
    private Boy next;

    public int getNo() {
        return no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }

    public Boy(int no) {
        this.no = no;
    }
}
