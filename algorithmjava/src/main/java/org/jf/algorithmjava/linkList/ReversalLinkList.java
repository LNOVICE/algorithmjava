package org.jf.algorithmjava.linkList;

import java.util.LinkedList;

public class ReversalLinkList {
   static class LinkListNode {

       int val;
       LinkListNode next;
       LinkListNode(LinkListNode node, int val) {
           this.val = val;
           this.next = node;
       }
   }


    public static void main(String[] args) {

       LinkListNode node5= new LinkListNode(null, 5);
       LinkListNode node4= new LinkListNode(node5, 4);
       LinkListNode node3= new LinkListNode(node4, 3);
       LinkListNode node2= new LinkListNode(node3, 2);
       LinkListNode node1= new LinkListNode(node2, 1);
//        LinkListNode head = reversalByIteration(node1);
        LinkListNode head  = reversalByRecusive(node1);
        LinkedList ll = new LinkedList();
        ll.push(1);
        System.out.println(head);


    }


    /**
     * 迭代逆序单链表
     * @param curr
     */
    public static LinkListNode reversalByIteration(LinkListNode curr) {

        LinkListNode prev = null;
        LinkListNode next ;

        while (curr!= null){
            next = curr.next;
            curr.next =  prev;
            prev = curr;
            curr = next;

       }
        return prev;
    }

    public static LinkListNode reversalByRecusive(LinkListNode curr) {

        if(curr.next == null ) {
            return curr;
        }
        LinkListNode head = reversalByRecusive(curr.next);
        curr.next.next = curr;
        curr.next= null;
        return head;

    }

}
