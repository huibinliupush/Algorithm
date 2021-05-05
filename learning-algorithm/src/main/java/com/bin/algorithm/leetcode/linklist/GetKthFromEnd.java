package com.bin.algorithm.leetcode.linklist;

import com.bin.algorithm.leetcode.linklist.entity.ListNode;

public class GetKthFromEnd {


    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        if (k < 1) {
            return new ListNode();
        }

        ListNode kNode = new ListNode();
        kNode = head;

        for (int step = 1; step <= k - 1; step++) {
            head = head.next;
            if (head == null) {
                return new ListNode();//k比链表个数大
            }
        }

        while (head.next != null) {
            head = head.next;
            kNode = kNode.next;
        }

        return kNode;
    }


    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);

        GetKthFromEnd test = new GetKthFromEnd();
        ListNode.printListNode(test.getKthFromEnd(node1,5));
    }
}
