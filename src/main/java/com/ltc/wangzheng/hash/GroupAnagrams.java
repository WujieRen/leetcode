package com.ltc.wangzheng.hash;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = new String[]{"ca","c"};
        groupAnagrams(strs).forEach(System.out::println);
    }

    public static List<List<String>> o1(String[] strs) {
        HashMap<String, LinkedList<String>> res = new HashMap<>();
        for(String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if(res.containsKey(key)) res.get(key).addLast(s);
            else {
                LinkedList<String> list = new LinkedList<String>();
                list.add(s);
                res.put(key, list);
            }
        }
        return new ArrayList<>(res.values());
    }

    // ["eat","tea","tan","ate","nat","bat"]
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        for(int j = 0; j < strs.length; ++j) {
            if(strs[j].equals("0")) continue;
            Map<Character, Integer> map = new HashMap<>();
            for(char c : strs[j].toCharArray()) {
                if(!map.containsKey(c)) map.put(c, 1);
                else map.put(c, map.get(c)+1);
            }
            List<String> list = new LinkedList<>();
            list.add(strs[j]);
            for(int i = j + 1; i < strs.length; ++i) {
                Map<Character, Integer> tmpMap = new HashMap<>(map);
                boolean flag = true;
                for (char c : strs[i].toCharArray()) {
                    if(tmpMap.containsKey(c)) {
                        int newNum = tmpMap.get(c) - 1;
                        tmpMap.put(c, newNum);
                        if(newNum == 0) tmpMap.remove(c);
                    } else {
                        flag = false;
                    }
                }
                if (flag && tmpMap.size() == 0) {
                    list.add(strs[i]);
                    strs[i] = "0";
                }
            }
            res.add(list);
        }
        return res;
    }
}
