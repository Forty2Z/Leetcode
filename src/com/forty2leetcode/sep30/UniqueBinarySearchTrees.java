package com.forty2leetcode.sep30;

/*
* Leetcode 96: Unique Binary Search tree
*Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
*
*解法：这道题非常有意思，因为是计算有多少种BST，选择用DP
* 对于dp[k] = number of different BST
* 把1 to k每个值拿出来当root，左子树比root都要小，右子树比root都要大，当前root值下，不同的组合数量为dp[level - root]*dp[root - 1]
* 然后再把root 从1 to k 的值累加起来就是dp[k]的值
* */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int level = 2; level <= n; level++) {
            for (int root = 1; root <= level; root++) {
                dp[level] += dp[level - root] * dp[root - 1];
            }
        }
        return dp[n];
    }
}
