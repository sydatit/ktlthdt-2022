package codelearn.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = new String[]{
                "bdddddddddd","bbbbbbbbbbc"
        };
        GroupAnagrams anagrams = new GroupAnagrams();
        System.out.println(anagrams.groupAnagrams(strs));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            List<String> list = map.getOrDefault(sortedStr, new ArrayList<>());
            list.add(str);
            map.put(sortedStr, list);
        }
        return new ArrayList<>(map.values());
    }
}
