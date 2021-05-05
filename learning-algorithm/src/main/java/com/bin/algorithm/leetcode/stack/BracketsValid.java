package com.bin.algorithm.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 检测括号的有效性
 *
 * 遇到左括号就压栈
 * 遇到右括号就出栈 比较栈顶括号是否匹配
 * */
public class BracketsValid {

    private Map<Character,Character> bracketsMap = new HashMap<Character,Character>(){
        {
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }
    };

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }


        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int index = 0; index < chars.length; index++) {
            char bracket = chars[index];
            if (stack.isEmpty()) {
                if (bracketsMap.containsKey(bracket)) {
                    return false;
                }
                stack.push(bracket);
            } else {
                if (bracketsMap.containsKey(bracket)) {
                    char waitToMatchBracket = stack.pop();
                    if (bracketsMap.get(bracket) == waitToMatchBracket) {
                        continue;
                    } else {
                        return false;
                    }

                } else {
                    stack.push(bracket);
                }
            }
        }

        return stack.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        BracketsValid test = new BracketsValid();
        System.out.println(test.isValid(""));
        System.out.println(test.isValid("]"));
        System.out.println(test.isValid("}[]"));
        System.out.println(test.isValid("[]"));
        System.out.println(test.isValid("{}"));
        System.out.println(test.isValid("([])"));
    }
}
