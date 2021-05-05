package com.bin.algorithm.leetcode.binarysearch;

public class NextGreatestLetter {

    public char nextGreatestLetter(char[] letters, char target) {
        if (letters == null) {
            return 'a';
        }

        int low = 0;
        int high = letters.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (letters[mid] > target) {
                if (mid == 0 || letters[mid -1] <= target) {
                    return letters[mid];
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return letters[0];
    }
    public static void main(String[] args) {

    }
}
