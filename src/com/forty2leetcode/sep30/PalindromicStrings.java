package com.forty2leetcode.sep30;

/*
* Leetcode 647: Palindromic Strings
*Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
*
*
* 解法： O（n2) 暴力解法 不是很好
*
* */

public class PalindromicStrings {

    public int countSubstrings(String s) {
        char[] arr = s.toCharArray();
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res++;
            for (int j = 0; j < i; j++) {
                if (isPalindrome(arr, j, i)) {
                    res++;
                }
            }
        }
        return res;
    }

    boolean isPalindrome(char[] arr, int i, int j) {
        while (i <= j) {
            if (arr[i] != arr[j]) return false;
            i++;
            j--;
        }
        return true;
    }
}
