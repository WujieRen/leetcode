package com.ltc.wangzheng.backtracking;

import java.util.*;

/**
 * @author rwj
 * @create_time 2021/12/21
 * @description
 */
public class Permute {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(nums, used);
        return res;
    }
    public void backTrack(int[] nums, boolean[] used) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i = 0; i < nums.length; ++i) {
//            if(list.contains(nums[i])) continue;
            if (used[i]) continue;    //这个效率更高，我更倾向于这种
            list.add(nums[i]);
            used[i] = true;
            backTrack(nums, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
