package com.bin.algorithm.leetcode.hash;

public class SingleNumber {

    /**
     * ^ 异或运算
     * 任何数与本身 异或 等于 0 -》 a ^ a = 0
     * 任何数与0 异或 等于 本身 -》 a ^ 0 = a
     * 异或运算满足交换律和结合律   a ^ b ^ a = b ^ a ^ a = b
     *
     * */
    public int singleNumber(int[] nums) {
        if (nums == null) {
            return -1;
        }
        //相同的数 异或^ 等于 0
        int singleNum = 0;
        for (int i = 0; i < nums.length; i++) {
            singleNum ^= nums[i];
        }

        return singleNum;
    }

    public static void main(String[] args) {

    }
}
