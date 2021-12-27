package com.ltc.wangzheng.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rwj
 * @create_time 2021/12/27
 * @description https://leetcode-cn.com/problems/combination-sum/
 */
public class CombinationSum2 {
    static List<List<Integer>> res = new LinkedList<>();
    static List<Integer> list = new ArrayList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(candidates, target, 0);
        return new ArrayList<>(res);
    }
    public static void backTrack(int[] candidates, int target, int start) {
        if(target == 0 && list.size() > 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(start >=  candidates.length || target < 0) return;

        for(int i = 0; i <= target/candidates[start]; ++i) {
            for(int j = 0; j < i; ++j) {
                list.add(candidates[start]);
            }
            backTrack(candidates, target-candidates[start]*i, start+1);
            for(int j = 0; j < i; ++j) {
                list.remove(list.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        combinationSum(new int[]{2,3,7}, 12);
        System.out.println(res);
    }
}
