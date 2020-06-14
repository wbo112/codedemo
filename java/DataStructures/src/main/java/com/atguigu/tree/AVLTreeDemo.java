package com.atguigu.tree;

import java.util.Objects;

public class AVLTreeDemo {
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 5, 7, 8};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new AVLNode(arr[i]));

        }
        System.out.println("树的高度" + avlTree.height());
        System.out.println("左子树高度" + avlTree.getRoot().left.height());
        System.out.println("右子树高度" + avlTree.getRoot().right.height());
    }
}

class AVLTree {
    private AVLNode root;

    public AVLNode getRoot() {
        return root;
    }

    public void add(AVLNode AVLNode) {
        if (Objects.isNull(root)) {
            root = AVLNode;
        } else {
            root.add(AVLNode);
        }
    }

    public int height() {
        if (Objects.isNull(root)) {
            return 0;
        } else {
            return root.height();
        }
    }

    public AVLNode search(int value) {
        if (Objects.isNull(root)) {
            return null;
        } else {
            return root.search(value);
        }
    }

    public AVLNode searchParent(int value) {
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

    public AVLNode delRightTreeMin(AVLNode AVLNode) {
        AVLNode targetAVLNode = AVLNode;

        while (Objects.nonNull(targetAVLNode.left)) {
            targetAVLNode = targetAVLNode.left;
        }
        delAVLNode(targetAVLNode.value);
        return targetAVLNode;
    }

    public void delAVLNode(int value) {
        if (Objects.isNull(root)) {
            return;
        } else {
            if (value == root.value) {
                root = null;
                return;
            }
            AVLNode targetAVLNode = search(value);
            if (Objects.isNull(targetAVLNode)) {
                return;
            }
            AVLNode parent = searchParent(value);
            if (Objects.isNull(targetAVLNode.left) && Objects.isNull(targetAVLNode.right)) {
                if (Objects.nonNull(parent.left) && parent.left == targetAVLNode) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else if (Objects.nonNull(targetAVLNode.left) && Objects.nonNull(targetAVLNode.right)) {
                AVLNode rightMinAVLNode = delRightTreeMin(targetAVLNode);
                targetAVLNode.value = rightMinAVLNode.value;
            } else {
                //要删除的节点只有左子树
                if (Objects.nonNull(targetAVLNode.left)) {

                    //要删除的节点是左节点
                    if (Objects.nonNull(parent.left) && parent.left == targetAVLNode) {
                        parent.left = targetAVLNode.left;
                    } else {
                        parent.right = targetAVLNode.left;
                    }

                } else { //要删除的节点只有右子树
                    if (Objects.nonNull(parent.left) && parent.left == targetAVLNode) {
                        parent.left = targetAVLNode.right;
                    } else {
                        parent.right = targetAVLNode.right;
                    }
                }

            }
        }
    }
}

class AVLNode {
    int value;
    AVLNode left;
    AVLNode right;

    public AVLNode(int value) {
        this.value = value;
    }

    public int height() {
        return Math.max(Objects.isNull(left) ? 0 : left.height(), Objects.isNull(right) ? 0 : right.height()) + 1;
    }

    private void leftRotate() {
        //创建新的节点，以当前根节点的值
        AVLNode newAVLNode = new AVLNode(value);
        //把新的节点的左子树设置成当前节点的左子树
        newAVLNode.left = left;

        //把新的节点的右子树设置成带呢过去节点的右子树的左子树
        newAVLNode.right = right.left;
        value = right.value;
        left = newAVLNode;
        right = right.right;
        //把当前节点的值替换成右子树的值


    }

    private void rightRotate() {
        AVLNode newAVLNode = new AVLNode(value);
        newAVLNode.right = right;
        newAVLNode.left = left.right;

        value = left.value;
        left = left.left;
        right = newAVLNode;
    }

    public AVLNode search(int value) {
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

    public AVLNode searcParent(int value) {
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

    public void add(AVLNode AVLNode) {
        if (Objects.isNull(AVLNode)) {
            return;
        }
        if (AVLNode.value < value) {
            if (Objects.isNull(left)) {
                left = AVLNode;
            } else {
                left.add(AVLNode);
            }
        } else {
            if (Objects.isNull(right)) {
                right = AVLNode;
            } else {
                right.add(AVLNode);
            }
        }
        if  (Objects.nonNull(right) && Objects.nonNull(left) && (right.height() - left.height() > 1)) {
            if(Objects.nonNull(right)&&right.left.height()>right.right.height()){
                right.rightRotate();
            }
            leftRotate();
        }else
        if  (Objects.nonNull(right) && Objects.nonNull(left) && (left.height() - right.height() > 1)) {
            if(Objects.nonNull(left)&&left.right.height()>left.left.height()){
                left.leftRotate();
            }
            rightRotate();
        }
    }


    @Override
    public String toString() {
        return "AVLNode{" +
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
