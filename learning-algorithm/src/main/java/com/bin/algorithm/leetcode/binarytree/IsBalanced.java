package com.bin.algorithm.leetcode.binarytree;

import com.bin.algorithm.leetcode.binarytree.entity.TreeNode;

public class IsBalanced {

    private boolean isBalance;

    public boolean isBalanced(TreeNode root) {
        isBalance = true;
        depth(root);
        return isBalance;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = depth(root.left);

        if (!isBalance) {
            return 0;
        }

        int righDepth = depth(root.right);

        if (!isBalance) {
            return 0;
        }

        if (Math.abs(leftDepth - righDepth) > 1) {
            isBalance = false;
        }

        return Math.max(leftDepth, righDepth) + 1;

    }

    public static void main(String[] args) {

    }
}
