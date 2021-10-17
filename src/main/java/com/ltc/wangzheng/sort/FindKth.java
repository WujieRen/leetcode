package com.ltc.wangzheng.sort;

import java.util.Arrays;

/**
 * @author rwj
 * @create_time 2021/10/17
 * @description
 */
public class FindKth {
    public static void main(String[] args) {
        int[] nums = new int[]{2,5,3,1,4,6};
        System.out.println(findKthLargest(nums, 2));
        System.out.println(Arrays.toString(nums));

        System.out.println(Arrays.toString(smallestK(nums, 2)));
    }

    public static int[] smallestK(int[] arr, int k) {
        int len = arr.length;
        for(int i = 0; i < len; ++i) {
            for(int j = i + 1; j < len; ++j) {
                if(arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
            if(i == k) {
                break;
            }
        }
        int[] minNums = new int[k];
        System.arraycopy(arr, 0, minNums, 0, k);
        return minNums;
    }

    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        for(int i = 0; i < len; ++i) {
            for(int j = 0; j < len - 1; ++j) {
                if(nums[j] > nums[j+1]) {
                    int tmp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = tmp;
                }
            }
            if(i == k) break;
        }
        return nums[len - k];
    }

}
