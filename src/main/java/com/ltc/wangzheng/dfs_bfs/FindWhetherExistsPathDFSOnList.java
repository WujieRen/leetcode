package com.ltc.wangzheng.dfs_bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rwj
 * @create_time 2021/12/29
 * @description https://leetcode-cn.com/problems/route-between-nodes-lcci/
 */
public class FindWhetherExistsPathDFSOnList {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
//        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        /** 1.建立邻接表 */
        for (int[] ints : graph) {
            if (!map.containsKey(ints[0])) {
                map.put(ints[0], new ArrayList<>());
            }
            map.get(ints[0]).add(ints[1]);
        }
//        return dfs(start, target, map, visited);
        return dfs(start, target, map);
    }
    public boolean dfs(int start, int target, Map<Integer, List<Integer>> map) {
        if(!map.containsKey(start)) return false;
        List<Integer> list = map.get(start);
        if(list == null) return false;
        if(list.contains(target)) return true;
        for(int num : list) {
            if(dfs(num, target, map)) return true;
            map.put(num, null);
        }
        return false;
    }
}
