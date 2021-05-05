package com.bin.algorithm.leetcode;

public class ReverseLeftWords {

    /**
     *
     * 输入: s = "abcdefg", k = 2
     * 输出: "cdefgab"
     *
     * 输入: s = "lrloseumgh", k = 6
     * 输出: "umghlrlose"
     * */
    public static void main(String[] args) {
        ReverseLeftWords test = new ReverseLeftWords();
        System.out.println(test.reverseLeftWords("abcdefg",2));
        System.out.println(test.reverseLeftWords("lrloseumgh",6));
        System.out.println(test.reverseLeftWords("asd",0));
    }

    public String reverseLeftWords(String s, int n) {
        if (s == null) {
            return s;
        }

        if (n <= 0) {
            return s;
        }

        int strLen = s.length();

        if (strLen <= n) {
            return s;
        }

        StringBuilder finalStrBuilder = new StringBuilder();

        for (int index = n; index < n + strLen; index++) {
            finalStrBuilder.append(s.charAt(index % strLen));
        }

        return finalStrBuilder.toString();
    }
}
