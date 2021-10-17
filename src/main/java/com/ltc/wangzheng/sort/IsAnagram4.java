package com.ltc.wangzheng.sort;

import java.util.Arrays;

/**
 * @author rwj
 * @create_time 2021/10/14
 * @description
 */
public class IsAnagram4 {

    public static void main(String[] args) {
        char[] tmp = new char[]{'d', 'b', 'f', 'c', 'a', 'e'};
        splitQuick(tmp, 0, 5);
        System.out.println(Arrays.toString(tmp));
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int len = s.length();
        char[] sChar = s.toCharArray();
        splitQuick(sChar, 0, len - 1);
        char[] tChar = t.toCharArray();
        splitQuick(tChar, 0, len - 1);
        for(int i = 0; i < len; ++i) {
            if(sChar[i] != tChar[i]) return false;
        }
        return true;
    }

    private static void splitQuick(char[] cs, int low, int high) {
        if(low >= high) return;
        int pivotIdx = partitionSort(cs, low, high);
        splitQuick(cs, low, pivotIdx);
        splitQuick(cs, pivotIdx + 1, high);
    }

    private static int partitionSort(char[] cs, int low, int high) {
        char pivot = cs[high];
        int j = high - 1;
        while(low < j) {
            while(low < j && cs[low] <= pivot)  low++;
            while(low < j && cs[j] >= pivot)  j--;
            if(low < j) swap(cs, low, j);
        }
        if(cs[j] > pivot) swap(cs, j, high);
        return j;
    }

    private static void swap(char[] cs, int left, int right) {
        char tmp = cs[left];
        cs[left] = cs[right];
        cs[right] = tmp;
    }

}
