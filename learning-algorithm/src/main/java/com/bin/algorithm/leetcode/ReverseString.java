package com.bin.algorithm.leetcode;

import java.util.Arrays;

public class ReverseString {

    /**
     * 输入：["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     *
     *
     * 输入：["H","a","n","n","a","h"]
     * 输出：["h","a","n","n","a","H"]
     *
     * */
    public static void main(String[] args) {
        ReverseString test = new ReverseString();
        test.reverseString("hello".toCharArray());
        test.reverseString("Hannah".toCharArray());
        test.reverseString("Hanbah".toCharArray());
        test.reverseString("".toCharArray());
        test.reverseString("H".toCharArray());
    }

    public void reverseString(char[] s) {
        if (s == null) {
            return;
        }

        int strLen = s.length;

        int midIndex = strLen >> 1;

        for (int index = 0; index < midIndex; index++) {
            int swapIndex = strLen - 1 - index;
            swapArrayByIndex(s,index,swapIndex);
        }

        print(s);

    }

    private void swapArrayByIndex(char[] s,int index,int swapIndex) {
        char temp = s[index];
        s[index] = s[swapIndex];
        s[swapIndex] = temp;
    }

    private void print(char[] s) {
        System.out.println(Arrays.toString(s));
    }
}
