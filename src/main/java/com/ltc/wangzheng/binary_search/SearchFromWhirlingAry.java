package com.ltc.wangzheng.binary_search;

/**
 * 对于这种不是一个山峰状的数组来说，因为从某个点折叠过来的；除非整个折叠一遍；否则中间必有一个断开的点mid；
 * 在mid两边的数据都是递增的；
 * 所以这列题目的关键是要找到转折点在mid的那边；所有的一切都要围绕这个来解决；
 */

public class SearchFromWhirlingAry {

    public int search2(int[] nums, int target) {
        int maxIdx = nums.length - 1, left = 0, right = maxIdx;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            }
//            if (nums[mid] >= nums[left]) {
            if (nums[mid] > nums[left]) {
                if(target >= nums[left] && target < nums[mid]) {    //left～mid一定是递增的
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(target > nums[mid] && target <= nums[right]) {   //mid~right一定是递增的
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int maxIdx = nums.length - 1, left = 0, right = maxIdx;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (target == nums[mid]) {
                return mid;
            } else if (nums[left] > nums[mid]) {
                if (target > nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            } else {
                if (target >= nums[left] && nums[mid] < target) right = mid - 1;
                else left = mid + 1;
            }
        }
        return -1;
    }
}
