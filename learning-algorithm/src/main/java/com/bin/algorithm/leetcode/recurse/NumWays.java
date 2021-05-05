package com.bin.algorithm.leetcode.recurse;

import java.util.HashMap;
import java.util.Map;

public class NumWays {

    private Map<Integer, Integer> cache = new HashMap<>();

    public int numWays(int n) {
/*        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 1;
        }


        int numWay1 = cache.computeIfAbsent(n - 1, k -> {
            return numWays(n - 1) % 1000000007;
        });

        int numWay2 = cache.computeIfAbsent(n - 2, k -> {
            return numWays(n - 2) % 1000000007;
        });

        //青蛙最后一步是1 + 最后一步是2
        return numWay1 + numWay2;*/

        int pre = 1;
        int cur = 1;

        for (int index = 1; index < n; index++) {
            int sum = (pre + cur) % 1000000007;
            pre = cur;
            cur = sum;
        }

        return cur;
    }


    public static void main(String[] args) {
        NumWays test = new NumWays();
        System.out.println(test.numWays(44));
    }
}
