package com.ltc.wangzheng.find_low;

/**
 * @author rwj
 * @create_time 2021/9/26
 * @description
 */
public class SetZeroes {
    public static void main(String[] args) {
        boolean[] tmp = new boolean[2];
        for (boolean t : tmp) {
            System.out.println(t);
        }

    }

    private static void f3(int[][] matrix) {
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        boolean flagCol = false;
        for (int i = 0; i < rowNum; i++) {
            if (matrix[i][0] == 0) {
                flagCol = true;
            }
            for (int j = 1; j < colNum; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < rowNum; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < colNum; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < colNum; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < rowNum; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            for (int i = 1; i < colNum; i++) {
                matrix[0][i] = 0;
            }
        }
        if (flagCol) {
            for (int i = 0; i < rowNum; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    private static void f2(int[][] matrix) {
        int srcRowNum = matrix.length;
        int srcColNum = matrix[0].length;
        boolean[] row = new boolean[srcRowNum];
        boolean[] col = new boolean[srcColNum];
        for (int i = 0; i < srcRowNum; ++i) {
            for (int j = 0; j < srcColNum; ++j) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < srcRowNum; ++i) {
            if (row[i]) {
                for (int j = 0; j < srcColNum; ++j) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < srcColNum; ++i) {
            if (col[i]) {
                for (int j = 0; j < srcRowNum; ++j) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

    private static void f1(int[][] matrix) {
        int srcRowNum = matrix.length;
        int srcColNum = matrix[0].length;
        int itemNum = srcColNum * srcColNum;
        int[] row = new int[itemNum];
        int[] column = new int[itemNum];
        int cnt = 0;
        for (int i = 0; i < srcRowNum; ++i) {
            for (int j = 0; j < srcColNum; ++j) {
                if (matrix[i][j] == 0) {
                    row[cnt] = i;
                    column[cnt] = j;
                    ++cnt;
                }
            }
        }
        int idx = 0;
        while (idx < cnt) {
            for (int j = 0; j < srcColNum; ++j) {
                int rowNum = row[idx];
                matrix[rowNum][j] = 0;
            }
            for (int i = 0; i < srcRowNum; ++i) {
                int colNum = column[idx];
                matrix[i][colNum] = 0;
            }
            ++idx;
        }
    }
}
