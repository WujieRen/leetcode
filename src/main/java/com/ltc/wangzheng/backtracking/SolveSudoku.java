package com.ltc.wangzheng.backtracking;

/**
 * @author rwj
 * @create_time 2021/12/25
 * @description
 */
public class SolveSudoku {

    public static void solveSudoku(char[][] board) {
        backTrack(board);
    }
    public static boolean backTrack(char[][] board) {
        for(int row = 0; row < 9; ++row) {
            for (int col = 0; col < 9; ++col) {
                char curCh = board[row][col];
                if (curCh != '.') continue;
                for (char k = '1'; k <= '9'; ++k) {
                    if(!valid(board, row, col, k)) continue;
                    board[row][col] = k;
                    if(backTrack(board)) return true;
                    board[row][col] = '.';
                }
                return false;
            }
        }
        return true;
    }

    public static boolean valid(char[][] board, int row, int col, char k) {
        //验证行
        for(int i = 0; i < 9; ++i) if(i != col && board[row][i] == k) return false;
        //验证列
        for(int i = 0; i < 9; ++i) if(i != row && board[i][col] == k) return false;
        //验证小九宫格
        int startRow = (row/3)*3;
        int startCol = (col/3)*3;
        for(int i = startRow; i < startRow+3; ++i) {
            for(int j = startCol; j < startCol+3; ++j) {
                if(board[i][j] == k) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[9][9];
        board[0] = new char[]{'5','3','.','.','7','.','.','.','.'};
        board[1] = new char[]{'6','.','.','1','9','5','.','.','.'};
        board[2] = new char[]{'.','9','8','.','.','.','.','6','.'};
        board[3] = new char[]{'8','.','.','.','6','.','.','.','3'};
        board[4] = new char[]{'4','.','.','8','.','3','.','.','1'};
        board[5] = new char[]{'7','.','.','.','2','.','.','.','6'};
        board[6] = new char[]{'.','6','.','.','.','.','2','8','.'};
        board[7] = new char[]{'.','.','.','4','1','9','.','.','5'};
        board[8] = new char[]{'.','.','.','.','8','.','.','7','9'};
        solveSudoku(board);
    }
}
