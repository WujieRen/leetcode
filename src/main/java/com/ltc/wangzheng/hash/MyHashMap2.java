package com.ltc.wangzheng.hash;

import java.util.LinkedList;

public class MyHashMap2 {

    private class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    LinkedList<Pair>[] values;
    private static final int initCapacity = 1000;       //刚开始得值是100，这样的话冲突率很高，导致一只增加到100000才access

    public MyHashMap2() {
        values = new LinkedList[initCapacity];
    }

    private int hash(int key) {
        return key % initCapacity;
    }

    /*public void put(int key, int value) {
        int idx = hash(key);
        if(values[idx] == null) {
            values[idx] = new LinkedList<Pair>();
            values[idx].addLast(new Pair(key, value));
        } else {
            for(Pair pair : values[idx]) {
                if(pair.key == key) {
                    values[idx].remove(pair);
                    break;
                }
            }
            values[idx].add(new Pair(key, value));
        }
    }*/

    public void put(int key, int value) {
        int idx = hash(key);
        if(values[idx] == null) {
            values[idx] = new LinkedList<Pair>();
            values[idx].addLast(new Pair(key, value));
        } else {
            for(Pair pair : values[idx]) {
                if(pair.key == key) {
                    pair.value = value;
                    return;
                }
            }
            values[idx].add(new Pair(key, value));
        }
    }

    public int get(int key) {
        int idx = hash(key);
        if(values[idx] == null) return -1;
        for(Pair pair : values[idx]) {
            if(pair.key == key) return pair.value;
        }
        return -1;
    }

    public void remove(int key) {
        int idx = hash(key);
        if(values[idx] == null) return;
        values[idx].removeIf(pair -> pair.key == key);
    }
}
