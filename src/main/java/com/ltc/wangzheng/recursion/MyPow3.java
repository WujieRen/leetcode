package com.ltc.wangzheng.recursion;

/**
 * @author rwj
 * @create_time 2021/10/14
 * @description
 */
public class MyPow3 {
    public static void main(String[] args) {
        System.out.println(myPow(2.00, -3));

    }

    private static double f1(double x, int n) {
        if(n >= 0) return myPow(x, n);
        else return 1/(myPow(x, -1*(n+1))*x);
    }

    public static double myPow(double x, int n) {
        if(n == 0) return 1;
        double halfPow = myPow(x, n/2);
        if(n % 2 == 0) {
            return halfPow * halfPow;
        } else {
            return halfPow * halfPow * x;
        }
    }
}
