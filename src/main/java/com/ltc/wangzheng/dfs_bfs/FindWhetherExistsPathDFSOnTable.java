package com.ltc.wangzheng.dfs_bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author rwj
 * @create_time 2021/12/28
 * @description https://leetcode-cn.com/problems/route-between-nodes-lcci/
 *
 * 超时
 */
public class FindWhetherExistsPathDFSOnTable {
    static boolean flag;
    public static boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        boolean[] used = new boolean[n];
        Set<int[]> set = new HashSet<>(Arrays.asList(graph));
        return dfs(used, set, start, target);
    }
    public static boolean dfs(boolean[] used, Set<int[]> graph, int start, int target) {
        for (int[] ints : graph) {
            if (ints[0] == start) {
                if(used[ints[1]]) break;
                if (ints[1] == target) {
                    flag = true;
                    break;
                }
                used[ints[1]] = true;
                dfs(used, graph, ints[1], target);
                used[ints[1]] = false;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int[][] graph = new int[4][2];
        graph[0] = new int[]{0,1};
        graph[1] = new int[]{1,7};
        graph[2] = new int[]{1,11};
        graph[3] = new int[]{7,12};
        System.out.println(findWhetherExistsPath(13, graph, 0, 12));
    }
}
