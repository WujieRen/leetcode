package com.ltc.wangzheng.heap;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author rwj
 * @create_time 2021/12/18
 * @description https://leetcode-cn.com/problems/top-k-frequent-elements/
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */
public class TopKFrequent {
    /**
     * 解法①：利用哈希表        O(n)
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(map.containsKey(num)) map.put(num, map.get(num)+1);
            else map.put(num, 0);
        }
        List<Map.Entry<Integer, Integer>> listMap = new ArrayList<>(map.entrySet());
        listMap.sort((o1, o2) -> o2.getValue()-o1.getValue());
        int[] res = new int[k];
        for(int i = 0; i < k; ++i) {
            res[i] = listMap.get(i).getKey();
        }
        return res;
    }

    /**
     * 解法②：维护一个k个元素的小顶堆，每次插入元素后，自上而下堆化
     */
    class QueElement {
        int num;
        int cnt;
        QueElement(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) map.put(num, map.getOrDefault(num, 0)+1);
        //按照出现个数构建小顶堆
        Queue<QueElement> priQue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cnt));
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(priQue.size() < k) { //这里注意，写成 <= 结果就会出错。原因是小顶堆一旦元素等于k时就应该去执行堆化了
                priQue.offer(new QueElement(entry.getKey(), entry.getValue()));
            } else {
                int curCnt = priQue.peek().cnt;
                if(entry.getValue() > curCnt) {
                    priQue.poll();
                    priQue.offer(new QueElement(entry.getKey(), entry.getValue()));
                }
            }
        }
        int[] res = new int[k];
        for(int i = 0; i < k; ++i) {
            res[i] = priQue.poll().num;
        }
        return res;
    }

}
