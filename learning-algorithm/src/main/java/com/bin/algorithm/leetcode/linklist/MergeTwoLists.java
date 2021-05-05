package com.bin.algorithm.leetcode.linklist;

import com.bin.algorithm.leetcode.linklist.entity.ListNode;

public class MergeTwoLists {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode sentinel = new ListNode();
        ListNode cur = sentinel;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }

            cur = cur.next;
        }

        if (l1 == null) {
            cur.next = l2;
        }

        if (l2 == null) {
            cur.next = l1;
        }

        return sentinel.next;

    }


    public static void main(String[] args) {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);


        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(5,node6);
        ListNode node4 = new ListNode(4,node5);

        MergeTwoLists test = new MergeTwoLists();
        ListNode.printListNode(test.mergeTwoLists(node1,node4));
    }
}
