package com.bin.algorithm.leetcode.hash;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class MyHashMap {

    private ArrayList<LinkedList<HashItem>> array;

    private int capactiy;

    private int mask;

    private int load;

    private double maxLoadFactor = 0.7;

    /** Initialize your data structure here. */
    public MyHashMap() {
        capactiy = 16;
        mask = capactiy - 1;
        load = 0;
        array = new ArrayList<>(capactiy);
        for (int i = 0; i < capactiy; i++) {
            array.add(new LinkedList<HashItem>());
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        load++;
        double loadFactor = (double) load / capactiy;
        if (loadFactor >= maxLoadFactor) {
            capactiy = capactiy << 1;
            mask = capactiy - 1;

            ArrayList<LinkedList<HashItem>> waitExpansion = new ArrayList<>(capactiy);
            for (int i = 0; i < capactiy; i++) {
                waitExpansion.add(new LinkedList<HashItem>());
            }

            for (LinkedList<HashItem> list : array) {
                list.forEach(hashItem->{
                    int index = hashItem.getKey() & mask;
                    LinkedList expansList = waitExpansion.get(index);
                    if (expansList == null) {
                        expansList = new LinkedList();
                        waitExpansion.set(index, expansList);
                    }
                    expansList.add(hashItem);
                });

            }

            array = waitExpansion;

        }

        int index = key & mask;
        LinkedList<HashItem> list = array.get(index);
        if (list == null) {
            list = new LinkedList<HashItem>();
            array.set(index, list);
        }

        for (HashItem item : list) {
            if (item.getKey() == key) {
                item.setValue(value);
                return;
            }
        }

        HashItem item = new HashItem(key, value);
        list.add(item);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key & mask;
        LinkedList<HashItem> list = array.get(index);
        if (list == null) {
            return -1;
        }

        for (HashItem item : list) {
            if (item.key == key) {
                return item.value;
            }
        }

        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key & mask;
        LinkedList<HashItem> list = array.get(index);
        if (list == null) {
            return;
        }


        Iterator<HashItem> iterator = list.iterator();
        while (iterator.hasNext()) {
            HashItem item = iterator.next();
            if (item.getKey() == key) {
                iterator.remove();
                return;
            }
        }

    }

    private static class HashItem {
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

        public HashItem(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    public static void main(String[] args) {
        MyHashMap test = new MyHashMap();
        test.put(1,1);
        System.out.println(test.get(1));
        test.put(1,2);
        System.out.println(test.get(1));
        test.put(1,3);
        System.out.println(test.get(1));

        test.put(2,2);
        System.out.println(test.get(2));
        test.put(3,3);
        System.out.println(test.get(3));

        test.remove(4);
        test.remove(3);
        System.out.println(test.get(3));

        System.out.println("-------扩容---------");

        for (int index = 7; index < 60; index++) {
            test.put(index,index);
        }


        System.out.println(test.get(1));

        System.out.println(test.get(2));
        System.out.println(test.get(3));

        test.remove(4);
        test.remove(3);
        System.out.println(test.get(3));

    }
}
