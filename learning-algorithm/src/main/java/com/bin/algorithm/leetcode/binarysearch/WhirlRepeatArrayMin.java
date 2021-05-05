package com.bin.algorithm.leetcode.binarysearch;

public class WhirlRepeatArrayMin {

    public int findMin(int[] nums) {
        if (nums == null) {
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (low == high) {
                return nums[mid];
            }

            if ((mid == 0 && nums[high] > nums[mid]) ||
                    (mid != 0 && nums[mid - 1] > nums[mid])) {
                return nums[mid];
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] == nums[high]) {//重复值在末尾或者在两边
                high--;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        WhirlRepeatArrayMin test = new WhirlRepeatArrayMin();
        System.out.println(test.findMin(new int[]{
                1,1
        }));
    }
}
