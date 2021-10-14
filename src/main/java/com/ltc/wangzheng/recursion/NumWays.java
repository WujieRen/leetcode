package com.ltc.wangzheng.recursion;

/**
 * @author rwj
 * @create_time 2021/10/13
 * @description
 */
public class NumWays {
    public int numWays(int n) {
        int[] nums = new int[n+1];
        return f1(n, nums);
    }

    public int f1(int n, int[] nums) {
        if(n == 0) return 1;
        if(n == 1) return 1;
        if(nums[n] != 0) return nums[n];
        nums[n] = (f1(n-1, nums) + f1(n-2, nums)) % 1000000007;
        return nums[n];
    }

    //TODO: 非递归方式
    public int f2(int n) {
        int a = 1, b = 1;
        for(int i = 2; i <= n; ++i) {
            int sum = (a+b)%1000000007;
            a = b;
            b = sum;
        }
        return b;
    }
}
