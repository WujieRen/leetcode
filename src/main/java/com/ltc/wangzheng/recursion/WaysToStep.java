package com.ltc.wangzheng.recursion;

import java.math.BigDecimal;

/**
 * @author rwj
 * @create_time 2021/10/13
 * @description
 */
public class WaysToStep {
    public int waysToStep(int n) {
        int[] nums = new int[n+1];
        return f1(n, nums);
    }

    public int f1(int n, int[] nums) {
        if(n == 0) return 1;
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 4;
        if(nums[n] != 0) return nums[n];
        nums[n] = ((f1(n-1, nums) + f1(n-2, nums)) % 1000000007 + f1(n-3, nums))%1000000007;
        return nums[n];
    }
    public int f2(int n) {
        if(n < 0) return 0;
        if(n == 0 || n == 1) return 1;
        if(n == 2) return 2;
        int a = 1, b = 1, c = 2;
        for(int i = 3; i <= n; ++i) {
            int sum = ((a + b)%1000000007+c)%1000000007;
            a = b;
            b = c;
            c = sum;
        }
        return c;
    }
}
