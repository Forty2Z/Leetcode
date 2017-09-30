package com.forty2leetcode.sep23;
/*
* Leetcode 200: Number of Islands
*
*Given a 2d grid map of '1's (land) and '0's (water),
* count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
* You may assume all four edges of the grid are all surrounded by water.
*
*解法： DFS
*遍历每个点，每次遇到1陆地时，先标为'0'然后看上下左右是否为陆地，遇到边界或者outbound return
*
* */

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    helper(grid, i, j);

                }
            }
        }
        return res;
    }

    private void helper(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        helper(grid, i + 1, j);
        helper(grid, i - 1, j);
        helper(grid, i, j + 1);
        helper(grid, i, j - 1);

        return;
    }
}
