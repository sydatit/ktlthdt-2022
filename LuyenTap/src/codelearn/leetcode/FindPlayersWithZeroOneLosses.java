package codelearn.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class FindPlayersWithZeroOneLosses {
    public static void main(String[] args) {
        System.out.println(findWinners(new int[][] {
                {1,3},
                {2,3},
                {3,6},
                {5,6},
                {5,7},
                {4,5},
                {4,8},
                {4,9},
                {10,4},
                {10,9}
        }));
    }
//    public static List<List<Integer>> findWinners(int[][] matches) {
//        List<List<Integer>> list = new ArrayList<>();
//        Set<Integer> notLostMembers = new HashSet<>();
//        Set<Integer> losses = new HashSet<>();
//        Set<Integer> lossesOne = new HashSet<>();
//        int[] counts = new int[100001];
//
//        for (int[] match :matches) {
//            notLostMembers.add(match[0]);
//            notLostMembers.add(match[1]);
//            losses.add(match[1]);
//            counts[match[1]]++;
//            if (counts[match[1]] == 1) {
//                lossesOne.add(match[1]);
//            } else if (counts[match[1]] == 2) {
//                lossesOne.remove(match[1]);
//            }
//        }
//        notLostMembers.removeAll(losses);
//        list.add(notLostMembers.stream().sorted().collect(Collectors.toList()));
//        list.add(lossesOne.stream().sorted().collect(Collectors.toList()));
//
//        return list;
//    }
//    public static List<List<Integer>> findWinners(int[][] matches) {
//        List<List<Integer>> list = new ArrayList<>();
//        List<Integer> noLostMembers = new ArrayList<>();
//        List<Integer> lostOneMembers = new ArrayList<>();
//        int[] wins = new int[100001];
//        int[] losses = new int[100001];
//        int max = Integer.MIN_VALUE;
//        for (int[] match : matches) {
//            wins[match[0]]++;
//            losses[match[1]]++;
//            max = Math.max(max, Math.max(match[0], match[1]));
//        }
//        for (int i = 0; i <= max; i++) {
//            if (wins[i] > 0 && losses[i] == 0) {
//                noLostMembers.add(i);
//            }
//            if (losses[i] == 1) {
//                lostOneMembers.add(i);
//            }
//        }
//        list.add(noLostMembers);
//        list.add(lostOneMembers);
//        return list;
//    }
    public static List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> noLostMembers = new ArrayList<>();
        List<Integer> lostOneMembers = new ArrayList<>();
        int[] marks = new int[100001];
        int max = Integer.MIN_VALUE;
        
        list.add(noLostMembers);
        list.add(lostOneMembers);
        return list;
    }
}
