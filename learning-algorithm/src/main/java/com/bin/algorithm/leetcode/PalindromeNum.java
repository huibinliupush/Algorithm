package com.bin.algorithm.leetcode;

public class PalindromeNum {


    /**
     * 输入：x = 121
     * 输出：true
     *
     * 输入：x = -121
     * 输出：false
     *
     * 输入：x = 10
     * 输出：false
     *
     * 不将整数转为字符串来解决
     *
     * 将数字对半折叠 比较 两部分整数的大小
     * 对半条件： x <= reverseNum
     * 偶数：对半折叠后的数字 肯定是相等的
     * 奇数：x == reverseNum / 10
     *
     * */
    public static void main(String[] args) {
        PalindromeNum test = new PalindromeNum();
        System.out.println(test.isPalindrome(1221));
        System.out.println(test.isPalindrome(12321));
        System.out.println(test.isPalindrome(121));
        System.out.println(test.isPalindrome(-111));
        System.out.println(test.isPalindrome(10));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        /**
         * 个位数为0的肯定不是回文数
         * 0是回文数
         * */
        if (x % 10 == 0 && x != 0) {
            return false;
        }

        //对半折叠后的数字
        int reversedNum = 0;

        while (x > reversedNum) {
            int lastNUM = x % 10;
            reversedNum = reversedNum * 10 + lastNUM;
            x /= 10;
        }

        if (x == reversedNum || x == reversedNum / 10) {
            return true;
        }

        return false;
    }
}
