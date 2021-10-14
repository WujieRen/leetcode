package com.ltc.wangzheng.recursion;

/**
 * @author rwj
 * @create_time 2021/10/12
 * @description
 */
public class Fib {
    public static void main(String[] args) {
        System.out.println(f1(0));
        System.out.println(f1(1));
        System.out.println(f1(2));
        System.out.println(f1(5));
    }

    //TODO: 超出时间限制
    private static int f1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return f1(n-1) + f1(n-2);
    }



    private static int f2(int n) {
        int[] nums = new int[n];
        return fib(n, nums);
    }

    private static int fib(int n, int[] nums) {
        int mod = 1000000007;
        if (n == 0) return 0;
        if (n == 1) return 1;
        if(nums[n] != 0) return nums[n];
        nums[n] = (fib(n-1, nums) + fib(n-2, nums)) % mod;
        return nums[n] % mod;
//        return nums[n] % mod;     //TODO:这里注意要先取模再往nums[n]里面存，否则会越界，导致结果出错（出现负数）
    }
}
