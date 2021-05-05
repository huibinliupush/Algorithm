package com.bin.algorithm.leetcode.binarysearch;

public class GuessGame {

    public int guessNumber(int n) {
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int flag = guess(mid);
            if (flag == 0) {
                return mid;
            } else if (flag < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;

    }

    private int guess(int num) {
        int pick = 6;
        if (num < pick) {
            return -1;
        }

        if (num > pick) {
            return 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        GuessGame test = new GuessGame();
        System.out.println(test.guessNumber(10));
    }
}
