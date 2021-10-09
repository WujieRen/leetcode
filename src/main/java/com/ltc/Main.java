package com.ltc;

/**
 * @author rwj
 * @create_time 2021/5/8
 * @description
 */
public class Main {
    public static void main(String[] args) {
        /*t1(5);
        t2(5);
        t3(5);*/
        char[] c = new char[3];
        c[1] = 98;
        c[2] = '2';
        System.out.println(c.length);
        System.out.println(Integer.parseInt("49"));
    }

    public static void t1(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; ++j) {
                result += i * j;
            }
        }
        System.out.println(result);
    }

    public static void t2(int n) {
        int result = 0;
        int tmp = 0;
        for (int i = 1; i <= n; ++i) {
            tmp += i;
        }
        for (int j = 1; j <= n; ++j) {
            result += tmp * j;
        }
        System.out.println(result);
    }

    public static void t3(int n) {
        int result = 0;
        int inTmp = 0;
        for(int i = 1; i <= n; ++i) {
            inTmp += i;
        }
        int outTmp = 0;
        for(int j = 1; j <= n; ++j) {
            outTmp += j;
        }
        System.out.println(inTmp * outTmp);
    }

}