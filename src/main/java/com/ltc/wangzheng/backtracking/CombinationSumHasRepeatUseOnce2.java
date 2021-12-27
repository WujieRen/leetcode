package com.ltc.wangzheng.backtracking;

import java.util.*;

/**
 * @author rwj
 * @create_time 2021/12/27
 * @description https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class CombinationSumHasRepeatUseOnce2 {
    static List<List<Integer>> res = new LinkedList<>();
    static List<Integer> list = new ArrayList<>();
    /** 该写法比下面的速度要慢1倍    */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //1. 先统计每个数字出现频率
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : candidates) map.put(num, map.getOrDefault(num, 0)+1);
        int[] uniqNum = new int[map.size()];
        int[] uniqNumCnt = new int[map.size()];
        int i = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            uniqNum[i] = entry.getKey();
            uniqNumCnt[i] = entry.getValue();
            ++i;
        }
        backTrack(target, uniqNum, 0, uniqNumCnt);
        return res;
    }

    public static void backTrack(int target, int[] uniqNum, int startIdx, int[] uniqNumCnt) {
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(startIdx >= uniqNum.length || target < 0) return;
        for(int i = 0; i <= uniqNumCnt[startIdx]; ++i) {
            for(int j = 0; j < i; ++j) {
                list.add(uniqNum[startIdx]);
                uniqNumCnt[startIdx]--;
            }
            backTrack(target-uniqNum[startIdx]*i, uniqNum, startIdx+1, uniqNumCnt);
            for(int j = 0; j < i; ++j) {
                list.remove(list.size()-1);
                uniqNumCnt[startIdx]++;
            }
        }
    }

    /** 下面这个写法是上面写法的2~3倍；上面写发主要花时间就在对map进行循环的地方 */
    public static List<List<Integer>> combinationSum_zg(int[] candidates, int target) {
        //1. 先统计每个数字出现频率
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : candidates) map.put(num, map.getOrDefault(num, 0)+1);
        List<Integer> nums = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        /*for (int candidate : candidates) {
            if (map.containsKey(candidate)) {
                nums.add(candidate);
                counts.add(map.get(candidate));
                map.remove(candidate);
            }
        }*/
        /** 下面的for循环效率比上面的for循环效率要低1倍；因为对map进行遍历比较花时间 */
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            nums.add(entry.getKey());
            counts.add(entry.getValue());
        }
        backTrack_zg(target, nums, 0, counts);
        return res;
    }

    public static void backTrack_zg(int target, List<Integer> nums, int startIdx, List<Integer> counts) {
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(startIdx >= nums.size() || target < 0) return;
        for(int i = 0; i <= counts.get(startIdx); ++i) {
            for(int j = 0; j < i; ++j) {
                list.add(nums.get(startIdx));
            }
            backTrack_zg(target-nums.get(startIdx)*i, nums, startIdx+1, counts);
            for(int j = 0; j < i; ++j) {
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        combinationSum2(new int[]{14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12}, 20);
        System.out.println(res);
    }
}
