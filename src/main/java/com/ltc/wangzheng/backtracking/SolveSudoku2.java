package com.ltc.wangzheng.backtracking;

/**
 * @author rwj
 * @create_time 2021/12/25
 * @description
 *
 * 第二种写法
 */
public class SolveSudoku2 {
    boolean[][] row = new boolean[9][10]; //标记x行存在的数字
    boolean[][] col = new boolean[9][10]; //标记y列存在的数字
    boolean[][][] block = new boolean[3][3][10]; //标记z块存在的数字
    boolean flag = true; //为false时表示当前填充出现问题
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) { //先标记好初始化存在过的数字
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '0';
                row[i][num] = true;
                col[j][num] = true;
                block[i / 3][j / 3][num] = true;
            }
        }
        dfs(board, 0, 0);
    }
    void dfs(char[][] board, int x, int y) {
        if (y >= 9) { //填充完当前行的所有列
            if (x + 1 <= 8) { //还没填充到最后一行
                dfs(board, x + 1, 0);
            } else { //已经填充完所有行和列
                flag = true;
            }
            return;
        }
        if (board[x][y] == '.') { //需要填充
            for (int num = 1; num <= 9; num++) { //尝试填充列表1~9
                if (row[x][num] || col[y][num] || block[x / 3][y / 3][num]) continue; //num被使用过
                board[x][y] = (char)('0' + num);
                row[x][num] = col[y][num] = block[x / 3][y / 3][num] = true;
                dfs(board, x, y + 1);
                if (flag) return; //填充完毕，直接返回
                row[x][num] = col[y][num] = block[x / 3][y / 3][num] = false;
                board[x][y] = '.';
            }
            flag = false; //出现问题，9个数字都不能正确填充，标记flag为false
        } else { //不需填充
            dfs(board, x, y + 1);
        }
    }
}
