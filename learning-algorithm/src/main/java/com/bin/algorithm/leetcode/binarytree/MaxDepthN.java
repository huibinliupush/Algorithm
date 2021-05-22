package com.bin.algorithm.leetcode.binarytree;

import com.bin.algorithm.leetcode.binarytree.entity.Node;

import java.util.List;

public class MaxDepthN {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        List<Node> children = root.children;

        if (children == null) {
            return 1;
        }

        int maxChildDepth = 0;

        for (Node node : children) {
            int childDepth = maxDepth(node);
            maxChildDepth = Math.max(maxChildDepth, childDepth);
        }

        return maxChildDepth + 1;
    }

    public static void main(String[] args) {

    }
}
