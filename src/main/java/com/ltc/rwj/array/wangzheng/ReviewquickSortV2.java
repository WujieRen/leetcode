package com.ltc.rwj.array.wangzheng;

import java.util.Arrays;

/**
 * @author rwj
 * @create_time 2021/8/30
 * @description 这个还有点问题；得改一下
 */
public class ReviewquickSortV2 {
    private static int[] arry = {0, 5, 1, 9, 6, 7, 19, 11, 3, 8, 4};

    public static void main(String[] args) {
        quickSort(arry, 0, arry.length - 1);
        System.out.println(Arrays.toString(arry));
    }

    private static void quickSort(int[] ary, int low, int high) {
        if (low >= high) return;
        int p = partition(ary, low, high);
        quickSort(ary, low, p - 1);
        quickSort(ary, p + 1, high);
    }

    private static int partition(int[] ary, int low, int high) {
        int i = low, j = low;
        while (j < high) {
            if (ary[j] < ary[high]) {
                int tmp = ary[i];
                ary[i++] = ary[j];      //TODO:这里注意++必须是再最后一次使用该参数以后才能进行操作
                ary[j] = tmp;
            }
            j++;
        }
        int tmp = ary[i];
        ary[i] = ary[high];
        ary[high] = tmp;
        return i;
    }
}
