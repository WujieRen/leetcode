package com.ltc.wangzheng.hash;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public static void main(String[] args) {
        int[] tmp = new int[]{4,1,2,1,2};
//        System.out.println(singleNumber(tmp));
        System.out.println(1^2);
        System.out.println(2^2);
        System.out.println(3^2);
        System.out.println(4^2);
    }

    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!map.containsKey(num)) map.put(num, 1);
            else map.put(num, map.get(num)+1);
        }
        for(Map.Entry<Integer, Integer> ent : map.entrySet()) {
            if(ent.getValue() == 1) return ent.getKey();
        }
        return -1;
    }

}
