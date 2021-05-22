package com.bin.algorithm.leetcode.binarytree;

import com.bin.algorithm.leetcode.binarytree.entity.TreeNode;

public class DiameterOfBinaryTree {

    private Integer maxNodeNum;

    public int diameterOfBinaryTree(TreeNode root) {
        maxNodeNum = 1;
        maxDepth(root);
        return maxNodeNum - 1;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDeptth = maxDepth(root.right);

        int nodeNums = leftMaxDepth + rightMaxDeptth + 1;

        if (nodeNums > maxNodeNum) {
            maxNodeNum = nodeNums;
        }

        return Math.max(leftMaxDepth,rightMaxDeptth) + 1;
    }
    public static void main(String[] args) {

    }
}
