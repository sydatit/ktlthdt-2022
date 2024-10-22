package codelearn.leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberLaserBeamsBank {
    public static void main(String[] args) {
        System.out.println(numberOfBeams(new String[]{"011001","000000","010100","001000"}));
    }
//    public static int numberOfBeams(String[] bank) {
//        int result = 0;
//        List<Integer> listBitCount = new ArrayList<>();
//        Arrays.stream(bank).forEach(row -> {
//            BigInteger big = new BigInteger(row, 2);
//            int count = big.bitCount();
//            if (count > 0)
//                listBitCount.add(count);
//        });
//        for (int i = 0; i < listBitCount.size() - 1; i++) {
//            result += listBitCount.get(i) * listBitCount.get(i + 1);
//        }
//
//        return result;
//    }

    public static int numberOfBeams(String[] bank) {
        int result = 0;
        int previous = -1;
        for (String row : bank) {
            int count = countBit(row);
            if (count > 0) {
                if (previous != -1) {
                    result += count * previous;
                }
                previous = count;
            }
        }
        return result;
    }

    private static int countBit(String row) {
        int count = 0;
        for (char c :row.toCharArray()) {
            if (c == '1') count++;
        }
        return count;
    }
}
