package com.ltc.wangzheng.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author rwj
 * @create_time 2021/12/26
 * @description https://leetcode-cn.com/problems/permutations-ii/
 *
 * 通过控制次数来判断重复数字还可以用几次
 *
 * 这个和 SubsetsWithDup2 的不同在于：
 *      SubsetsWithDup2 中，能放几次次数是不变的；每次放几个却是可变的；
 *      而 PermuteUnique2 中，每次都要把所有的放进去（即放几个是不变的——把所有的都放进去）；放完这次后能放几次是可变的；
 */
public class PermuteUnique2 {

    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) hm.put(num, hm.getOrDefault(num, 0)+1);
        int n = hm.size();
        int[] uniqueNums = new int[n];
        int[] counts = new int[n];
        int k = 0;
        for (int num : nums) {
            if (hm.containsKey(num)) {
                uniqueNums[k] = num;
                counts[k] = hm.get(num);
                k++;
                hm.remove(num);
            }
        }
        backtrack(uniqueNums, counts, 0, new ArrayList<>(), nums.length);
        return result;
    }
    private void backtrack(int[] uniqueNums, int[] counts, int k, List<Integer> path, int n) {
        if (k == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < uniqueNums.length; ++i) {
            if (counts[i] == 0) continue;
            path.add(uniqueNums[i]); // 添加选择
            counts[i]--;
            backtrack(uniqueNums, counts, k + 1, path, n);
            path.remove(path.size() - 1); // 撤销选择
            counts[i]++;
        }
    }
}
