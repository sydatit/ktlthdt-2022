package huongdoituong.J07007_LietKeTuKhacNhau;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class WordSet {
    private String inputWord;
    private TreeSet<String> treeSet = new TreeSet<>();
    private String listWord;

    public WordSet(String inputWord) throws FileNotFoundException {
        this.inputWord = inputWord;
        Scanner scanner = new Scanner(new File(inputWord));
        while (scanner.hasNext()) {
            String input = scanner.next();
            treeSet.add(formatString(input));
        }
        listWord = treeSet.stream().reduce( "", ( acc, element) -> acc + element + "\n");
    }
    private static String formatString(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            stringBuilder.append(Character.toLowerCase(input.charAt(i)));
        }
        return stringBuilder.toString().trim();
    }

    @Override
    public String toString() {
        return listWord;
    }
}
