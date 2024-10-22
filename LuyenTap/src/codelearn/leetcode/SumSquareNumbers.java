package codelearn.leetcode;

public class SumSquareNumbers {
    public static void main(String[] args) {
        SumSquareNumbers sumSquareNumbers = new SumSquareNumbers();
        System.out.println(sumSquareNumbers.judgeSquareSum(5));
        System.out.println(sumSquareNumbers.judgeSquareSum(3));
        System.out.println(sumSquareNumbers.judgeSquareSum(4));
        System.out.println(sumSquareNumbers.judgeSquareSum(2));
        System.out.println(sumSquareNumbers.judgeSquareSum(1));
        System.out.println(sumSquareNumbers.judgeSquareSum(0));
        System.out.println(sumSquareNumbers.judgeSquareSum(1000000));
    }
    public boolean judgeSquareSum(int c) {
        for (int a = 0; a <= Math.sqrt(c); a++) {
            int bPower = (int) (c - Math.pow(a, 2));
            int temp = (int) Math.sqrt(c - Math.pow(a, 2));
            if (temp * temp == bPower) {
                return true;
            }
        }
        return false;
    }
}
