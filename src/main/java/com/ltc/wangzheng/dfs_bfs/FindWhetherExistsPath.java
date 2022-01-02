package com.ltc.wangzheng.dfs_bfs;

/**
 * @author rwj
 * @create_time 2021/12/29
 * @description https://leetcode-cn.com/problems/route-between-nodes-lcci/
 *
 * 这个方法是效率最高的；1ms       但是效率高可能是因为巧合。
 * 从时间复杂度分析来看，BFS和DFS的时间复杂度都不比这个差；但是对于这个题目来说，这个效率的确是很高。
 * 应该是因为数据排列导致不够均匀分散，且是按顺序排的，所以这种方式很快(每次最多只需找 last -1 次)。
 *
 * 原理是：
 *      直接取出所有数组，遍历第二个元素找到target；然后逆着回去找start；
 *      如果找得到；返回 true
 *      找不到 返回 false
 *  最差时间复杂度 O(n + n-1 + n-2 + n-3 + ... + 1) = O(n^2)
 */
public class FindWhetherExistsPath {
    public static boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        if(start == target) return true;
        for(int[] entry: graph) {
            if(entry[1] == target)
                return findWhetherExistsPath(n, graph, start, entry[0]);
        }
        return false;
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
