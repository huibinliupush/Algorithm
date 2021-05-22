package com.bin.algorithm.leetcode.binarytree;

import com.bin.algorithm.leetcode.binarytree.entity.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderN {

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new LinkedList<>();
        }

        List<List<Integer>> result = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int levelSize = queue.size();

            for (int index = 0; index < levelSize; index++) {
                Node levelNode = queue.poll();
                level.add(levelNode.val);

                List<Node> children = levelNode.children;
                if (children != null) {
                    for (Node node : children) {
                        queue.add(node);
                    }
                }
            }

            result.add(level);
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
