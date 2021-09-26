package com.ltc.wangzheng.pure_code;

import java.util.Arrays;

/**
 * @author rwj
 * @create_time 2021/9/23
 * @description
 */
public class ReverseWord {
    public static void main(String[] args) {
        //TODO: 最值得注意的是String类型以空白符为分割的时候不能用空格；
        // 而应该用\\s+，且要将字符串前后的空白字符去除
        System.out.println(Arrays.toString("  hello world!  ".trim().split("\\s+")));
//        System.out.println(Arrays.toString("a good example".split(" ")));
//        System.out.println(Arrays.toString("a   n".split(" ")));
        System.out.println(f1("  hello world!  "));
    }

   /* private static String f3(String s) {

    }*/

    //TODO: f2的效率是f1的3~5倍。效率应该是插在for循环那块儿代码上；f2循环时会有很多次不进去；而f1却每次遍历都要进去
    private static String f2(String s) {
        String[] ss = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = ss.length - 1; i>=0; i--) {
            if(ss[i].equals(""))
                continue;
            sb.append(ss[i] + " ");
        }
        return sb.toString().trim();
    }

    private static String f1(String s) {
        String[] strs = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; --i) {
            if (i == 0) sb.append(strs[i].trim());
            else sb.append(strs[i] + " ");
        }
        return sb.toString();
    }
}
