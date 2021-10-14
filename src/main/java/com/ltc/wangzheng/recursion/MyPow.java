package com.ltc.wangzheng.recursion;

/**
 * @author rwj
 * @create_time 2021/10/13
 * @description
 */
public class MyPow {

    public double myPow(double x, int n) {
        if (n == 0) return x / x;
        if (n == 1) return x;
        int tmp = Math.abs(n);
        if(n > 0) {
            return x * myPow(tmp, n-1);
        } else {
            return 1 / (x * myPow(tmp, n-1));
        }
    }

    public double myPow1(double x, int n) {
        if(x == 0 || x == 1) return x;
        if (x == -1) {
            if(n == Integer.MIN_VALUE) {
                return 1;
            } else {
                return n*-1%2 == 0 ? 1 : -1;
            }
        }
        if(n == Integer.MIN_VALUE) return 0;
        if (n == 0) return x / x;
        if (n == 1) return x;
        long tmp = Math.abs(n);
        double res = x;
        while(tmp > 1) {
            res *= x;
            --tmp;
        }
        return n > 0 ? res : 1/res;
    }


}
