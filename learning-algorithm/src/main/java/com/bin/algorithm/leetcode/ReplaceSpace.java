package com.bin.algorithm.leetcode;

public class ReplaceSpace {

    /**
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     *
     * */
    public static void main(String[] args) {
        ReplaceSpace test = new ReplaceSpace();
        System.out.println(test.replaceSpace("We are happy."));
    }

    public String replaceSpace(String s) {
        if (s == null) {
            return s;
        }

        int strLen = s.length();
        int index = 0;
        StringBuilder replaceBuilder = new StringBuilder();
        while (index < strLen) {
            char wordChar = s.charAt(index);
            if (Character.isWhitespace(wordChar)) {
                replaceBuilder.append("%20");
            } else {
                replaceBuilder.append(String.valueOf(wordChar));
            }
            index++;
        }
        return replaceBuilder.toString();
    }
}
