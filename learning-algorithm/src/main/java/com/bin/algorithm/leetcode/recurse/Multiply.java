package com.bin.algorithm.leetcode.recurse;

public class Multiply {

    public int multiply(int A, int B) {
        if (A == 0 || B == 0) {
            return 0;
        }

        boolean positive = true;
        if ((A < 0 && B > 0) || (A > 0 && B < 0)) {
            positive = false;
        }

        A = Math.abs(A);
        B = Math.abs(B);
        int smallNum = A <= B ? A : B;
        int bigNum = A > B ? A : B;
        int result = 0;
        for (int index = 0; index < smallNum; index++) {
            result += bigNum;
        }

        return positive ? result : -result;
    }

    public static void main(String[] args) {
        Multiply test = new Multiply();
        System.out.println(test.multiply(32,-10));
    }
}
