package com.bin.algorithm.leetcode.hash;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache {

    private Deque<CacheItem> deque;

    private int capacity;

    public LRUCache(int capacity) {
        if (capacity < 1) {
            this.capacity = 1;
        }
        this.capacity = capacity;
        deque = new LinkedList<CacheItem>();
    }

    public int get(int key) {
        Iterator<CacheItem> iterator = deque.iterator();
        CacheItem result = null;
        while (iterator.hasNext()) {
            CacheItem cache = iterator.next();
            if (cache.getKey() == key) {
                result = cache;
                iterator.remove();
                break;
            }
        }

        if (result == null) {
            return -1;
        }

        deque.addLast(result);
        return result.getValue();
    }

    public void put(int key, int value) {
        Iterator<CacheItem> iterator = deque.iterator();
        CacheItem result = null;
        while (iterator.hasNext()) {
            CacheItem cache = iterator.next();
            if (cache.getKey() == key) {
                result = cache;
                iterator.remove();
                break;
            }
        }

        if (result == null && capacity == deque.size()) {
            deque.pollFirst();
        }

        CacheItem cache = new CacheItem(key, value);
        deque.addLast(cache);
    }

    private static class CacheItem {
        private int key;
        private int value;

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public CacheItem(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {

    }
}
