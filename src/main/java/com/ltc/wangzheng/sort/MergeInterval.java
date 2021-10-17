package com.ltc.wangzheng.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author rwj
 * @create_time 2021/10/17
 * @description
 */
public class MergeInterval {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for(int[] num : nums) {
            System.out.println(Arrays.toString(num));
        }
    }



}
