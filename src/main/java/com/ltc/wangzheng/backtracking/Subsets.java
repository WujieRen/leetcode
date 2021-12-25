package com.ltc.wangzheng.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rwj
 * @create_time 2021/12/21
 * @description
 */
public class Subsets {
    /** 写法形式① */
    static List<List<Integer>> res = new LinkedList<>();
    static List<Integer> list = new ArrayList<>();
    static public List<List<Integer>> subsets(int[] nums) {
        res.add(list);
        backTrack(nums, 0, nums.length);
        return res;
    }
    public static void backTrack(int[] nums, int startIdx, int endIdx) {
        System.out.println(startIdx + "--" + list);
        if(startIdx == endIdx) return;

        for(int i = startIdx; i < endIdx; ++i) {
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            backTrack(nums, i+1, endIdx);
            list.remove(list.size()-1);
        }
    }

    /** 写法形式② */
    public static List<List<Integer>> subsets2(int[] nums) {
        res.add(list);
        backTrack2(nums);
        return res;
    }
    public static void backTrack2(int[] nums) {
        if(nums.length == 0) return;

        for(int i = 0; i < nums.length; ++i) {
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            backTrack2(Arrays.copyOfRange(nums, i+1, nums.length));
            list.remove(list.size()-1);
        }
    }

    /** 写法③：本质一样，但其实思路是不一样的。
     *      这种写法相当于是：
     *          [1,2,3,4]
     *          [1,2,4]
     *          [1,3,4]
     *          [1,4]
     * */
    static List<List<Integer>> ans=new ArrayList<List<Integer>>();
    static List<Integer> t=new ArrayList<Integer>();
    public static List<List<Integer>> subsets3(int[] nums) {
        dfs(0,nums);
        //List<Integer> t = new ArrayList<Integer>();
        return ans;
    }
    public static void dfs(int start,int[]nums){
        if(start==nums.length){
            ans.add(new ArrayList(t)); //注意这里指针
            return;
        }

        t.add(nums[start]);
        dfs(start+1,nums);
        t.remove(t.size()-1);

        dfs(start+1,nums);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        subsets3(nums);
        subsets(nums);
        System.out.println(res);
    }

}
