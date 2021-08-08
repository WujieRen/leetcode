package com.rwj.ltc.array.wangzheng;

import java.util.Arrays;

/**
 * @author rwj
 * @create_time 2021/8/4
 * @description 快排
 */
public class QuickSort {

    private static int[] arry = {0, 5, 1, 9, 6, 7, 19, 11, 3, 8, 4};

    public static void main(String[] args) {
        quickSort(arry, 0, arry.length - 1);
        System.out.println(Arrays.toString(arry));
    }

    private static void quickSort(int[] arry, int low, int high) {
        if (low >= high) return;
        int left = low, right = high, temp = arry[low];
        while (left < right) {
            while (left < right && arry[right] >= temp) right--;        //TODO: 这里一定要记得 left < right
            while (left < right && arry[left] <= temp) left++;          //TODO: 这里一定要记得 left < right
            if (left < right) {
                int tmp = arry[right];
                arry[right] = arry[left];
                arry[left] = tmp;
            }
        }
        arry[low] = arry[left];
        arry[left] = temp;

        quickSort(arry, low, right - 1);    //TODO: 这个地方很关键，不是以mid位分割；而是以基准数所在的位置分割
        quickSort(arry, right + 1, high);
    }

}
