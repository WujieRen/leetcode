package com.ltc.wangzheng.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author rwj
 * @create_time 2021/10/11
 * @description
 */
public class RemoveDuplicates2 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
//        System.out.println(sb.toString());
        System.out.println(f1("adbbdac"));
        char[] cs = new char[2];
        System.out.println(Arrays.toString(cs));

    }

    private static String f1(String s) {
        int len = s.length();
        char[] cs = new char[len];
        int cnt = -1;
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (cnt < 0) {
                cs[++cnt] = c;
            } else {
                if (cs[cnt] == c) {
                    cs[cnt] = 0;
                    cnt--;
                } else {
                    cs[++cnt] = c;
                }
            }
        }
//        char[] res = new char[cnt+1];
//        System.arraycopy(cs, 0, res, 0, cnt+1);
//        return String.valueOf(res);
        return new String(cs, 0, cnt+1);
    }
}
