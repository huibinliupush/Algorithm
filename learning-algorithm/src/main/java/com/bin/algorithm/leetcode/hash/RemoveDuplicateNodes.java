package com.bin.algorithm.leetcode.hash;

import com.bin.algorithm.leetcode.hash.entity.ListNode;

import java.util.HashSet;

public class RemoveDuplicateNodes {

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode sentinel = new ListNode();
        ListNode tail = sentinel;

        HashSet<Integer> cache = new HashSet<>();
        while (head != null) {
            if (!cache.contains(head.val)) {
                cache.add(head.val);
                tail.next = head;
                tail = head;
            }

            head = head.next;
        }

        tail.next = null;
        return sentinel.next;
    }
    public static void main(String[] args) {
        ListNode node5 = new ListNode(2);
        ListNode node4 = new ListNode(3,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);

        RemoveDuplicateNodes test = new RemoveDuplicateNodes();
        ListNode.printListNode(test.removeDuplicateNodes(node1));
    }
}
