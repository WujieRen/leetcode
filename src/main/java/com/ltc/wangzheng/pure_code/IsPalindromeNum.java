package com.ltc.wangzheng.pure_code;

/**
 * @author rwj
 * @create_time 2021/9/24
 * @description
 */
public class IsPalindromeNum {
    public static void main(String[] args) {
        System.out.println(f2(0));
    }

    private static boolean f2(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) return false;
        int quo = x;
        int a = 0, sum = 0;
        while(quo > 0) {
            a = quo % 10;
            sum = sum * 10 + a;
            quo = quo / 10;
        }
        return sum == x;
    }


    private static boolean f1(int x) {
        String s = String.valueOf(x);
        int n = s.length() - 1;
        for(int left = 0, right = n; left < right; ++left, --right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
        }
        return true;
    }
}
