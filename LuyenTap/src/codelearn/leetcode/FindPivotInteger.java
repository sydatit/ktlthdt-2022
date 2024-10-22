package codelearn.leetcode;

public class FindPivotInteger {
    public static void main(String[] args) {
        FindPivotInteger findPivotInteger = new FindPivotInteger();
        System.out.println(findPivotInteger.pivotInteger(9));
    }
    public int pivotInteger(int n) {
        int resultFormula =(int) Math.pow(n, 2) + n;
        float result = (float) resultFormula / 2;
        result = (float) Math.sqrt(result);
        if (result == (int) result) {
            return (int) result;
        }
        return -1;
    }

}
