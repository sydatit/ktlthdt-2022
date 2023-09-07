package codelearn.leetcode.Checkpoint;

import java.util.Scanner;

public class PASSWORD_NCC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        while (n-->0){
            String line1 = scanner.nextLine();
            String line2 = scanner.nextLine();
            System.out.println(solve(line1, line2));
        }
    }

    private static String solve(String line1, String line2) {
        StringBuilder sb = new StringBuilder();
        char[] chars1 = line1.toCharArray();
        char[] chars2 = line2.toCharArray();
        int i = 0, j = 0, n = line1.length(), m = line2.length();
        int priority = 0;
        while (i < n && j < m) {
            if (chars1[i] > chars2[j]){
                sb.append(chars2[j++]);
                priority = 0;
            } else if( chars1[i] < chars2[j]){
                sb.append(chars1[i++]);
                priority = 0;
            } else{
                if( priority == 0){
                    priority = getPriority(chars1, chars2, i, j);
                }
                if( priority == 1){
                    sb.append(chars1[i++]);
                }else{
                    sb.append(chars2[j++]);
                }
            }
        }
        while (i < n) {
            sb.append(chars1[i++]);
        }
        while (j < m) {
            sb.append(chars2[j++]);
        }
        return sb.toString();
    }

    private static int getPriority(char[] chars1, char[] chars2, int i, int j) {
        int n = chars1.length;
        int m = chars2.length;
        int priority = 0;
        while (i < n && j < m) {
            if (chars1[i] > chars2[j]){
                priority = 2;
                break;
            } else if( chars1[i] < chars2[j]){
                priority = 1;
                break;
            }
            i++;
            j++;
        }
        if( priority == 0){
            if( i == n){
                priority = 2;
            }else{
                priority = 1;
            }
        }
        return priority;
    }
}
/*
2 4 6 8
n = 8
1 2 4 8
2
ABABAB
ACAAAA
ADBBD
DCAB

ABCABAC
BACBABCA

-------
AAACC
AAACCBBD
AAAAAACCBBCCD

AAACC
AAACCCBBD
AAAAAACCCBBCCD
 */