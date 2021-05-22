package com.bin.algorithm.leetcode.binarytree;

import com.bin.algorithm.leetcode.binarytree.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        preOrderRecurse(root,result);
        return result;
    }

    private void preOrderRecurse(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        preOrderRecurse(root.left,result);
        preOrderRecurse(root.right,result);

    }

    public static void main(String[] args) {

    }
}
