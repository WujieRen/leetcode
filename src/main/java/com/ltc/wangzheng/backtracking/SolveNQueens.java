package com.ltc.wangzheng.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rwj
 * @create_time 2021/12/22
 * @description https://leetcode-cn.com/problems/eight-queens-lcci/
 */
public class SolveNQueens {
    List<List<String>> res = new ArrayList<>();
    List<String> list = new LinkedList<>();
    char[][] board;

    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        for (int i = 0; i < n; ++i) Arrays.fill(board[i], '.');
        backTrack(n, 0);
        return res;
    }

    public void backTrack(int n, int row) {
        if (row == n) {
            for(int i = 0; i < n; ++i) list.add(String.valueOf(board[i]));
            res.add(new ArrayList<>(list));
            list.clear();
            return;
        }

        for (int i = 0; i < n; ++i) {
            if (!valid(row, i, n)) continue;
            board[row][i] = 'Q';
            backTrack(n, row + 1);
            board[row][i] = '.';
        }
    }

    public boolean valid(int row, int col, int n) {
        //验证行           这个是可以不验证的
//        for (int i = 0; i < n; ++i) if (board[row][i] == 'Q') return false;
        //验证列
        for (int i = 0; i < row; ++i) if (board[i][col] == 'Q') return false;
        //验证左上对角线
        for (int i = row, j = col; i >= 0 && j >= 0; --i, --j) if (board[i][j] == 'Q') return false;
        //验证右上对角线
        for (int i = row, j = col; i >= 0 && j < n; --i, ++j) if (board[i][j] == 'Q') return false;
        //TODO: 当前的方式是相当于层不变，每次递归每列；就应该用以上判重
        //  如果是先深入列，再在列里遍历行；那就要用一下判重条件
        //验证左下对角线
//        for (int i = row, j = col; i >= 0 && j < n; ++i, --j) if (board[i][j] == 'Q') return false;
        return true;
    }
}
