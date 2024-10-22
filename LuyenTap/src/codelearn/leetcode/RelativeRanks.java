package codelearn.leetcode;

import java.util.PriorityQueue;

public class RelativeRanks {
    public static void main(String[] args) {
        int[] score = {10,3,8,9,4};
        RelativeRanks relativeRanks = new RelativeRanks();
        String[] result = relativeRanks.findRelativeRanks(score);
        for (String s : result) {
            System.out.println(s);
        }
    }
    private static final String GOLD_MEDAL = "Gold Medal";
    private static final String SILVER_MEDAL = "Silver Medal";
    private static final String BRONZE_MEDAL = "Bronze Medal";
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < score.length; i++) {
            queue.add(new int[]{score[i], i});
        }
//        queue.forEach(i -> System.out.println(i[0] + " " + i[1]));
        String[] ranks = new String[score.length];
        for (int i = 0; i < ranks.length && !queue.isEmpty(); i++) {
            int[] rank = queue.poll();
            if (i == 0) {
                ranks[rank[1]] = GOLD_MEDAL;
            } else if (i == 1) {
                ranks[rank[1]] = SILVER_MEDAL;
            } else if (i == 2) {
                ranks[rank[1]] = BRONZE_MEDAL;
            } else {
                ranks[rank[1]] = String.valueOf(i + 1);
            }
        }

        return ranks;
    }
}
