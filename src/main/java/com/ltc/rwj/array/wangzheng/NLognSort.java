package com.ltc.rwj.array.wangzheng;

import java.util.Arrays;

/**
 * @author rwj
 * @create_time 2021/8/2
 * @description 归并排序
 */
public class NLognSort {

    private static int[] arry = {5, 4, 6, 3, 2, 1};

    public static void main(String[] args) {
        splitArray(arry, 0, arry.length - 1);
    }

    private static void splitArray(int[] arry, int low, int high) {
        if (low < high) {
            int mid = (high + low) / 2;
            splitArray(arry, low, mid);
            splitArray(arry, mid + 1, high);

            /*int[] tmp = new int[10];
            System.out.println(String.format("%s  -  %s - %s - %s", low, mid, high, high - low + 1));
            System.arraycopy(arry, low, tmp, 0, high - low + 1);
            System.out.println(Arrays.toString(tmp));*/
//            int[] tmp = new int[arry.length];

            sortAndMerge(arry, low, mid, high);
        }
    }

    private static void sortAndMerge(int[] arry, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int i = low, j = mid + 1, idex = 0;
        while (i <= mid && j <= high) {
            if (arry[i] <= arry[j]) {
                tmp[idex++] = arry[i++];
            } else {
                tmp[idex++] = arry[j++];
            }
            System.out.println(Arrays.toString(tmp) + "---");
        }

        while (i <= mid) {
            tmp[idex++] = arry[i++];
        }
        while (j <= high) {
            tmp[idex++] = arry[j++];
        }

        idex = 0;
        while(low <= high) {
            arry[low++] = tmp[idex++];
        }
        System.out.println(Arrays.toString(tmp));
    }

}
