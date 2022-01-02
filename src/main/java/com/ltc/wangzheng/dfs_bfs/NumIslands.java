package com.ltc.wangzheng.dfs_bfs;

/**
 * @author rwj
 * @create_time 2021/12/28
 * @description https://leetcode-cn.com/problems/number-of-islands/comments/
 * <p>
 * 思路： 遍历岛这个二维数组，如果当前数为1，则进入感染函数并将岛个数+1
 * 感染函数：其实就是一个递归标注的过程，它会将所有相连的1都标注成2。
 * 为什么要标注？这样就避免了遍历过程中的重复计数的情况，
 * 一个岛所有的1都变成了特殊值后，遍历的时候就不会重复遍历了。
 */
public class NumIslands {
    /*public int numIslands(char[][] grid) {
        int num = 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        for(int i = 0; i < rowLen; ++i) {
            for(int j = 0; j < colLen; ++j) {
                if(grid[i][j] == '1') {
                    bs(grid, i, j);
                    ++num;
                }
            }
        }
        return num;
    }*/

    static int num;
    public static int numIslands(char[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        dfs(grid, 0, rowLen, colLen);
        return num;
    }

    /** dfs实现两层for循环； 也可以用bfs（row不变，递归col） */
    public static void dfs(char[][] grid, int col, int rowLen, int colLen) {
        if(col >= colLen) return;
        for(int row = 0; row < rowLen; ++row) {
            if(grid[row][col] == '1') {
                ++num;
                bs(grid, row, col, rowLen, colLen);
            }
        }
        dfs(grid, col+1, rowLen, colLen);
    }

    public static void bs(char[][] grid, int row, int col, int rowLen, int colLen) {
        if (row < 0 || col < 0 || row >= rowLen || col >= colLen || grid[row][col] != '1') return;
        grid[row][col] = '3';
        bs(grid, row + 1, col, rowLen, colLen);
        bs(grid, row - 1, col, rowLen, colLen);
        bs(grid, row, col + 1, rowLen, colLen);
        bs(grid, row, col - 1, rowLen, colLen);
    }

    public static void main(String[] args) {
        char[][] chs = new char[10][10];
        chs[0] = new char[]{'1','1','1','1','1','0','1','1','1','1'};
        chs[1] = new char[]{'1','0','1','0','1','1','1','1','1','1'};
        chs[2] = new char[]{'0','1','1','1','0','1','1','1','1','1'};
        chs[3] = new char[]{'1','1','0','1','1','0','0','0','0','1'};
        chs[4] = new char[]{'1','0','1','0','1','0','0','1','0','1'};
        chs[5] = new char[]{'1','0','0','1','1','1','0','1','0','0'};
        chs[6] = new char[]{'0','0','1','0','0','1','1','1','1','0'};
        chs[7] = new char[]{'1','0','1','1','1','0','0','1','1','1'};
        chs[8] = new char[]{'1','1','1','1','1','1','1','1','0','1'};
        chs[9] = new char[]{'1','0','1','1','1','1','1','1','1','0'};
        System.out.println(numIslands(chs));
    }
}
