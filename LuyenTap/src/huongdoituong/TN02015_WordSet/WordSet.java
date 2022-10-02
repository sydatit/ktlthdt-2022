package huongdoituong.TN02015_WordSet;

import java.util.Scanner;
import java.util.TreeSet;

public class WordSet {
    private TreeSet<String> wordSet = new TreeSet<>();

    public WordSet(Scanner scanner) {
        while (scanner.hasNext()){
            String token = scanner.next();
            wordSet.add( token.toLowerCase());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        wordSet.forEach( s -> sb.append(s + "\n"));
        return sb.toString().trim();
    }
}
