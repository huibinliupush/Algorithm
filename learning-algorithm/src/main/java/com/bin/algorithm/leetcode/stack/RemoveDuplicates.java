package com.bin.algorithm.leetcode.stack;

import java.util.Stack;

public class RemoveDuplicates {

    public String removeDuplicates(String S) {
        if (S == null || S.length() < 2) {
            return S;
        }

        Stack<Character> notDuplicateStr = new Stack<Character>();
        char[] chars = S.toCharArray();

        for (int index = 0; index < chars.length; index++) {
            char strChar = chars[index];
            if (notDuplicateStr.isEmpty()) {
                notDuplicateStr.push(strChar);
                continue;
            }

            if (strChar == notDuplicateStr.peek()) {
                notDuplicateStr.pop();
            } else {
                notDuplicateStr.push(strChar);
            }
        }

        return getResult(notDuplicateStr);
    }

    private String getResult(Stack<Character> notDuplicateStr) {
        Stack<Character> resultStack = new Stack<Character>();
        StringBuilder resultBuilder = new StringBuilder();

        while (!notDuplicateStr.isEmpty()) {
            resultStack.push(notDuplicateStr.pop());
        }

        while (!resultStack.isEmpty()) {
            resultBuilder.append(resultStack.pop());
        }

        return resultBuilder.toString();
    }



    public static void main(String[] args) {
        RemoveDuplicates test = new RemoveDuplicates();
        System.out.println(test.removeDuplicates("abbaca"));
    }
}
