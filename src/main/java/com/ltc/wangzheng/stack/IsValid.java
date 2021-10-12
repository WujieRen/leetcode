package com.ltc.wangzheng.stack;

import java.util.LinkedList;

/**
 * @author rwj
 * @create_time 2021/10/10
 * @description
 */
public class IsValid {

    public static void main(String[] args) {
        System.out.println(f2("([)]"));
    }

    private boolean isLeft(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private boolean isRight(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    private boolean f1(String s) {
        int len = s.length();
        if (len % 2 != 0) return false;
        LinkedList<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (isLeft(c)) stack.addLast(c);
            if (isRight(c)) {
                if (stack.isEmpty()) return false;
                char tmpLeft = stack.removeLast();
                if (c == ')' && tmpLeft != '(') return false;
                if (c == '}' && tmpLeft != '{') return false;
                if (c == ']' && tmpLeft != '[') return false;
            }
        }
        return stack.isEmpty();
    }

    //TODO: 注释掉的是 jdk 1.6 可以使用的方式，jkd 1.8无法通过编译
    private static boolean f2(String s) {
//        Deque<Character> queue = new LinkedList<Character>();
        LinkedList<Character> queue = new LinkedList<Character>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
//                queue.push(')');
                queue.addLast(')');
            } else if (c == '{') {
//                queue.push('}');
                queue.addLast('}');
            } else if (c == '[') {
//                queue.push(']');
                queue.addLast(']');
//            } else if (queue.isEmpty() || c != queue.peek()) {
            } else if (queue.isEmpty() || c != queue.getLast()) {
                return false;
            } else {
//                queue.poll();
                queue.removeLast();
            }
        }
        return queue.isEmpty();
    }

    //TODO: 这个效率很高，但是很巧妙；一般想不到
    private static boolean f3(String s) {
        int len = s.length();
        if(len %2 != 0 || len == 0) return false;
        int index = -1;
        char[] cs = new char[len];
        for(char c : s.toCharArray()) {
            index++;
            if(index == 0 || c == '(' || c == '[' || c =='{') {
                cs[index] = c;
            } else {
                if(c == ')' && cs[index - 1] == '(') index -= 2;
                if(c == ']' && cs[index - 1] == '[') index -= 2;
                if(c == '}' && cs[index - 1] == '{') index -= 2;
            }
        }
        return index == -1;
    }
}
