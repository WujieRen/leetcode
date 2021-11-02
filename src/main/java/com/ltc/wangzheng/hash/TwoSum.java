package com.ltc.wangzheng.hash;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            int otherNum = target - num;
            if(hashMap.containsKey(otherNum) && hashMap.get(otherNum) != i) {
                return new int[]{hashMap.get(otherNum), i};
            }
            hashMap.put(num, i);    //TODO: 这个的顺序是有关结果正确性的，先看有没有再往里放；不然会差值相等时会造成原先的值被覆盖
        }
        return new int[]{};
    }
}
