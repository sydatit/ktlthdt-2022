package codelearn.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagrams2 {
    public static void main(String[] args) {
        GroupAnagrams2 groupAnagrams = new GroupAnagrams2();
        System.out.println(groupAnagrams.groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            String group = generateGroup(str);
            if (groups.containsKey(group)) {
                List<String> list = groups.get(group);
                list.add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                groups.put(group, list);
            }

        }
        return new ArrayList<>(groups.values());
    }

    private String generateGroup(String str) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26];
        for (char c:str.toCharArray()) {
            count[c - 'a']++;
        }
        for (int j : count) {
            sb.append(j).append('-');
        }
        return sb.toString();
    }
}
