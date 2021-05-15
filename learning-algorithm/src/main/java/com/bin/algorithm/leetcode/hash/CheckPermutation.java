package com.bin.algorithm.leetcode.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CheckPermutation {

    public boolean CheckPermutation(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }

        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();

        int s1Len = s1Chars.length;
        int s2len = s2Chars.length;

        if (s1Len != s2len) {
            return false;
        }

        HashMap<Character, Integer> s1Cache = new HashMap<>();
        HashMap<Character, Integer> s2Cache = new HashMap<>();
        for (int i = 0; i < s1Len; i++) {
            Character c = s1Chars[i];
            if (!s1Cache.containsKey(c)) {
                s1Cache.put(c, 1);
            } else {
                int frequence = s1Cache.get(c);
                s1Cache.put(c, ++frequence);
            }
        }

        for (int i = 0; i < s2len; i++) {
            Character c = s2Chars[i];
            if (!s2Cache.containsKey(c)) {
                s2Cache.put(c, 1);
            } else {
                int frequence = s2Cache.get(c);
                s2Cache.put(c, ++frequence);
            }
        }

        if (s1Cache.size() != s2Cache.size()) {
            return false;
        }

        for (Map.Entry<Character, Integer> entry : s1Cache.entrySet()) {
            if (!s2Cache.containsKey(entry.getKey())) {
                return false;
            }

            if (entry.getValue() != s2Cache.get(entry.getKey())) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
