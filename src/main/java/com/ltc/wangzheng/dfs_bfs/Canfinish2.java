package com.ltc.wangzheng.dfs_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rwj
 * @create_time 2022/1/2
 * @description
 *
 * 拓补排序解法，这个是争哥的写法，但是不好理解，因为高了个 adj ，其实不需要这个也可以，见 CanFinish3
 *
 * 拓补排序参考：https://www.jianshu.com/p/b59db381561a
 *
 * TODO: 注意，Arrays.fill 只适合于用在基础数据类型上
 */
public class Canfinish2 {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new List[numCourses];
//        Arrays.fill(adj, new ArrayList<Integer>());
        //TODO: 注意，在这里，Arrays.fill 是个错误用法，会导致结果错误。
        // 因为fill方法底层是用 Object val 接的参数，并把数组的每个元素值设置为 val；
        // 当参数为 引用类型 时，即代表数组的每个元素都是同一个对象，当该对象值改变时，所有元素值都会改变
        // 正确下发如下：
        for(int i = 0; i < numCourses; ++i) adj[i] = new ArrayList<>();
        int[] indegrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            adj[prerequisite[1]].add(prerequisite[0]);
            indegrees[prerequisite[0]]++;
        }   //课程关系邻接表  && 统计入度
        LinkedList<Integer> zeroInDegrees = new LinkedList<>();
        for(int i = 0; i < indegrees.length; ++i) {
            if(indegrees[i] == 0) zeroInDegrees.add(i);
        }
        int zeroCount = 0;
        while(!zeroInDegrees.isEmpty()) {
            int courseIdx = zeroInDegrees.removeFirst();
            ++zeroCount;
            for(Integer out : adj[courseIdx]) {
                indegrees[out]--;
                if(indegrees[out] == 0)
                    zeroInDegrees.addLast(out);
            }
        }
        return zeroCount == numCourses;
    }

    public static void main(String[] args) {
        int[][] ints = new int[4][2];
        ints[0] = new int[]{0,3};
        ints[1] = new int[]{0,1};
        ints[2] = new int[]{1,2};
        ints[3] = new int[]{3,0};
        System.out.println(canFinish(4, ints));
    }
}
