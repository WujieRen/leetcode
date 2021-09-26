package com.ltc.wangzheng.pure_code;

import java.util.Arrays;

/**
 * @author rwj
 * @create_time 2021/9/24
 * @description 用空白字符分割字符串时，如果空白字符出现在字符串最前面和中间，那就会出现分割后元素为空的情况；如果空白字符在末尾则不会
 */
public class lengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(" a   c  ".split(" ")));     //TODO:  [, a, , , c]
        System.out.println(Arrays.toString(" a   c  ".split("\\s+")));  //TODO:  [, a, c]
        System.out.println(f2(" a   bc  "));
        System.out.println(f3(" afsad aaa "));
    }

    private static int f3(String s) {
        s = s.trim();
        int n = s.length() - 1;
        int cnt = 0;
        while(n >= 0 && s.charAt(n) != ' ') {
            cnt++;
            n--;
        }
        return cnt;
    }

    private static int f2(String s) {
        String[] sts = s.split("\\s+");
        return sts[0].length();
    }

    private static int f1(String s) {
        s = s.trim();
        int lenth = s.length();
        int slow = 0, fast = 0;
        while(fast < lenth) {
            char c = s.charAt(fast++);
            if(c == ' ') {
                slow = fast;
            }
        }
        return fast - slow;
    }
}
