package codelearn.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceWords {
    public static void main(String[] args) {
        ReplaceWords replaceWords = new ReplaceWords();
        List<String> dictionary = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords.replaceWords(dictionary, sentence));
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        NodeC head = buildTrie(dictionary);
        StringBuilder result = new StringBuilder();
//        System.out.println(head);
        for (String word : sentence.split(" ")) {
            StringBuilder sb = new StringBuilder();
            String s = checkRoot(head, word, sb, 0);
            result.append(!s.isEmpty() ? s : word).append(" ");
        }

        return result.toString();
    }

    private String checkRoot(NodeC nodeC, String word, StringBuilder sb, int i) {
        if (i == word.length()) {
            return "";
        }
        char c = word.charAt(i);
        if (nodeC.childrenNode.containsKey(c)) {
            sb.append(c);
            if (nodeC.childrenNode.get(c).isLeaf) {
                return sb.toString();
            } else {
                return checkRoot(nodeC.childrenNode.get(c), word, sb, i + 1);
            }
        } else {
            return "";
        }
    }

    private NodeC buildTrie(List<String> dictionary) {
        NodeC head = new NodeC();
        for (String word : dictionary) {
            traverseInWord(head, word, 0);
        }
        return head;
    }

    private void traverseInWord(NodeC nodeC, String word, int i) {
        if (nodeC.childrenNode.containsKey(word.charAt(i))) {
            if (i + 1 < word.length()) {
                traverseInWord(nodeC.childrenNode.get(word.charAt(i)), word, i + 1);
            } else {
                nodeC.childrenNode.get(word.charAt(i)).isLeaf = true;
            }
        } else {
            NodeC child = new NodeC();
            nodeC.childrenNode.put(word.charAt(i), child);
            if (i + 1 < word.length()) {
                traverseInWord(child, word, i + 1);
            } else {
                child.isLeaf = true;
            }
        }
    }

    static class NodeC {
        boolean isLeaf;
        Map<Character, NodeC> childrenNode;

        public NodeC() {
            isLeaf = false;
            childrenNode = new HashMap<>();
        }
    }
}
