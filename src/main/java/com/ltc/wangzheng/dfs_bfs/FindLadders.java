package com.ltc.wangzheng.dfs_bfs;

import java.util.*;

/**
 * @author rwj
 * @create_time 2022/1/1
 * @description https://leetcode-cn.com/problems/word-transformer-lcci/
 */
public class FindLadders {
    static char[] letters = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','r','s','t','u','v','w','x','y','z'};
    static List<String> res = new LinkedList<>();
    static Set<String> wSet;
    static boolean flag;
    public static List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        wSet = new HashSet<>(wordList); //TODO: 这里如果不转换成 set 会超时。
                                        // 根本原因在于HashSet查找某个元素效率为 O(1)；而list则需要遍历O(n)
        wSet.remove(beginWord);
        res.add(beginWord);
        dfs(beginWord, endWord, 0);
        if(flag) return res;
        return new ArrayList<>();
    }

    public static void dfs(String beginWord, String endWord, int step) {
        if(flag || step > res.size() + wSet.size()) return;
        String cur = beginWord;
        List<String> words = getWords(cur);
        for(String word : words) {
            if(!word.equals(cur) && wSet.contains(word) && !flag) {
                cur = word;
                wSet.remove(word);
                res.add(word);
                if(word.equals(endWord)) {
                    flag = true;
                    return;
                }
                dfs(cur, endWord, step+1);
                if(!flag) {
                    res.remove(cur);
                }
            }
        }
    }

    public static List<String> getWords(String cur) {
        List<String> list = new LinkedList<>();
        for(int i = 0; i < cur.length(); ++i) {
            StringBuilder sb = new StringBuilder(cur);
            for(int j = 0; j < 27; ++j) {
                sb.setCharAt(i, letters[j]);
                list.add(sb.toString());
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> tmp = new LinkedList<>();
        tmp.add("hot");
        tmp.add("dot");
        tmp.add("dog");
        tmp.add("lot");
        tmp.add("log");
        tmp.add("cog");
        System.out.println(findLadders("hit", "cog", tmp));
    }

}
