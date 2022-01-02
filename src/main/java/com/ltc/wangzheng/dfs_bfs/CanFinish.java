package com.ltc.wangzheng.dfs_bfs;

import java.util.*;

/**
 * @author rwj
 * @create_time 2021/12/29
 * @description https://leetcode-cn.com/problems/course-schedule/comments/
 *
 * dfs 解法；也可以用拓补排序，见 Canfinish2
 */
public class CanFinish {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        if (prerequisites.length == 0 || numCourses == 0) return true;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] ints : prerequisites) {
            if (!map.containsKey(ints[0])) map.put(ints[0], new LinkedList<>());
            map.get(ints[0]).add(ints[1]);
        }
        //TODO: 对prerequisites进行遍历，每次根据pre[1]进行dfs；
        // 有几点需要注意：
        //       1. 如果pre[0] == pre[1] ，这种情况代表出现了环
        //       2. 如果 searchKey == key ，说明出现了环
        //       3. 同一个key（以该key为头的某一条链）进行查找过程中，深度优先遍历后序元素时，
        //          如果某个元素出现次数>1；也说明链表中出现了环

        // TODO: 这种写法稍简单写，是把对 pre 的遍历放在了 dfs 外面
       /* for (int[] prerequisite : prerequisites) {
//            if(prerequisite[0] == prerequisite[1]) return false;
            int key = prerequisite[0];
            if (!map.containsKey(key)) continue;
            if(!dfs(key, prerequisite[1], map, visited)) return false;
//            Arrays.fill(visited, 0);  //TODO: 这里也很关键，当上一条链中不存在环时，访问新链要把所有值置为0 （但是可以优化）
        }
        return true;
        */
        //TODO: 把外层for循环写在 dfs 内部，作为dfs的一部分 ;
        //      这种写法较难，细节难以把控
        //          —— 尤其是遍历 pre 时，每层完成后什么条件下需要返回；下面条件下不需要返回需要继续往下执行
        dfs(0, prerequisites, prerequisites[0][0], 0, prerequisites[0][1], map, visited);
        return flag;
    }

    static boolean flag = true;

    /**
     *
     * @param level prerequisites的第几个元素
     * @param prerequisites
     * @param key   本轮dfs要查找的key——即判断是否存在环的关键key
     * @param cnt   本轮dfs是否结束： == 0 结束， >0 还没结束
     * @param searchKey 迭代递归时的 key ，去 map 中找 key
     * @param map
     * @param visited  下标位置元素被访问次数
     */
    public static void dfs(int level, int[][] prerequisites, int key, int cnt, int searchKey, Map<Integer, List<Integer>> map, int[] visited) {
        if (key == searchKey || !flag) {
            flag = false;
            return;
        }

        if (map.containsKey(searchKey)) {
            visited[searchKey]++;       //TODO: 这个地方就代表同一dfs过程中，访问到该元素的次数
            cnt++;
            for (int num : map.get(searchKey)) {
                if (!map.containsKey(num)) continue;
                if (num == key || visited[searchKey] > 1 || map.get(num).contains(key)) {
                    flag = false;
                    return;
                }
                dfs(level, prerequisites, key, cnt, num, map, visited);
                map.remove(num);
                //    visited[searchKey]--;
            }
            /**
             * 这里的关键在于，如果map不包含num，就会退出for循环，继续往下走；
             *      往下走的时候相当于visited状态没有正常-1；
             *      且-1后要返回上一个for循环的地方，而不能直接往下走；
             * 所以要解决的关键问题就在于；如何判定是第一个进来的pre[1]这个元素，
             *      如果是这个元素；就不能返回；因为还要继续对 pre 后序的元素进行遍历
             *      如果不是这个元素，那执行完内层for循环后，就得返回，不能继续往下走——因为会导致 visited 中的元素状态不正确
             *
             */
            visited[searchKey]--; //放这里也可以
            cnt--;
            if(cnt != 0) return;
        }

        ++level;
        if (level >= prerequisites.length) return;
        dfs(level, prerequisites, prerequisites[level][0], 0, prerequisites[level][1], map, visited);
    }

    /**
     *
     * @param key           本轮dfs要查找的key——即判断是否存在环的关键key
     * @param searchKey     迭代递归时的 key ，去 map 中找 key
     * @param map
     * @param visited       下标位置元素被访问次数
     * @return
     */
    public static boolean dfs(int key, int searchKey, Map<Integer, List<Integer>> map, int[] visited) {
//        visited[searchKey]++;       //放这里也可以，推荐下面
        if (key == searchKey) return false;
        if (!map.containsKey(searchKey)) return true;
        visited[searchKey]++;       //TODO: 这个地方就代表同一dfs过程中，访问到该元素的次数
        for (int num : map.get(searchKey)) {
            if (!map.containsKey(num)) continue;
            if (num == key || visited[searchKey] > 1 || map.get(num).contains(key)) return false;
            if (!dfs(key, num, map, visited)) return false;
            map.remove(num);
//            visited[searchKey]++; //放这里也可以
        }
        visited[searchKey]--;   //放这里可以，推荐这个
        return true;
    }

    public static void main(String[] args) {
        int[][] pre = new int[8][];
        pre[0] = new int[]{1, 0};
        pre[1] = new int[]{0, 3};
        pre[2] = new int[]{0, 2};
        pre[3] = new int[]{3, 2};
        pre[4] = new int[]{2, 5};
        pre[5] = new int[]{4, 5};
        pre[6] = new int[]{5, 6};
        pre[7] = new int[]{2, 4};
        System.out.println(canFinish(7, pre));
    }
}
