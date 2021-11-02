package com.ltc.wangzheng.hash;

/**
 * ["MyHashMap","put","put","put","put","remove","put","put","put","put","put","put","get","put","get","put","remove","get"]
 * [[],[970,538],[908,29],[395,865],[250,847],[836],[233,568],[657,790],[595,271],[769,219],[55,112],[157,493],[920],[632,358],[669],[506,228],[904],[473],[461,40],[748,973]]
 */
public class MyHashMap {

    HashTab[] values;
    int initCapacity;       //刚开始得值是100，这样的话冲突率很高，导致一只增加到100000才access

    private static class HashTab {
        int key;
        int value;

        public HashTab(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int hash(int key) {
        return key % initCapacity;
    }

    public MyHashMap() {
        this.initCapacity = 100000;
        values = new HashTab[initCapacity];
    }

    public void put(int key, int value) {
        int idx = hash(key);
        if(values[idx] != null) values[idx].value = value;
        else values[idx] = new HashTab(key, value);
    }

    public int get(int key) {
        HashTab v = values[hash(key)];
        return v == null ? -1 : v.value;
    }

    public void remove(int key) {
        int idx = hash(key);
        HashTab v = values[idx];
        if(v != null) values[idx] = null;
    }
}
