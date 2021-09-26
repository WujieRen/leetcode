package com.ltc.wangzheng.pure_code;

/**
 * @author rwj
 * @create_time 2021/9/24
 * @description
 */
public class rReverseLeftWords {
    public static void main(String[] args) {
        System.out.println(f3("abcde", 3));
    }

    private static String f3(String s, int n) {
        int len = s.length();
        char[] sc = s.toCharArray();
        char[] cs = new char[len];
        int endLength = len - n;
        System.arraycopy(sc, n, cs, 0, endLength);
        System.arraycopy(sc, 0, cs, endLength, n);
        return new String(cs);
    }

    private static String f2(String s, int n) {
        String end = s.substring(n);
        String start = s.substring(0, n);       //TODO: substring底层用的Arrays.copyOfRange - > System.arraycopy方法，效率很高
        return end + start;
    }

    private static String f1(String s, int n) {
        int len = s.length();
        char[] cs = new char[len];
        int start = 0;
        int tmp = n;
        char[] sc = s.toCharArray();
        while (tmp <= len-1) {
            cs[start++] = sc[tmp++];
        }
        int i = 0;
        while(i < n) {
            cs[start++] = sc[i++];
        }
        return new String(cs);
    }
}
