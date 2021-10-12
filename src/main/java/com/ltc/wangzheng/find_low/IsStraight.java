package com.ltc.wangzheng.find_low;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rwj
 * @create_time 2021/9/26
 * @description
 */
public class IsStraight {
    public static void main(String[] args) {
        System.out.println(f1(new int[] {0, 4, 9, 9, 10}));
    }

    private static boolean f4(int[] nums) {
        boolean[] dump = new boolean[14];
        int min = 100;
        int max = 0;
        for(int i = 0; i < 5; ++i) {
            if(nums[i] != 0) {
                if(dump[nums[i]]) return false;
                else dump[nums[i]] = true;

                if(nums[i] > max) max = nums[i];
                if(nums[i] < min) min = nums[i];
            }
        }
        return max - min < 5;
    }

    private static boolean f3(int[] nums) {
        int tmp = nums[0];
        int zeroCnt = tmp == 0 ? 1 : 0;
        int max = tmp;
        int min = tmp == 0 ? Integer.MAX_VALUE : tmp;
        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        if(tmp != 0) numMap.put(tmp, tmp);
        for(int i = 1; i < nums.length; ++i) {
            if(numMap.containsKey(nums[i])) return false; //存在重复元素，返回false
            if(nums[i] != 0) numMap.put(nums[i], nums[i]);
            if(nums[i] == 0) ++zeroCnt;        //只要存在一个0，标志位更新
            if(nums[i] > max) max = nums[i];        //记录最大值
            if(nums[i] < min && nums[i] != 0) min = nums[i];    //记录最小值
            tmp = nums[i];
        }   //先得遍历一遍，看有没非0的重复元素，有的话直接返回false
        if(zeroCnt > 3) return true;
        return max - min <= 4;
    }

    private static boolean f2(int[] nums) {
        Arrays.sort(nums);
        return f1(nums);
    }

    /**
     * 这是排序了的情况
     * @param nums
     * @return
     */
    private static boolean f1(int[] nums) {
        int tmp = nums[0];
        for(int i = 1; i < nums.length; ++i) {
            if(nums[i] == tmp && nums[i] != 0) return false;
            tmp = nums[i];
        }   //先得遍历一遍，看有没非0的重复元素，有的话直接返回false
        if(nums[3] == 0) return true;   //那么剩下的情况里，只有可能0是重复出现的；那就得满足以下条件
        if(nums[2] == 0 && nums[4] - nums[3] <= 4) return true;
        if(nums[1] == 0 && nums[4] - nums[2] <= 4) return true;
        if(nums[0] == 0 && nums[4] - nums[1] <= 4) return true;
        return nums[4] - nums[0] == 4;
    }
}
