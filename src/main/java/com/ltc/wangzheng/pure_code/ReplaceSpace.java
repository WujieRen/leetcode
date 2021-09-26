package com.ltc.wangzheng.pure_code;

/**
 * @author rwj
 * @create_time 2021/9/24
 * @description
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        System.out.println(f1("  v "));
    }

    private static String f1(String s){
        int n = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i <= n) {
            char tmp = s.charAt(i);
            if(tmp == ' ') {
                sb.append("%20");
            } else {
                sb.append(tmp);
            }
            i++;
        }
        return sb.toString();
    }

}
