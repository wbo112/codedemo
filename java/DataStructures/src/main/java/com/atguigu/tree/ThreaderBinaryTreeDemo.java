package com.atguigu.tree;

import java.util.Objects;

/**
 * 线索化中序二叉树
 */
public class ThreaderBinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode1 root = new HeroNode1(1, "a");
        HeroNode1 heroNode1 = new HeroNode1(3, "b");
        HeroNode1 heroNode2 = new HeroNode1(6, "c");
        HeroNode1 heroNode3 = new HeroNode1(8, "d");
        HeroNode1 heroNode4 = new HeroNode1(10, "e");
        HeroNode1 heroNode5 = new HeroNode1(14, "f");
        root.setLeft(heroNode1);
        root.setRight(heroNode2);
        heroNode1.setLeft(heroNode3);
        heroNode1.setRight(heroNode4);
        heroNode2.setLeft(heroNode5);
        BinaryTree1 binaryTree1 = new BinaryTree1(root);
        binaryTree1.threadedNodes();
        HeroNode1 leftNode1 = heroNode5.getLeft();
        System.out.println(leftNode1);
        System.out.println("使用线索化遍历二叉树");
        binaryTree1.threadedList();

    }
}

class BinaryTree1 {
    private HeroNode1 root;

    //为了实现线索化,需要创建指向当前结点的前驱节点的指针
    //在递归进行线索化时,pre总是指向前驱节点
    private HeroNode1 preNode;

    public BinaryTree1(HeroNode1 root) {
        this.root = root;
    }

    public void threadedNodes() {
        threadedNodes(root);
    }

    /**
     * @param node1 当前需要线索化的结点
     */
    public void threadedNodes(HeroNode1 node1) {
        if (Objects.isNull(node1)) {
            return;
        }
        //先线索化左指数
        threadedNodes(node1.getLeft());
        //线索化当前节点
        //处理当前节点的前驱节点
        if (Objects.isNull(node1.getLeft())) {
            //让当前结点的左指针指向前驱结点
            node1.setLeft(preNode);
            node1.setLeftType(1);
        }

        if (Objects.nonNull(preNode) && Objects.isNull(preNode.getRight())) {
            preNode.setRight(node1);
            preNode.setRightType(1);
        }
        preNode = node1;
        //线索化右指数
        threadedNodes(node1.getRight());
    }

    /**
     * 线索化二叉树中序遍历
     */
    public void threadedList() {
        HeroNode1 node1 = root;
        while (Objects.nonNull(node1)) {
            while (node1.getLeftType() == 0) {
                node1 = node1.getLeft();
            }
            System.out.println(node1);
            while (node1.getRightType() == 1) {
                node1 = node1.getRight();
                System.out.println(node1);

            }
            node1 = node1.getRight();
        }
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

    public HeroNode1 perOrderSearch(int no) {
        if (Objects.nonNull(root)) {
            return root.perOrderSearch(no);
        }
        return null;
    }

    public HeroNode1 infixOrderSearch(int no) {
        if (Objects.nonNull(root)) {
            return root.infixOrderSearch(no);
        }
        return null;
    }

    public HeroNode1 postOrderSearch(int no) {
        if (Objects.nonNull(root)) {
            return root.postOrderSearch(no);
        }
        return null;
    }
}

class HeroNode1 {

    private int no;
    private String name;
    private HeroNode1 left;
    private HeroNode1 right;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    //0表示指向左子树   1表示指向前序节点
    private int leftType;
    //0表示指向右子树   1表示指向后续节点
    private int rightType;

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

    public HeroNode1(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public HeroNode1 getLeft() {
        return left;
    }

    public void setLeft(HeroNode1 left) {
        this.left = left;
    }

    public HeroNode1 getRight() {
        return right;
    }

    public void setRight(HeroNode1 right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode1{" +
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
    public HeroNode1 perOrderSearch(int no) {
        if (this.no == no) {
            return this;
        }
        HeroNode1 heroNode;
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
    public HeroNode1 infixOrderSearch(int no) {

        HeroNode1 heroNode;
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
    public HeroNode1 postOrderSearch(int no) {

        HeroNode1 heroNode;
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