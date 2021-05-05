package com.bin.algorithm.leetcode;

public class StrToInt {

    public int strToInt(String str) {
        if (str == null) {
            return 0;
        }

        int num = 0;
        boolean hasDigit = false;
        boolean negative = false;
        //正负符号之前有没有出现过
        boolean appeardFlag = false;
        for (int index = 0; index < str.length(); index++) {
            char wordChar = str.charAt(index);
            if (wordChar == ' ') {
                if (hasDigit) {
                    break;
                }
                if (appeardFlag) {
                    break;
                }
                continue;
            }

            if (wordChar == '-') {
                if (hasDigit) {
                    break;
                }

                if (appeardFlag) {
                    return 0;
                }


                negative = true;
                appeardFlag = true;
                continue;
            }

            if (wordChar == '+') {
                if (hasDigit) {
                    break;
                }

                if (appeardFlag) {
                    return 0;
                }

                appeardFlag = true;
                continue;
            }

            if (!isDigit(wordChar) && !hasDigit) {
                return 0;
            }

            if (!isDigit(wordChar)) {
                break;
            }


            hasDigit = true;

            int wordNum = negative ? -(wordChar - '0') : wordChar - '0';

            if (isOverFlow(num, negative, wordNum)) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            num = num * 10 + wordNum;

        }

        return num;
    }

    private boolean isOverFlow(int num, boolean negative, int wordNum) {
        if (negative) {
            return num < (Integer.MIN_VALUE - wordNum) / 10;
        } else {
            return num > (Integer.MAX_VALUE - wordNum) / 10;
        }
    }


    private boolean isDigit(char wordChar) {
        return wordChar >= '0' && wordChar <= '9';
    }

    /**
     * 输入: "42"
     * 输出: 42
     *
     * 输入: "   -42"
     * 输出: -42
     *
     * 输入: "words and 987"
     * 输出: 0
     *
     * 输入: "4193 with words"
     * 输出: 4193
     *
     * 输入: "-91283472332"
     * 输出: -2147483648
     *
     * "3.14159"
     * 3
     *
     * "   +0 123"
     * 123
     *
     *
     * */
    public static void main(String[] args) {
        StrToInt test = new StrToInt();

        System.out.println(test.strToInt("-5-"));
        System.out.println(test.strToInt("0-1"));
        System.out.println(test.strToInt("-  234"));
        System.out.println(test.strToInt("   +0 123"));
        System.out.println(test.strToInt("+-1"));
        System.out.println(test.strToInt("+1"));
        System.out.println(test.strToInt("3.14159"));
        System.out.println(test.strToInt("42"));
        System.out.println(test.strToInt("-42"));
        System.out.println(test.strToInt("word and 987"));
        System.out.println(test.strToInt("4193 with words"));
        System.out.println(test.strToInt("-91283472332"));
    }

}
