package com.ltc.wangzheng.hash;

import java.io.Serializable;
import java.util.*;

public class ThreeSum {


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            if(nums[i] > 0) return res;
            int first = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            if(left < right && nums[left+1] == nums[left-1]) continue;
            List<Integer> list = new LinkedList<>();
            while (left < right) {
                if(left != i+1 && nums[left] == first) continue;
                if(right != nums.length - 1 && nums[right] == nums[right + 1]) continue;
                int sum = first + nums[left] + nums[right];
                if (sum == 0) {
                    list.add(first);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    break;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
            if(list.size() > 0) res.add(list);
        }
        return res;
    }
}
