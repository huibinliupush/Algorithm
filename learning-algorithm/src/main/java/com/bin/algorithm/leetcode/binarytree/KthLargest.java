package com.bin.algorithm.leetcode.binarytree;

import com.bin.algorithm.leetcode.binarytree.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthLargest {

    public int kthLargest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.push(root);
                root = root.right;
            }

            root = stack.pop();
            result.add(root.val);
            if (result.size() == k) {
                return result.get(k - 1);
            }
            root = root.left;
        }

        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {

    }
}
