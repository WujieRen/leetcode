package com.ltc.wangzheng.sort;

/**
 * @author rwj
 * @create_time 2021/10/14
 * @description
 */
public class Exchange {
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right) {
            while(left < right && nums[left] % 2 == 1) left++;
            while(left < right && nums[right] % 2 == 0) right--;
            if(left < right) swap(nums, left, right);
        }
        return nums;
    }

    private static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
