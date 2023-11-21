package codelearn.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumAmountTimeCollectGarbage {
    public static void main(String[] args) {
        MinimumAmountTimeCollectGarbage g = new MinimumAmountTimeCollectGarbage();
        String[] garbage = new String[]{"G","P","GP","GG"};
        int[] travel = new int[]{2, 4, 3};
        System.out.println(g.garbageCollection(garbage, travel));
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        int result = 0;
        int pIndex = 0;
        int gIndex = 0;
        int mIndex = 0;
        int[] prefixSum = new int[travel.length];
        prefixSum[0] = travel[0];
        for (int i = 1; i < travel.length; i++) {
            prefixSum[i] += prefixSum[i - 1] + travel[i];
        }
        for (int i = 0; i < garbage.length; i++) {
            result += garbage[i].length();
            if (garbage[i].contains("P")) pIndex = i;
            if (garbage[i].contains("G")) gIndex = i;
            if (garbage[i].contains("M")) mIndex = i;
        }
        if (pIndex > 0) result += prefixSum[pIndex - 1];
        if (gIndex > 0) result += prefixSum[gIndex - 1];
        if (mIndex > 0) result += prefixSum[mIndex - 1];

        return result;
    }

//    public int garbageCollection(String[] garbage, int[] travel) {
//        int result = 0;
//        int[][] typeGarbage = new int[3][2];
//        for (int i = 0; i < garbage.length; i++) {
//            countNumberOfOccurrences(garbage[i], typeGarbage, i);
//        }
//        for (int[] garbageI : typeGarbage) {
//            int costTravel = 0;
//            for (int j = 0; j < garbageI[1] && j < travel.length; j++) {
//                costTravel += travel[j];
//            }
//            costTravel += garbageI[0];
//            result += costTravel;
//        }
//        return result;
//    }

    private void countNumberOfOccurrences(String g, int[][] typeGarbage, int house) {
        char[] charArray = g.toCharArray();
        for (char c :charArray) {
            switch (c) {
                case 'P':
                    typeGarbage[0][0]++;
                    typeGarbage[0][1] = house;
                    break;
                case 'M':
                    typeGarbage[1][0]++;
                    typeGarbage[1][1] = house;
                    break;
                case 'G':
                    typeGarbage[2][0]++;
                    typeGarbage[2][1] = house;
                    break;
                default:
                    break;
            }
        }
    }
}
/*
P
M
G
 */
