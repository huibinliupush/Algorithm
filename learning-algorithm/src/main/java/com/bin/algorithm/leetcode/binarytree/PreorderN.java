package com.bin.algorithm.leetcode.binarytree;

import com.bin.algorithm.leetcode.binarytree.entity.Node;

import java.util.LinkedList;
import java.util.List;

public class PreorderN {

    public List<Integer> preorder(Node root) {
        List<Integer> result = new LinkedList<>();
        preOrderRecurse(root,result);
        return result;
    }

    public void preOrderRecurse(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        List<Node> children = root.children;
        if (children == null) {
            return;
        }

        for (Node child : children) {
            preOrderRecurse(child,result);
        }
    }

    public static void main(String[] args) {

    }
}
