package com.ltc.wangzheng.hash;

import java.util.*;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : arr1) {
            if (!map.containsKey(num)) map.put(num, 1);
            else map.put(num, map.get(num) + 1);
        }
        int idx = 0;
        for (int i = 0; i < arr2.length; ++i) {
            int cnt = map.get(arr2[i]);
            while (cnt > 0) {
                arr1[idx++] = arr2[i];
                --cnt;
            }
            map.remove(arr2[i]);
        }
        int mid = idx;
        for (Map.Entry<Integer, Integer> ent : map.entrySet()) {
            int key = ent.getKey();
            int cnt = ent.getValue();
            while (cnt > 0) {
                arr1[idx++] = key;
                --cnt;
            }
        }
        Arrays.sort(arr1, mid, arr1.length - 1);
        return arr1;
    }
}
