package com.ltc.wangzheng.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @author rwj
 * @create_time 2021/12/24
 * @description
 */
public class RestoreIpAddresses {
    static int len;
    static int ipLen;
    static int point = 0;
    static List<String> res = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    public static List<String> restoreIpAddresses(String s) {
        len = s.length();
        ipLen = len+4;
        if(len < 4 || len > 12) return null;
        backTrack(s, 0, 0);
        return res;
    }
    public static void backTrack(String s, int start, int sbLen) {
        if(sb.length() > ipLen) return;
        if(sb.length() == ipLen) {
            res.add(sb.deleteCharAt(sb.length()-1).toString());
            return;
        }
        for(int i = start; i < len && point <= 3; ++i) {
            String curS = s.substring(start, i+1);
            if(curS.length() > 1 && curS.startsWith("0")) break;
            int curN = Integer.parseInt(curS);
            if(curN > 255) break;
            sb.append(curN);
            sb.append(".");
            ++point;
            backTrack(s, i+1, sb.length());
            sb.delete(sbLen, sb.length());
            --point;
        }
    }

    public static void main(String[] args) {
        restoreIpAddresses("25525511135");
        System.out.println(res);
    }
}
