package com.bin.algorithm.leetcode.binarytree;

import com.bin.algorithm.leetcode.binarytree.entity.TreeNode;

import java.util.Stack;

public class ConvertBST {

    public TreeNode convertBST(TreeNode root) {
        TreeNode sumTree = root;
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }

            root = stack.pop();
            sum += root.val;
            root.val = sum;

            root = root.left;
        }

        return sumTree;
    }

    public static void main(String[] args) {

    }
}
