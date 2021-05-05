package com.bin.algorithm.leetcode;

public class DefangIPaddr {


    public String defangIPaddr(String address) {
        StringBuilder defangIpBuilder = new StringBuilder();
        int addressLen = address.length();
        for (int index = 0; index < addressLen; index++) {
            char addressChar = address.charAt(index);
            if ('.' == addressChar) {
                defangIpBuilder.append("[.]");
            } else {
                defangIpBuilder.append(addressChar);
            }

        }

        return defangIpBuilder.toString();
    }

    public static void main(String[] args) {
        DefangIPaddr test = new DefangIPaddr();
        System.out.println(test.defangIPaddr("1.1.1.1"));
        System.out.println(test.defangIPaddr("255.100.50.0"));
    }
}
