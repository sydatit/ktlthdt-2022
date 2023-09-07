package codelearn.leetcode;

public class AddBinary {
    public static void main(String[] args) {
        System.out.println((new AddBinary()).addBinary("111", "11111"));
    }
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int redundancy = 0;
        int i, j;
        for (i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 ; i--, j--) {
            int total = 0;
            if( i >= 0) total += a.charAt(i) - '0';
            if( j >= 0) total += b.charAt(j) - '0';
            total += redundancy;
            redundancy = total/2;
            sb.append(total%2);
        }
        if(redundancy != 0) sb.append(redundancy);
        return sb.reverse().toString();
    }
}
