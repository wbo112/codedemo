package com.atguigu.tree;

import java.util.Objects;

/**
 * 二叉树
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode heroNode = new HeroNode(1, "宋江");
        HeroNode heroNode1 = new HeroNode(2, "吴用");
        HeroNode heroNode2 = new HeroNode(3, "卢俊义");
        HeroNode heroNode3 = new HeroNode(4, "林冲");
        HeroNode heroNode4 = new HeroNode(5, "关胜");
        BinaryTree binaryTree = new BinaryTree(heroNode);
        heroNode.setLeft(heroNode1);
        heroNode.setRight(heroNode2);
        heroNode2.setRight(heroNode3);
        heroNode2.setLeft(heroNode4);
        System.out.println("前序遍历:");
        binaryTree.perOrder();

        System.out.println("中序遍历");
        binaryTree.infixOrder();

        System.out.println("后续遍历");
        binaryTree.postOrder();


        System.out.println("前序遍历查找");
        HeroNode resNode = binaryTree.perOrderSearch(5);
        if (Objects.nonNull(resNode)) {
            System.out.println("找到了:" + resNode);
        } else {
            System.out.println("没找到编号为:" + 5 + "的HeroNode");
        }
        binaryTree.delNode(5);


        System.out.println("中序遍历查找");
        resNode = binaryTree.infixOrderSearch(5);
        if (Objects.nonNull(resNode)) {
            System.out.println("找到了:" + resNode);
        } else {
            System.out.println("没找到编号为:" + 5 + "的HeroNode");
        }


        System.out.println("后序遍历查找");
        resNode = binaryTree.postOrderSearch(5);
        if (Objects.nonNull(resNode)) {
            System.out.println("找到了:" + resNode);
        } else {
            System.out.println("没找到编号为:" + 5 + "的HeroNode");
        }


    }
}

class BinaryTree {
    private HeroNode root;

    public BinaryTree(HeroNode root) {
        this.root = root;
    }

    public void perOrder() {
        if (Objects.nonNull(root)) {
            root.perOrder();
        } else {
            System.out.println("当前二叉树为空");
        }
    }

    public void infixOrder() {
        if (Objects.nonNull(root)) {
            root.infixOrder();
        } else {
            System.out.println("当前二叉树为空");
        }
    }

    public boolean delNode(int no) {
        if (Objects.nonNull(root)) {
            if (root.getNo() == no) {
                root = null;
                return true;
            } else {
                return root.delNode(no);
            }
        }
        return false;
    }

    public void postOrder() {
        if (Objects.nonNull(root)) {
            root.postOrder();
        } else {
            System.out.println("当前二叉树为空");
        }
    }

    public HeroNode perOrderSearch(int no) {
        if (Objects.nonNull(root)) {
            return root.perOrderSearch(no);
        }
        return null;
    }

    public HeroNode infixOrderSearch(int no) {
        if (Objects.nonNull(root)) {
            return root.infixOrderSearch(no);
        }
        return null;
    }

    public HeroNode postOrderSearch(int no) {
        if (Objects.nonNull(root)) {
            return root.postOrderSearch(no);
        }
        return null;
    }
}

class HeroNode {

    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //删除结点
    public boolean delNode(int no) {
        if (Objects.nonNull(left) && left.no == no) {
            this.left = null;
            return true;
        }
        if (Objects.nonNull(right) && right.no == no) {
            this.right = null;
            return true;
        }
        if (Objects.nonNull(left) && left.delNode(no)) {
            return true;
        }
        if (Objects.nonNull(right) && right.delNode(no)) {
            return true;
        }
        return false;
    }

    //前序遍历
    public void perOrder() {
        System.out.println(this);
        if (Objects.nonNull(left)) {
            this.left.perOrder();
        }
        if (Objects.nonNull(right)) {
            this.right.perOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        if (Objects.nonNull(left)) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (Objects.nonNull(right)) {
            this.right.infixOrder();
        }
    }

    //后续遍历
    public void postOrder() {
        if (Objects.nonNull(left)) {
            this.left.postOrder();
        }
        if (Objects.nonNull(right)) {
            this.right.postOrder();
        }
        System.out.println(this);
    }


    //前序遍历查找
    public HeroNode perOrderSearch(int no) {
        if (this.no == no) {
            return this;
        }
        HeroNode heroNode;
        if (Objects.nonNull(left)) {
            heroNode = left.perOrderSearch(no);
            if (Objects.nonNull(heroNode)) {
                return heroNode;
            }

        }
        if (Objects.nonNull(right)) {
            heroNode = right.perOrderSearch(no);
            if (Objects.nonNull(heroNode)) {
                return heroNode;
            }
        }
        return null;
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no) {

        HeroNode heroNode;
        if (Objects.nonNull(left)) {
            heroNode = left.infixOrderSearch(no);
            if (Objects.nonNull(heroNode)) {
                return heroNode;
            }
        }
        if (this.no == no) {
            return this;
        }
        if (Objects.nonNull(right)) {
            heroNode = right.infixOrderSearch(no);
            if (Objects.nonNull(heroNode)) {
                return heroNode;
            }
        }
        return null;
    }

    //后续遍历查找
    public HeroNode postOrderSearch(int no) {

        HeroNode heroNode;
        if (Objects.nonNull(left)) {
            heroNode = left.postOrderSearch(no);
            if (Objects.nonNull(heroNode)) {
                return heroNode;
            }
        }

        if (Objects.nonNull(right)) {
            heroNode = right.postOrderSearch(no);
            if (Objects.nonNull(heroNode)) {
                return heroNode;
            }
        }
        if (this.no == no) {
            return this;
        }
        return null;
    }
}
