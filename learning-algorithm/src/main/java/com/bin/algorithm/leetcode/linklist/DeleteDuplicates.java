package com.bin.algorithm.leetcode.linklist;

import com.bin.algorithm.leetcode.linklist.entity.ListNode;

public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode pre = head;

        while (pre.next != null) {
            if (pre.val == pre.next.val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        DeleteDuplicates test = new DeleteDuplicates();

        ListNode node5 = new ListNode(2);
        ListNode node4 = new ListNode(2,node5);
        ListNode node3 = new ListNode(2,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);

        ListNode head = test.deleteDuplicates(node1);
        ListNode.printListNode(head);

    }
}
