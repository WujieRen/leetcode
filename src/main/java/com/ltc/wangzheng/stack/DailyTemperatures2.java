package com.ltc.wangzheng.stack;

import java.util.Stack;

/**
 * @author rwj
 * @create_time 2021/10/11
 * @description
 */
public class DailyTemperatures2 {
    class MyStack{
        int num;
        int idx;
        public MyStack(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Stack<MyStack> stack = new Stack<MyStack>();
        for(int i = 0; i < len; ++i) {
            int temprature = temperatures[i];
            while(!stack.isEmpty() && temprature > stack.peek().num) {
                MyStack tmp = stack.pop();
                res[tmp.idx] = i - tmp.idx;
            }
            stack.push(new MyStack(temprature, i));
        }
        return res;
    }
}
