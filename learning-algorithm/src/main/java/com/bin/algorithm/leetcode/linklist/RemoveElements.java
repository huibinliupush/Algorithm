package com.bin.algorithm.leetcode.linklist;

import com.bin.algorithm.leetcode.linklist.entity.ListNode;

public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {

        ListNode sentinel = new ListNode();
        sentinel.next = head;

        ListNode pre = sentinel;

        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }

        return sentinel.next;
    }


    public static void main(String[] args) {

    }
}
