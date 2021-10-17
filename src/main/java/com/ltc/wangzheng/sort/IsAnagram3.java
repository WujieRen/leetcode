package com.ltc.wangzheng.sort;

import java.util.Arrays;

/**
 * @author rwj
 * @create_time 2021/10/14
 * @description  归并排序
 */
public class IsAnagram3 {

    public static void main(String[] args) {
        char[] tmp = new char[]{'d', 'b', 'f', 'c', 'a', 'e'};
        splitMerge(tmp, 0, 5);
        System.out.println(Arrays.toString(tmp));
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int len = s.length();
        char[] sChar = s.toCharArray();
        splitMerge(sChar, 0, len - 1);
        char[] tChar = t.toCharArray();
        splitMerge(tChar, 0, len - 1);
        for(int i = 0; i < len; ++i) {
            if(sChar[i] != tChar[i]) return false;
        }
        return true;
    }

    private static void splitMerge(char[] cs, int low, int high) {
        if(low >= high) return;
        int mid = (high + low) / 2;
        splitMerge(cs, low, mid);
        splitMerge(cs, mid + 1, high);
        merge(cs, low, mid, high);
    }

    private static void merge(char[] cs, int low, int mid, int high) {
        char[] tmp = new char[high - low + 1];
        int  tmpIdx = 0, left = low, right = mid + 1;
        while(left <= mid && right <= high) {
            if(cs[left] <= cs[right]) {
                tmp[tmpIdx++] = cs[left++];
            } else {
                tmp[tmpIdx++] = cs[right++];
            }
        }
        while(left <= mid) tmp[tmpIdx++] = cs[left++];
        while(right <= high) tmp[tmpIdx++] = cs[right++];
//        tmpIdx = 0;
//        while(low <= high) cs[low++] = tmp[tmpIdx++];
        System.arraycopy(tmp, 0, cs, low, high - low + 1);
    }

}
