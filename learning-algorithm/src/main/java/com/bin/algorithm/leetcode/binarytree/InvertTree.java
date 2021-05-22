package com.bin.algorithm.leetcode.binarytree;

import com.bin.algorithm.leetcode.binarytree.entity.TreeNode;

public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode invertLeft = invertTree(root.left);
        TreeNode invertRight = invertTree(root.right);

        root.left = invertRight;
        root.right = invertLeft;

        return root;
    }

    public static void main(String[] args) {

    }
}
