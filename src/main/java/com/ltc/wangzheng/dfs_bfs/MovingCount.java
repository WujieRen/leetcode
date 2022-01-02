package com.ltc.wangzheng.dfs_bfs;

/**
 * @author rwj
 * @create_time 2021/12/28
 * @description https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
public class MovingCount {
    int cnt = 0;
    public int movingCount(int m, int n, int k) {
        boolean[][] board = new boolean[m][n];
        dfs(board, 0, 0, k);
        return cnt;
    }
    public void dfs(boolean[][] board, int row, int col, int k) {
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col]) return;
        int sum = row/10 + row%10 + col/10 + col%10;
        if(sum > k) return;
        board[row][col] = true;
        ++cnt;
        dfs(board, row+1, col, k);
        dfs(board, row, col+1, k);
        //TODO:以下两行是看了别人的答案后发现可以优化的地方；因为是从(0,0)开始，只能往大方向走
//        dfs(board, row-1, col, k);
//        dfs(board, row, col-1, k);
    }

    /** 写法② */
    public int dfs2(boolean[][] board, int row, int col, int k) {
        if(row < 0 || col < 0 || row >= board.length
                || col >= board[0].length || board[row][col]
                || row/10 + row%10 + col/10 + col%10 > k) return 0;
        board[row][col] = true;
        return dfs2(board, row+1, col, k) + dfs2(board, row, col+1, k) + 1;
    }
}
