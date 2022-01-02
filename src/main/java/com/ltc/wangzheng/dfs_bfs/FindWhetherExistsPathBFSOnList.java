package com.ltc.wangzheng.dfs_bfs;

import java.util.*;

/**
 * @author rwj
 * @create_time 2021/12/28
 * @description https://leetcode-cn.com/problems/route-between-nodes-lcci/
 */
public class FindWhetherExistsPathBFSOnList {

    public static boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        /** 1.建立邻接表 */
        for (int[] ints : graph) {
            if (!map.containsKey(ints[0])) {
                map.put(ints[0], new ArrayList<>());
            }
            map.get(ints[0]).add(ints[1]);
        }
        /** bfs */
        return bfs(start, target, map);
    }
    /** bfs */
    public static boolean bfs(int start, int target, Map<Integer, List<Integer>> map) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        while (!que.isEmpty()) {
            int top = que.poll();
            if(!map.containsKey(top)) continue;
            List<Integer> list = map.get(top);
            if(list == null) continue;
            if(list.contains(target)) return true;
            que.addAll(list);
            map.put(top, null);
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] graph = new int[4][2];
        graph[0] = new int[]{0, 1};
        graph[1] = new int[]{1, 7};
        graph[2] = new int[]{1, 11};
        graph[3] = new int[]{7, 12};
        System.out.println(findWhetherExistsPath(13, graph, 0, 12));
    }
}
