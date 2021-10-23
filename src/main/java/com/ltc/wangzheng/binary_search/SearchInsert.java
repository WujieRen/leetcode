package com.ltc.wangzheng.binary_search;

public class SearchInsert {
    public static void main(String[] args) {

    }

    private static int o2(int[] nums, int target) {
        int n = nums.length;
        if (target > nums[n - 1]) return n;
        int left = 0, right = n-1;
        while(left <= right) {
            int mid = (right-left)/2 + left;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int searchInsert(int[] nums, int target) {
        if(nums.length == 1) return nums[0] >= target ? 0 : 1;
        if(nums.length == 2) {
            if(nums[0] >= target) return 0;
            if(nums[1] < target) return 2;
            return 1;
        }
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = left + (right-left)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                if(mid != 0 && nums[mid-1] < target) return mid;
                right = mid - 1;
            } else {
                if(mid != nums.length - 1 && nums[mid+1] >= target) return mid + 1;
                left = mid + 1;
            }
        }
        return left == 0 ? 0 : nums.length;
    }

    private static int o1(int[] nums, int target) {
        int n = nums.length;
        if (target > nums[n - 1]) return n;

        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
