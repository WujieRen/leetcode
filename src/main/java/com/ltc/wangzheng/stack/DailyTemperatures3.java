package com.ltc.wangzheng.stack;

import java.util.Stack;

/**
 * @author rwj
 * @create_time 2021/10/11
 * @description
 */
public class DailyTemperatures3 {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < len; ++i) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int preIdx = stack.pop();
                res[preIdx] = i - preIdx;
            }
            stack.push(i);
        }
        return res;
    }
}
