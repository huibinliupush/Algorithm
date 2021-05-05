package com.bin.algorithm.leetcode.stack;

import java.util.Stack;

public class Calculate {


    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> numStack = new Stack<>();
        //存放先要计算的运算法  也就是优先级高的运算符
        Stack<Character> opsStack = new Stack<>();

        char[] chars = s.toCharArray();

        Integer calculateNum = null;

        for (int index = 0; index < chars.length; index++) {
            char calcuate = chars[index];
            if (isDigit(calcuate)) {
                calculateNum = calculateNum == null ? 0 : calculateNum;
                calculateNum = calculateNum * 10 + (calcuate - '0');
            }

            if (isOps(calcuate)) {
                numStack.push(calculateNum);
                calculateNum = null;
                if (opsStack.isEmpty()) {
                    opsStack.push(calcuate);
                } else {
                    while (!priority(calcuate, opsStack)) {
                        caculate(numStack, opsStack);
                    }

                    opsStack.push(calcuate);
                }
            }
        }

        if (calculateNum != null) {
            numStack.push(calculateNum);
        }

        while (!opsStack.isEmpty()) {
            caculate(numStack, opsStack);
        }
        return numStack.pop();

    }

    private void caculate(Stack<Integer> numStack, Stack<Character> opsStack) {
        int number2 = numStack.pop();
        int number1 = numStack.pop();
        char ops = opsStack.pop();
        Integer result = caculate(number1, number2, ops);
        numStack.push(result);
    }
    private int caculate(int number1, int number2, char ops) {
        if ('+' == ops) {
            return number1 + number2;
        }

        if ('-' == ops) {
            return number1 - number2;
        }

        if ('*' == ops) {
            return number1 * number2;
        }

        if ('/' == ops) {
            return number1 / number2;
        }

        return 0;
    }

    /**
     * ops是否比栈顶优先级大
     */
    private boolean priority(Character ops, Stack<Character> opsStack) {
        if (opsStack.isEmpty()) {
            return true;
        }

        char opsTop = opsStack.peek();
        if ((ops == '*' || ops == '/') && (opsTop == '+' || opsTop == '-')) {
            return true;
        } else {
            return false;
        }
    }


    private boolean isDigit(Character character) {
        if (character >= '0' && character <= '9') {
            return true;
        } else {
            return false;
        }
    }

    private boolean isOps(Character character) {
        if (character == '+' || character == '-'
                || character == '*' || character == '/') {

            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Calculate test = new Calculate();

        System.out.println(test.calculate("3+2*2"));
        System.out.println(test.calculate("42+2"));

        System.out.println(test.calculate("1*2-3/4+5*6-7*8+9/10"));
    }
}
