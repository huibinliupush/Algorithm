package com.bin.algorithm.leetcode.hash;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return nums;
        }

        HashMap<Integer, Integer> numCache = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {
            numCache.put(nums[index], index);
        }

        for (int index = 0; index < nums.length; index++) {
            int plusNum = target - nums[index];
            if (!numCache.containsKey(plusNum)) {
                continue;
            }

            int plusIndex = numCache.get(plusNum);
            if (index == plusIndex) { //去除自己 [3,2,4] target 6
                continue;
            }
            return new int[]{index, plusIndex};
        }

        numCache = null;
        return new int[]{-1,-1};
    }


    public static void main(String[] args) {
        TwoSum test = new TwoSum();
        getResult(test, new int[]{-1,-2,-3,-4,-5}, -8);
        getResult(test, new int[]{0,4,3,0}, 0);
        getResult(test, new int[]{2, 7, 11, 15}, 9);
        getResult(test, new int[]{20, 10, 11, 15}, 9);
        getResult(test, new int[]{3,2,4}, 6);
        getResult(test, new int[]{3,3}, 6);
        getResult(test, new int[]{10,25,100,3,6,3,90,5,3}, 6);
    }

    public static void getResult(TwoSum test, int[] testArray, int target) {

        int[] result = test.twoSum(testArray, target);

        if (result == null) {
            System.out.println(String.format("数组:%s 中不存在两数之和等于%d", Arrays.toString(testArray),target));
            return;
        }

        System.out.println( String.format("数组：%s 中 两个数之和等于%d 的下标为：%s",
                Arrays.toString(testArray),target,Arrays.toString(result)));
    }
}
