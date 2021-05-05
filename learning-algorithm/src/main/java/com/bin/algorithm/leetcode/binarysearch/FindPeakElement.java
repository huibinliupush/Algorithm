package com.bin.algorithm.leetcode.binarysearch;

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        if (nums == null) {
            return -1;
        }

        int len = nums.length;

        if (len == 1) {
            return 0;
        }

        if (len == 2) {
            return nums[0] >= nums[1] ? 0 : 1;
        }

        int low = 0;
        int high = len - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid == 0 || mid == len -1) {
                return mid;
            }

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] < nums[mid + 1]) {
                low++;
            } else {
                high--;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        FindPeakElement test = new FindPeakElement();
        System.out.println(test.findPeakElement(new int[]{
                1,2,4,5,6,7
        }));

        System.out.println(test.findPeakElement(new int[]{
                1,2,3,1
        }));

        System.out.println(test.findPeakElement(new int[]{
                1,2,1,3,5,6,4
        }));
    }
}
