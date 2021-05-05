package com.bin.algorithm.leetcode.binarysearch;

public class PeakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        if (arr == null) {
            return -1;
        }

        int len = arr.length;
        if (len < 3) {
            return -1;
        }

        int low = 0;
        int high = len - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] < arr[mid-1]) {
                high--;
            } else {
                low++;
            }

        }

        return -1;
    }


    public static void main(String[] args) {

        PeakIndexInMountainArray test = new PeakIndexInMountainArray();
        System.out.println(test.peakIndexInMountainArray(new int[]{
                1,2,3,4,5,1,2
        }));

        System.out.println(test.peakIndexInMountainArray(new int[]{
                0,2,1,0
        }));

        System.out.println(test.peakIndexInMountainArray(new int[]{
                1,2,3,1
        }));

        System.out.println(test.peakIndexInMountainArray(new int[]{
                1,2,1,3,5,6,4
        }));

    }
}
