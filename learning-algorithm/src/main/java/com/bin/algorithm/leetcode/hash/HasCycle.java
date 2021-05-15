package com.bin.algorithm.leetcode.hash;

import com.bin.algorithm.leetcode.hash.entity.ListNode;

import java.util.HashSet;

public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        HashSet<ListNode> cache = new HashSet<>();
        while (head != null) {
            if (cache.contains(head)) {
                return true;
            }

            cache.add(head);
            head = head.next;
        }

        return false;
    }

    public static void main(String[] args) {
        HasCycle test = new HasCycle();

        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(8,node4);
        ListNode node2 = new ListNode(1,node3);
        ListNode node1 = new ListNode(4,node2);

        node5.next = node3;

       System.out.println(test.hasCycle(node1));
    }
}
