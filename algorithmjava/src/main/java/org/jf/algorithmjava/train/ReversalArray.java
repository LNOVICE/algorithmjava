package org.jf.algorithmjava.train;

import org.jf.algorithmjava.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表的头节点，按链表从尾到头的顺序返回每个节点的值（用数组返回）。
 */
public class ReversalArray {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList ret = new ArrayList<Integer>();
        Stack stack = new Stack();
        while(listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        while(!stack.isEmpty()) {
            ret.add(stack.pop());
        }
        return ret;
    }
}


