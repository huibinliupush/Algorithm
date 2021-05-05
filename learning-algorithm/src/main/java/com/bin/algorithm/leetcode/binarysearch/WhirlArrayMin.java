package com.bin.algorithm.leetcode.binarysearch;

public class WhirlArrayMin {

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

            if ((mid != 0 && nums[mid -1] > nums[mid]) ||
                    (mid == 0 && nums[high] > nums[mid])) {
                //最小值一定在最大值的后边
                //在循环有序数组中 前一个元素如果大于当前元素，那么当前元素就是最小值
                return nums[mid];
            } else if (nums[mid] > nums[high]) { //最小值一定在循环有序区间，不在有序区间
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        WhirlArrayMin test = new WhirlArrayMin();
        System.out.println(test.findMin(new int[]{
                3,4,5,1,2
        }));
    }
}
