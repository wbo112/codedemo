package com.atguigu.linkedlist;

import java.util.Objects;
import java.util.Stack;

public class SingleLinkedList {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "公孙胜", "入云龙");
        HeroNode heroNode5 = new HeroNode(4, "林冲", "豹子头");

//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode3);
//        singleLinkedList.add(heroNode4);

        singleLinkedList.addOrder(heroNode1);
        singleLinkedList.addOrder(heroNode4);
        singleLinkedList.addOrder(heroNode3);
        singleLinkedList.addOrder(heroNode4);
        singleLinkedList.addOrder(heroNode2);
        singleLinkedList.list();
        singleLinkedList.update(heroNode5);
        System.out.printf("length   = %d\n", singleLinkedList.getLength());
        System.out.println(singleLinkedList.findLastIndexNode(1));
        singleLinkedList.reversetList();
        singleLinkedList.list();
        System.out.println("=====================");
        singleLinkedList.reversePrint();


    }

    private HeroNode head = new HeroNode(0, "", "");

    public int getLength() {
        if (Objects.isNull(head.next)) {

            return 0;
        }
        int length = 0;
        HeroNode heroNode = head.next;
        while (Objects.nonNull(heroNode)) {
            length++;
            heroNode = heroNode.next;
        }
        return length;
    }

    private void reversePrint() {
        if (Objects.isNull(head.next)) {
            System.out.println("链表为空");
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while (Objects.nonNull(cur)) {
            stack.push(cur);
            cur = cur.next;
        }
        stack.stream().forEach(System.out::println);

    }

    public HeroNode findLastIndexNode(int index) {
        int size = getLength();
        if (index <= 0 || index > size) {
            return null;
        }

        HeroNode heroNode = head.next;
        for (int i = 0; i < size - index; i++) {
            heroNode = heroNode.next;
        }
        return heroNode;
    }

    public void reversetList() {
        if (Objects.isNull(head.next) || Objects.isNull(head.next.next)) {
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverHead = new HeroNode(0, "", "");

        //列表反转 算法
        while (Objects.nonNull(cur)) {
            next = cur.next;
            cur.next = reverHead.next;
            reverHead.next = cur;
            cur = next;
        }
        head.next = reverHead.next;
        reverHead.next = null;
    }

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        HeroNode nextNode;
        while (Objects.nonNull(temp.next)) {
            temp = temp.next;

        }
        temp.next = heroNode;
    }

    public void list() {
        if (Objects.isNull(head.next)) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (Objects.nonNull(temp)) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void addOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (Objects.isNull(temp.next)) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("准备插入的编号已经存在 %d\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void update(HeroNode newHeroNode) {
        if (Objects.isNull(head.next)) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;

        while (Objects.nonNull(temp)) {
            if (temp.no == newHeroNode.no) {
                temp.name = newHeroNode.name;
                temp.nickname = newHeroNode.nickname;
                System.out.println("已经找到并更新");
                list();
                break;

            }
            temp = temp.next;
        }

    }

    public void del(int no) {
        HeroNode temp = head;
        while (Objects.nonNull(temp.next)) {
            if (temp.next.no == no) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

}


class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +

                '}';
    }

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }


}