package com.bin.algorithm.leetcode.hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Intersection {

    /**
     * 求相同数的解法 都可以用 异或运算
     * */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }

        HashSet<Integer> cache = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            cache.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (cache.contains(nums2[i])) {
                result.add(nums2[i]);
            }
        }

        int[] intersection = new int[result.size()];
        int i = 0;
        for (Integer inter : result) {
            intersection[i++] = inter;
        }
        return intersection;

    }
    public static void main(String[] args) {

    }
}
