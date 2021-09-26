package com.ltc.wangzheng.pure_code;

/**
 * @author rwj
 * @create_time 2021/9/23
 * @description 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 */
public class recindIP {
    public static void main(String[] args) {
//        String addredss = "1.1.1.1";
        String addredss = "155.155.155.155";
        System.out.println(f1(addredss));
    }

    private static String f1(String address) {
        char[] newIp4 = new char[address.length() + 6];
        int j = 0;
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                newIp4[j] = '[';
                newIp4[j + 1] = '.';
                newIp4[j + 2] = ']';
                j+=3;
            } else {
                newIp4[j++] = address.charAt(i);
            }
        }
        return new String(newIp4);
    }

    private static String f2(String address) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < address.length(); i++) {
            char c = address.charAt(i);
            if(c == '.') {
                sb.append("[.]");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
