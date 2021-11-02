package com.ltc.wangzheng.hash;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {

    public boolean isAnagram2(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()) {
            if(map.containsKey(c)) map.put(c, map.get(c)+1);
            else map.put(c, 1);
        }
        for(char c : t.toCharArray()) {
            if(!map.containsKey(c)) return false;
            if(map.get(c) <= 0) return false;
            map.put(c, map.get(c)-1);
        }
        for(Map.Entry<Character, Integer> m : map.entrySet()) {
            if(m.getValue() >= 1) return false;
        }
        return true;
    }

    public boolean isAnagram(String s, String t) {
        String shortStr = s.length() > t.length() ? t : s;
        String longStr = s.length() > t.length() ? s : t;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : shortStr.toCharArray()) {
            if(map.containsKey(c)) map.put(c, map.get(c)+1);
            else map.put(c, 1);
        }
        for(char c : longStr.toCharArray()) {
            if(!map.containsKey(c)) return false;
            if(map.get(c) <= 0) return false;
            map.put(c, map.get(c)-1);
        }
        return true;
    }
}
