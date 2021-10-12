package com.ltc.wangzheng.find_low;

import java.util.Arrays;

/**
 * @author rwj
 * @create_time 2021/9/26
 * @description
 */
public class DivingBoard {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(f1(1, 1, 3)));
    }

    private static int[] f1(int shorter, int longer, int k) {
        if(k == 0) return new int[0];
        if(shorter == longer) return new int[]{ k * shorter };
        int[] res = new int[k+1];
        for(int i = k; i >= 0; --i) {
            int tmp = k-i;
            res[tmp] = shorter * i + longer * tmp;
        }
        return res;
    }
}
