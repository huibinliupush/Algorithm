package com.bin.algorithm.leetcode.hash;

import java.util.*;

public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1 == null) {
            return arr1;
        }

        HashMap<Integer, Integer> cache = new HashMap<>();

        if (arr2 != null) {
            for (int i = 0; i < arr2.length; i++) {
                cache.put(arr2[i], i);
            }
        }

        List<Integer> arr1List = new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {
            arr1List.add(arr1[i]);
        }

        /**
         * cache存储arr2的元素 和 对应的下标
         *
         * 如果arr1中的两个比较元素 均在 cache中 -》 比较下标
         *  均不在cache中 -》 比较本身
         *
         *  剩下情况 在cache中的数小 (题目要求 未在arr2出现过的元素按照升序放在末尾)
         *
         * */
        Collections.sort(arr1List, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer cache1 = cache.get(o1);
                Integer cache2 = cache.get(o2);
                if (cache1 == null && cache2 == null) {
                    return o1 - o2;
                } else if (cache1 != null && cache2 != null) {
                    return cache1 - cache2;
                } else {
                    if (cache1 == null) {
                        return 1;
                    }

                    if (cache2 == null) {
                        return -1;
                    }
                }

                return 0;
            }
        });

        int[] result = new int[arr1List.size()];
        int index = 0;
        for (Integer num : arr1List) {
            result[index++] = num;
        }

        return result;
    }

    public static void main(String[] args) {
        RelativeSortArray test = new RelativeSortArray();

        int[] result = test.relativeSortArray(new int[]{
                2,3,1,3,2,4,6,7,9,2,19
        }, new int[]{
                2,1,4,3,9,7
        });

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
