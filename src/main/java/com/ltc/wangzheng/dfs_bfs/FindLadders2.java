package com.ltc.wangzheng.dfs_bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author rwj
 * @create_time 2022/1/2
 * @description https://leetcode-cn.com/problems/word-transformer-lcci/
 */
public class FindLadders2 {
    boolean found;
    List<String> res = new ArrayList<>();
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        dfs(beginWord, endWord, wordList, new HashSet<>());
        return res;
    }

    public void dfs(String beginWord, String endWord, List<String> wordList, Set<String> visited) {
        if (found) return;

        visited.add(beginWord);
        res.add(beginWord);
        if (beginWord.equals(endWord)) {
            found = true;
            return;
        }

        for (String str : wordList) {   //遍历 wordList 中的每一个元素
            if (!isValidChange(beginWord, str) || visited.contains(str)) continue; //如果访问过了或者不同字母个数相差不是1，就跳过
            dfs(str, endWord, wordList, visited);   //找到字母相差1的就放到res中，然后以该字符为beginWord进行下一次查找
        }

        if (!found) res.remove(res.size()-1);
    }

    public boolean isValidChange(String cur, String word) {
        int diff = 0;
        for (int i = 0; i < cur.length(); ++i) {
            if (cur.charAt(i) != word.charAt(i)) ++diff;
        }
        return diff == 1;
    }

    public static void main(String[] args) {

    }

}
