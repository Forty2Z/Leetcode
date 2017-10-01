package com.forty2leetcode.oct1;

/*
* Leetcode 5: Longest Palindromic Sbustring
* Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
*解法： DP， 建立2维boolean数组，代表从i to j的substring是否为palindromic
* 判断条件是s.charAt(i) 和s.charAt(j)是否相等以及dp[j+1][i-1]是否为true或者i,j相距小于等于2
*
*
*
*
*
* */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        dp[0][0] = true;
        int max = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (max < (i - j + 1)) {
                        max = i - j + 1;
                        start = j;
                        end = i;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
