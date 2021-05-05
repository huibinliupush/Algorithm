package com.bin.algorithm.leetcode.linklist;

import com.bin.algorithm.leetcode.linklist.entity.ListNode;

public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode odd = head;
        ListNode evenHead = odd.next;
        ListNode even = evenHead;

        int index = 1;
        while (odd.next != null || even.next != null) {
            boolean oddFlag = (index % 2) != 0;
            if (oddFlag) {
                odd.next = odd.next.next;
                if (odd.next == null) {
                    break;
                }
                odd = odd.next;
            } else {
                even.next = even.next.next;
                even = even.next;
                if (even == null) {
                    break;
                }
            }

            index++;
        }

        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);

        OddEvenList test = new OddEvenList();
        ListNode result = test.oddEvenList(node1);
        ListNode.printListNode(result);

    }
}
