package com.ltc.wangzheng.pure_code;

/**
 * @author rwj
 * @create_time 2021/9/24
 * @description
 */
public class strToInt {
    public static void main(String[] args) {
        System.out.println((int) '0' - 48);
        System.out.println(0 * 10 + 9);
        System.out.println(f1("-2147483648"));
    }

    private static int f1(String str) {
        int len = str.length();
        int j = 0;
        char[] cs = str.toCharArray();
        int isPositive = 0;
        int res = 0;
        while (j < len) {
            if (isPositive == 0 && cs[j] == ' ') {
                ++j;
                continue;
            }
            if (isPositive == 0 && cs[j] != '+' && cs[j] != '-' && !Character.isDigit(cs[j])) {
                return 0;
            }
            if (isPositive != 0 && !Character.isDigit(cs[j])) {
                return res * isPositive;
            }
            if (cs[j] == '+') {
                if (len > j + 1 && cs[j + 1] == '-') return 0;
                isPositive = 1;
            }
            if (cs[j] == '-') {
                if (len > j + 1 && cs[j + 1] == '+') return 0;
                isPositive = -1;
            }
            if (Character.isDigit(cs[j])) {
                if (isPositive == 0) { //第一次进来时发现isPositive是0，说明第一次碰到数字之前，没有任何符号，
                    isPositive = 1;
                }
                res = res * 10 + (cs[j] - 48);
                if(res > 214748364 && j+1 < len) {
                    if (isPositive == -1) return Integer.MIN_VALUE;
                    else return Integer.MAX_VALUE;
                }
                if (res == 214748364 && j+1 < len) {
                    if(isPositive == -1 && cs[j+1] > '8') return Integer.MIN_VALUE;
                    if(cs[j+1] > '7') return Integer.MAX_VALUE;
                }
            }
            ++j;
        }
        return res * isPositive;
    }
}
