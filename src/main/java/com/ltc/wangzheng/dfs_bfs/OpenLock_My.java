package com.ltc.wangzheng.dfs_bfs;

import java.util.Arrays;
import java.util.List;

/**
 * @author rwj
 * @create_time 2021/12/31
 * @description 注意： 以下解法并不能解决打开所这道题。只是实现了一个多阶段选择的模型
 *  以下代码实现的相当于从 0000 -> 0001 -> .... -> 0010 -> 0011 -> ...
 *                      -> 0100 -> 0101 -> ... -> 1000 -> 1001 -> ... -> 9999
 *     的数字序列；和原题目略有差别，算是另外一道题了。
 *
 *      我理解错误的地方在于忽略了一句话：每次旋转都只能旋转一个拨轮的一位数字。
 *      如果每次旋转都只能拨动一个数字，那每个数字状态 'xxxx' 其实对应的都只有8个状态可以拨
 */
public class OpenLock_My {
    static int cnt;
    static boolean flag;
    public static int openLock(String[] deadends, String target) {
        char[] chs = new char[]{'0', '0', '0', '0'};
        List<String> deadList = Arrays.asList(deadends);
        dfs(chs, 0, deadList, target);
        return cnt == 0 ? -1 : cnt;
    }
    public static void dfs(char[] chs, int idx, List<String> deadList, String target) {
        if(idx > chs.length || flag) return;
        String curStr = new String(chs);
        if(curStr.equals(target)) {
            flag = true;
            return;
        }
        if(idx == chs.length) return;
        for(int i = 0; i <= 9; ++i) {
            chs[idx] = (char) (i+48);
            if(deadList.contains(new String(chs)))
                continue;
            if(i != 0 && !flag) cnt++;
            dfs(chs, idx+1, deadList, target);
            if(i!= 0 && !flag) cnt--;
            chs[idx] = '0';
        }
    }

    public static void main(String[] args) {
        openLock(new String[]{"0003", "0201"}, "0202");
        System.out.println(cnt);
    }
}
