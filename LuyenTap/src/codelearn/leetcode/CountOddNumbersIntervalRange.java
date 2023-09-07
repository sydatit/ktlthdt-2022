package codelearn.leetcode;

public class CountOddNumbersIntervalRange {
    public static void main(String[] args) {
        System.out.println((new CountOddNumbersIntervalRange()).countOdds(
                3, 20
        ));
    }
    public int countOdds(int low, int high) {
        int result = 0;
        if( high - low < 10){
            for (int i = low; i <= high; i++) {
                if( i % 2 != 0) result++;
            }
        }else {
            while ((high - low) % 10 != 0){
                if(high-- % 2 != 0) result++;
            }
            result += (high - low) / 2;
            if( low % 2 != 0) result++;
        }
        return result;
    }
}
