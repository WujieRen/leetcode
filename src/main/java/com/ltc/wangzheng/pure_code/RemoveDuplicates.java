package com.ltc.wangzheng.pure_code;

/**
 * @author rwj
 * @create_time 2021/9/24
 * @description
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(f2(new int[]{ 1, 1, 2, 2, 3, 3, 5}));
    }

    private static int f2(int[] nums) {
        int len = nums.length;
        int i = 0;
        for(int j = 1; j < len; ++j) {
            if(nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return ++i;
    }

    private static int f1(int[] nums) {
        int len = nums.length;
        if(len <= 0) return 0;
        int tmp = nums[0];
        int endIdx = 1;
        for (int i = 1; i < len; i++) {
            if(tmp != nums[i]) {
                tmp = nums[i];
                nums[endIdx++] = nums[i];
            }
        }
        return endIdx;
    }
}
