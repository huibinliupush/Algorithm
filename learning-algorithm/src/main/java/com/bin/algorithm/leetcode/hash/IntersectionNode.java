package com.bin.algorithm.leetcode.hash;

import com.bin.algorithm.leetcode.hash.entity.ListNode;

import java.util.HashSet;

public class IntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        HashSet<ListNode> cache = new HashSet<>();
        cache.add(headA);
        ListNode next = headA.next;
        while (next != null) {
            cache.add(next);
            next = next.next;
        }

        while (headB != null) {
            if (cache.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(8,node4);
        ListNode node2 = new ListNode(1,node3);
        ListNode node1 = new ListNode(4,node2);


        ListNode node9 = new ListNode(1,node3);
        ListNode node8 = new ListNode(0,node9);
        ListNode node7 = new ListNode(5,node8);

        IntersectionNode test = new IntersectionNode();
        ListNode.printListNode(test.getIntersectionNode(node1,node7));
    }
}
