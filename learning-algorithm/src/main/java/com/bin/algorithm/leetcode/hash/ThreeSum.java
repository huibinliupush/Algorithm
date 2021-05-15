package com.bin.algorithm.leetcode.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null) {
            return result;
        }

        int len = nums.length;
        if (len < 3) {
            return result;
        }

        HashMap<Integer, Integer> cache = new HashMap<>();

        for (int i = 0; i < len; i++) {
            cache.put(nums[i], i);
        }

        for (int j = 1; j < len; j++) {
            int sum = -(nums[0] + nums[j]);
            if (!cache.containsKey(sum)) {
                continue;
            }

            int sumIndex = cache.get(sum);
            if (sumIndex > j) {
                List<Integer> resultItem = new ArrayList<>();
                resultItem.add(nums[0]);
                resultItem.add(nums[j]);
                resultItem.add(sum);
                result.add(resultItem);
            }
        }

        return result;

    }

    public static void main(String[] args) {
        ThreeSum test = new ThreeSum();
        List<List<Integer>> result = test.threeSum(new int[]{0,0,0,0});

        result.stream().forEach(list -> {
            System.out.println(Arrays.toString(list.toArray()));
        });
    }
}
