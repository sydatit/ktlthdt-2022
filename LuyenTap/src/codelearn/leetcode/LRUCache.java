package codelearn.leetcode;

import java.util.*;

public class LRUCache {
    public static void main(String[] args) {
    }
    class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    Node head;
    Node tail;
    int capacity;
}
