package codelearn.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        SortCharactersByFrequency s = new SortCharactersByFrequency();
        System.out.println(s.frequencySort("tree"));
    }
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, StringBuilder> map = new HashMap<>();
        int[] numbers = new int[10];
        int[] lowerChars = new int[26];
        int[] upperChars = new int[26];

        for (char c : s.toCharArray()) {
            if ('a' <= c && c <= 'z') {
                lowerChars[c - 'a']++;
            }
            if ('A' <= c && c <= 'Z') {
                upperChars[c - 'A']++;
            }
            if ('0' <= c && c <= '9') {
                numbers[c - '0']++;
            }
        }
        for (int i = 0; i < lowerChars.length; i++) {
            if (i < numbers.length && numbers[i] != 0) {
                addToMap(map, numbers[i], (char) (i + '0'));
            }
            if (lowerChars[i] != 0) {
                addToMap(map, lowerChars[i], (char) (i + 'a'));
            }
            if (upperChars[i] != 0) {
                addToMap(map, upperChars[i], (char) (i + 'A'));
            }
        }
        TreeMap<Integer, StringBuilder> sortedMap = new TreeMap<>(Collections.reverseOrder());
        sortedMap.putAll(map);
        sortedMap.forEach((k,v) -> sb.append(v.toString()));

        return sb.toString();
    }

    private void addToMap(Map<Integer, StringBuilder> map, int occus, char c) {
        StringBuilder sb = map.getOrDefault(occus, new StringBuilder());
        int temp = occus;
        while (temp-->0) sb.append(c);
        map.putIfAbsent(occus, sb);
    }
}
