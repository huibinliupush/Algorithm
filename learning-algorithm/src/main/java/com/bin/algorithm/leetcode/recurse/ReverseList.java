package com.bin.algorithm.leetcode.recurse;

import com.bin.algorithm.leetcode.linklist.entity.ListNode;

public class ReverseList {


    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }



    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);

        ReverseList test = new ReverseList();
        ListNode.printListNode(test.reverseList(node1));
    }
}
