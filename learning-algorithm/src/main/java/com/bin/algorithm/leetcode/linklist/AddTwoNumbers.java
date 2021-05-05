package com.bin.algorithm.leetcode.linklist;

import com.bin.algorithm.leetcode.linklist.entity.ListNode;

public class AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode sentinel = new ListNode();
        ListNode cur = new ListNode();
        sentinel = cur;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = sum / 10;
            sum = sum % 10;

            ListNode node = new ListNode();
            node.val = sum;
            cur.next = node;
            cur = node;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }

        }

        if (carry > 0) {
            ListNode node = new ListNode();
            node.val = carry;
            cur.next = node;

        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode node3 = new ListNode(4);
        ListNode node2 = new ListNode(6,node3);
        ListNode node1 = new ListNode(5,node2);

        ListNode node6 = new ListNode(6);
        ListNode node4 = new ListNode(4,node6);
        ListNode node5 = new ListNode(2,node4);

        AddTwoNumbers test = new AddTwoNumbers();
        ListNode.printListNode(test.addTwoNumbers(node1,node5));
    }
}
