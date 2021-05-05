package com.bin.algorithm.leetcode;

import java.util.Arrays;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        if (nums == null) {
            return null;
        }

        int arrayLength = nums.length;

        if (arrayLength < 2) {
            return null;
        }

        for (int index = 0; index < arrayLength; index++) {
            int plusNum = nums[index];
            int plusdNum = target - plusNum;

            int plusdNumIndex = searchPlusdNumIndexInArray(plusdNum,nums,index);

            if (plusdNumIndex >= 0) {
                return new int[]{index,plusdNumIndex};
            }

        }

        return null;
    }


    private int searchPlusdNumIndexInArray(int searchNum, int[] nums, int plusNumIndex) {

        if (nums == null) {
            return -1;
        }

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == searchNum && index != plusNumIndex) {
                return index;
            }
        }
        return -1;
    }


    /**
     * nums = [2,7,11,15], target = 9
     *
     * nums = [20,10,11,15], target = 9
     *
     * nums = [3,2,4], target = 6
     *
     * nums = [3,3], target = 6
     *
     * nums = [10,25.100,3,6,90,5,3], target = 6
     *
     * nums = [0,4,3,0] ,target = 0
     *
     * [-1,-2,-3,-4,-5] -8
     *
     * */
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

    public static void getResult(TwoSum test,int[] testArray,int target) {

        int[] result = test.twoSum(testArray, target);

        if (result == null) {
            System.out.println(String.format("数组:%s 中不存在两数之和等于%d", Arrays.toString(testArray),target));
            return;
        }

        System.out.println( String.format("数组：%s 中 两个数之和等于%d 的下标为：%s",
                Arrays.toString(testArray),target,Arrays.toString(result)));
    }
}
