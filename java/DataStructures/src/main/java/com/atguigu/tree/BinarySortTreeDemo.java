package com.atguigu.tree;

import java.util.Objects;

public class BinarySortTreeDemo {

    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        System.out.println("中序遍历二叉排序树:");
        binarySortTree.infixOrder();
        binarySortTree.delNode(2);
        binarySortTree.delNode(5);
        binarySortTree.delNode(9);
        System.out.println("删除节点后:");
        System.out.println("中序遍历二叉排序树:");
        binarySortTree.infixOrder();
    }
}

class BinarySortTree {
    private Node root;

    public void add(Node node) {
        if (Objects.isNull(root)) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public Node search(int value) {
        if (Objects.isNull(root)) {
            return null;
        } else {
            return root.search(value);
        }
    }

    public Node searchParent(int value) {
        if (Objects.isNull(root)) {
            return null;
        } else {
            return root.searcParent(value);
        }
    }

    public void infixOrder() {
        if (Objects.nonNull(root)) {
            root.infixOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public Node delRightTreeMin(Node node) {
        Node targetNode = node;

        while (Objects.nonNull(targetNode.left)) {
            targetNode = targetNode.left;
        }
        delNode(targetNode.value);
        return targetNode;
    }

    public void delNode(int value) {
        if (Objects.isNull(root)) {
            return;
        } else {
            if (value == root.value) {
                root = null;
                return;
            }
            Node targetNode = search(value);
            if (Objects.isNull(targetNode)) {
                return;
            }
            Node parent = searchParent(value);
            if (Objects.isNull(targetNode.left) && Objects.isNull(targetNode.right)) {
                if (Objects.nonNull(parent.left) && parent.left == targetNode) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else if (Objects.nonNull(targetNode.left) && Objects.nonNull(targetNode.right)) {
                Node rightMinNode = delRightTreeMin(targetNode);
                targetNode.value = rightMinNode.value;
            } else {
                //要删除的节点只有左子树
                if (Objects.nonNull(targetNode.left)) {

                    //要删除的节点是左节点
                    if (Objects.nonNull(parent.left) && parent.left == targetNode) {
                        parent.left = targetNode.left;
                    } else {
                        parent.right = targetNode.left;
                    }

                } else { //要删除的节点只有右子树
                    if (Objects.nonNull(parent.left) && parent.left == targetNode) {
                        parent.left = targetNode.right;
                    } else {
                        parent.right = targetNode.right;
                    }
                }
            }
        }
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public Node search(int value) {
        if (this.value == value) {
            return this;
        } else if (this.value > value) {
            if (Objects.nonNull(left)) {
                return left.search(value);
            } else {
                return null;
            }
        } else {
            if (Objects.nonNull(right)) {
                return right.search(value);
            } else {
                return null;
            }
        }
    }

    public Node searcParent(int value) {
        if ((Objects.nonNull(left) && left.value == value) || (Objects.nonNull(right) && right.value == value)) {
            return this;
        } else {
            if (value < this.value && Objects.nonNull(left)) {

                return left.searcParent(value);


            } else if (value >= this.value && Objects.nonNull(right)) {
                return right.searcParent(value);
            }
            return null;
        }
    }

    public void add(Node node) {
        if (Objects.isNull(node)) {
            return;
        }
        if (node.value < value) {
            if (Objects.isNull(left)) {
                left = node;
            } else {
                left.add(node);
            }
        } else {
            if (Objects.isNull(right)) {
                right = node;
            } else {
                right.add(node);
            }
        }
    }


    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public void infixOrder() {
        if (Objects.nonNull(left)) {
            left.infixOrder();
        }
        System.out.println(this);
        if (Objects.nonNull(right)) {
            right.infixOrder();
        }
    }
}
