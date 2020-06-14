package com.atguigu.hashtable;

import java.util.Objects;
import java.util.Scanner;

public class HashTableDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        int id;
        String name;
        while (true) {
            System.out.println("add：添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit： 退出系统");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    id = scanner.nextInt();
                    System.out.println("输入名字");
                    name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    break;
                default:
                    break;
            }
        }
    }
}

class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class HashTab {
    private EmpLinkedList[] empLinkedArray;
    private int size;

    public HashTab(int size) {
        this.size = size;
        empLinkedArray = new EmpLinkedList[size];
    }

    public void findEmpById(int id) {
        EmpLinkedList empLinkedList = empLinkedArray[id % size];
        if (Objects.isNull(empLinkedList)) {
            System.out.println("当前id不存在");
            return;
        }
        Emp emp = empLinkedList.findEmpById(id);
        if (Objects.nonNull(emp)) {
            System.out.println("当前雇员信息:" + emp + ", 在第" + id % size + "链表中");

        } else {
            System.out.println("当前id不存在");
        }

    }

    public void add(Emp emp) {
        EmpLinkedList empLinkedList = empLinkedArray[emp.id % size];
        if (Objects.isNull(empLinkedList)) {
            empLinkedArray[emp.id % size] = new EmpLinkedList();
            empLinkedList = empLinkedArray[emp.id % size];
        }
        empLinkedList.add(emp);

    }

    public void list() {
        for (int i = 0; i < size; i++) {
            if (Objects.nonNull(empLinkedArray[i])) {
                empLinkedArray[i].list(i);
            }

        }
    }
}

class EmpLinkedList {
    private Emp head;

    public void add(Emp emp) {
        if (Objects.isNull(head)) {
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (Objects.nonNull(curEmp.next)) {
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    public void list(int no) {
        if (Objects.isNull(head)) {
            System.out.println("链表为空");
            return;
        }
        System.out.printf("当前是第%d号链表\n", no);
        Emp curEmp = head;
        while (Objects.nonNull(curEmp)) {
            System.out.print("==>" + curEmp);
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    public Emp findEmpById(int id) {
        Emp curEmp = head;
        while (Objects.nonNull(curEmp)) {
            if (curEmp.id == id) {
                return curEmp;
            }
        }
        return null;
    }
}