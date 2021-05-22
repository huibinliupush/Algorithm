package com.bin.algorithm.leetcode.binarytree;

import com.bin.algorithm.leetcode.binarytree.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        postOrderRecurse(root,result);
        return result;
    }

    private void postOrderRecurse(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        postOrderRecurse(root.left,result);
        postOrderRecurse(root.right, result);
        result.add(root.val);

    }

    public static void main(String[] args) {

    }
}
