package com.bin.algorithm.leetcode.hash;

import java.util.Arrays;
import java.util.HashMap;

public class WordsFrequency {

    private HashMap<String, Integer> cache = new HashMap<>();

    public WordsFrequency(String[] book) {
        if (book == null) {
            return;
        }

        Arrays.stream(book).forEach(word->{
            if (cache.containsKey(word)) {
                int frequence = cache.get(word);
                cache.put(word, ++frequence);
            } else {
                cache.put(word, 1);
            }
        });
    }

    public int get(String word) {
        return cache.containsKey(word) ? cache.get(word) : 0;
    }

    public static void main(String[] args) {
        WordsFrequency wordsFrequency = new WordsFrequency(new String[]{"i", "have", "an", "apple", "he", "have", "a", "pen"});


        System.out.println(wordsFrequency.get("you"));
        System.out.println(wordsFrequency.get("have"));
        System.out.println(wordsFrequency.get("an"));
        System.out.println(wordsFrequency.get("apple"));
        System.out.println(wordsFrequency.get("pen"));
    }
}
