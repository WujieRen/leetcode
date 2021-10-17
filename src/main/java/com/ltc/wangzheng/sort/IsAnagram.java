package com.ltc.wangzheng.sort;

import java.util.HashMap;

/**
 * @author rwj
 * @create_time 2021/10/14
 * @description
 */
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()) {
            if(!sMap.containsKey(c)) {
                sMap.put(c, 1);
                continue;
            }
            sMap.put(c, sMap.get(c)+1);
        }
        for(char c : t.toCharArray()) {
            if(!tMap.containsKey(c)) {
                tMap.put(c, 1);
                continue;
            }
            tMap.put(c, tMap.get(c)+1);
        }
        for(char c : s.toCharArray()) {
            if(!sMap.get(c).equals(tMap.get(c))) return false;
        }
        return true;
    }
}
