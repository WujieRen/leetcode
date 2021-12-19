package com.ltc.wangzheng.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author rwj
 * @create_time 2021/12/19
 * @description 利用堆求数组中位数；一直维护具有以下特性的两个堆：
 * - 一个大顶堆，一个小顶堆；
 * - 每个堆中元素接近n/2，如果n时偶数，两个队中的数据个数都是n/2；
 * 如果是奇数，大顶堆有n/2+1个数，小顶堆有n/2个数；
 * - 大顶堆中的元素都小于等于小顶堆的元素。
 * 则：大顶堆中的堆顶元素就是中位数。
 * <p>
 * 在插入数据时，如何维护两个堆继续满足以上特性呢？
 * 如果数据小于等于大顶堆的堆顶元素，就将这个数据插入到大顶堆，否则插入到小顶堆；
 * 此时可能出现两个堆中元素不符合以上约定；
 * 这时需要通过从一个堆中把堆顶元素移动到另一个堆，直到个数满足以上约定。
 */
public class MedianFinder2 {

    private Queue<Integer> bigHeap;
    private Queue<Integer> smallHeap;

    public MedianFinder2() {
        bigHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        smallHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o));
    }

    public void addNum(int num) {
        if (bigHeap.isEmpty() || num <= bigHeap.peek()) {
            bigHeap.offer(num);
        } else {
            smallHeap.offer(num);
        }
        while (smallHeap.size() > bigHeap.size()) bigHeap.offer(smallHeap.poll());
        while (bigHeap.size() - smallHeap.size() > 1) smallHeap.offer(bigHeap.poll());
    }

    public double findMedian() {
        if(bigHeap.size() > smallHeap.size()) return bigHeap.peek();
        else return (bigHeap.peek()+smallHeap.peek())/2f;
    }
}
