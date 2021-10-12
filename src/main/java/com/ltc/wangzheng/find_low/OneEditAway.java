package com.ltc.wangzheng.find_low;

/**
 * @author rwj
 * @create_time 2021/9/27
 * @description
 */
public class OneEditAway {
    public static void main(String[] args) {
        System.out.println(f2("a", "b"));
    }

    private static boolean f2(String first, String second) {
        int fLen = first.length();
        int sLen = second.length();
        int mLen = fLen - sLen;
        if(mLen > 1 || mLen < -1) return false;
        int diffCharNum = 0;
        for (int i = 0, j = 0; i < fLen && j < sLen; ++i, ++j) {
            if (first.charAt(i) == second.charAt(j)) continue;
            ++diffCharNum;
            if (diffCharNum > 1) return false;
            if (mLen == 1) {
                --j;
            }
            if(mLen == -1){
                --i;
            }
        }
        return true;
    }

    private static boolean f1(String first, String second) {
        int fLen = first.length();
        int sLen = second.length();
        int mLen = Math.abs(fLen - sLen);
        if (mLen > 1) return false;
        int diffCharNum = 0;
        if (mLen == 0) {
            for (int i = 0; i < fLen; ++i) {
                if (first.charAt(i) != second.charAt(i)) {
                    ++diffCharNum;
                }
            }
            return diffCharNum <= 1;
        } else {
            diffCharNum = 0;
            for (int i = 0, j = 0; i < fLen && j < sLen; ++i, ++j) {
//                if(first.charAt(i) == second.charAt(j)) continue;
                if (first.charAt(i) != second.charAt(j)) {
                    ++diffCharNum;
                    if (diffCharNum > 1) return false;
                    if (fLen > sLen && i + 1 < fLen) {
                        if (first.charAt(++i) != second.charAt(j)) return false;
                    } else {
                        if (second.charAt(++j) != first.charAt(i)) return false;
                    }
                }
            }
        }
        return true;
    }
}
