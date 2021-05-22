package com.bin.algorithm.leetcode.binarytree;

import com.bin.algorithm.leetcode.binarytree.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        List<List<Integer>> reuslt = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            //当前queue里存放的就是一层的所有节点
            int levelSize = queue.size();

            for (int index = 1; index <= levelSize; index++) {
                TreeNode levelNode = queue.poll();
                level.add(levelNode.val);

                if (levelNode.left != null) {
                    queue.add(levelNode.left);
                }

                if (levelNode.right != null) {
                    queue.add(levelNode.right);
                }
            }

            reuslt.add(level);
        }

        return reuslt;

    }

    public static void main(String[] args) {

    }
}
