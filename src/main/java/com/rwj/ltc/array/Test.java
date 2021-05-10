package com.rwj.ltc.array;

import com.rwj.ltc.common.ArrayUtils;

import java.util.Arrays;

/**
 * @author rwj
 * @create_time 2021/5/10
 * @description
 */
public class Test {
    private static int tmp;
    private static int[] nums = {3, 2, 1, 0, 1, 3, 2,  5, 4, 6};

    public static void main(String[] args) {
        System.out.println(Math.floor(5.8));
        System.out.println(Math.floor(5.1));
//        System.out.println(Arrays.toString(TopN.o_2(nums)));
    }




    public static void t1() {

        int k = 2;

        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j< nums.length; j++) {
                ArrayUtils.swap(nums, i, j);
                System.out.println("i="+i+"\tj="+j+"\tnums:"+Arrays.toString(nums));
            }
            if(i == k) {
                break;
            }
        }
        System.out.println("-----------"+nums[k-1]+"-------------");
    }
}
