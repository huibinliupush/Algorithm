package com.bin.algorithm.leetcode.stack;

import java.util.Stack;

public class SortedStack {
    private Stack<Integer> stack;
    private Stack<Integer> tempStack;

    public SortedStack() {
        stack = new Stack<>();
        tempStack = new Stack<>();
    }

    public void push(int val) {
        while (!stack.isEmpty() && stack.peek() < val) {
            tempStack.push(stack.pop());
        }

        stack.push(val);

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

    }

    public void pop() {
        if (isEmpty()) {
            return;
        }

        stack.pop();
    }

    public int peek() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        SortedStack test = new SortedStack();


        test.pop();
        test.pop();
        test.push(8);
        test.pop();
        test.isEmpty();



        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);

        System.out.println(test.peek());
        test.pop();

        System.out.println(test.peek());
        test.pop();

        System.out.println(test.peek());
        test.pop();

        System.out.println(test.peek());
        test.pop();

        System.out.println(test.peek());
        test.pop();
    }
}
