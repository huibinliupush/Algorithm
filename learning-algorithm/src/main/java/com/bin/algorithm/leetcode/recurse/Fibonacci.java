package com.bin.algorithm.leetcode.recurse;

public class Fibonacci {


    public int fib(int n) {
        if (n == 0) {
            return 0;
        }

        int pre = 1;
        int cur = 1;

        for (int index = 3; index <= n; index++) {
            int sum = (pre + cur) % 1000000007;
            pre = cur;
            cur = sum;
        }

        return cur;

    }


    public static void main(String[] args) {

    }
}
