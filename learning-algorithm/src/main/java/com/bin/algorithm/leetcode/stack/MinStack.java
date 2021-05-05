package com.bin.algorithm.leetcode.stack;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> sortedStack;
    private Stack<Integer> sortedTempStack;

    public MinStack() {
        stack = new Stack<>();
        sortedStack = new Stack<>();
        sortedTempStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        while (!sortedStack.isEmpty() && sortedStack.peek() < val) {
            sortedTempStack.push(sortedStack.pop());
        }

        sortedStack.push(val);

        while (!sortedTempStack.isEmpty()) {
            sortedStack.push(sortedTempStack.pop());
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }

        int top = stack.pop();

        while (!sortedStack.isEmpty() && top > sortedStack.peek()) {
            sortedTempStack.push(sortedStack.pop());
        }

        if (!sortedStack.isEmpty()) {
            sortedStack.pop();
        }

        while (!sortedTempStack.isEmpty()) {
            sortedStack.push(sortedTempStack.pop());
        }

        return;
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }

        return stack.peek();
    }

    public int getMin() {
        return sortedStack.isEmpty() ? -1 : sortedStack.peek();
    }

    public static void main(String[] args) {
        MinStack test = new MinStack();
        test.push(-2);
        test.push(0);
        test.push(-3);

        System.out.println(test.getMin());
        test.pop();
        System.out.println(test.top());
        System.out.println(test.getMin());

    }
}
