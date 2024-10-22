package contest.midyear2024.bestteam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BESTTEAM {
    private static final int MAX_QUALITY = 1000;
    private static final int MIN_QUALITY = -1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] qualities = new int[n];
        int[] prefixSum = new int[n];
        for (int i = 0; i < n; i++) {
            qualities[i] = sc.nextInt();
            if (i == 0) {
                prefixSum[i] = qualities[i];
            } else {
                prefixSum[i] = prefixSum[i - 1] + qualities[i];
            }
        }
        int max = findBestTeamWithSumGreaterOrEqualToZero(n, qualities, prefixSum);

        int maxForSumLessThanZero = findBestTeamWithSumLessThanZero(n, qualities, prefixSum);
        if (maxForSumLessThanZero > max) {
            max = maxForSumLessThanZero;
        }
        System.out.println(max);
    }

    private static int findBestTeamWithSumLessThanZero(int n, int[] qualities, int[] prefixSum) {
        int s = 0;
        int e = 0;
        Map<Integer, List<int[]>> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int minSoFar = qualities[0];
        int minEndingHere = qualities[0];
        for (int i = 1; i < n; i++) {
            minEndingHere = minEndingHere + qualities[i];
            if (qualities[i] <= minEndingHere) {
                minEndingHere = qualities[i];
                s = i;
            }
            if (minEndingHere <= minSoFar && minEndingHere < 0 && i - s >= 1) {
                minSoFar = minEndingHere;
                e = i;
                List<int[]> list = map.getOrDefault(minSoFar, new ArrayList<>());
                if (list.isEmpty()) {
                    list.add(new int[]{s, e});
                    map.put(minSoFar, list);
                } else {
                    int[] last = list.get(list.size() - 1);
                    if (last[0] != s) {
                        list.add(new int[]{s, e});
                        map.put(minSoFar, list);
                    }
                }
            }
        }

        return traversePotentialSubArr(qualities, prefixSum, map, max, minSoFar);
    }

    private static int findBestTeamWithSumGreaterOrEqualToZero(int n, int[] qualities, int[] prefixSum) {
        int s = 0;
        int e = 0;
        Map<Integer, List<int[]>> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int maxSoFar = qualities[0];
        int maxEndingHere = qualities[0];
        for (int i = 1; i < n; i++) {
            maxEndingHere = maxEndingHere + qualities[i];
            if (qualities[i] >= maxEndingHere) {
                maxEndingHere = qualities[i];
                s = i;
            }
            if (maxEndingHere >= maxSoFar && maxEndingHere >= 0 && i - s >= 1) {
                maxSoFar = maxEndingHere;
                e = i;
                List<int[]> list = map.getOrDefault(maxSoFar, new ArrayList<>());
                if (list.isEmpty()) {
                    list.add(new int[]{s, e});
                    map.put(maxSoFar, list);
                } else {
                    int[] last = list.get(list.size() - 1);
                    if (last[0] != s) {
                        list.add(new int[]{s, e});
                        map.put(maxSoFar, list);
                    }
                }
            }
        }

        return traversePotentialSubArr(qualities, prefixSum, map, max, maxSoFar);
    }

    private static int traversePotentialSubArr(int[] qualities, int[] prefixSum, Map<Integer, List<int[]>> map, int max, int minSoFar) {
        List<int[]> list = map.get(minSoFar);
        if (list == null) {
            return max;
        }
        for (int[] arr : list) {
            int sum = calculateQuality(qualities, arr[0], arr[1], prefixSum);
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    private static int calculateQuality(int[] qualities, int i, int j, int[] prefixSum) {
        int sum = 0;
        for (int k = i; k < j; k++) {
            sum += qualities[k] * (prefixSum[j] - prefixSum[k]);
        }
        return sum;
    }
}

/*
9
-3 -5 4 2 -7 -9 -1 9 10

12
8 1 10 -3 -5 4 2 -7 -9 -1 9 10

12
9 10 -3 -5 4 2 -7 -9 -1 8 1 10

 */