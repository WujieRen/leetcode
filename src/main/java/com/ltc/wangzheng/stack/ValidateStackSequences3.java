package com.ltc.wangzheng.stack;

import java.util.Stack;

/**
 * @author rwj
 * @create_time 2021/10/11
 * @description
 */
public class ValidateStackSequences3 {

    private static boolean f1(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<Integer>();
        int j = 0;
        for (int i1 : pushed) {
            stack.push(i1);
            while (!stack.isEmpty() && popped[j] == stack.peek()) {
                stack.pop();
                ++j;
            }
        }
        return stack.isEmpty();
    }
}
