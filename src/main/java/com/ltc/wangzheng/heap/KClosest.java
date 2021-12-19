package com.ltc.wangzheng.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author rwj
 * @create_time 2021/12/19
 * @description
 */
public class KClosest {
    class QueElement{
        int idx;
        double distance;
        QueElement(int idx, double distance) {
            this.idx = idx;
            this.distance = distance;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        Queue<QueElement> priQue = new PriorityQueue<>((o1, o2) -> (int) (o2.distance - o1.distance));
        for(int i = 0; i < points.length; ++i) {
            int[] pairs = points[i];
            double distance = Math.sqrt(Math.pow(pairs[0],2) + Math.pow(pairs[1],2));
            if(priQue.size() < k) {
                priQue.offer(new QueElement(i, distance));
            } else {
                if(distance < priQue.peek().distance) {
                    priQue.poll();
                    priQue.offer(new QueElement(i, distance));
                }
            }
        }
        int[][] res = new int[k][2];
        for(int i = k-1; i >= 0; --i) {
            res[i] = points[priQue.poll().idx];
        }
        return res;
    }
}
