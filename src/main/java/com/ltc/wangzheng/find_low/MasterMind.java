package com.ltc.wangzheng.find_low;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rwj
 * @create_time 2021/9/26
 * @description
 */
public class MasterMind {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(f1("RGBY", "GGRR")));
    }

    private static int[] f1(String solution, String guess) {
        char[] ss = solution.toCharArray();
        char[] gs = guess.toCharArray();
        int[] res = new int[] {0, 0};
        for(int i = 0; i < ss.length; ++i) {
            if(ss[i] == gs[i]) {
                res[0] += 1;
                ss[i] = '0';
                gs[i] = '0';
            }
        }
        for(int i = 0; i < ss.length; ++i) {
            for(int j = 0; j < gs.length; ++j) {
                if(gs[j] == '0') continue;
                if(i != j && ss[i] == gs[j]) {
                    res[1] += 1;
                    gs[j] = '0';
                    break;
                }
            }
        }
        return res;
    }
}
