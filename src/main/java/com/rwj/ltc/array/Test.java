package com.rwj.ltc.array;

import com.rwj.ltc.common.ArrayUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rwj
 * @create_time 2021/5/10
 * @description
 */
@Slf4j
public class Test {
    private static int tmp;
//    private static int[] nums = {3, 2, 1, 0, 1, 3, 2,  5, 4, 6};
    private static int[] nums = {3, 2, 1, 5, 6, 4};

    public static void main(String[] args) {
//        System.out.println(Math.floor(5.8));
//        System.out.println(Math.floor(5.1));
//        System.out.println(Arrays.toString(TopN.o_2(nums)));
//        System.out.println(Arrays.toString(TopN.o_3(nums)));
//        System.out.println(nums[nums.length-2]);
        long tmp = System.currentTimeMillis();
        for(int i = 0; i < 20000; i++) {
            try{
                if(i == 3) throw new IllegalArgumentException("发生异常");
            } catch (Exception e) {
                log.info("发生异常了...");
            }
            System.out.println(i);
        }
        System.out.println((System.currentTimeMillis() - tmp));
    }




    public static void t1() {
        int k = 2;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j< nums.length; j++) {
                ArrayUtils.swap(nums, i, j);
                log.info("i={}\tj={}\tnums:{}", i, j, Arrays.toString(nums));
//                System.out.println("i="+i+"\tj="+j+"\tnums:"+Arrays.toString(nums));
            }
            if(i == k) {
                break;
            }
        }
        log.info("--------------  {} -------------", nums[k-1]);
//        System.out.println("-----------"+nums[k-1]+"-------------");
    }
}
