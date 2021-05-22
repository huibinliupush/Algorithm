package com.bin.algorithm.leetcode.binarytree;

import com.bin.algorithm.leetcode.binarytree.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderPrint {

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }

        List<Integer> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode level = queue.poll();
            resultList.add(level.val);
            if (level.left != null) {
                queue.add(level.left);
            }

            if (level.right != null) {
                queue.add(level.right);
            }
        }


        int[] result = new int[resultList.size()];
        int index = 0;
        for (int level : resultList) {
            result[index++] = level;
        }

        return result;

    }

    public static void main(String[] args) {

    }
}
