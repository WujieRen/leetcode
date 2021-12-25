package com.ltc.wangzheng.backtracking;

import java.util.*;

/**
 * @author rwj
 * @create_time 2021/12/23
 * @description
 */
public class CombinationSum {
    /** 这个谁接到排序 + 去重，效率偏低 */
    static Set<List<Integer>> set = new HashSet<>();
    static List<Integer> list = new ArrayList<>();
    public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
        backTrack1(candidates, target);
        return new ArrayList<>(set);
    }
    public static void backTrack1(int[] candidates, int target) {
        if(target == 0) {
            List<Integer> tmp = new ArrayList<>(list);
//            Collections.sort(tmp);
            tmp.sort(Comparator.comparingInt(o -> o));
            set.add(new ArrayList<>(tmp));
            return;
        }

        for(int i = 0; i < candidates.length; ++i) {
            int curNum = candidates[i];
            if(target - curNum < 0) continue;
            list.add(curNum);
            backTrack1(candidates, target-curNum);
            list.remove(list.size()-1);
        }
    }

    /** 优化① */
    static List<List<Integer>> res = new LinkedList<>();
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        backTrack2(candidates, target, 0);
        return new ArrayList<>(res);
    }
    public static void backTrack2(int[] candidates, int target, int start) {
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        //这里只需要让每一次都从当前位置开始，不去当前位置之前找就可以避免重复
        for(int i = start; i < candidates.length; ++i) {
            int curNum = candidates[i];
            if(target - curNum < 0) continue;
            list.add(curNum);
            backTrack2(candidates, target-curNum, i);
            list.remove(list.size()-1);
        }
    }

    /** 这是别人的节点，不过是用的sum；一开始靠觉得我的写法和这个一样却结果不对；后来才发现是他在回溯前先对数组排了个序... */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // 先进行排序
        backtracking(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }

    public static void backtracking(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int sum, int idx) {
        // 找到了数字和为 target 的组合
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            // 如果 sum + candidates[i] > target 就终止遍历
            if (sum + candidates[i] > target) break;
            path.add(candidates[i]);
            backtracking(res, path, candidates, target, sum + candidates[i], i);
            path.remove(path.size() - 1); // 回溯，移除路径 path 最后一个元素
        }
    }

    public static void main(String[] args) {
        /*List<Integer> tmp = new ArrayList<>();
        tmp.add(3);
        tmp.add(5);
        Collections.sort(tmp);
        System.out.println(tmp);*/
        combinationSum(new int[]{5,1}, 9);
        System.out.println(res);
    }

}
