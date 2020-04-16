package org.jf.algorithmjava.binaryTree;

import org.springframework.beans.BeanUtils;

import java.util.*;

/**
 * 使用堆栈的方式实现二叉树先序，中序， 后序遍历
 */
public class BinaryTreeTraversal {

    public static void  inOrderTraversal(BinTree tree){
        BinTree copyTree = tree;
        Stack<BinTree> binTreeStack = new Stack<BinTree>();
        while (copyTree != null || !binTreeStack.isEmpty()) {
            while (copyTree != null) {
                binTreeStack.push(copyTree);
                copyTree = copyTree.getLeft();
            }

            if(!binTreeStack.isEmpty()) {
                copyTree = binTreeStack.pop();
                System.out.println(copyTree.getData());
                copyTree = copyTree.getRight();
            }

        }

    }

    /**
     * 先序遍历
     * @param tree
     */
    public static void  preOrderTraversal(BinTree tree){
        BinTree copyTree = tree;
        Stack<BinTree> binTreeStack = new Stack<BinTree>();
        while (copyTree != null || !binTreeStack.isEmpty()) {
            while (copyTree != null) {
                binTreeStack.push(copyTree);
                System.out.println(copyTree.getData());;
                copyTree = copyTree.getLeft();
            }

            if(!binTreeStack.isEmpty()) {
                copyTree = binTreeStack.pop();
                copyTree = copyTree.getRight();
            }

        }

    }



//前序遍历为 root -> left -> right，后序遍历为 left -> right -> root，可以修改前序遍历成为 root -> right -> left，那么这个顺序就和后序遍历正好相反。

    /**
     * 后序遍历
     * @param tree
     */
    public static void  postOrderTraversal(BinTree tree){
        BinTree copyTree = tree;
        List<Object> tmpList = new ArrayList<Object>();
        Stack<BinTree> binTreeStack = new Stack<BinTree>();
        while (copyTree != null || !binTreeStack.isEmpty()) {
            while (copyTree != null) {
                binTreeStack.push(copyTree);
                tmpList.add(copyTree.getData());
                copyTree = copyTree.getRight();
            }

            if(!binTreeStack.isEmpty()) {
                copyTree = binTreeStack.pop();
                copyTree = copyTree.getLeft();
            }

        }
        Collections.reverse(tmpList);
        for (Object tmp :tmpList) {

            System.out.println(tmp);
        }

    }

    /**
     * 层序遍历
     * @param tree
     */

    public static void  levelOrderTraversal(BinTree tree) {
        BinTree copyTree = tree;
        Queue<BinTree> binTreeQueue = new LinkedList<BinTree>();
        if (copyTree == null) {
            return;
        }
        binTreeQueue.offer(copyTree);
        while (binTreeQueue.peek()!= null) {
            //移除队首根节点，将左子树右子树入队
            copyTree = binTreeQueue.poll();
            System.out.println(copyTree.getData());
            binTreeQueue.offer(copyTree.left);
            binTreeQueue.offer(copyTree.right);
        }


    }





//     1
//   2   3
// 4  5 6

    public static void main(String[] args) {

        BinTree<Integer> tree6 = new BinTree<Integer>(6,null,null);
        BinTree<Integer> tree5 = new BinTree<Integer>(5,null,null);
        BinTree<Integer> tree4 = new BinTree<Integer>(4,null,null);
        BinTree<Integer> tree3 = new BinTree<Integer>(3,tree6,null);
        BinTree<Integer> tree2 = new BinTree<Integer>(2,tree4,tree5);
        BinTree<Integer> tree1 = new BinTree<Integer>(1,tree2,tree3);
//        System.out.println("-------------inOderTraversal start-------------");
//        inOrderTraversal(tree1);
//        System.out.println("-------------inOderTraversal end-------------");
//        System.out.println("-------------preOrderTraversal start-------------");
//        preOrderTraversal(tree1);
//        System.out.println("-------------preOrderTraversal end-------------");

        System.out.println("-------------postOrderTraversal start-------------");
        postOrderTraversal(tree1);
        System.out.println("-------------postOrderTraversal end-------------");

        System.out.println("-------------levelOrderTraversal start-------------");
        levelOrderTraversal(tree1);
        System.out.println("-------------levelOrderTraversal end-------------");
        System.out.println("tree1:"+tree1.getData());



    }


}
