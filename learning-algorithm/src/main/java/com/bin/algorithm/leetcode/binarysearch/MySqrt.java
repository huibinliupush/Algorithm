package com.bin.algorithm.leetcode.binarysearch;

public class MySqrt {

    public int mySqrt(int x) {
        if (x == 0) {
            return x;
        }

        int low = 1;
        int high = x;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long square = (long) mid * mid;
            if (square == x) {
                return mid;
            } else if (square < x) {
                long midPlusSquare = (long) (mid + 1) * (mid + 1);
                if (midPlusSquare > x) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        MySqrt test = new MySqrt();
        System.out.println(test.mySqrt(16));
        System.out.println(test.mySqrt(8));
        System.out.println(test.mySqrt(2147395599));
    }
}
