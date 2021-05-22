package com.bin.algorithm.leetcode.binarytree;

import com.bin.algorithm.leetcode.binarytree.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderPrint2 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();
        boolean order = true;

        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int levelSize = queue.size();
            //获取当前层的所有节点
            for (int index = 0; index < levelSize; index++) {
                TreeNode levelNode = queue.poll();

                if (order) {
                    level.add(levelNode.val);
                }else {
                    stack.push(levelNode);
                }

                if (levelNode.left != null) {
                    queue.add(levelNode.left);
                }

                if (levelNode.right != null) {
                    queue.add(levelNode.right);
                }
            }

            if (!order) {
                while (!stack.isEmpty()) {
                    level.add(stack.pop().val);
                }

                order = true;
            } else {
                order = false;
            }

            result.add(level);
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
