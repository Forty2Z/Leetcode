package com.forty2leetcode.sep30;

/*
* Leetcode 79： Word Search
*Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
The same letter cell may not be used more than once.
*解法： 类似leetcdoe 200 Numbers of Island
* DFS, 找上下左右有没有可以通的路径， 由于不能回头（访问一个点多次）在recursion的时候暂时把值改为'0'，recursion完了再改回去
* 判断条件是outbounds and char 不对应相等
*
* */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (helper(board, i, j, wordArray, 0)) return true;
            }
        }
        return false;

    }

    private boolean helper(char[][] board, int i, int j, char[] wordArray, int index) {
        if (i >= board.length || i < 0 || j >= (board[i].length) || j < 0 || board[i][j] != wordArray[index]) {
            return false;
        }
        if (index == (wordArray.length - 1)) return true;
        char cur = board[i][j];
        board[i][j] = '0';

        boolean found = helper(board, i + 1, j, wordArray, index + 1)
                || helper(board, i - 1, j, wordArray, index + 1)
                || helper(board, i, j + 1, wordArray, index + 1)
                || helper(board, i, j - 1, wordArray, index + 1);
        board[i][j] = cur;
        return found;

    }
}
