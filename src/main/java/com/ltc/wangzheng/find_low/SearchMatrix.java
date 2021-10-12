package com.ltc.wangzheng.find_low;

/**
 * @author rwj
 * @create_time 2021/9/28
 * @description
 */
public class SearchMatrix {
    public static void main(String[] args) {

    }

    private static boolean f1(int[][] matrix, int target) {
        int rowNum = matrix.length - 1;
        int colNum = matrix[0].length - 1;
        for(; colNum >= 0; --colNum) {
            if(matrix[0][colNum] == target) return true;
            if(matrix[0][colNum] < target) break;
        }
        for(; rowNum >= 0; --rowNum) {
            if(matrix[rowNum][0] == target) return true;
            if(matrix[rowNum][0] < target) break;
        }
        //以上两个for循环找出了这个数可能在那行和那列往前的范围
        //以下是在这行和这列去找，找到就存在，找不到就不存在
        while(rowNum >=0 && colNum >= 0) {
            for(int i = 0; i <= colNum; ++i) {
                if(matrix[rowNum][i] == target) return true;
            }
            for(int i = 0; i <= rowNum; ++i) {
                if(matrix[i][colNum] == target) return true;
            }
            --rowNum;
            --colNum;
        }
        return false;
    }
}
