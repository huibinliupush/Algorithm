package com.bin.algorithm.leetcode;

import java.util.Arrays;

public class RemoveDuplicates {

    /**
     * 输入：nums = [1,1,2]
     * 输出：2, nums = [1,2]
     *
     *
     * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
     * 输出：5, nums = [0,1,2,3,4]
     *
     * */
    public static void main(String[] args) {
        RemoveDuplicates test = new RemoveDuplicates();
        System.out.println(test.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            printArray(new int[0]);
            return 0;
        }

        int arrayLen = nums.length;

        if (arrayLen <= 1) {
            printArray(nums);
            return arrayLen;
        }

        int replacePosIndex = 0;
        int duplicateIndex = 1;

        /**
         * 在(replacePosIndex，duplicateIndex)区间内的位置都可以覆盖
         * 重复的位置都是可以被覆盖的，需要这两个指针来指示
         * */
        while (duplicateIndex < arrayLen) {
            int replacePos = nums[replacePosIndex];
            int duplicatePos = nums[duplicateIndex];

            if (replacePos == duplicatePos) {
                duplicateIndex++;
            } else {
                nums[++replacePosIndex] = nums[duplicateIndex++];
            }
        }

        printArray(nums);
        return replacePosIndex + 1;
    }

    private void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
