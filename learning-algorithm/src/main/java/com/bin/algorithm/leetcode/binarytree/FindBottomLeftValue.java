package com.bin.algorithm.leetcode.binarytree;

import com.bin.algorithm.leetcode.binarytree.entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindBottomLeftValue {

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1;
        }

        Deque<Deque<Integer>> levelResult = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Deque<Integer> level = new LinkedList<>();
            int levelSize = queue.size();

            for (int index = 0; index < levelSize; index++) {
                TreeNode node = queue.poll();
                level.addLast(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            levelResult.addLast(level);
        }

        return levelResult.getLast().getFirst();
    }

    public static void main(String[] args) {

    }
}
