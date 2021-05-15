package com.bin.algorithm.leetcode.hash;

import java.util.HashSet;

public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 1) {
            return -1;
        }

        HashSet<Integer> cache = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (cache.contains(nums[i])) {
                return nums[i];
            } else {
                cache.add(nums[i]);
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
