package com.ltc.wangzheng.recursion;

/**
 * @author rwj
 * @create_time 2021/10/13
 * @description
 */
public class WaysToStep2 {

    public static void main(String[] args) {
        System.out.println(waysToStep2(5));
    }

    private static int[] DP = new int[1000001];
    private static int CUR = 3;
    static {
        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 4;
    }

    public static int waysToStep(int n) {
        if(n <= CUR) return DP[n];
        for(int i = CUR+1; i <=n; ++i) {
            DP[i] = ((waysToStep(i-1)+waysToStep(i-2))%1000000007+waysToStep(i-3))%1000000007;
        }
        CUR = n;
        return DP[n];
    }

    public static int waysToStep2(int n) {
        if(n <= CUR) return DP[n];
        for(int i = CUR+1; i <=n; ++i) {
            DP[i] = ((DP[i-1]+DP[i-2])%1000000007+DP[i-3])%1000000007;
        }
        CUR = n;
        return DP[n];
    }

}
