package com.bin.algorithm.leetcode.linklist;

import com.bin.algorithm.leetcode.linklist.entity.ListNode;

public class GetIntersectionNode {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode curA = headA;
        ListNode curB = headB;

        ListNode sentinet = new ListNode();
        boolean listAFinal = false;
        boolean listBFinal = false;

        while (curA.next != null || !listAFinal) {
            if (curA.val == curB.val && sentinet.next == null) {
                sentinet.next = curA;
            }

            if (curA.val != curB.val) {
                sentinet.next = null;
            }

            if (curA.next == null && !listAFinal) {
                curA = headB;
                listAFinal = true;
            } else {
                curA = curA.next;
            }

            if (curB.next == null && !listBFinal) {
                curB = headA;
                listBFinal = true;
            } else {
                curB = curB.next;
            }
        }

        return sentinet.next;
    }


    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(8,node4);
        ListNode node2 = new ListNode(1,node3);
        ListNode node1 = new ListNode(4,node2);

        ListNode node12 = new ListNode(5);
        ListNode node11 = new ListNode(4,node12);
        ListNode node10 = new ListNode(8,node11);
        ListNode node9 = new ListNode(1,node10);
        ListNode node8 = new ListNode(6,node9);
        ListNode node7 = new ListNode(5,node8);

        GetIntersectionNode test = new GetIntersectionNode();
        ListNode.printListNode(test.getIntersectionNode(node1,node7));
    }
}
