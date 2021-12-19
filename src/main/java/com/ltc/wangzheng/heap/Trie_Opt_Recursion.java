package com.ltc.wangzheng.heap;

/**
 * @author rwj
 * @create_time 2021/12/19
 * @description
 *
 * 标准Trie树，但是递归调用的效率要比遍历高，速度更快。     29ms
 */
public class Trie_Opt_Recursion {
    class TrieNode {
        boolean isEnd;
        TrieNode[] next;

        TrieNode() {
            this.isEnd = false;
            this.next = new TrieNode[26];   // 每个节点最多有26个不同的小写字母
        }
    }

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie_Opt_Recursion() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        insertChar(word, 0, root);
    }

    public void insertChar(String word, int idx, TrieNode node) {
        if (idx == word.length()) {
            node.isEnd = true;
            return;
        }
        int ch = word.charAt(idx) - 'a';
        if (node.next[ch] == null) node.next[ch] = new TrieNode();
        insertChar(word, idx + 1, node.next[ch]);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return searchRec(word, 0, root);
    }

    public boolean searchRec(String word, int idx, TrieNode node) {
        if (idx == word.length()) return node.isEnd;
        int ch = word.charAt(idx) - 'a';
        if (node.next[ch] == null) return false;
        return searchRec(word, idx + 1, node.next[ch]);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return startsRec(prefix, 0, root);
    }

    public boolean startsRec(String prefix, int idx, TrieNode node) {
        if(idx == prefix.length()) return true;
        int ch = prefix.charAt(idx) - 'a';
        if (node.next[ch] == null) return false;
        return startsRec(prefix, idx+1, node.next[ch]);
    }
}
