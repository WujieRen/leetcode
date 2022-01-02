package com.ltc.wangzheng.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author rwj
 * @create_time 2022/1/2
 * @description https://leetcode-cn.com/problems/course-schedule/comments/
 *
 * 拓补排序写法②      这个写法更好理解，但是效率比争哥那个要低
 */
public class CanFinish3 {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        //统计每个课程入度
        for(int[] pre : prerequisites) indegrees[pre[0]]++; //统计入度
        //将入度为0的放入队列
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < numCourses; ++i) {
            if(indegrees[i] == 0) que.add(i);
        }
        //遍历入度为0的课程，当入度为0时，入队；
        int cnt = 0;
        while(!que.isEmpty()) {
            Integer qTop = que.remove();
            cnt++;
            for(int[] pre : prerequisites) {
                if(pre[1] == qTop) {
                    indegrees[pre[0]]--;
                    if(indegrees[pre[0]] == 0) que.add(pre[0]);
                }
            }
        }
        return cnt == numCourses;   //如果入度为0的元素和课程元素相等，说明没有环，即可以通过
    }

}
