package com.ltc.wangzheng.sort;

import java.util.Arrays;

/**
 * @author rwj
 * @create_time 2021/10/15
 * @description 看逆序对个数可以联想归并排序中从最低下的元素往上面合并时，两组值对比过程中即可对逆序对总数进行计数
 */
public class ReversePairs2 {

    static int reverseCount = 0;

    public static void main(String[] args) {
        int[] nums = new int[]{2, 6, 4, 3, 1, 5};
//        mergeSort(nums, 0, 6 - 1);
        System.out.println(Arrays.toString(nums));
        System.out.println(mergeSort(nums, 0, 5));
        System.out.println(Arrays.toString(nums));
    }

    private static int mergeSort(int[] nums, int low, int high) {
        if(low >= high) return 0;
        int mid = low + (high - low) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
        return reverseCount;
    }

    private static void merge(int[] nums, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int i = low, j = mid + 1, idx = 0;
        while(i <= mid && j <= high) {
            if(nums[i] < nums[j]) {
                tmp[idx++] = nums[i++];
            } else {
                reverseCount += (mid - i + 1);
                tmp[idx++] = nums[j++];
            }
        }
        while(i <= mid) tmp[idx++] = nums[i++];
        while(j <= high) tmp[idx++] = nums[j++];
        System.arraycopy(tmp, 0, nums, low, high-low+1);
    }

}
