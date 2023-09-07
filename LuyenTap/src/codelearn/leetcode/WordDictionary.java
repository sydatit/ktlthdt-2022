package codelearn.leetcode;

public class WordDictionary {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.addWord("pad");
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.addWord("pad");
        System.out.println(wordDictionary.search("pad")); // returns true
        System.out.println(wordDictionary.search(".ad")); // returns true
        System.out.println(wordDictionary.search("b..")); // returns true
        System.out.println(wordDictionary.search("..b")); // returns true
        System.out.println(wordDictionary.search(".ad")); // returns true
    }
    static class TrieNode{
        TrieNode[] children;
        boolean isEndOfWord;
        int ALPHABET_SIZE = 26;
        public TrieNode() {
            children = new TrieNode[ALPHABET_SIZE];
            isEndOfWord = false;
        }
    }
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
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
        return searchNode(word, root, 0);
    }

    private boolean searchNode(String word, TrieNode node, int i) {
        if( i == word.length())
            return node.isEndOfWord;
        if( word.charAt(i) == '.'){
            for (int j = 0; j < node.ALPHABET_SIZE; j++) {
                if(node.children[j] != null && searchNode(word, node.children[j], i + 1 ))
                    return true;
            }
            return false;
        }else {
            int c = word.charAt(i) - 'a';
            if(node.children[c] == null)
                return false;
            return searchNode(word, node.children[c], i + 1 );
        }
    }
}
