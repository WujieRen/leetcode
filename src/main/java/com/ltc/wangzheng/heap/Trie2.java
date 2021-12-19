package com.ltc.wangzheng.heap;

import java.util.LinkedList;
import java.util.List;

/**
 * @author rwj
 * @create_time 2021/12/19
 * @description
 */
public class Trie2 {

    List<String> list;

    /** Initialize your data structure here. */
    public Trie2() {
        list = new LinkedList<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        list.add(word);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return list.contains(word);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        for(String word : list) {
            if(word.startsWith(prefix)) return true;
        }
        return false;
    }
}
