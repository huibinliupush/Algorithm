package com.bin.algorithm.leetcode.binarysearch;

public class IsPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if (num == 0) {
            return true;
        }

        int low = 1;
        int high = num;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long square = (long) mid * mid;

            if (square == num) {
                return true;
            } else if (square > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        IsPerfectSquare test = new IsPerfectSquare();
        System.out.println(test.isPerfectSquare(16));
    }
}
