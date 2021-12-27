package com.ltc.wangzheng.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rwj
 * @create_time 2021/12/21
 * @description https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinations {
    /*static String[] strs = new String[]{
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wzyz"
    };*/
    static String[] strs = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    static List<String> res = new ArrayList<>();
    static List<Character> str = new LinkedList<>();

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return res;
        backTrack(digits, 0);
        return res;
    }

    public static void backTrack(String digits, int level) {
        if (str.size() == digits.length()) {
            StringBuilder sb = new StringBuilder();
            for (Character ch : str) {
                sb.append(ch);
            }
            res.add(sb.toString());
            return;
        }
//        String letter = strs[Integer.parseInt(digits.substring(level, level + 1))];
        String letter = strs[digits.charAt(level)-'0'];
        for (int i = 0; i < letter.length(); ++i) {
            str.add(letter.charAt(i));
            backTrack(digits, level + 1);
            str.remove(str.size() - 1);
        }
    }

    /** 优化 */
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations2(String digits) {
        if(digits == null || digits.length() == 0) return res;
        backTrack2(digits, 0);
        return res;
    }
    public void backTrack2(String digits, int level) {
        if(sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String letter = strs[digits.charAt(level)-'0'];
        for(int i = 0; i < letter.length(); ++i) {
            sb.append(letter.charAt(i));
            backTrack2(digits, level + 1);
            sb.deleteCharAt(sb.length()-1);
        }
    }


    public static void main(String[] args) {
//        letterCombinations("234");
        System.out.println("234".charAt(0)-'0');
    }
}
