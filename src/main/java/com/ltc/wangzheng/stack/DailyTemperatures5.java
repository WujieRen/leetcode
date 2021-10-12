package com.ltc.wangzheng.stack;

/**
 * @author rwj
 * @create_time 2021/10/11
 * @description
 */
public class DailyTemperatures5 {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        int[] stack = new int[len];
        int top = -1;
        for(int i = len - 1; i >= 0; --i) {
            while(top >= 0 && temperatures[i] >= temperatures[stack[top]]) {
                --top;
            }
            res[i] = top < 0 ? 0 : stack[top] - i;
            stack[++top] = i;
        }
        return res;
    }
}
