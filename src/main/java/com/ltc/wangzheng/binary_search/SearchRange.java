package com.ltc.wangzheng.binary_search;

public class SearchRange {
    public static void main(String[] args) {

    }

    private static int[] searchRange2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int start = -1, end = -1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target) {
                if(mid == 0 || nums[mid - 1] != target) {
                    start = mid;
                    break;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target) {
                if(mid == nums.length - 1 || nums[mid+1] != target) {
                    end = mid;
                    break;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{start, end};
    }

    private static int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int start = -1, end = -1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                if(mid == 0) {
                    start = mid;
                    break;
                }
                if (nums[mid - 1] < target) {
                    start = mid;
                    break;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                if(mid == nums.length - 1) {
                    end = mid;
                    break;
                }
                if (nums[mid + 1] > target) {
                    end = mid;
                    break;
                } else {
                    left = mid + 1;
                }
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{start, end};
    }
}
