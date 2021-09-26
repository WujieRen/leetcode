package com.ltc.rwj.common;

/**
 * @author rwj
 * @create_time 2021/5/10
 * @description
 */
public class ArrayUtils {
    static int tmp;
    public static void swap(int[] nums, int i, int j) {
        if(nums[i] < nums[j]) {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
