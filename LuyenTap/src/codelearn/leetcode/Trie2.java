package codelearn.leetcode;

public class Trie2 {
    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        Trie2 trie = new Trie2();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true

    }
    static class TrieNode{
        TrieNode[] children;
        boolean isEndOfWord;
        public TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }
    private StringBuilder previousW;
    private TrieNode root;
    public Trie2() {
        root = new TrieNode();
    }

    public void insert(String word) {
        previousW = new StringBuilder(word);
        int length = word.length();
        TrieNode node = root;
        for (int i = 0; i < length; i++) {
            int index = word.charAt(i) - 'a';
            if( node.children[index] == null)
                node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        int length = word.length();
        TrieNode node = root;
        for (int i = 0; i < length; i++) {
            int index = word.charAt(i) - 'a';
            if( node.children[index] == null)
                return false;
            node = node.children[index];
        }
        return (node.isEndOfWord);
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
