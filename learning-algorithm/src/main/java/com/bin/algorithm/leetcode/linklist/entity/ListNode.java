package com.bin.algorithm.leetcode.linklist.entity;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void printListNode(ListNode node) {
        if (node == null) {
            System.out.println("链表为空");
        }

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
