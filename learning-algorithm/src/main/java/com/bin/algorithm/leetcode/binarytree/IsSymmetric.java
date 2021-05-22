package com.bin.algorithm.leetcode.binarytree;

import com.bin.algorithm.leetcode.binarytree.entity.TreeNode;

public class IsSymmetric {

    private boolean symmetric;

    public boolean isSymmetric(TreeNode root) {
        this.symmetric = true;
        if (root == null) {
            return symmetric;
        }

        symmetric(root.left, root.right);
        return symmetric;
    }

    private void symmetric(TreeNode left, TreeNode right) {
        if (!symmetric) {
            return;
        }

        if (left == null && right == null) {
            return;
        }

        if (!(left != null && right != null)) {
            symmetric = false;
            return;
        }

        if (left.val != right.val) {
            symmetric = false;
            return;
        }

        symmetric(left.left, right.right);
        if (!symmetric) {
            return;
        }

        symmetric(left.right,right.left);
    }


    public static void main(String[] args) {

    }
}
