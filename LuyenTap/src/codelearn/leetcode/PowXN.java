package codelearn.leetcode;

public class PowXN {
    public static void main(String[] args) {
        PowXN powXN = new PowXN();
        System.out.println(powXN.myPow(2.10000, -3));
    }
    private double powN( double x, int n){
        if(Math.abs(n) == 1)
            return x;
        if( n == 0 )
            return 1.0;
        double res = powN( x, n/ 2);
        if( n % 2 == 0)
            return res * res;
        else
            return x * res * res;
    }
    public double myPow(double x, int n) {

        double res = powN(x, n);
        if( n < 0)
            return 1.0/res;
        return res;
    }
}
