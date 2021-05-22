package com.bin.algorithm.leetcode.binarytree;

import com.bin.algorithm.leetcode.binarytree.entity.TreeNode;

public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDeph = maxDepth(root.right);

        return leftMaxDepth >= rightMaxDeph ? leftMaxDepth+1 : rightMaxDeph + 1;

    }

    public static void main(String[] args) {

    }
}
