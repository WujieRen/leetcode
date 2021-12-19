package com.ltc.wangzheng.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author rwj
 * @create_time 2021/12/19
 * @description
 */
public class KClosest2 {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> priQue = new PriorityQueue<>((o1, o2)
                -> o2[0] * o2[0] + o2[1] * o2[1] - o1[0] * o1[0] - o1[1] * o1[1]);  //TODO:注意后面全是减号
        for (int i = 0; i < points.length; ++i) {
            int[] point = points[i];
            if (priQue.size() < k) {
                priQue.offer(point);
            } else if (((PriorityQueue<int[]>) priQue).comparator().compare(point, priQue.peek()) > 0) {
                priQue.poll();
                priQue.offer(point);
            }
        }
        int[][] res = new int[priQue.size()][2];
        int idx = 0;
        for(int[] p1 : priQue) {
            res[idx++] = p1;
        }
        return res;
    }
}
