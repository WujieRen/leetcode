package com.ltc.wangzheng.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rwj
 * @create_time 2021/12/26
 * @description https://leetcode-cn.com/problems/combinations/
 */
public class Combine {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        backTracking(n, k, 1, list);
        return res;
    }

    public void backTracking(int n, int k, int startIdx, List<Integer> list) {
        if(list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = startIdx; i <= n-(k- list.size())+1; ++i) {
//            if(list.contains(i)) continue;
            list.add(i);
            backTracking(n, k, i + 1, list);
            list.remove(list.size()-1);
        }
    }

    /**  争哥写法
     * */
    public List<List<Integer>> combine2(int n, int k) {
        List<Integer> list = new ArrayList<>();
        backTracking(n, k, 1, list);
        return res;
    }
    public void backTrack2(int n, int k, int step, List<Integer> list) {
        if(list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        /*if(step == n+1) {
            return;
        }*/
        /** 优化 */
        if (list.size() + (n - step + 1) < k) {
            return;
        }

        list.add(step);
        backTrack2(n, k, step+1, list);
        list.remove(list.size()-1);
        backTrack2(n, k, step+1, list);
    }


}
