package com.bin.algorithm.leetcode.binarytree;

import com.bin.algorithm.leetcode.binarytree.entity.TreeNode;

public class IsValidBST {

    /**
     *  也可利用二叉搜索树的特性
     *  中序遍历，看结果是否升序
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBst(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }

        if (root.val <= lower || root.val >= upper) {
            return false;
        }

        return isValidBst(root.left, lower, root.val) && isValidBst(root.right, root.val, upper);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        IsValidBST test = new IsValidBST();

        System.out.println(test.isValidBST(root));

    }
}
