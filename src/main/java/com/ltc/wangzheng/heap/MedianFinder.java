package com.ltc.wangzheng.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author rwj
 * @create_time 2021/12/19
 * @description
 *
 * 以下是效率很低的方法（超出时间限制）。也可以利用堆来结局。参考<MedianFinder2>
 */
public class MedianFinder {
    List<Integer> nums;
    int size;
    public MedianFinder() {
        nums = new ArrayList<>();
        this.size = 0;
    }

    public void addNum(int num) {
        nums.add(num);
        ++size;
        Collections.sort(nums);
    }

    public double findMedian() {
        if(size%2 != 0) return nums.get(size/2)*1.0;
        else return (nums.get(size/2)+nums.get(size/2-1))/2f;
    }

    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(1);
        m.addNum(2);
        System.out.println(m.findMedian());
    }
}
