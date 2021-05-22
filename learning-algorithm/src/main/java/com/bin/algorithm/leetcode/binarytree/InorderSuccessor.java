package com.bin.algorithm.leetcode.binarytree;

import com.bin.algorithm.leetcode.binarytree.entity.TreeNode;

public class InorderSuccessor {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p == null) {
            return null;
        }

        TreeNode pParent = null;
        TreeNode pIndicator = root;

        while (pIndicator != null) {
            if (pIndicator == p) {
                break;
            }

            pParent = pIndicator;
            if (pIndicator.val < p.val) {
                pIndicator = pIndicator.right;
            } else {
                pIndicator = pIndicator.left;
            }
        }


        if (pIndicator != p) {
            return null;
        }

        if (p.right != null) {
            TreeNode successor = p.right;

            while (successor.left != null) {
                successor = successor.left;
            }

            return successor;
        }

        if (pParent == null) {
            return null;
        }

        if (pParent.left == p) {
            return pParent;
        }

        if (pParent.right == p) {
            return null;
        }

        return null;

    }

    public static void main(String[] args) {

    }
}
