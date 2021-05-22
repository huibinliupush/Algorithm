package com.bin.algorithm.leetcode.binarytree;

import com.bin.algorithm.leetcode.binarytree.entity.TreeNode;

public class LowestCommonAncestorInSearchTree {

    /**
     * 1:左右子树是否分别包含一个p或者q
     * 2: p是q的根  或者q是p的根
     *
     * */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }

        TreeNode min = p.val < q.val ? p : q;
        TreeNode max = p.val < q.val ? q : p;

        while (root != null) {
            if (root.val > min.val && root.val < max.val) {
                return root;
            }

            if (root.val == min.val || root.val == max.val) {
                return root;
            }

            if (root.val > max.val) {
                root = root.left;
                continue;
            }

            if (root.val < min.val) {
                root = root.right;
                continue;
            }

        }

        return null;

    }


    public static void main(String[] args) {

    }
}
