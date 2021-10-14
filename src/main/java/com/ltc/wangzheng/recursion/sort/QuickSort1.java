package com.ltc.wangzheng.recursion.sort;

import java.util.Arrays;

/**
 * @author rwj
 * @create_time 2021/10/13
 * @description
 */
public class QuickSort1 {
    public static void main(String[] args) {
        int[] ary = new int[]{1, 5, 6, 3, 2, 4};
        System.out.println(Arrays.toString(quickSort(ary, 0, ary.length - 1)));
    }

    private static int[] quickSort(int[] ary, int low, int high) {
        if(low >= high) return ary;
        int pivot = partitionSort(ary, low, high);
        quickSort(ary, low, pivot - 1);
        quickSort(ary, pivot + 1, high);
        return ary;
    }

    private static int partitionSort(int[] ary, int low, int high) {
        int j = high - 1;
        while (low < j) {
            while (low < j && ary[low] < ary[high]) {
                ++low;
            }
            while (j > low && ary[j] > ary[high]) {
                --j;
            }
            if (low != j) {
                swap(ary, low, j);
            }
        }
        if(ary[j] > ary[high]) {
            swap(ary, j, high);
        }
        return j;
    }

    private static void swap(int[] ary, int low, int high) {
        int tmp = ary[low];
        ary[low] = ary[high];
        ary[high] = tmp;
    }
}
