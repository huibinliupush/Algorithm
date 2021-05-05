package com.bin.algorithm.leetcode.linklist;

import com.bin.algorithm.leetcode.linklist.entity.ListNode;

public class RemoveNthFromEnd {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        if (n < 1) {
            return head;
        }

        ListNode sentinel = new ListNode();
        sentinel.next = head;

        ListNode preK = sentinel;

        for (int step = 0; step < n - 1; step++) {
            head = head.next;
            if (head == null) {
                return sentinel.next;
            }
        }

        while (head.next != null) {
            head = head.next;
            preK = preK.next;
        }

        preK.next = preK.next.next;
        return sentinel.next;
    }


    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);

        RemoveNthFromEnd test = new RemoveNthFromEnd();
        ListNode.printListNode(test.removeNthFromEnd(node1, 6));
    }
}
