package com.bin.algorithm.leetcode;

public class PokerStraight {

    /**
     * 输入: [1,2,3,4,5]
     * 输出: True
     *
     * 输入: [0,0,1,2,5]
     * 输出: True
     *
     * */
    public static void main(String[] args) {
        PokerStraight test = new PokerStraight();
        System.out.println(test.isStraight(new int[]{1,2,3,4,5}));
        System.out.println(test.isStraight(new int[]{0,0,3,4,5}));

    }

    public boolean isStraight(int[] nums) {
        if (nums == null) {
            return false;
        }

        int len = nums.length;

        if (len != 5) {
            return false;
        }

        //排序？
        int kingNum = 0;
        int minusSum = 0;
        int minusNum = 0;
        for (int index = 0; index < 4; index = index + 2) {
            int a = nums[index];

            if (a == 0) {
                kingNum++;
            }

            if (minusNum != 0) {
                minusSum += (a - minusNum);
                continue;
            }

            int b = nums[index + 1];

            if (b == 0) {
                kingNum++;
            }

            if (b == 0 && a == 0) {
                continue;
            }

            if (b == 0) {
                minusNum = a;
                continue;
            }

            if (a == 0) {
                minusNum = b;
                continue;
            }

            minusSum += (b - a);
        }

        if (kingNum > 2) {
            return false;
        }

        if (kingNum == 0 && minusSum == 4) {
            return true;
        }

        if (kingNum == 2 && (minusSum == 4 || minusSum ==2)) {
            return true;
        }

        if (kingNum == 1 && minusSum == 5) {
            return true;
        }


        return false;
    }
}
