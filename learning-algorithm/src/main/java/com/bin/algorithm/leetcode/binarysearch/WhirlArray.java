package com.bin.algorithm.leetcode.binarysearch;

public class WhirlArray {

    public int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[low] < nums[mid]) {
                if (nums[low] == target) {
                    return low;
                }

                if (nums[low]< target && nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            } else {
                if (nums[high] == target) {
                    return high;
                }
                if (nums[mid] < target && nums[high] > target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        WhirlArray test = new WhirlArray();
        System.out.println(test.search(new int[]{
                3,1
        },1));
    }
}
