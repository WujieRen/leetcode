package com.ltc.wangzheng.heap;

/**
 * @author rwj
 * @create_time 2021/12/19
 * @description https://leetcode-cn.com/problems/implement-trie-prefix-tree/comments/
 *
 * 标准Trie树      40ms
 * 优化，见<Trie_Opt_Recursion>
 */
public class Trie {

    class TrieNode{
        boolean isEnd;
        TrieNode[] next;
        TrieNode() {
            this.isEnd = false;
            this.next = new TrieNode[26];   // 每个节点最多有26个不同的小写字母
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); ++i) {
            int ch = word.charAt(i) - 'a';
            if(cur.next[ch] == null) cur.next[ch] = new TrieNode();
            cur = cur.next[ch];
        }
        cur.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); ++i) {
            int ch = word.charAt(i) - 'a';
            if(cur.next[ch] == null) return false;
            cur = cur.next[ch];
        }
        return cur.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); ++i) {
            int ch = prefix.charAt(i) - 'a';
            if(cur.next[ch] == null) return false;
            cur = cur.next[ch];
        }
        return true;
    }
}
