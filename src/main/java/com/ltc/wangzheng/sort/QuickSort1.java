package com.ltc.wangzheng.sort;

import java.util.Arrays;

/**
 * @author rwj
 * @create_time 2021/10/17
 * @description 前后双指针
 */
public class QuickSort1 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 6, 4, 3, 1, 5};
        quickSort(nums, 0, 6-1);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] nums, int low, int high) {
        if(low >= high) return;
        int pivotIdx = partition(nums, low, high);
        quickSort(nums, low, pivotIdx - 1);
        quickSort(nums, pivotIdx + 1, high);
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        //TODO:   比 pivot小 <-- i --> 还没考察 --> j --> 比pivot大
        int i = low, j = high - 1;
        while(i < j) {
            while(i < j && nums[i] < pivot) ++i;
            while(j > i && nums[j] > pivot) --j;
            if(i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, i, high);//TODO: 如果quickSort()中的high = pivot - 1就不需要有if判断，
                            // TODO 否则得加上； 因为选出pivot后就意味着左边的比pivot小；右边的比 pivot大；
                            //TODO 如果左边的部分把pivot又重新作为pivot，那这里的交换就会把已排好的顺序打乱
//        if(nums[i] > nums[high]) swap(nums, i, high);
        return i;
    }


    private static void swap(int[] ary, int low, int high) {
        int tmp = ary[low];
        ary[low] = ary[high];
        ary[high] = tmp;
    }
}
