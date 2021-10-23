package com.ltc.wangzheng.binary_search;

/**
 * 对于这种不是一个山峰状的数组来说，因为从某个点折叠过来的；除非整个折叠一遍；否则中间必有一个断开的点mid；
 * 在mid两边的数据都是递增的；
 * 所以这列题目的关键是要找到转折点在mid的那边；所有的一切都要围绕这个来解决；
 * 具体来说有两种方式：
 *      1。 一旦mid < mid - 1;说明这个点就是转折点；这个点两遍的都是递增状；
 *      2。 以下标为0为基准；只要mid比nums[0]大；说明从0～mid一定是递增的；
 */
public class FindMin {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,4,5,1};
        findMin2(nums);
    }

    public static int o1(int[] nums) {
        int left = 0, maxIdx = nums.length - 1, right = maxIdx;
//        if(nums[left] <= nums[right]) return nums[left];
        while(left <= right) {
            int mid = (right-left)/2+left;
            if(left == right) return nums[mid];
            if((mid != 0 && nums[mid] < nums[mid-1])
                    || (mid == 0 && nums[mid] < nums[right])) {
                return nums[mid];
            } else if(nums[mid] < nums[right]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int findMin2(int[] nums) {
        int left = 0, maxIdx = nums.length - 1, right = maxIdx;
        if(nums[left] <= nums[right]) return nums[left];
        while(left <= right) {
            int mid = (right-left)/2+left;
            int cur = nums[mid];
            int numLeft = mid == 0 ? Integer.MIN_VALUE : nums[mid-1];
            int numRight = mid == maxIdx ? Integer.MAX_VALUE : nums[mid+1];
            if(cur < numLeft && cur < numRight) {
                return nums[mid];
            }
            if(nums[mid] >= nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


}
