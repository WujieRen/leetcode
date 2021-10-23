package com.ltc.wangzheng.binary_search;

public class FindPeakElement {

    public int findPeakElement2(int[] nums) {
        int maxIdx = nums.length - 1, left = 0, right = maxIdx;
        if(maxIdx == 0) return 0;
        while(left <= right) {
            int mid = (right-left)/2+left;
            int curV = nums[mid];
            int leftV = mid == 0 ? Integer.MIN_VALUE : nums[mid-1];
            int rightV = mid == maxIdx ? Integer.MIN_VALUE : nums[mid+1];
            if(curV > leftV && curV > rightV) {
                return mid;
            }
            if(nums[mid] > nums[mid+1]) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    public int findPeakElement(int[] nums) {
        int maxIdx = nums.length - 1, left = 0, right = maxIdx;
        if(maxIdx == 1) return nums[0] > nums[1] ? 0 : 1;
        while(left <= right) {
            int mid = (right-left)/2+left;
            int numLeft = mid == 0 ? Integer.MIN_VALUE : nums[mid-1];
            int numRight = mid == maxIdx ? Integer.MIN_VALUE : nums[mid+1];
            if(nums[mid] >= numLeft && nums[mid] >= numRight) return mid;
            if(nums[mid] > nums[mid+1]) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
}
