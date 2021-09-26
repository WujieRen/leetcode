package com.ltc.rwj.array.wangzheng;

import java.util.Arrays;

/**
 * @author rwj
 * @create_time 2021/8/30
 * @description 王争老是文本解释有点难以理解，参考这个视频：https://www.youtube.com/watch?v=duln2xAZhBA
 */
public class ReviewQuickSortV1 {
    private static int[] arry = {0, 5, 1, 9, 6, 7, 19, 11, 3, 8, 4};

    public static void main(String[] args) {
        quickSort(arry, 0, arry.length - 1);
        System.out.println(Arrays.toString(arry));
    }

    private static void quickSort(int[] ary, int low, int high) {
        if(low >= high) return;

        int pivot = partition(ary, low, high);
        quickSort(ary, low, pivot - 1);
        quickSort(ary, pivot + 1, high);
    }

    private static int partition(int[] ary, int low, int high) {
        int left = low, right = low;
        while(right < high) {
            if(ary[right] < ary[high]) {
                int tmp = ary[left];
                ary[left++] = ary[right];
                ary[right++] = tmp;
            } else {
                right++;
            }
        }

        int tmp = ary[high];
        ary[high] = ary[left];
        ary[left] = tmp;
        return left;
    }
}
