package com.bin.algorithm.leetcode.linklist;

import com.bin.algorithm.leetcode.linklist.entity.ListNode;

public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        ListNode reverseList = new ListNode();
        ListNode reverse = slow;

        while (reverse != null) {
            ListNode next = reverse.next;
            reverse.next = reverseList.next;
            reverseList.next = reverse;
            reverse = next;
        }

        ListNode reverseHead = reverseList.next;
        while (reverseHead != null) {
            if (head.val == reverseHead.val) {
                head = head.next;
                reverseHead = reverseHead.next;
            } else {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(1);
        ListNode node4 = new ListNode(1,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);

        IsPalindrome test = new IsPalindrome();
        System.out.println(test.isPalindrome(node1));
    }
}
