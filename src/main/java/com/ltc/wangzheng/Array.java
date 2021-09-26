package com.ltc.wangzheng;

/**
 * @author rwj
 * @create_time 2021/9/21
 * @description
 */
public class Array {

    private int[] array;
    private int initSize;
    private int cnt;

    public Array(int initSize) {
        this.array = new int[initSize];
        this.initSize = initSize;
        this.cnt = 0;
    }

    public int findIndex(int item) {
        for (int i = 0; i < initSize; i++) {
            if (array[i] == item) return i;
        }
        return -1;
    }

    public int find(int index) {
        if (index < 0 || index >= cnt) return -1;
        return array[index];
    }

    public boolean add(int index, int value) {
        if (index < 0 || index > initSize) throw new ArrayIndexOutOfBoundsException("数组下标必须大于0小于" + initSize);
        //如果空间不够了，扩容
        if (array.length >= initSize) {
            int oldSize = initSize;
            int[] oldAry = new int[initSize *= 2];
            System.arraycopy(array, 0, oldAry, 0, oldSize);
            this.array = oldAry;
        }
        if (index < 0 || index > cnt) {
            System.out.println("位置不合法");
            return false;
        }

        for (int i = cnt + 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        cnt++;
        return true;
    }

    public boolean delete(int index) {
        if (index < 0 || index >= cnt) return false;
        while (index < cnt - 1) {
            array[index] = array[++index];
        }
        cnt--;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < cnt; ++i) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array tmp = new Array(5);
        tmp.add(0, 1);
        tmp.printAll();
        tmp.add(3, 4);
        tmp.printAll();
        tmp.add(1, 3);
        tmp.printAll();
        tmp.add(1, 2);
        tmp.printAll();

        System.out.println(tmp.find(3));
        System.out.println(tmp.find(2));
        System.out.println(tmp.findIndex(3));

        tmp.printAll();
        tmp.delete(0);
        tmp.printAll();

    }

}
