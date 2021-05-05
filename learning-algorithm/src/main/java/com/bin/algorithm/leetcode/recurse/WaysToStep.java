package com.bin.algorithm.leetcode.recurse;

public class WaysToStep {

    public int waysToStep(int n) {
       if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 2;
        }

        if (n == 2) {
            return 2;
        }

       // return waysToStep(n - 1) + waysToStep(n - 2) + waysToStep(n - 3);
        int prePre = 1;
        int pre = 1;
        int cur = 2;

        for (int index = 3; index <= n; index++) {
            int sum = (prePre + pre) % 1000000007 + cur ;
            prePre = pre;
            pre = cur;
            cur = sum;
        }

        return cur;

    }

    public static void main(String[] args) {

    }
}
