package com.ltc.wangzheng.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author rwj
 * @create_time 2021/10/12
 * @description
 */
public class RemoveDuplicates3 {
    private static String f1(String s) {
        Deque<Character> queue = new LinkedList<Character>();
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if(queue.isEmpty() || queue.peekLast() != c) {
                queue.addLast(c);
            } else {
                queue.pollLast();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            sb.append(queue.pollFirst());
        }
        return sb.toString();
    }
}
