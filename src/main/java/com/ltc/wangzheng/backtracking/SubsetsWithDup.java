package com.ltc.wangzheng.backtracking;

import java.util.*;

/**
 * @author rwj
 * @create_time 2021/12/21
 * @description
 */
public class SubsetsWithDup {

    /**
     * 写法①
     */
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res.add(list);
        Arrays.sort(nums);
        backTrack(nums);
        return res;
    }

    public void backTrack(int[] nums) {
        if (nums.length == 0) return;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            backTrack(Arrays.copyOfRange(nums, i + 1, nums.length));
            list.remove(list.size() - 1);
        }
    }

    /**
     * 写法①
     * 这里之所以HashSet能起到去重的效果，但是和顺序有关。元素相同且顺序一直才被人为是同一个元素
     */
    Set<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        set.add(list);
        Arrays.sort(nums);
        backTrack2(nums, 0);
        return new ArrayList<>(set);
    }

    public void backTrack2(int[] nums, int start) {
        if (nums.length == start) {
            set.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[start]);
        backTrack2(nums, start + 1);
        list.remove(list.size() - 1);

        backTrack2(nums, start + 1);
    }

    /** 写法③ */
    public List<List<Integer>> subsetsWithDup3(int[] nums) {
        Arrays.sort(nums);
        backTrack3(nums);
        return res;
    }

    public void backTrack3(int[] nums) {
        if(!res.contains(list)) res.add(new ArrayList<>(list));
        for (int i = 0; i < nums.length; ++i) {
            list.add(nums[i]);
            backTrack3(Arrays.copyOfRange(nums, i + 1, nums.length));
            list.remove(list.size() - 1);
        }
    }

    /**
     * 这种写法必须补一个空；
     * 这样的写法效率也是相对较低的；因为每次添加值时都涉及到一个查重
     * @param nums
     */
    public void backTrack4(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            list.add(nums[i]);
            if(!res.contains(list)) res.add(new ArrayList<>(list));
            backTrack4(Arrays.copyOfRange(nums, i + 1, nums.length));
            list.remove(list.size() - 1);
        }
    }

}
