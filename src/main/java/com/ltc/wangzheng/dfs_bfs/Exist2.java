package com.ltc.wangzheng.dfs_bfs;

/**
 * @author rwj
 * @create_time 2021/12/31
 * @description https://leetcode-cn.com/problems/word-search/
 */
public class Exist2 {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[0].length; ++j) {
                if(dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int row, int col, int wStart) {
        if(wStart == word.length()) return true;
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) return false;
        if(board[row][col] != word.charAt(wStart) || board[row][col] == '\0') return false;

        board[row][col] = '\0';
        boolean res = dfs(board, word, row-1, col, wStart+1)
                || dfs(board, word, row+1, col, wStart+1)
                || dfs(board, word, row, col-1, wStart+1)
                || dfs(board, word, row, col+1, wStart+1);
        board[row][col] = word.charAt(wStart);

        return res;
    }
}
