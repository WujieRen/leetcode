package com.rwj.ltc.array;

import com.rwj.ltc.common.ArrayUtils;

import java.util.Arrays;

/**
 * @author rwj
 * @create_time 2021/5/10
 * @description
 */
public class TopN {


//    public static int[] o_3() {
//
//    }

    public static int[] o_2_2(int[] nums) {
        int preIndex;
        int currentEle;
        for(int i = 1; i < nums.length; i++) {
            preIndex = i - 1;
            currentEle = nums[i];
            while(preIndex >= 0 && nums[preIndex] > currentEle) {
                nums[preIndex+1] = nums[preIndex--];
            }
            nums[preIndex+1] = currentEle;
        }
        return nums;
    }

    public static int[] o_2(int[] nums) {
        int preIndex;
        int currentEle;
        for(int i = 1; i < nums.length; i++) {
                currentEle = nums[i];
                for(preIndex = i - 1; preIndex >= 0 && nums[preIndex] > currentEle; preIndex--) {
                    nums[preIndex+1] = nums[preIndex];
                }
                nums[preIndex+1] = currentEle;
        }
        return nums;
    }


    /**
     * 选择排序，效率也很低
     *
     * 表现最稳定的排序算法之一，因为无论什么数据进去都是O(n2)的时间复杂度，所以用到它的时候，数据规模越小越好。
     * 唯一的好处可能就是不占用额外的内存空间了吧。
     * 理论上讲，选择排序可能也是平时排序一般人想到的最多的排序方法了吧。
     * @return
     */
    public int o_1(int[] nums, int k) {
        int maxIndex;
        for(int i = 0; i < nums.length - 1; i++) {
            maxIndex = i;
            for(int j = i+1; j < nums.length; j++) {
                if(nums[j] > nums[maxIndex]) {
                    maxIndex = j;
                }
            }
            ArrayUtils.swap(nums, i, maxIndex);
        }
        return nums[k-1];
    }



    /**
     * 暴力破解,冒泡排序
     * @param nums
     * @param k
     * @return
     */
    public int m_1(int nums[], int k) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j< nums.length; j++) {
                ArrayUtils.swap(nums, i, j);
                System.out.println("i="+i+"\tj="+j+"\tnums:"+ Arrays.toString(nums));
            }
            if(i == k) {
                break;
            }
        }
        return nums[k-1];
    }

    public int m_2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
