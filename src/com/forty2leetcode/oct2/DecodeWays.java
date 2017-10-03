package com.forty2leetcode.oct2;

/*
* Leetcode 91: Decode Ways
*Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*解法： DP，注意corner case string 长度为0或者null返回0；Integer.valueOf的用法
* substring(i-1, i)判断倒数1个字符是否不为0
* substring（i - 2, i) 判断倒数两个字符是否在10 to 26之间
*
*
*
* */
public class DecodeWays {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= s.length(); i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first != 0) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
