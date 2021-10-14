package com.ltc.wangzheng.recursion;

/**
 * @author rwj
 * @create_time 2021/10/14
 * @description
 */
public class MyPow2 {

    public double myPow(double x, int n) {
        long m = Math.abs((long)n);
        double num =calculate(x,m);
        if(n < 0)  return 1 / num;
        return num;
    }

    public double calculate(double x,long n){
        if(n == 0)  return 1;
        if(n == 1)  return x;
        double a = calculate(x,n/2);
        if(n % 2 == 0){
            return a * a;
        }
        return a * a * x;
    }
}
