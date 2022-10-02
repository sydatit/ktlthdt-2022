package Ex6_WordSet;

import java.util.TreeSet;

public class WordSet {
    private TreeSet<String> treeSet = new TreeSet<>();

    public WordSet(String newLine) {
        String[] strings = newLine.split(" ");
        for (int i = 0; i < strings.length; i++) {
            treeSet.add(strings[i].toLowerCase());
        }
    }
    private WordSet(TreeSet<String> treeSet) {
        this.treeSet = treeSet;
    }

    public WordSet union(WordSet wordSet){
        TreeSet<String> treeSetResult = new TreeSet<>();
        treeSetResult.addAll(treeSet);
        treeSetResult.addAll(wordSet.treeSet);
        return new WordSet(treeSetResult);
    }
    public WordSet intersection(WordSet wordSet){
        TreeSet<String> treeSetResult = new TreeSet<>();
        treeSetResult.addAll(treeSet);
        treeSetResult.retainAll(wordSet.treeSet);
        return new WordSet(treeSetResult);
    }

    @Override
    public String toString() {
        String output =
                treeSet.stream()
                        .reduce("", (s, s2) -> s + s2 + " ");
        return output.trim();
    }
}
