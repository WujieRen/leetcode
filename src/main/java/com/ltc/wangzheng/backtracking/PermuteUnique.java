package com.ltc.wangzheng.backtracking;

import java.util.*;

/**
 * @author rwj
 * @create_time 2021/12/21
 * @description
 */
public class PermuteUnique {

    /**
     * 很奇怪这个居然通过了，按理来说全排列的Hash值是一样的啊；为何最终却可以精准去重？
     * 说明我AbstractList.hashcode()方法理解不够
     */
    Set<List<Integer>> set = new HashSet<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(nums, used);
        return new ArrayList(set);
    }
    public void backTrack(int[] nums, boolean[] used) {
        if(list.size() == nums.length) {
            set.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i = 0; i < nums.length; ++i) {
     if (used[i]) continue;
     list.add(nums[i]);
     used[i] = true;
     backTrack(nums, used);
     list.remove(list.size() - 1);
     used[i] = false;
     }
     }

     /**
     * 不用Set去重，而是用条件限制——推荐这种，效率更高，算是一种剪枝。
     * 缺点是有时候条件不是那么容易发现。
     *
     */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique2(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(nums, used);
        return new ArrayList(res);
    }
    public void backTrack2(int[] nums, boolean[] used) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i = 0; i < nums.length; ++i) {
//            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            if(i > 0 && nums[i] == nums[i-1] && used[i-1]) continue;
            if(!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                backTrack(nums, used);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }

}
