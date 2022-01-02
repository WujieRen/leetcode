package com.ltc.wangzheng.dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rwj
 * @create_time 2021/12/29
 * @description https://leetcode-cn.com/problems/pond-sizes-lcci/submissions/
 */
public class PondSizes {
    public int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<Integer>();
        int rowLen = land.length;
        int colLen = land[0].length;
        for (int i = 0; i < rowLen; ++i) {
            for (int j = 0; j < colLen; ++j) {
                if(land[i][j] == 0) {
                    list.add(bs(land, i, j, rowLen, colLen));
                }
            }
        }
        /*list.sort(Comparator.comparingInt(o -> o));
        return list.stream().mapToInt(value -> value).toArray();*/
        //TODO; 下面这种方式比上面要快一倍
        int[] resArray=new int[list.size()];
        for(int i=0;i<list.size();i++){
            resArray[i]=list.get(i);
        }
        Arrays.sort(resArray);
        return resArray;
    }

    public int bs(int[][] land, int row, int col, int rowLen, int colLen) {
        if (row < 0 || col < 0 || row >= rowLen || col >= colLen || land[row][col] != -1) return 0;
        land[row][col] = -1;
        return bs(land, row + 1, col, rowLen, colLen) +
                bs(land, row - 1, col, rowLen, colLen) +
                bs(land, row, col + 1, rowLen, colLen) +
                bs(land, row, col - 1, rowLen, colLen) +
                bs(land, row - 1, col - 1, rowLen, colLen) +
                bs(land, row - 1, col + 1, rowLen, colLen) +
                bs(land, row + 1, col - 1, rowLen, colLen) +
                bs(land, row + 1, col + 1, rowLen, colLen) + 1;
    }
}
