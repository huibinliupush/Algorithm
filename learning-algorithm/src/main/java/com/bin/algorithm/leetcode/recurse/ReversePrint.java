package com.bin.algorithm.leetcode.recurse;

import com.bin.algorithm.leetcode.linklist.entity.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 栈
 * */
public class ReversePrint {

    private List<Integer> array = new ArrayList();

    public int[] reversePrint(ListNode head) {
        recursePrint(head);
        int[] result = new int[array.size()];
        for (int index = 0; index < array.size(); index++) {
            result[index] = array.get(index);
        }

        array.clear();
        return result;
    }

    private void recursePrint(ListNode head) {
        if (head == null) {
            return;
        }

        recursePrint(head.next);
        array.add(head.val);

    }

    public static void main(String[] args) {
        ReversePrint test = new ReversePrint();
        ListNode node3 = new ListNode(4);
        ListNode node2 = new ListNode(6,node3);
        ListNode node1 = new ListNode(5,node2);

        Arrays.stream(test.reversePrint(node1)).forEach(value->{
            System.out.println(value);
        });
    }
}
