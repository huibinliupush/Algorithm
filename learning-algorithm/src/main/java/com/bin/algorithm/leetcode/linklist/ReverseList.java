package com.bin.algorithm.leetcode.linklist;

import com.bin.algorithm.leetcode.linklist.entity.ListNode;

public class ReverseList {

    public ListNode reverseList(ListNode head) {

        ListNode sentinel = new ListNode();
        ListNode insert = head;

        while (insert != null) {
            ListNode next = insert.next;
            insert.next = sentinel.next;
            sentinel.next = insert;
            insert = next;
        }

        return sentinel.next;
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
