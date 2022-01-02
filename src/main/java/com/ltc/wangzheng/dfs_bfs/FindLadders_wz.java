package com.ltc.wangzheng.dfs_bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author rwj
 * @create_time 2022/1/2
 * @description
 */
public class FindLadders_wz {
    private Set<String> visited = new HashSet<>();
    private List<String> resultPath = new ArrayList<>();
    private boolean found = false;
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        dfs(beginWord, endWord, new ArrayList<>(), wordList);
        return resultPath;
    }
    private void dfs(String curWord, String endWord, List<String> path, List<String> wordList) {
        if (found) return;

        for (String nextWord : wordList) {
            if (visited.contains(nextWord) || !isValidChange(curWord, nextWord)) continue;
            path.add(nextWord);
            visited.add(nextWord);
            if (nextWord.equals(endWord)) {
                resultPath.addAll(path);
                found = true;
                return;
            }
            dfs(nextWord, endWord, path, wordList);
            path.remove(path.size()-1);
        }
    }
    private boolean isValidChange(String word1, String word2) {
        int diff = 0;
        for (int i = 0; i < word1.length(); ++i) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}
