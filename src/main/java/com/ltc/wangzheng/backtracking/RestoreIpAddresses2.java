package com.ltc.wangzheng.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rwj
 * @create_time 2021/12/27
 * @description https://leetcode-cn.com/problems/restore-ip-addresses/
 */
public class RestoreIpAddresses2 {
    List<String> res = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        backTrack(s, 0, 0, new ArrayList<>());
        return res;
    }
    public void backTrack(String s, int startIdx, int step, List<String> list) {
        if(step == 4 && startIdx == s.length()) {
            StringBuilder sb = new StringBuilder();
            for(String str : list) sb.append(str).append(".");
            sb.deleteCharAt(sb.length()-1);
            res.add(sb.toString());
            return;
        }
        if(step > 4 || startIdx >= s.length()) return;

        if(startIdx+1 <= s.length()) {
            list.add(s.substring(startIdx, startIdx+1));
            backTrack(s, startIdx+1, step+1, list);
            list.remove(list.size()-1);
        }
        if(s.charAt(startIdx) == '0') return;
        if(startIdx+2 <= s.length()) {
            list.add(s.substring(startIdx, startIdx+2));
            backTrack(s, startIdx+2, step+1, list);
            list.remove(list.size()-1);
        }
        if(startIdx+3 <= s.length()) {
            String str = s.substring(startIdx, startIdx+3);
            if(Integer.parseInt(str) > 255) return;
            list.add(str);
            backTrack(s, startIdx+3, step+1, list);
            list.remove(list.size()-1);
        }
    }
}
