package com.bin.algorithm.leetcode.binarytree;

import com.bin.algorithm.leetcode.binarytree.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();

        inOrderRecurse(root,result);
        return result;
    }

    private void inOrderRecurse(TreeNode root,List<Integer> result) {
        if (root == null) {
            return;
        }

        inOrderRecurse(root.left,result);
        result.add(root.val);
        inOrderRecurse(root.right,result);
    }

    private List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }

        return result;

    }

    public static void main(String[] args) {

    }
}
