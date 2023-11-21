package codelearn.leetcode;

public class PowerFour {
    public static void main(String[] args) {
        PowerFour powerFour = new PowerFour();
        System.out.println(powerFour.isPowerOfFour(16));
    }
    public boolean isPowerOfFour(int n) {
        double res = Math.log(n)/Math.log(4);
        return Math.pow(4, (int) res) == n;
    }
}
