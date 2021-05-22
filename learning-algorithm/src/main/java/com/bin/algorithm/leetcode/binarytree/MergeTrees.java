package com.bin.algorithm.leetcode.binarytree;

import com.bin.algorithm.leetcode.binarytree.entity.TreeNode;

public class MergeTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        if (root1 != null && root2 == null) {
            return root1;
        }

        if (root1 == null && root2 != null) {
            return root2;
        }

        TreeNode newRoot = new TreeNode();
        newRoot.val = root1.val + root2.val;

        TreeNode leftNode = mergeTrees(root1.left, root2.left);
        TreeNode rightNode = mergeTrees(root1.right, root2.right);

        newRoot.left = leftNode;
        newRoot.right = rightNode;

        return newRoot;
    }

    public static void main(String[] args) {

    }
}
