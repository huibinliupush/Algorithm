package com.bin.algorithm.leetcode.linklist;

import com.bin.algorithm.leetcode.linklist.entity.ListNode;

public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }

        ListNode reverseSentinel = new ListNode();
        ListNode cur = head;

        int index = 0;
        while (cur != null) {
            boolean isKnode = (++index % k) == 0;
            ListNode next = cur.next;
            cur.next = reverseSentinel.next;
            reverseSentinel.next = cur;

            if (isKnode) {
                index = 0;
            }

            cur = next;

        }


        return reverseSentinel.next;
    }


    public static void main(String[] args) {
        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(5,node6);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);

        ReverseKGroup test = new ReverseKGroup();
        ListNode.printListNode(test.reverseKGroup(node1, 3));
    }
}
