package codelearn.io;

import java.util.*;

public class ConcatenatedWords_472 {
    public static void main(String[] args) {
        System.out.println((new ConcatenatedWords_472()).findAllConcatenatedWordsInADict(
                new String[]{
                        "cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"
                }
        ));
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> setW = new HashSet<>(Arrays.asList(words));
        List<String> result = new ArrayList<>();
        for (String word: words) {
            if( checkConcatenated(word, setW))
                result.add(word);
        }
        return result;
    }

    private boolean checkConcatenated(String word, Set<String> setW) {
        for (int i = 1; i < word.length() - 1; i++) {
            String firstW = word.substring(0, i);
            String remainW = word.substring(i);
            if( setW.contains(firstW) && (setW.contains(remainW) || checkConcatenated(remainW, setW))) {
                return true;
            }
        }
        return false;
    }
}

