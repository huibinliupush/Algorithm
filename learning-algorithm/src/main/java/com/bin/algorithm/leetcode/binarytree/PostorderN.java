package com.bin.algorithm.leetcode.binarytree;

import com.bin.algorithm.leetcode.binarytree.entity.Node;

import java.util.LinkedList;
import java.util.List;

public class PostorderN {

    public List<Integer> postorder(Node root) {
        List<Integer> result = new LinkedList<>();
        postOrderRecurse(root,result);
        return result;
    }

    private void postOrderRecurse(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }

        List<Node> children = root.children;
        if (children != null) {
            for (Node child : children) {
                postOrderRecurse(child,result);
            }
        }

        result.add(root.val);
    }
    public static void main(String[] args) {

    }
}
