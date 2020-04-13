package org.jf.algorithmjava.binaryTree;

/**
 * 二叉树
 */
public class BinTree<T> {

    public BinTree() {
    }
    public BinTree(T data, BinTree left, BinTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    /**
     * 节点存储的数据
     */
    T data;
    /**
     * 左子树
     */
    BinTree left;
    /**
     * 右子树
     */
    BinTree right;

    public T getData() {
        return data;
    }

    public BinTree getLeft() {
        return left;
    }

    public BinTree getRight() {
        return right;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLeft(BinTree left) {
        this.left = left;
    }

    public void setRight(BinTree right) {
        this.right = right;
    }
}
