package com.bin.algorithm.leetcode.binarytree;

import com.bin.algorithm.leetcode.binarytree.entity.TreeNode;

public class LowestCommonAncestor {

    private TreeNode commonAncestor;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        commonAncestor = null;
        dfs(root, p, q);
        return commonAncestor;
    }


    /**
     * 1:左右子树是否包含p或者q,如果是 最近公众祖先为root
     * 2:root.val 等于 p或者q,并且左右子树有一个子树包含p或者q  root为最近公众祖先
     * */
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }

        boolean lson = dfs(root.left, p, q);
        if (commonAncestor != null) {
            return true;
        }

        boolean rson = dfs(root.right, p, q);

        if (commonAncestor != null) {
            return true;
        }

        if ((lson && rson) ||
                ((root.val == p.val || root.val == q.val) && (lson || rson))) {

            commonAncestor = root;
            return true;
        }

        return lson || rson || root.val == p.val || root.val == q.val;
    }


    public static void main(String[] args) {

    }
}
