package com.bin.algorithm.leetcode.stack;

import java.util.ArrayList;

/**
 * 一个数组实现三个栈
 * */
public class TripleInOne {

    private ArrayList<Integer> arrayList;

    private Integer stack1TopIndex = 0;
    private Integer stack2TopIndex = 1;
    private Integer stack3TopIndex = 2;

    public TripleInOne(int stackSize) {
        if (stackSize < 0) {
            arrayList = new ArrayList<>(0);
        }

        int size = stackSize * 3;
        arrayList = new ArrayList<>(size);

        for (int index = 0; index < size; index++) {
            arrayList.add(-1);
        }
    }

    public void push(int stackNum, int value) {
        if (isFull(stackNum)) {
            return;
        }

        if (stackNum == 0) {
            arrayList.set(stack1TopIndex, value);
            stack1TopIndex += 3;
        }

        if (stackNum == 1) {
            arrayList.set(stack2TopIndex, value);
            stack2TopIndex += 3;
        }

        if (stackNum == 2) {
            arrayList.set(stack3TopIndex, value);
            stack3TopIndex += 3;
        }

    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            return -1;
        }

        int top = -1;

        if (stackNum == 0) {
            stack1TopIndex -= 3;
            top = arrayList.get(stack1TopIndex);
            arrayList.set(stack1TopIndex, -1);

        }

        if (stackNum == 1) {
            stack2TopIndex -= 3;
            top = arrayList.get(stack2TopIndex);
            arrayList.set(stack2TopIndex, -1);
        }

        if (stackNum == 2) {
            stack3TopIndex -= 3;
            top = arrayList.get(stack3TopIndex);
            arrayList.set(stack3TopIndex, -1);
        }

        return top;
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            return -1;
        }

        int top = -1;

        if (stackNum == 0) {
            stack1TopIndex -= 3;
            top = arrayList.get(stack1TopIndex);
        }

        if (stackNum == 1) {
            stack2TopIndex -= 3;
            top = arrayList.get(stack2TopIndex);
        }

        if (stackNum == 2) {
            stack3TopIndex -= 3;
            top = arrayList.get(stack3TopIndex);
        }

        return top;
    }

    private boolean isFull(int stackNum) {
        if (arrayList.isEmpty()) {
            return true;
        }

        if (stackNum < 0 || stackNum > 2) {
            return true;
        }

        if (isEmpty(stackNum)) {
            return false;
        }

        int size = arrayList.size();
        return arrayList.get(size - 1 - (2 - stackNum)) >= 0;

    }

    public boolean isEmpty(int stackNum) {
        if (arrayList.isEmpty()) {
            return true;
        }

        if (stackNum < 0 || stackNum > 2) {
            return true;
        }

        if (arrayList.get(stackNum) < 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        TripleInOne test = new TripleInOne(18);
        System.out.println(test.peek(1));
        System.out.println(test.pop(2));
        System.out.println(test.isEmpty(1));
        test.push(2, 40);
        System.out.println(test.pop(2));
        test.push(0, 44);
        test.push(1, 40);
        System.out.println(test.pop(0));
        test.push(1, 54);
        test.push(0, 42);
        System.out.println(test.isEmpty(0));
        System.out.println(test.pop(1));
        System.out.println(test.peek(1));
        test.push(0, 56);
        System.out.println(test.peek(2));
        System.out.println(test.isEmpty(0));

        for (int i = 0; i < 50; i++) {
            test.push(0, i);
            test.push(1, i);
            test.push(2, i);
        }


        for (int i = 0; i < 55; i++) {
            test.pop(0);
            test.pop(1);
            test.pop(2);
        }
/*        test.push(0, 1);
        test.push(0, 2);
        test.push(0, 3);
        test.push(0, 4);

        test.push(1, 5);
        test.push(1, 6);
        test.push(1, 7);
        test.push(1, 8);

        test.push(2, 11);
        test.push(2, 12);
        test.push(2, 13);
        test.push(2, 14);

        System.out.println("---------栈1出栈-----------");
        System.out.println(test.pop(0));
        System.out.println(test.pop(0));
        System.out.println(test.pop(0));
        System.out.println(test.pop(0));
        System.out.println(test.peek(0));

        System.out.println("---------栈2出栈-----------");
        System.out.println(test.pop(1));
        System.out.println(test.pop(1));
        System.out.println(test.pop(1));
        System.out.println(test.pop(1));
        System.out.println(test.peek(1));


        System.out.println("---------栈3出栈-----------");
        System.out.println(test.pop(2));
        System.out.println(test.pop(2));
        System.out.println(test.pop(2));
        System.out.println(test.pop(2));
        System.out.println(test.peek(2));*/
    }
}
