package com.ltc.wangzheng.find_low;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rwj
 * @create_time 2021/9/27
 * @description
 */
public class Rotate {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;
        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;
        System.out.println(f1(matrix));
    }

    private static List<Integer> f1(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int t = 0, b = matrix.length - 1, l = 0, r = matrix[0].length - 1;
        while (true) {
            //向右
            for (int i = l; i <= r; i++) { res.add(matrix[t][i]); }
            if (++t > b) break;

            //向下
            for (int i = t; i <= b; i++) { res.add(matrix[i][r]); }
            if (--r < l) break;

            //向左
            for (int i = r; i >= l; i--) { res.add(matrix[b][i]); }
            if (--b < t) break;

            //向上
            for (int i = b; i >= t; i--) { res.add(matrix[i][l]); }
            if (++l > r) break;
        }
        return res;
    }
}
