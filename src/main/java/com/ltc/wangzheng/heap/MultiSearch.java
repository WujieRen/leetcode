package com.ltc.wangzheng.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rwj
 * @create_time 2021/12/19
 * @description 一开始想着是把big构建Trie树，然后让smalls去树里匹配，但是发现这样不行，
 * 因为big中重复出现的字符在Trie树上是重复的，导致只能匹配到最初出现的下标；
 * <p>
 * 后来改为，将smalls构建Trie树，然后让big去匹配，匹配到了就把当前的起始索引和结束索引记录下来；
 * 问题又来了，结果如何和smalls中的位置相匹配呢？
 * 用一个idx代表smalls中字符串的位置
 */
public class MultiSearch {
    class TrieNode {
        int idx;
        boolean word;
        TrieNode[] next;

        TrieNode() {
            this.next = new TrieNode[26];
        }
    }

    TrieNode root;

    /**
     * 构建Trie树
     *
     * @param word
     * @param idx
     */
    public void insert(String word, int idx) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            int ch = word.charAt(i) - 'a';
            if (cur.next[ch] == null) cur.next[ch] = new TrieNode();
            cur = cur.next[ch];
        }
        cur.idx = idx;
        cur.word = true;
    }

    public TrieNode find(String word, int start, int end) {
        TrieNode cur = root;
        int i = start;
        while (i <= end) {
            int ch = word.charAt(i) - 'a';
            if (cur.next[ch] == null) return null;
            cur = cur.next[ch];
            ++i;
        }
        return cur;
    }

    public int[][] multiSearch(String big, String[] smalls) {
        root = new TrieNode();
        //将smalls构建Trie树，并记录是第几个元素
        int sLen = smalls.length;
        int bLen =  big.length();
        for (int i = 0; i < sLen; ++i) {
            if (smalls[i].length() <= bLen) insert(smalls[i], i);
        }
        List<Integer>[] lists = new ArrayList[smalls.length];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < bLen; ++i) {
            for (int j = i; j < bLen; ++j) {    //我这个效率低就低在这里
                TrieNode cur = find(big, i, j);
                if (cur != null && cur.word) lists[cur.idx].add(i);
            }
        }
        int[][] res = new int[smalls.length][];
        for (int i = 0; i < lists.length; ++i) {
            int[] intList = lists[i].stream().mapToInt(value -> value).toArray();
            res[i] = intList;
        }
        return res;
    }

    /*public static void main(String[] args) {
        String big = "mississippi";
        String[] smalls = new String[]{"is","ppi","hi","sis","i","ssippi"};
        int[][] res = multiSearch(big, smalls);
        System.out.println(res);
    }*/
}
