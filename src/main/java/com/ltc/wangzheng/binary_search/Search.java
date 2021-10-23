package com.ltc.wangzheng.binary_search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Search {
    public static void main(String[] args) {

    }

    private static int search1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int search(int[] nums, int target) {
        int len = nums.length;
        return f1(nums, 0, len-1, target);
    }

    private static int f1(int[] nums, int low, int high, int target) {
        if(low > high) return -1;
        int mid = low + (high - low)/2;
        if(nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return f1(nums, low, mid-1, target);
        } else {
            return f1(nums, mid+1, high, target);
        }
    }
}
