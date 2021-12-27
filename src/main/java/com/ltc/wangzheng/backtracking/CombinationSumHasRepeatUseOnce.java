package com.ltc.wangzheng.backtracking;

import java.util.*;

/**
 * @author rwj
 * @create_time 2021/12/23
 * @description https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class CombinationSumHasRepeatUseOnce {

    List<List<Integer>> res = new LinkedList<>();
    List<Integer> list = new ArrayList<>();
    boolean[] flag;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        flag = new boolean[candidates.length];
        backTrack(candidates, target, 0);
        return res;
    }
    public void backTrack(int[] candidates, int target, int start) {
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = start; i < candidates.length && target - candidates[i] >= 0; ++i) {
            if(i > 0 && candidates[i] == candidates[i-1] && !flag[i-1]) continue;
            flag[i] = true;
            int curNum = candidates[i];
            list.add(curNum);
            backTrack(candidates, target-curNum, i+1);
            list.remove(list.size()-1);
            flag[i] = false;
        }
    }

}
