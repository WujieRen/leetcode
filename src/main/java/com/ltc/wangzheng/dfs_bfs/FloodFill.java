package com.ltc.wangzheng.dfs_bfs;

import java.util.Arrays;

/**
 * @author rwj
 * @create_time 2021/12/27
 * @description https://leetcode-cn.com/problems/color-fill-lcci/
 */
public class FloodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        dfs(image, sr, sc, newColor, oldColor);
        return image;
    }
    public static void dfs(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if (sr < 0 || sc < 0 || sr > image.length-1 || sc > image[0].length-1) return;
        if (image[sr][sc] == oldColor) image[sr][sc] = newColor;
        else return;
        dfs(image, sr - 1, sc, newColor, oldColor);
        dfs(image, sr + 1, sc, newColor, oldColor);
        dfs(image, sr, sc - 1, newColor, oldColor);
        dfs(image, sr, sc + 1, newColor, oldColor);

    }
    public void dfs_2(int[][] image, int sr, int sc, int newColor, int oldColor) {
        //越界或者这个点不能涂就返回
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length || image[sr][sc] != oldColor){
            return;
        }
        //涂色+四个方向扩散
        image[sr][sc] = newColor;
        dfs(image, sr - 1, sc, newColor, oldColor);
        dfs(image, sr + 1, sc, newColor, oldColor);
        dfs(image, sr , sc - 1, newColor, oldColor);
        dfs(image, sr , sc + 1, newColor, oldColor);
    }

    public static void main(String[] args) {
        int[][] image = new int[3][3];
        image[0] = new int[]{1, 1, 1};
        image[1] = new int[]{1, 1, 0};
        image[2] = new int[]{1, 0, 1 };
        floodFill(image, 1, 1, 2);
        System.out.println(Arrays.toString(image));
    }
}
