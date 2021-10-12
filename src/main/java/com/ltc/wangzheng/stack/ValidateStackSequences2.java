package com.ltc.wangzheng.stack;

import java.util.Stack;

/**
 * @author rwj
 * @create_time 2021/10/11
 * @description
 */
public class ValidateStackSequences2 {
    private static boolean f1(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0, j = 0;
        while (i < pushed.length) {
            while (!stack.isEmpty() && popped[j] == stack.peek()) {
                stack.pop();
                ++j;
            }
            stack.push(pushed[i]);
            ++i;
        }
        while (j < popped.length) {
            if (stack.peek() != popped[j]) return false;
            stack.pop();
            ++j;
        }
        return stack.isEmpty();
    }
}
