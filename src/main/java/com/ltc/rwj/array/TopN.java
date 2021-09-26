package com.ltc.rwj.array;

import com.ltc.rwj.common.ArrayUtils;

import java.util.Arrays;

/**
 * @author rwj
 * @create_time 2021/5/10
 * @description
 */
public class TopN {

    /**
     * 希尔排序，插入排序的改进版；1959年Shell发明，第一个突破O(n^2)的排序算法；
     * 又叫缩小增量排序。
     * @param nums
     * @return
     */
    public static int[] o_3(int[] nums) {
        int gap;
        for(gap = (int)Math.floor(nums.length / 2); gap > 0; gap = (int)Math.floor(gap / 2)) {
            for(int i = gap; i < nums.length; i++) {
                int j = i;
                int current = nums[i];
                while(j-gap > 0 && current < nums[j-gap]) {
                    nums[j] = nums[j-gap];
                    j = j - gap;
                }
                nums[j] = current;
            }
        }
        return nums;
    }

    /**
     * 插入排序写法二
     * @param nums
     * @return
     */
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

    /**
     * 插入排序写法一
     * @param nums
     * @return
     */
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
            if(maxIndex != i) ArrayUtils.swap(nums, i, maxIndex);
        }
        return nums[k-1];
    }

    /**
     * 冒泡排序优化：给定一个flag如果第一轮就没有交换操作的话，说明已经有序了，直接退出
     * @param nums
     * @param k
     * @return
     */
    public int m_2(int[] nums, int k) {
        int flag = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j< nums.length; j++) {
                ArrayUtils.swap(nums, i, j);
                System.out.println("i="+i+"\tj="+j+"\tnums:"+ Arrays.toString(nums));
                flag = 1;
            }
            if(flag == 0) {
                break;
            }
            if(i == k) {
                break;
            }
        }
        return nums[k-1];
    }

    /**
     * 冒泡排序
     * @param nums
     * @param k
     * @return
     */
    public int m_1(int[] nums, int k) {
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

    public int m_3(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
