package codelearn.leetcode;

import java.util.Arrays;

public class MyHashMap {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(1));   // return 1, The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(3));    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        System.out.println(myHashMap.get(2));    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        System.out.println(myHashMap.get(2));    // return -1 (i.e., not found), The map is now [[1,1]]
    }
    int[] arr;
    int mod = 177777;
    int size = 100000;
    public MyHashMap() {
        arr = new int[size];
        Arrays.fill(arr, -1);
    }

    public void put(int key, int value) {
        int index = findIndex(key);
        if (index < size)
            arr[index] = value;
        else arr[size - 1] = value;
    }

    public int get(int key) {
        int index = findIndex(key);
        if (index < size)
            return arr[index];
        else return -1;
    }

    public void remove(int key) {
        int index = findIndex(key);
        if (index < size)
            arr[index] = -1;
    }
    private int findIndex(int key) {
        return key % mod;
    }
}
