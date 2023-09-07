package codelearn.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class Trie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
    TrieNode1 root = null;
    private StringBuilder previousW = new StringBuilder();
    public Trie() {
        root = new TrieNode1();
    }

    public void insert(String word) {
        TrieNode1 node = root;
        for (int i = 0; i < word.length(); i++) {
            if(node.getCharacter()[(word.charAt(i) - 'a')] == 0){
                node.getCharacter()[(word.charAt(i) - 'a')] = 1;
                node.getMap().put(word.charAt(i), new TrieNode1());
            }
            node = node.getMap().get(word.charAt(i));
        }
    }



    public boolean search(String word) {
        previousW = new StringBuilder(word);
//        System.out.println(root);
        return searchNode(word, root, 0);
    }

    private boolean searchNode(String word, TrieNode1 node, int i) {
        if( i >= word.length())
            return true;
        if(node.getCharacter()[(word.charAt(i) - 'a')] == 0)
            return false;

        return searchNode(word, node.getMap().get(word.charAt(i)), i + 1 );
    }

    public boolean startsWith(String prefix) {
        char[] oldC = previousW.toString().toCharArray();
        char[] newC = prefix.toCharArray();
        if( newC.length > oldC.length)
            return false;
        for (int i = 0; i < newC.length; i++) {
            if( newC[i] != oldC[i])
                return false;
        }
        return true;
    }
}

class TrieNode1 {
    private int[] character;
    private HashMap<Character, TrieNode1> map;

    public TrieNode1() {
        character = new int[26];
        map = new HashMap<>();
    }

    public int[] getCharacter() {
        return character;
    }

    public void setCharacter(int[] character) {
        this.character = character;
    }

    public HashMap<Character, TrieNode1> getMap() {
        return map;
    }

    public void setMap(HashMap<Character, TrieNode1> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "character=" + Arrays.toString(character) +
                ", map=" + map +
                '}';
    }
}