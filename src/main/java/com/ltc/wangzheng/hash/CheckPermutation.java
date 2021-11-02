package com.ltc.wangzheng.hash;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {

    public boolean checkPermutation2(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : s1.toCharArray()) {
            if(map.containsKey(c)) map.put(c, map.get(c)+1);
            else map.put(c, 1);
        }
        for(char c : s2.toCharArray()) {
            if(!map.containsKey(c)) return false;
            if(map.get(c) <= 0) return false;
            map.put(c, map.get(c)-1);
        }
        return true;
    }

    public boolean checkPermutation(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : s1.toCharArray()) {
            if(map.containsKey(c)) map.put(c, map.get(c)+1);
            else map.put(c, 1);
        }
        for(char c : s2.toCharArray()) {
            if(map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c)-1);
            } else {
                return false;
            }
        }
        return true;
    }
}
