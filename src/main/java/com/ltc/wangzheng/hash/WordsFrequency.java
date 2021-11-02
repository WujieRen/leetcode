package com.ltc.wangzheng.hash;

import java.util.HashMap;

public class WordsFrequency {

    private HashMap<String, Integer> map = new HashMap<String, Integer>();

    public WordsFrequency(String[] book) {
        for (String s : book) {
            if (map.containsKey(s)) map.put(s, map.get(s) + 1);
            else map.put(s, 1);
        }
    }

    public int get(String word) {
        return map.get(word) == null ? 0 : map.get(word);
    }

}
