package com.bin.algorithm.leetcode.stack;


import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 队列实现栈
 * */
public class MyStack {
    private Queue<Integer> pushQueue;
    private Queue<Integer> popQueue;

    /** Initialize your data structure here. */
    public MyStack() {
        pushQueue = new LinkedList<>();
        popQueue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        pushQueue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (empty()) {
            return -1;
        }

        int pushSize = pushQueue.size();
        for (int popIndex = 0; popIndex < pushSize - 1; popIndex++) {
            popQueue.add(pushQueue.remove());
        }

        Integer top = pushQueue.remove();
        switchQueue();
        return top;
    }

    private void switchQueue() {
        Queue<Integer> temp = pushQueue;
        pushQueue = popQueue;
        popQueue = temp;
    }

    /** Get the top element. */
    public int top() {
        if (empty()) {
            return -1;
        }

        int pushSize = pushQueue.size();
        int top = -1;
        for (int popIndex = 0; popIndex < pushSize; popIndex++) {
            Integer pop = pushQueue.remove();
            popQueue.add(pop);
            if (popIndex == pushSize - 1) {
                top = pop;
            }
        }

        switchQueue();
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return pushQueue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack test = new MyStack();
        System.out.println(test.empty());
        System.out.println(test.pop());
        System.out.println(test.top());
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        System.out.println(test.empty());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println("top:"+test.top());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.empty());



    }
}
