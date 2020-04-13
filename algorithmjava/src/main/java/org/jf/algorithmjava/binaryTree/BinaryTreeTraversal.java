package org.jf.algorithmjava.binaryTree;

import org.springframework.beans.BeanUtils;
import sun.applet.Main;

import java.util.Stack;

/**
 * 使用堆栈的方式实现二叉树先序，中序， 后序遍历
 */
public class BinaryTreeTraversal {

    public static void  inOrderTraversal(BinTree tree){
        BinTree copyTree = new BinTree();
        BeanUtils.copyProperties(tree, copyTree);
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
        inOrderTraversal(tree1);


    }


}
