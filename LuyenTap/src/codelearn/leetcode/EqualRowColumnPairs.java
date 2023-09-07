package codelearn.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class EqualRowColumnPairs {
    public static void main(String[] args) {
        int[][] grid = new int[][] { { 11,1 },
                                    { 1,11 } };
        System.out.println(new EqualRowColumnPairs().equalPairs(grid));
    }
    public int equalPairs(int[][] grid) {
        Map<String, Integer> column = new HashMap<>();
        Map<String, Integer> row = new HashMap<>();
        AtomicInteger count = new AtomicInteger();
        StringBuilder sb = new StringBuilder();
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j]);
            }
            row.put(sb.toString(), row.getOrDefault(sb.toString(), 0) + 1);
            sb.setLength(0);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(grid[j][i]);
            }
            column.put(sb.toString(), column.getOrDefault(sb.toString(), 0) + 1);
            sb.setLength(0);
        }
        row.forEach((k, v) -> {
            if( column.containsKey(k))
                count.addAndGet((v * column.get(k)));
        });

        return count.get();
    }
}
