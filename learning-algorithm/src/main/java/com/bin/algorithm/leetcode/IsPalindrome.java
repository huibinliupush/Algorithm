package com.bin.algorithm.leetcode;

public class IsPalindrome {

    /**
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     *
     * 输入: "race a car"
     * 输出: false
     *
     * 只考虑字母和数字字符，可以忽略字母的大小写。
     * */
    public static void main(String[] args) {

        IsPalindrome test = new IsPalindrome();
        System.out.println(test.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(test.isPalindrome("race a car"));
        System.out.println(test.isPalindrome("qwdddqwg"));
    }


    public boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }

        int strLen = s.length();

        if (strLen <= 1) {
            return true;
        }

        s = s.toLowerCase();

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftChar = s.charAt(left);
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                continue;
            }

            char rightChar = s.charAt(right);
            if (!Character.isLetterOrDigit(rightChar)) {
                right--;
                continue;
            }

            if (leftChar == rightChar) {
                left++;
                right--;
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}
