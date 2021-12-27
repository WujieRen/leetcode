package com.ltc.wangzheng.backtracking;

import java.util.*;

/**
 * @author rwj
 * @create_time 2021/12/25
 * @description https://leetcode-cn.com/problems/subsets-ii/
 *
 * 这种思路是多阶段决策，通过看重复的数字有几个，每次分别放0个、1个、2个...n个
 *  以递归作为深度，遍历去重后的元素；
 *  for循环是单层的遍历，遍历当前层（当前元素）有几个；
 *  for循环中的for循环是控制当前层的元素放几个到结果集中。
 */
public class SubsetsWithDup2 {
    static List<List<Integer>> res = new LinkedList<>();
    static List<Integer> list = new ArrayList<>();
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        //1. 先统计每个数字出现频率
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) map.put(num, map.getOrDefault(num, 0)+1);
        int[] uniqNum = new int[map.size()];
        int[] uniqNumCnt = new int[map.size()];
        int i = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            uniqNum[i] = entry.getKey();
            uniqNumCnt[i] = entry.getValue();
            ++i;
        }
        backTrack(uniqNum, 0, uniqNumCnt);
        return res;
    }

    public static void backTrack(int[] uniqNum, int startIdx, int[] uniqNumCnt) {
        if(startIdx == uniqNum.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i <= uniqNumCnt[startIdx]; ++i) {
            for(int j = 0; j < i; ++j) {
                list.add(uniqNum[startIdx]);
            }
            backTrack(uniqNum, startIdx+1, uniqNumCnt);
            for(int j = 0; j < i; ++j) {
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        subsetsWithDup(nums);
    }
}
