package com.ltc.wangzheng.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rwj
 * @create_time 2021/12/23
 * @description
 */
public class CombinationSumNoRepeatUseOnce {

    static List<Integer> list = new ArrayList<>();
    static List<List<Integer>> res = new LinkedList<>();
    public static List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        backTrack(nums, k, n, 0);
        return res;
    }

    public static void backTrack(int[] nums, int k, int n, int start) {
        if(list.size() == k && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i < 9 && n > 0 && list.size() <= k; ++i) {
            list.add(nums[i]);
            backTrack(nums, k, n-nums[i], i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        combinationSum3(3,7);
        System.out.println(res);
    }
}
