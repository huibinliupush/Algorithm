package com.bin.algorithm.leetcode.binarysearch;

public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        SearchInsert test = new SearchInsert();
        System.out.println(test.searchInsert(new int[]{
                1,3,5,6
        }, 0));
    }
}
