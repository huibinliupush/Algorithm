package com.bin.algorithm.leetcode.binarysearch;

public class FindString {

    public int findString(String[] words, String s) {
        if (words == null) {
            return -1;
        }

        int low = 0;
        int high = words.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (words[mid].isEmpty()) {

                int index = mid + 1;
                while (index <= high) {
                    if (words[index].isEmpty()) {
                        index++;
                        continue;
                    }

                    if (words[index].compareTo(s) == 0) {
                        return index;
                    } else if (words[index].compareTo(s) > 0) {
                        high = mid - 1;
                        break;
                    } else {
                        low = mid + 1;
                        break;
                    }
                }


                if (index >= high) {
                    high = mid - 1;
                }

                continue;
            }

            if (words[mid].compareTo(s) == 0) {
                return mid;
            } else if (words[mid].compareTo(s) > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

       System.out.println();

    }
}
