package codelearn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MostProfitAssigningWork {
    public static void main(String[] args) {
        MostProfitAssigningWork mostProfitAssigningWork = new MostProfitAssigningWork();
        int[] difficulty = {68,35,52,47,86};
        int[] profit = {67,17,1,81,3};
        int[] worker = {92,10,85,84,82};
        System.out.println(mostProfitAssigningWork.maxProfitAssignment(difficulty, profit, worker));
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < difficulty.length; i++) {
            list.add(new int[]{difficulty[i], profit[i]});
        }
        list.sort((a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        Arrays.sort(worker);
        int currentIndex = 0;
        int maxProfit = 0;
        int n = worker.length;
        int m = difficulty.length;
        int[] currentV = null;
        int maxSoFar = 0;
        for (int i = 0; i < m; i++) {
            maxSoFar = Math.max(maxSoFar, list.get(i)[1]);
            list.get(i)[1] = maxSoFar;
        }

        if (worker[n - 1] < list.get(currentIndex)[0])
            return maxProfit;
        for (int i = 0; i < n; i++) {
            while (currentIndex < m && list.get(currentIndex)[0] <= worker[i]) {
                currentV = list.get(currentIndex);
                currentIndex++;
            }

            if (currentV != null) {
                maxProfit += currentV[1];
            }
        }
        return maxProfit;
    }
}
