package com.ltc.wangzheng.stack;

import java.util.Stack;

/**
 * @author rwj
 * @create_time 2021/10/11
 * @description 有一次验证了用基本数据类型模拟堆、栈等数据结构的操作，性能上要强大4倍以上
 */
public class DailyTemperatures4 {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        int[] stack = new int[len];
        int top = -1;
        for(int i = 0; i < len; ++i) {
            while(top != -1 && temperatures[i] > temperatures[stack[top]]) {
                res[stack[top]] = i - stack[top];
                --top;
            }
            stack[++top] = i;
        }
        return res;
    }
}
