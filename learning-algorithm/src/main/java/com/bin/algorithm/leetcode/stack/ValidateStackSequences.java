package com.bin.algorithm.leetcode.stack;

import java.util.HashMap;
import java.util.Map;

public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        boolean pushEmpty = pushed == null || pushed.length == 0;
        boolean popEmpty = popped == null || popped.length == 0;

        if (pushEmpty && popEmpty) {
            return true;
        }

        if (pushEmpty && !popEmpty) {
            return false;
        }

        if (!pushEmpty && popEmpty) {
            return true;
        }
        Map<Integer, Integer> pushdIndex = new HashMap<>();

        for (int index = 0; index < pushed.length; index++) {
            pushdIndex.put(pushed[index], index);
        }

        int index = 1;
        int pop = popped[0];
        int pushIndex = pushdIndex.get(pop);
        int size = popped.length;

        int round = 1;
        while (index < size) {
            int nextPop = popped[index];
            int nextPushIndex = pushdIndex.get(nextPop);

            if (nextPushIndex != pushIndex - round && nextPushIndex != pushIndex + round) {
                return false;
            }

            if (index % 2 == 0) {
                round++;
            }

            index++;
        }

        return true;

    }


    public static void main(String[] args) {
        ValidateStackSequences test = new ValidateStackSequences();
        int[] pushd = {1, 2, 3, 4, 5};
        int[] popd = {4, 5, 3, 2, 1};

        System.out.println(test.validateStackSequences(pushd, popd));
    }
}
