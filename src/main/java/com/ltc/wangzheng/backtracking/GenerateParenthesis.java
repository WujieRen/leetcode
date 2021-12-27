package com.ltc.wangzheng.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author rwj
 * @create_time 2021/12/24
 * @description https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParenthesis {
    static Stack<Character> stack = new Stack<>();
    static List<String> res = new LinkedList<>();
    static char[] chs;

    public static List<String> generateParenthesis(int n) {
        chs = new char[2 * n];
        Arrays.fill(chs, '(');
        backTrack(chs, 0);
        return res;
    }

    /**
     * 原先我写的判断括号组合是否正确，比优化后执行结果居然要慢 7ms；—— 优化后 2ms， 优化前 9ms
     */
    /*public static boolean valid(char[] chs) {
        if(chs[0] == ')') return false;
        if(!stack.isEmpty()) stack.clear();
        int i = 0;
        int flag = 0;
        while(i < chs.length) {
            if(chs[i] == '(') {
                ++flag;
                stack.push(chs[i]);
            }
            if(chs[i] == ')') {
                --flag;
                if(!stack.isEmpty()) stack.pop();
            }
            ++i;
        }
        return stack.isEmpty() && flag == 0;
    }*/
    public static boolean valid(char[] chs) {
        int balance = 0;
        for (char c : chs) {
            if (c == '(') ++balance;
            else --balance;
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    public static void backTrack(char[] chs, int start) {
        if (start == chs.length) {
            if (valid(chs)) res.add(new String(chs));
            return;
        }
        for (int i = 0; i < 2; ++i) {
            if (i != 0) chs[start] = ')';
            backTrack(chs, start + 1);
            chs[start] = '(';
        }
    }

    /**  另一种写法 */
    public static void backTrack2(char[] chs, int start) {
        if (start == chs.length) {
            if (valid(chs)) res.add(new String(chs));
            return;
        }

        chs[start] = ')';
        backTrack2(chs, start + 1);
        chs[start] = '(';
        backTrack2(chs, start + 1);
    }

    public static void main(String[] args) {
        generateParenthesis(3);
        System.out.println(res);
//        System.out.println(valid(new char[]{'(','(','(',')',')',')'}));
    }
}
