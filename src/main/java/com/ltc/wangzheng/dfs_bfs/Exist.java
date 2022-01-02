package com.ltc.wangzheng.dfs_bfs;

/**
 * @author rwj
 * @create_time 2021/12/30
 * @description https://leetcode-cn.com/problems/word-search/
 */
public class Exist {
    static int cnt;
    static boolean flag;
    public static boolean exist(char[][] board, String word) {
        int rowLen = board.length;
        int colLen = board[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];
        for(int i = 0; i < rowLen; ++i) {
            for(int j = 0; j < colLen; ++j) {
                cnt = 0;
                if(board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0, rowLen, colLen, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean dfs(char[][] board, String word, int row, int col, int wStart, int rowLen, int colLen, boolean[][] visited) {
        if(cnt == word.length() || wStart == word.length() || flag) {
            flag = true;
            return true;
        }
        if(row < 0 || col < 0 || row >= rowLen || col >= colLen) return false;
        if(board[row][col] != word.charAt(wStart) || visited[row][col] || cnt >= rowLen*colLen) return false;
        cnt++;
        wStart++;
        visited[row][col] = true;
        boolean left = dfs(board, word, row-1, col, wStart, rowLen, colLen, visited);
        boolean right = dfs(board, word, row+1, col, wStart, rowLen, colLen, visited);
        boolean down = dfs(board, word, row, col-1, wStart, rowLen, colLen, visited);
        boolean up = dfs(board, word, row, col+1, wStart, rowLen, colLen, visited);
        cnt--;  //TODO: 提交了9次才通过；因为cnt有时 >= 结果是对的；有时 > 结果是对的，
                //      花了两个小时来寻找和测试cnt的边界，结果白费；因为找不到合适的边界;
                //      最后仔细想 cnt 在程序中的定位和作用；发现我一开始定位的时候其实就是指递归深入了第几次；
                //      一下想到在归的过程中，没有将 cnt 恢复现场，导致cnt的值一直是在++ ；已经偏离了它的定义；
                //      遂增加 cnt-- ，一试，通过
        visited[row][col] = false;
        return left || right || down || up;
    }

    public static void main(String[] args) {
        char[][] board = new char[3][];
//        board[0] = new char[]{'A','B','C','E'};
//        board[1] = new char[]{'S','F','C','S'};
//        board[2] = new char[]{'A','D','E','E'};
        board[0] = new char[]{'a','a','a','a'};
        board[1] = new char[]{'a','a','a','a'};
        board[2] = new char[]{'a','a','a','a'};
        System.out.println(exist(board, "aaaaaaaaaaab"));
    }
}
