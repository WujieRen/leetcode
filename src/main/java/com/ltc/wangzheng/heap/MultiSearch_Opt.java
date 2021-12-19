package com.ltc.wangzheng.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rwj
 * @create_time 2021/12/19
 * @description
 */
public class MultiSearch_Opt {
    Trie root;
    public int[][] multiSearch(String big, String[] smalls) {
        root = new Trie();
        int m = smalls.length;
        int n = big.length();
        for(int i = 0; i < m; i++){
            insert(smalls[i],i);
        }
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i = 0; i < m; i++){
            ans.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < n; i++){
            Trie cur = root;
            int idx = i;
            while(idx < n){
                int index = big.charAt(idx) - 'a';
                if(cur.children[index] == null){
                    break;
                }
                cur = cur.children[index];
                if(cur.word){
                    ans.get(cur.num).add(i);
                }
                idx++;
            }
        }
        int[][] res = new int[m][];
        for(int i = 0; i < m; i++){
            res[i] = ans.get(i).stream().mapToInt(Integer::intValue).toArray();
        }
        return res;
    }

    /**
     * 构建树
     * @param word
     * @param idx
     */
    public void insert(String word, int idx){
        Trie cur = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(cur.children[index] == null){
                cur.children[index] = new Trie();
            }
            cur = cur.children[index];
        }
        cur.word = true;
        cur.num = idx;
    }

    /**
     * 树结构
     */
    class Trie{
        boolean word;
        int num = 0;
        Trie[] children;
        public Trie(){
            num = 0;
            word = false;
            children = new Trie[26];
        }
    }
}
