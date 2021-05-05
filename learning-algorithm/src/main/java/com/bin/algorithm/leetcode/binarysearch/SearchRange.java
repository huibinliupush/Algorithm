package com.bin.algorithm.leetcode.binarysearch;

import java.util.Arrays;

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};

        if (nums == null) {
            return result;
        }

        result[0] = binarySearch(nums, target, true);
        result[1] = binarySearch(nums, target, false);

        return result;
    }

    private int binarySearch(int[] nums, int target, boolean firstEqual) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (firstEqual) {
                    if (mid == 0 || nums[mid - 1] != target) {
                        return mid;
                    }else {
                        high = mid - 1;
                    }
                }else {
                    if (mid == nums.length - 1 || nums[mid + 1] != target) {
                        return mid;
                    } else {
                        low = mid + 1;
                    }
                }

            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        SearchRange test = new SearchRange();
        Arrays.stream(test.searchRange(new int[]{3,3,3},3)).forEach(num->{
            System.out.println(num);
        });

        Arrays.stream(test.searchRange(new int[]{5,7,7,8,8,10},8)).forEach(num->{
            System.out.println(num);
        });

        Arrays.stream(test.searchRange(new int[]{5,7,7,8,8,10},6)).forEach(num->{
            System.out.println(num);
        });

        Arrays.stream(test.searchRange(new int[]{},0)).forEach(num->{
            System.out.println(num);
        });


    }
}
