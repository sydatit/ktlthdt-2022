package codelearn.leetcode;

public class MyHashSet {
    private int[] coreInt;
    public MyHashSet() {
        coreInt = new int[1000001];
    }

    public void add(int key) {
        coreInt[key] = 1;
    }

    public void remove(int key) {
        coreInt[key] = 0;
    }

    public boolean contains(int key) {
        return coreInt[key] == 1;
    }
}
