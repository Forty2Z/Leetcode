package com.forty2leetcode.oct1;

/*
* Leetcode 62: Unique Path
*A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time.
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
*
*解法： 二维DP, 代表走到i,j有多少不同的路径，因为只能向下和向右，所有当i==0或者j==0有只有一条路径（边界条件）
* dp[i][j] = dp[i-1][j] + dp[i][j-1]
*
*
* */
public class UniquePath {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
