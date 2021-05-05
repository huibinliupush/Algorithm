package com.bin.algorithm.leetcode.stack;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * */
public class CQueue {

    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public CQueue() {
        inputStack = new Stack<Integer>();
        outputStack = new Stack<Integer>();
    }

    public void appendTail(int value) {
        inputStack.push(value);
    }

    public int deleteHead() {
        if (outputStack.isEmpty() && inputStack.isEmpty()) {
            return -1;
        }

        if (outputStack.isEmpty()) {

            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }

        return outputStack.pop();

    }


    public static void main(String[] args) {
        CQueue test = new CQueue();
        System.out.println(test.deleteHead());

        test.appendTail(1);
        test.appendTail(2);
        test.appendTail(3);
        test.appendTail(4);

        System.out.println(test.deleteHead());
        System.out.println(test.deleteHead());
        System.out.println(test.deleteHead());
        System.out.println(test.deleteHead());
        System.out.println(test.deleteHead());
    }

}
