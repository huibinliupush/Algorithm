package com.bin.algorithm.leetcode;

public class LengthOfLastWord {

    /**
     * 输入：s = "Hello World"
     * 输出：5
     *
     * 输入：s = " "
     * 输出：0
     *
     * */
    public static void main(String[] args) {
        LengthOfLastWord test = new LengthOfLastWord();
        System.out.println(test.lengthOfLastWord("hello world"));
        System.out.println(test.lengthOfLastWord(" "));
        System.out.println(test.lengthOfLastWord("hello world java   "));
    }

    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }

        int lastWordNum = 0;
        int strLen = s.length();
        boolean lastIsWhitespace = false;
        for (int index = 0; index < strLen; index++) {
            char wordChar = s.charAt(index);

            if ((wordChar >= 'a' && wordChar <= 'z') || (wordChar >= 'A' && wordChar <= 'Z')) {
                if (lastIsWhitespace) {
                    lastWordNum = 1;
                } else {
                    lastWordNum++;
                }

                lastIsWhitespace = false;
            }

            if (Character.isWhitespace(wordChar)) {
                lastIsWhitespace = true;
            }
        }

        return lastWordNum;
    }
}
