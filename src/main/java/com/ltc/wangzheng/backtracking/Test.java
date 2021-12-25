package com.ltc.wangzheng.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author rwj
 * @create_time 2021/12/21
 * @description
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        Collections.swap(list, 1, 2);
        System.out.println(list);
        Collections.swap(list, 2, 1);
        System.out.println(list);
    }
}
