package com.ltc.wangzheng.sort;

import java.util.Arrays;

/**
 * @author rwj
 * @create_time 2021/10/17
 * @description
 */
public class QuickSort2 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 6, 4, 3, 1, 5};
        quickSort(nums, 0, 6 - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int pivotIdx = partition(nums, low, high);
        quickSort(nums, low, pivotIdx - 1);
        quickSort(nums, pivotIdx + 1, high);
    }

    //TODO: 这里的partition可以有两种写法
    private static int partition(int[] nums, int low, int high) {
        //TODO:    比pivot小    <--  i   -->  比pivot大  <-- j --> 还没考察
        int i = low, j = low, pivot = nums[high];
        while (j < high) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                ++i;
            }
            ++j;
        }
        swap(nums, i, high);
        return i;
    }

    /*private static int partition(int[] nums, int low, int high) {
        int i = low, j = low, pivot = nums[high];
        while (j < high) {
            while (j < high && nums[j] > pivot) {
                ++j;
            }
            swap(nums, i, j);
            ++i;
            ++j;
        }
        swap(nums, i, high);
        return i;
    }*/


    private static void swap(int[] ary, int low, int high) {
        int tmp = ary[low];
        ary[low] = ary[high];
        ary[high] = tmp;
    }
}
