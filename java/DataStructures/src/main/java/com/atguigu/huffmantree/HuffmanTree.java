package com.atguigu.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class HuffmanTree {

    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
     Node root=   createHuffmanTree(arr);
        root.preOrder();
    }

    public static Node createHuffmanTree(int[] arr) {


        List<Node> nodeList = new ArrayList<>();
        for (int value : arr) {
            nodeList.add(new Node(value));
        }
        int i=1;
        while (nodeList.size() > 1) {

        Collections.sort(nodeList);
        //System.out.println(nodeList);
        Node left = nodeList.get(0);
        Node right = nodeList.get(1);

        Node parent = new Node(left.getValue() + right.getValue());
        parent.setLeft(left);
        parent.setRight(right);
        nodeList.remove(left);
        nodeList.remove(right);
        nodeList.add(parent);

        System.out.println("第"+i+"次处理后" + nodeList);
        i++;
    }
        return nodeList.get(0);
}
}

class Node implements Comparable<Node> {
    //结点权值
    private int value;

    private Node left;
    private Node right;

    public void preOrder(){
        preOrder(this);
    }
    public  void preOrder(Node node){
        System.out.println(node);
        if(Objects.nonNull(node.getLeft())){
            preOrder(node.getLeft());
        }

        if(Objects.nonNull(node.getRight())){
            preOrder(node.getRight());
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
