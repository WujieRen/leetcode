package com.ltc.wangzheng.hash;

import java.util.HashMap;

public class FindRepeatNumber {
    public static void main(String[] args) {
        int[] tmp = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(tmp));
    }
    public static int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums) {
            if(!map.containsKey(num)) {
                map.put(num,1);
                continue;
            }
            map.put(num, map.get(num)+1);
            if(map.get(num) > 1) {
                return num;
            }
        }
        return 0;
    }
}
