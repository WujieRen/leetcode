package com.ltc.wangzheng.find_low;

/**
 * @author rwj
 * @create_time 2021/9/28
 * @description
 */
public class Tictactoe {
    public static void main(String[] args) {
        String[] str = new String[]{"OX    O ", "OX  X O ", "XX  O O ", "OX      ", " X      ", " X    O ", "XX      ", "OX  O O "};
        System.out.println(f1(str));
//        char c = 'a';
//        String s = String.valueOf(c);
//        System.out.println(s);
    }

    private static String f1(String[] board) {
        int len = board.length;
        boolean hasSpace = false;
        for (int row = 0; row < len; ++row) {        //每行和每列检查
            int rowCnt = 0, colCnt = 0;
            char rowTmp = board[row].charAt(0);
            char colTmp = board[0].charAt(row);
            for (int col = 0; col < len; ++col) {
                if (board[row].charAt(col) == rowTmp && rowTmp!= ' ') {
                    ++rowCnt;
                }
                if (board[col].charAt(row) == colTmp && colTmp != ' ') {
                    ++colCnt;
                }
                if (board[row].charAt(col) == ' ' || board[col].charAt(row) == ' ') hasSpace = true;
            }
            if (rowCnt == len ) return String.valueOf(rowTmp);
            if (colCnt == len ) return String.valueOf(colTmp);
        }
        int leftCnt = 0, rightCnt = 0;
        char leftLineSt = board[0].charAt(0);
        int n = len - 1;
        char rightLineSt = board[0].charAt(n);
        for (int i = 0; i < len; ++i) {
            if (leftLineSt != ' ' && board[i].charAt(i) == leftLineSt) {
                ++leftCnt;
            }
            if (rightLineSt != ' ' && board[i].charAt(n - i) == rightLineSt) {
                ++rightCnt;
            }
        }
        if (leftCnt == len) return String.valueOf(leftLineSt);
        if (rightCnt == len) return String.valueOf(rightLineSt);
        return hasSpace ? "Pending" : "Draw";
    }
}
