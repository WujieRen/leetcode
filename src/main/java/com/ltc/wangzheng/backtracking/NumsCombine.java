package com.ltc.wangzheng.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rwj
 * @create_time 2021/12/21
 * @description
 */
public class NumsCombine {

    public static void main(String[] args) {
        combine(4, 2);
        System.out.println(res);
    }

    static List<List<Integer>> res = new LinkedList<>();
    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        backTracking(n, k, 1, list);
        return res;
    }

    public static void backTracking(int n, int k, int startIdx, List<Integer> list) {
        if(list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = startIdx; i <= n; ++i) {
            list.add(i);
            backTracking(n, k, i + 1, list);
            list.remove(list.size()-1);
        }
    }

}
