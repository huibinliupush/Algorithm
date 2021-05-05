package com.bin.algorithm.leetcode.linklist;

import com.bin.algorithm.leetcode.linklist.entity.ListNode;

public class HasCycle {


    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null) {
                return false;
            }

            slow = slow.next;

            if (fast.next == null) {
                return false;
            }

            fast = fast.next.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode node6 = new ListNode(5);
        ListNode node5 = new ListNode(5,node6);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(8,node4);
        ListNode node2 = new ListNode(1,node3);
        ListNode node1 = new ListNode(4,node2);

        node6.next = node3;

        HasCycle test = new HasCycle();
        System.out.println(test.hasCycle(node1));
    }
}
