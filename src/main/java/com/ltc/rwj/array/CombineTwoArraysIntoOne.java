package com.ltc.rwj.array;

import java.util.Arrays;

/**
 * @author rwj
 * @create_time 2021/5/12
 * @description 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/all-about-array/x9lhe7/
 * 来源：力扣（LeetCode）
 */
public class CombineTwoArraysIntoOne {

    /**
     * 这个是别人的解法，愣是没看懂；留着以后回看。
     */
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            for (int i = m; i < nums1.length; i++) {
                nums1[i] = nums2[--n];
            }
            quickSort(nums1, 0, nums1.length - 1);
        }

        private void quickSort(int[] nums1, int l1, int r1) {
            if (nums1 == null || l1 >= r1) {
                return;
            }
            int l = l1, r = r1, povit = nums1[l1];
            while (l < r) {
                while (l < r && nums1[r] > povit) {
                    r--;
                }
                if (l < r) {
                    nums1[l++] = nums1[r];
                }
                while (l < r && nums1[l] < povit) {
                    l++;
                }
                if (l < r) {
                    nums1[r--] = nums1[l];
                }
            }
            nums1[l] = povit;
            quickSort(nums1, l1, l - 1);
            quickSort(nums1, l + 1, r1);
        }
    }

    public void o_2(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int i1 = 0, i2 = 0, i3 = 0;
        int[] copy = new int[m];
        System.arraycopy(nums1, 0, copy, 0, m);
        while (i1 < m && i2 < n) {
            if (copy[i1] < nums2[i2]) {
                nums1[i3++] = copy[i1++];
            } else {
                nums1[i3++] = nums2[i2++];
            }
        }
        while (i1 < m) {
            nums1[i3++] = copy[i1++];
        }
        while (i2 < n) {
            nums1[i3++] = nums2[i2++];
        }
    }

    /**
     * m_o_1优化
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void m_0_2(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int indexAll = m + n - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] <= nums2[index2]) {
                nums1[indexAll] = nums2[index2--];
            } else {
                nums1[indexAll] = nums1[index1--];
            }
            indexAll--;
        }
        while (index2 >= 0) {
            nums1[indexAll--] = nums2[index2--];
        }
    }

    /**
     * 因为两个数组是排好序的，所以直接从最后一个比就可以。谁大就往nums1的最后放谁；
     * 直到其中一个的下标为-1；
     * 如果nums1的下表为-1；需要把nums2中的元素放在nums1中的合适位置；
     * 如果nums2的下标为-1；则无需理会，nums1本来的元素不需要动。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void m_0_1(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int indexAll = m + n - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] <= nums2[index2]) {
                nums1[indexAll] = nums2[index2--];
            } else {
                nums1[indexAll] = nums1[index1--];
            }
            indexAll--;
        }
        if (index1 == -1) {
            for (int tmp = indexAll; tmp >= 0; tmp--) {
                nums1[tmp] = nums2[index2--];
            }
        }
    }


    public void m_2(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < (m + n); i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }

    /**
     * 插入法（思路借鉴了插入排序）：
     * 遍历每一个nums2的元素n，把n和nums1的每个元素对比，找到合适的位置插入；
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void m_1(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            nums1[0] = nums2[0];
        }
        int tmp = m - 1;
        for (int i = 0; i < n; i++) {
            int j;
            for (j = tmp; j >= 0; j--) {
                if (nums2[i] < nums1[j]) {
                    nums1[j + 1] = nums1[j];
                } else {
                    nums1[j + 1] = nums2[i];
                    break;
                }
            }
            if (j == -1) {
                nums1[j + 1] = nums2[i];
            }
            tmp++;
        }
    }
}
