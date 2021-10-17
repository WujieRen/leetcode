package com.ltc.wangzheng.sort;

import java.util.Arrays;

/**
 * @author rwj
 * @create_time 2021/10/14
 * @description
 */
public class CanMakeArithmeticProgression {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length <= 2) return true;
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for(int i = 1; i < arr.length - 1; ++i) {
            int curDiff = arr[i+1] - arr[i];
            if(curDiff != diff) {
                return false;
            }
        }
        return true;
    }
}
