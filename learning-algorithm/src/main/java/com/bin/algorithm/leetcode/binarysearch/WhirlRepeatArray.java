package com.bin.algorithm.leetcode.binarysearch;

public class WhirlRepeatArray {

    public boolean search(int[] nums, int target) {
        if (nums == null) {
            return false;
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[low] == nums[mid] && nums[mid] == nums[high]) { //重复数据在两边
                low++;
                high--;
            } else if (nums[low] <= nums[mid]) { //重复数据在左边
                if (nums[low] == target) {
                    return true;
                }

                if (nums[low] < target && nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] <= nums[high]) { //重复数据在右边
                if (nums[high] == target) {
                    return true;
                }

                if (nums[mid] < target && nums[high] > target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
