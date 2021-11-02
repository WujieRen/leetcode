package com.ltc.wangzheng.hash;

import com.ltc.rwj.common.ArrayUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums1) {
            set.add(num);
        }
        Set<Integer> set2 = new HashSet<Integer>();
        for(int num : nums2) {
            if(set.contains(num)) set2.add(num);
        }
        return set2.stream().mapToInt(Integer::intValue).toArray();
    }
}
