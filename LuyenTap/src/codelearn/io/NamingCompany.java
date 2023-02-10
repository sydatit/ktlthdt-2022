package codelearn.io;

import java.util.HashSet;
import java.util.Set;

public class NamingCompany {
    public static void main(String[] args) {
        System.out.println((new NamingCompany()).distinctNames(
                new String[]{
                        "coffee","donuts","time","toffee"
                }
        ));
    }
    public long distinctNames(String[] ideas) {
        long result = 0;
        Set<String> setStr[] = new Set[26];
        for (int i = 0; i < 26; i++) {
            setStr[i] = new HashSet<>();
        }
        for (String item: ideas){
            char first = item.charAt(0);
            setStr[first - 'a'].add(item.substring(1));
        }
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                Set<String> totalS = new HashSet<>();
                totalS.addAll(setStr[i]);
                totalS.addAll(setStr[j]);
                int size = totalS.size();
                result += (long) (size - setStr[i].size()) * (size - setStr[j].size());
            }
        }
        return result* 2;
    }
}
