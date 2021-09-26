package com.ltc.wangzheng.pure_code;

import java.util.Arrays;

/**
 * @author rwj
 * @create_time 2021/9/23
 * @description
 */
public class ReverseString {
    public static void main(String[] args) {
//        char[] s = new char[]{'h','e','l','l','o'};
        char[] s = new char[]{'H','a','n','n','a','h'};
        f2(s);
        System.out.println(Arrays.toString(s));
    }

    private static void f1(char[] s) {
        int n = s.length - 1;
        for(int i = n / 2; i >= 0; i--) {
            char tmp = s[i];
            s[i] = s[n-i];
            s[n-i] = tmp;
        }
    }

    private static void f2(char[] s) {
        int n = s.length - 1;
        int i = n/2;
        if(n/2==0 && n > 1) i-=1;
        while(i >= 0) {
            char tmp = s[i];
            s[i] = s[n-i];
            s[n-i] = tmp;
            --i;
        }
    }
}
