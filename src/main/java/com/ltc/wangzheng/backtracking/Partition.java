package com.ltc.wangzheng.backtracking;

import java.util.*;

/**
 * @author rwj
 * @create_time 2021/12/23
 * @description
 */
public class Partition {
    static List<List<String>> res = new ArrayList<>();
    static List<String> list = new ArrayList<>();
    public static List<List<String>> partitionIterate(String s) {
        int n = s.length();
        for (int len = 1; len <= n; ++len) {
            for(int start = 0; start < n; ++start) {
                if(start > 0) {
                    for(int needAdd = 0; needAdd < start; ++needAdd) list.add(String.valueOf(s.charAt(needAdd)));
                }
                int i = start;
                while (i <= n) {
                    if (i + len > n) {
                        for (char ch : s.substring(i).toCharArray()) list.add(String.valueOf(ch));
                        break;
                    }
                    String curS = s.substring(i, i + len);
                    if (!valid(curS)) {
                        list.add(String.valueOf(s.charAt(i)));
                        ++i;
                        continue;
                    }
                    list.add(curS);
                    i += len;
                }
                if(!res.contains(new ArrayList(list))) res.add(new ArrayList<>(list));
                list.clear();
            }
        }
        return res;
    }
    public static boolean valid(String s) {
        for(int i = 0, j = s.length()-1; i <= j; ++i,--j) {
            if(s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    public static List<List<String>> partition(String s) {
        backTrack(s, 0);
        return res;
    }
    public static void backTrack(String s, int start) {
        if(start >= s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i < s.length(); ++i) {
            String curS = s.substring(start, i+1);
            if(!valid(curS)) continue;
            list.add(curS);
            backTrack(s, i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        partition("abbbc");
        System.out.println(res);
    }
}
