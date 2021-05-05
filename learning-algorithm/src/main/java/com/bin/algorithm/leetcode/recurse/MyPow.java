package com.bin.algorithm.leetcode.recurse;

public class MyPow {

    public double myPow(double x, int n) {

        boolean positive = n >= 0 ? true : false;
        double pre = x;
        double cur = 1;
        n = Math.abs(n);
        for (int index = 1; index <= n; index++) {
            double sum = pre * cur;
            cur = sum;
        }

        return positive ? cur : 1 / cur;
    }

    public static void main(String[] args) {
        MyPow test = new MyPow();
        System.out.println(test.myPow(0.0001, 2147483647));
    }
}
