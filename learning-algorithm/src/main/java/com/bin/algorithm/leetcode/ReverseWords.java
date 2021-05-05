package com.bin.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseWords {


    /**
     * 输入: "the sky is blue"
     * 输出: "blue is sky the"
     *
     * 输入: "  hello world!  "
     * 输出: "world! hello"
     * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     *
     * 输入: "a good   example"
     * 输出: "example good a"
     * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     *
     * */
    public static void main(String[] args) {
        ReverseWords test = new ReverseWords();
        System.out.println(test.reverseWords("the sky is blue"));
        System.out.println(test.reverseWords("   hello world!  "));
        System.out.println(test.reverseWords("a  good    example"));

    }

    public String reverseWords(String s) {
        if (s == null) {
            return s;
        }

        ArrayList wordList = getWordList(s);
        swapWord(wordList);
        return wordList.stream().collect(Collectors.joining(" ")).toString();
    }

    private void swapWord(ArrayList wordList) {
        int size = wordList.size();
        for (int index = 0; index < (size >> 1); index++) {
            int swapIndex = size - 1 - index;
            Object temp = wordList.get(index);
            wordList.set(index, wordList.get(swapIndex));
            wordList.set(swapIndex, temp);
        }
    }

    private ArrayList getWordList(String wordStr) {
        int strLen = wordStr.length();
        ArrayList wordList = new ArrayList<String>();
        String wordBuilder = null;
        for (int index = 0; index < strLen; index++) {
            char wordChar = wordStr.charAt(index);
            if (Character.isWhitespace(wordChar)) {
                if (wordBuilder != null) {
                    wordList.add(wordBuilder);
                    wordBuilder = null;
                }

                continue;
            }

            if (wordBuilder == null) {
                wordBuilder = String.valueOf(wordChar);
            } else {
                wordBuilder += String.valueOf(wordChar);
            }

            if (index == strLen - 1) {
                wordList.add(wordBuilder);
            }

        }

        return wordList;

    }
}
